package eu.paniw.timetable.pages.menu;

import java.util.Arrays;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.app.Menu;
import eu.paniw.timetable.domain.app.MenuPosition;
import eu.paniw.timetable.pages.EditPage;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "menu/edit", alt = "menu/add")
@MountMixedParam(parameterNames = {"id"})
public class MenuEditPage extends EditPage<Menu> {

	public MenuEditPage(PageParameters param) {
		super(param, Menu.class, MenuViewPage.class, MenuListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		TextField<String> nameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "name"));
		nameTF.setRequired(true);
		builder.addComponent(nameTF, "menu.name");

		DropDownChoice<MenuPosition> menuPositionDDC = new DropDownChoice<MenuPosition>("item",
				new PropertyModel<MenuPosition>(getFormModel(), "menuPosition"), Arrays.asList(MenuPosition.values())) {
			private static final long serialVersionUID = -3965739261427409287L;

			@Override
			protected CharSequence getDefaultChoice(Object selected) {
				return MenuPosition.MAIN.toString();
			}

		};
		menuPositionDDC.setRequired(true);
		builder.addComponent(menuPositionDDC, "menu.menuPosition");

		TextField<Integer> positionTF = new TextField<Integer>("item", new PropertyModel<Integer>(getFormModel(), "position"));
		positionTF.setRequired(true);
		builder.addComponent(positionTF, "menu.position");

		TextField<String> addressTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "address"));
		addressTF.setRequired(true);
		builder.addComponent(addressTF, "menu.address");
	}

	@Override
	public void onAfterSubmit() {
		responseParam = new PageParametersTool("id", getFormModel().getObject().getId()).getPP();
	}
}
