package eu.paniw.timetable.pages.schedule;

import java.util.List;
import net.databinder.hib.Databinder;
import net.databinder.models.hib.HibernateListModel;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;
import org.hibernate.Session;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.entity.Schedule;
import eu.paniw.timetable.pages.BasePage;
import eu.paniw.timetable.panel.schedule.SchedulePanel;

@MountPath(path = "schedule")
@AuthorizeInstantiation("USER")
public class SchedulePage extends BasePage {
	private ScheduleManager manager;
	private RepeatingView rv;
	private List<Schedule> scheduleList;
	private String scheduleName;
	private String scheduleDescription;
	private Boolean scheduleRandomization;

	public SchedulePage(PageParameters param) {
		super(param, "scheduleTitle");
		init();
	}

	protected void init() {
		manager = new ScheduleManager();

		Form<Schedule> formSchedule = new Form<Schedule>("scheduleForm");
		add(formSchedule);

		TextField<String> scheduleNameField = new TextField<String>("scheduleName", new PropertyModel<String>(this,
				"scheduleName"));
		scheduleNameField.setRequired(true);
		formSchedule.add(scheduleNameField);

		TextArea<String> scheduleDescriptionField = new TextArea<String>("scheduleDescription", new PropertyModel<String>(
				this, "scheduleDescription"));
		formSchedule.add(scheduleDescriptionField);

		CheckBox randomCB = new CheckBox("scheduleRandomization", new PropertyModel<Boolean>(this, "scheduleRandomization"));
		formSchedule.add(randomCB);

		Button scheduleOrder = new Button("scheduleOrder") {
			private static final long serialVersionUID = 8354044262314174400L;

			@Override
			public void onSubmit() {
				super.onSubmit();

				Schedule schedule = manager.order(scheduleRandomization);
				schedule.setName(scheduleName);
				schedule.setDescription(scheduleDescription);

				Session session = Databinder.getHibernateSession();
				session.beginTransaction();
				session.save(schedule);
				session.getTransaction().commit();
				
				getSession().info(getString("scheduleCreate", null, "scheduleCreate"));

				setResponsePage(SchedulePage.class);
			}
		};
		scheduleOrder.add(new AttributeModifier("value", true, new ResourceModel("scheduleOrder", "scheduleOrder")));
		formSchedule.add(scheduleOrder);

		rv = new RepeatingView("schedules");
		rv.setOutputMarkupId(true);
		add(rv);

		scheduleList = new HibernateListModel<Schedule>(Schedule.class).getObject();
		for(Schedule s : scheduleList) {
			SchedulePanel sp = new SchedulePanel(rv.newChildId(), s, SchedulePage.this);
			sp.setRenderBodyOnly(true);
			rv.add(sp);
		}
	}
}
