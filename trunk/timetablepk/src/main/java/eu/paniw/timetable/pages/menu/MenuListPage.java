package eu.paniw.timetable.pages.menu;

import java.util.ArrayList;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.app.Menu;
import eu.paniw.timetable.pages.ListPage;

@MountPath(path = "menu/menu", alt = "menu")
public class MenuListPage extends ListPage<Menu> {
	public MenuListPage(PageParameters param) {
		super(param, Menu.class);
		init();
	}

	@Override
	protected void init() {
		asdp = new MenuSortableDataProvider(Menu.class);

		columns = new ArrayList<IColumn<Menu>>();
		columns.add(new PropertyColumn<Menu>(new Model<String>("ID"), "id", "id"));
		columns.add(new PropertyColumn<Menu>(new Model<String>("Name"), "name", "name"));
		columns.add(new PropertyColumn<Menu>(new Model<String>("Menu position"), "menuPosition", "menuPosition"));

		super.init();
	}
}
