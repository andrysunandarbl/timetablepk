package eu.paniw.timetable.pages.menu;

import java.util.ArrayList;
import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.app.Menu;
import eu.paniw.timetable.pages.ListPage;
import eu.paniw.timetable.panel.LinksPanel;
import eu.paniw.timetable.tool.LinkTool;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "menu", alt = "menus")
@AuthorizeInstantiation("ADMIN")
public class MenuListPage extends ListPage<Menu> {
	public MenuListPage(PageParameters param) {
		super(param, "menuTitle", Menu.class, MenuEditPage.class);
		init();
	}

	@Override
	protected void init() {
		asdp = new MenuSortableDataProvider(Menu.class);

		columns = new ArrayList<IColumn<Menu>>();
		columns.add(new PropertyColumn<Menu>(new Model<String>(getString("app.id", null, "app.id")), "id", "id"));
		columns.add(new PropertyColumn<Menu>(new Model<String>(getString("menu.name", null, "menu.name")), "name", "name"));
		columns.add(new PropertyColumn<Menu>(new Model<String>(getString("menu.menuPosition", null, "menu.menuPosition")),
				"menuPosition", "menuPosition"));
		columns.add(new PropertyColumn<Menu>(new Model<String>(getString("menu.position", null, "menu.position")), "position",
				"position"));
		columns.add(new PropertyColumn<Menu>(new Model<String>(getString("menu.address", null, "menu.address")), "address",
				"address"));
		columns.add(new PropertyColumn<Menu>(new Model<String>(getString("menu.secondLevel", null, "menu.secondLevel")),
				"secondLevel", "secondLevel"));
		columns.add(new AbstractColumn<Menu>(new Model<String>(getString("app.actions", null, "app.actions"))) {
			private static final long serialVersionUID = -5779057576370409825L;

			@Override
			public void populateItem(Item<ICellPopulator<Menu>> cellItem, String componentId, IModel<Menu> rowModel) {
				cellItem.add(new LinksPanel(componentId).addLink(
						new BookmarkablePageLink<Page>("link", MenuViewPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "app.view").addLink(
						new BookmarkablePageLink<Page>("link", MenuEditPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "app.edit").addLink(
						LinkTool.getDeleteLink("link", rowModel.getObject(), getString("app.delquestion", null,
								"app.delquestion"), asdp, wmc), "app.delete"));
			}
		});

		super.init();
	}
}
