package eu.paniw.timetable.pages.room;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.MinimumValidator;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.entity.Room;
import eu.paniw.timetable.pages.EditPage;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "room/edit", alt = "room/add")
@MountMixedParam(parameterNames = {"id"})
public class RoomEditPage extends EditPage<Room> {
	public RoomEditPage(PageParameters param) {
		super(param, Room.class, RoomViewPage.class, RoomListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		TextField<String> nameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "name"));
		nameTF.setRequired(true);
		builder.addComponent(nameTF, "room.name");

		TextField<Integer> capacityTF = new TextField<Integer>("item", new PropertyModel<Integer>(getFormModel(), "capacity"));
		capacityTF.setRequired(true);
		capacityTF.add(new MinimumValidator<Integer>(0));
		builder.addComponent(capacityTF, "room.capacity");

		CheckBox lectureCB = new CheckBox("item", new PropertyModel<Boolean>(getFormModel(), "lecture"));
		builder.addComponent(lectureCB, "room.lecture");
	}

	@Override
	public void onAfterSubmit() {
		responseParam = new PageParametersTool("id", getFormModel().getObject().getId()).getPP();
	}
}
