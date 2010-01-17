package eu.paniw.timetable.pages.room;

import java.util.ArrayList;
import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.entity.Room;
import eu.paniw.timetable.pages.ListPage;
import eu.paniw.timetable.panel.LinksPanel;
import eu.paniw.timetable.tool.LinkTool;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "room", alt = "rooms")
public class RoomListPage extends ListPage<Room> {
	public RoomListPage(PageParameters param) {
		super(param, "roomTitle", Room.class, RoomEditPage.class);
		init();
	}

	@Override
	protected void init() {
		asdp = new RoomSortableDataProvider(Room.class);

		columns = new ArrayList<IColumn<Room>>();
		columns.add(new PropertyColumn<Room>(new Model<String>(getString("app.id", null, "app.id")), "id", "id"));
		columns.add(new PropertyColumn<Room>(new Model<String>(getString("room.name", null, "room.name")), "name", "name"));
		columns.add(new PropertyColumn<Room>(new Model<String>(getString("room.capacity", null, "room.capacity")), "capacity",
				"capacity"));
		columns.add(new PropertyColumn<Room>(new Model<String>(getString("room.lecture", null, "room.lecture")), "lecture",
				"lecture"));
		columns.add(new AbstractColumn<Room>(new Model<String>(getString("app.actions", null, "app.actions"))) {
			private static final long serialVersionUID = -917688005338370119L;

			@Override
			public void populateItem(Item<ICellPopulator<Room>> cellItem, String componentId, IModel<Room> rowModel) {
				cellItem.add(new LinksPanel(componentId).addLink(
						new BookmarkablePageLink<Page>("link", RoomViewPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "app.view").addLink(
						new BookmarkablePageLink<Page>("link", RoomEditPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "app.edit").addLink(
						LinkTool.getDeleteLink("link", rowModel.getObject(), getString("app.delquestion", null,
								"app.delquestion"), asdp, wmc), "app.delete"));
			}
		});

		super.init();
	}
}