package eu.paniw.timetable.pages.room;

import java.util.ArrayList;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.entity.Room;
import eu.paniw.timetable.pages.ListPage;

@MountPath(path = "room")
public class RoomListPage extends ListPage<Room> {
	public RoomListPage(PageParameters param) {
		super(param, Room.class);
		init();
	}

	@Override
	protected void init() {
		asdp = new RoomSortableDataProvider(Room.class);

		columns = new ArrayList<IColumn<Room>>();
		columns.add(new PropertyColumn<Room>(new Model<String>("ID"), "id", "id"));
		columns.add(new PropertyColumn<Room>(new Model<String>("Name"), "name", "name"));
		columns.add(new PropertyColumn<Room>(new Model<String>("Cpacity"), "capacity", "capacity"));
		columns.add(new PropertyColumn<Room>(new Model<String>("Lecture"), "lecture", "lecture"));

		super.init();
	}
}