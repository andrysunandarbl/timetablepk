package eu.paniw.timetable.pages.user;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.data.User;
import eu.paniw.timetable.pages.ListPage;

@MountPath(path = "user/list")
public class UserListPage extends ListPage<User> {
	private UserSortableDataProvider usdp;

	public UserListPage(PageParameters param) {
		super(param, User.class);
		init();
	}

	@Override
	protected void init() {
		columns = new ArrayList<IColumn<User>>();
		columns.add(new PropertyColumn<User>(new Model<String>("ID"), "id", "id"));
		columns.add(new PropertyColumn<User>(new Model<String>("User name"), "userName", "userName"));
		columns.add(new PropertyColumn<User>(new Model<String>("First name"), "firstname", "firstname"));
		columns.add(new PropertyColumn<User>(new Model<String>("Surname"), "surname", "surname"));
		columns.add(new PropertyColumn<User>(new Model<String>("Active"), "active", "active"));

		usdp = new UserSortableDataProvider();

		provider = new SortableDataProvider<User>() {
			private static final long serialVersionUID = -502933560011908163L;

			@Override
			public Iterator<User> iterator(int first, int count) {
				return usdp.selectItems(first, count, getSort()).iterator();
			}

			@Override
			public IModel<User> model(User object) {
				return new Model<User>(object);
			}

			@Override
			public int size() {
				return usdp.getItems().size();
			}
		};

		super.init();
	}
}
