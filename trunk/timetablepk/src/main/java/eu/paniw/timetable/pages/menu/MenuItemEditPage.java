package eu.paniw.timetable.pages.menu;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.MinimumValidator;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.app.MenuItem;
import eu.paniw.timetable.pages.EditPage;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "menu/menuitem/edit", alt = "menu/menuitem/add")
@MountMixedParam(parameterNames = {"id"})
public class MenuItemEditPage extends EditPage<MenuItem> {
	public MenuItemEditPage(PageParameters param) {
		super(param, MenuItem.class, MenuItemViewPage.class, MenuItemListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		TextField<String> nameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "name"));
		nameTF.setRequired(true);
		builder.addComponent(nameTF, "menuitem.name");

		TextField<Integer> positionTF = new TextField<Integer>("item",
				new PropertyModel<Integer>(getFormModel(), "position"));
		positionTF.add(new MinimumValidator<Integer>(0));
		positionTF.setRequired(true);
		builder.addComponent(positionTF, "menuitem.position");

		TextField<String> addressTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "address"));
		addressTF.setRequired(true);
		builder.addComponent(addressTF, "menuitem.address");
	}

	@Override
	public void onAfterSubmit() {
		responseParam = new PageParametersTool("id", getFormModel().getObject().getId()).getPP();
	}
}