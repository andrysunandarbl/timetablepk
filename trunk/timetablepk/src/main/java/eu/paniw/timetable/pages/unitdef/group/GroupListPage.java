package eu.paniw.timetable.pages.unitdef.group;

import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.entity.Group;
import eu.paniw.timetable.pages.unitdef.UnitDefListPage;
import eu.paniw.timetable.panel.LinksPanel;
import eu.paniw.timetable.tool.LinkTool;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "group", alt = "groups")
public class GroupListPage extends UnitDefListPage<Group> {
	public GroupListPage(PageParameters param) {
		super(param, Group.class);
		init();
	}

	@Override
	protected void init() {
		columns.add(new PropertyColumn<Group>(new Model<String>("Parent"), "parent", "parent.unifyName"));
		columns.add(new AbstractColumn<Group>(new Model<String>("Actions")) {
			private static final long serialVersionUID = -1455881377506448240L;

			@Override
			public void populateItem(Item<ICellPopulator<Group>> cellItem, String componentId, IModel<Group> rowModel) {
				cellItem.add(new LinksPanel(componentId).addLink(
						new BookmarkablePageLink<Page>("link", GroupViewPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "list.view").addLink(
						new BookmarkablePageLink<Page>("link", GroupEditPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "list.edit").addLink(
						LinkTool.getDeleteLink("link", rowModel.getObject(), "Are you sure?", asdp, wmc), "list.delete"));
			}
		});

		super.init();
	}
}
