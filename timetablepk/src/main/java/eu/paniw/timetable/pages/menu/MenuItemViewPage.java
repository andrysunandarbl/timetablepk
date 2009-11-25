package eu.paniw.timetable.pages.menu;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.app.MenuItem;
import eu.paniw.timetable.pages.ViewPage;

@MountPath(path = "menu/menuitem/view")
@MountMixedParam(parameterNames = {"id"})
public class MenuItemViewPage extends ViewPage<MenuItem> {
	public MenuItemViewPage(PageParameters param) {
		super(param, MenuItem.class, MenuItemListPage.class, MenuItemEditPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		Label idL = new Label("item", new PropertyModel<String>(hom, "id"));
		builder.addComponent(idL, "menuitem.id");

		Label nameL = new Label("item", new PropertyModel<String>(hom, "name"));
		builder.addComponent(nameL, "menuitem.id.name");

		Label positionL = new Label("item", new PropertyModel<String>(hom, "position"));
		builder.addComponent(positionL, "menuitem.position");

		Label addressL = new Label("item", new PropertyModel<String>(hom, "address"));
		builder.addComponent(addressL, "menuitem.address");
	}
}
