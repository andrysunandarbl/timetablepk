package eu.paniw.timetable.pages.teacher;

import java.util.List;
import net.databinder.models.hib.HibernateListModel;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.form.palette.Palette;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.entity.Course;
import eu.paniw.timetable.domain.entity.Teacher;
import eu.paniw.timetable.pages.EditPage;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "teacher/edit", alt = "teacher/add")
@MountMixedParam(parameterNames = {"id"})
public class TeacherEditPage extends EditPage<Teacher> {
	public TeacherEditPage(PageParameters param) {
		super(param, Teacher.class, TeacherViewPage.class, TeacherListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		TextField<String> degreeTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "degree"));
		degreeTF.setRequired(true);
		builder.addComponent(degreeTF, "teacher.degree");

		TextField<String> firstnameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "firstname"));
		firstnameTF.setRequired(true);
		builder.addComponent(firstnameTF, "teacher.firstname");

		TextField<String> surnameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "surname"));
		builder.addComponent(surnameTF, "teacher.surname");

		Palette<Course> unitsP = new Palette<Course>("item", new PropertyModel<List<Course>>(getFormModel(), "courses"),
				new HibernateListModel<Course>(Course.class), new ChoiceRenderer<Course>("unifyName", "id"), 5, false);
		builder.addComponent(unitsP, "teacher.courses");
	}

	@Override
	public void onAfterSubmit() {
		responseParam = new PageParametersTool("id", getFormModel().getObject().getId()).getPP();
	}
}
