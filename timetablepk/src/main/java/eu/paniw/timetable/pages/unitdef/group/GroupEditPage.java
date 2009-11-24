package eu.paniw.timetable.pages.unitdef.group;

import net.databinder.models.hib.HibernateListModel;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.entity.Group;
import eu.paniw.timetable.domain.entity.Unit;
import eu.paniw.timetable.pages.unitdef.UnitDefEditPage;

@MountPath(path = "group/edit", alt = "group/add")
@MountMixedParam(parameterNames = {"id"})
public class GroupEditPage extends UnitDefEditPage<Group> {
	public GroupEditPage(PageParameters param) {
		super(param, Group.class, GroupViewPage.class, GroupListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		DropDownChoice<Unit> parentDDC = new DropDownChoice<Unit>("formfield",
				new PropertyModel<Unit>(getFormModel(), "count"), new HibernateListModel<Unit>(Unit.class),
				new ChoiceRenderer<Unit>("unifyName", "id"));
		builder.addComponent(parentDDC, "group.unit");
	}
}
