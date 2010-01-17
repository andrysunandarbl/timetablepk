package eu.paniw.timetable.pages.menu;

import java.util.Arrays;
import net.databinder.models.hib.HibernateListModel;
import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.Application;
import eu.paniw.timetable.domain.app.Menu;
import eu.paniw.timetable.domain.app.MenuPosition;
import eu.paniw.timetable.domain.app.Translation;
import eu.paniw.timetable.domain.app.UserAppRole;
import eu.paniw.timetable.pages.EditPage;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "menu/edit", alt = "menu/add")
@MountMixedParam(parameterNames = {"id"})
@AuthorizeInstantiation("ADMIN")
public class MenuEditPage extends EditPage<Menu> {

	public MenuEditPage(PageParameters param) {
		super(param, "menuTitle", Menu.class, MenuViewPage.class, MenuListPage.class);
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

		CheckBox secondLevelCB = new CheckBox("item", new PropertyModel<Boolean>(getFormModel(), "secondLevel"));
		builder.addComponent(secondLevelCB, "menu.secondLevel");

		DropDownChoice<Translation> translationDDC = new DropDownChoice<Translation>("item", new PropertyModel<Translation>(
				getFormModel(), "translation"), new HibernateListModel<Translation>(Translation.class),
				new ChoiceRenderer<Translation>("key"));
		builder.addComponent(translationDDC, "menu.translation");

		DropDownChoice<UserAppRole> roleDDC = new DropDownChoice<UserAppRole>("item", new PropertyModel<UserAppRole>(
				getFormModel(), "role"), Arrays.asList(UserAppRole.values()));
		roleDDC.setRequired(true);
		roleDDC.setNullValid(false);
		builder.addComponent(roleDDC, "menu.role");
	}

	@Override
	public void onAfterSubmit() {
		((Application) getApplication()).getMenuLoader().refreshMenus();

		responseParam = new PageParametersTool("id", getFormModel().getObject().getId()).getPP();
	}
}
