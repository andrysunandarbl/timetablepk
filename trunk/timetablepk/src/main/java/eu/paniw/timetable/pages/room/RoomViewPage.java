package eu.paniw.timetable.pages.room;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.entity.Room;
import eu.paniw.timetable.pages.ViewPage;

@MountPath(path = "room/view")
@MountMixedParam(parameterNames = {"id"})
public class RoomViewPage extends ViewPage<Room> {
	public RoomViewPage(PageParameters param) {
		super(param, "roomTitle", Room.class, RoomListPage.class, RoomEditPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		Label idL = new Label("item", new PropertyModel<String>(hom, "id"));
		builder.addComponent(idL, "app.id");

		Label nameL = new Label("item", new PropertyModel<String>(hom, "name"));
		builder.addComponent(nameL, "room.name");

		Label capacityL = new Label("item", new PropertyModel<String>(hom, "capacity"));
		builder.addComponent(capacityL, "room.capacity");

		Label lectureL = new Label("item", new PropertyModel<String>(hom, "lecture"));
		builder.addComponent(lectureL, "room.lecture");
	}
}
