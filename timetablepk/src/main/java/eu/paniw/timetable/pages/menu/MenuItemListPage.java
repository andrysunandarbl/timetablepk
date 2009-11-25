package eu.paniw.timetable.pages.menu;

import java.util.ArrayList;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.app.MenuItem;
import eu.paniw.timetable.pages.ListPage;

@MountPath(path = "menu/menuitem")
public class MenuItemListPage extends ListPage<MenuItem> {
	public MenuItemListPage(PageParameters param) {
		super(param, MenuItem.class);
		init();
	}

	@Override
	protected void init() {
		asdp = new MenuItemSortableDataProvider(MenuItem.class);

		columns = new ArrayList<IColumn<MenuItem>>();
		columns.add(new PropertyColumn<MenuItem>(new Model<String>("ID"), "id", "id"));
		columns.add(new PropertyColumn<MenuItem>(new Model<String>("Name"), "name", "name"));
		columns.add(new PropertyColumn<MenuItem>(new Model<String>("Position"), "position", "position"));
		columns.add(new PropertyColumn<MenuItem>(new Model<String>("Address"), "address", "address"));

		super.init();
	}
}
