package eu.paniw.timetable.pages.user;

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
import eu.paniw.timetable.domain.entity.User;
import eu.paniw.timetable.pages.ListPage;
import eu.paniw.timetable.panel.LinksPanel;
import eu.paniw.timetable.tool.LinkTool;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "user", alt = "users")
public class UserListPage extends ListPage<User> {
	public UserListPage(PageParameters param) {
		super(param, User.class);
		init();
	}

	@Override
	protected void init() {
		asdp = new UserSortableDataProvider(User.class);

		columns = new ArrayList<IColumn<User>>();
		columns.add(new PropertyColumn<User>(new Model<String>(getString("app.id", null, "app.id")), "id", "id"));
		columns.add(new PropertyColumn<User>(new Model<String>(getString("user.userName", null, "user.userName")), "userName",
				"userName"));
		columns.add(new PropertyColumn<User>(new Model<String>(getString("user.firstname", null, "user.firstname")),
				"firstname", "firstname"));
		columns.add(new PropertyColumn<User>(new Model<String>(getString("user.surname", null, "user.surname")), "surname",
				"surname"));
		columns.add(new PropertyColumn<User>(new Model<String>(getString("user.active", null, "user.active")), "active",
				"active"));
		columns.add(new AbstractColumn<User>(new Model<String>(getString("app.actions", null, "app.actions"))) {
			private static final long serialVersionUID = 472860112165821493L;

			@Override
			public void populateItem(Item<ICellPopulator<User>> cellItem, String componentId, IModel<User> rowModel) {
				cellItem.add(new LinksPanel(componentId).addLink(
						new BookmarkablePageLink<Page>("link", UserViewPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "app.view").addLink(
						new BookmarkablePageLink<Page>("link", UserEditPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "app.edit").addLink(
						LinkTool.getDeleteLink("link", rowModel.getObject(), getString("app.delquestion", null,
								"app.delquestion"), asdp, wmc), "app.delete"));
			}
		});

		super.init();
	}
}
