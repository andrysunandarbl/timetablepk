package eu.paniw.timetable.pages.unitdef.group;

import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.entity.Group;
import eu.paniw.timetable.pages.unitdef.UnitDefListPage;

@MountPath(path = "group")
public class GroupListPage extends UnitDefListPage<Group> {
	public GroupListPage(PageParameters param) {
		super(param, Group.class);
		init();
	}

	@Override
	protected void init() {
		columns.add(new PropertyColumn<Group>(new Model<String>("Parent"), "parent", "parent.unifyName"));

		super.init();
	}
}
