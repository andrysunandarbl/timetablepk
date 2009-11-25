package eu.paniw.timetable.pages.menu;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.app.Menu;
import eu.paniw.timetable.pages.ViewPage;

@MountPath(path = "menu/menu/view")
@MountMixedParam(parameterNames = {"id"})
public class MenuViewPage extends ViewPage<Menu> {
	public MenuViewPage(PageParameters param) {
		super(param, Menu.class, MenuListPage.class, MenuEditPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		Label idL = new Label("item", new PropertyModel<String>(hom, "id"));
		builder.addComponent(idL, "menu.id");

		Label nameL = new Label("item", new PropertyModel<String>(hom, "name"));
		builder.addComponent(nameL, "menu.name");

		Label menuPositionL = new Label("item", new PropertyModel<String>(hom, "menuPosition"));
		builder.addComponent(menuPositionL, "menu.menuPosition");
	}
}
