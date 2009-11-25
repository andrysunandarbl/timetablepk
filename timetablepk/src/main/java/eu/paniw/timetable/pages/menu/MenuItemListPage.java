package eu.paniw.timetable.pages.menu;

import java.util.ArrayList;
import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.app.MenuItem;
import eu.paniw.timetable.pages.ListPage;
import eu.paniw.timetable.panel.LinksPanel;
import eu.paniw.timetable.tool.LinkTool;
import eu.paniw.timetable.tool.PageParametersTool;

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
		columns.add(new AbstractColumn<MenuItem>(new Model<String>("Actions")) {
			private static final long serialVersionUID = 1554068675120404389L;

			@Override
			public void populateItem(Item<ICellPopulator<MenuItem>> cellItem, String componentId, IModel<MenuItem> rowModel) {
				cellItem.add(new LinksPanel(componentId).addLink(
						new BookmarkablePageLink<Page>("link", MenuItemViewPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "list.view").addLink(
						new BookmarkablePageLink<Page>("link", MenuItemEditPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "list.edit").addLink(
						LinkTool.getDeleteLink("link", rowModel.getObject(), "Are you sure?", asdp, wmc), "list.delete"));
			}
		});

		super.init();
	}
}
