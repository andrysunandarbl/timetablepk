package eu.paniw.timetable.pages.unitdef.group;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.entity.Group;
import eu.paniw.timetable.pages.unitdef.UnitDefViewPage;

@MountPath(path = "group/view")
@MountMixedParam(parameterNames = {"id"})
public class GroupViewPage extends UnitDefViewPage<Group> {
	public GroupViewPage(PageParameters param) {
		super(param, "groupTitle", Group.class, GroupListPage.class, GroupEditPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		Label unitL = new Label("item", new PropertyModel<String>(hom, "parent.unifyName"));
		builder.addComponent(unitL, "group.parent");
	}
}
