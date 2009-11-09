package eu.paniw.timetable.pages.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.databinder.models.hib.HibernateListModel;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import eu.paniw.timetable.data.User;

public class UserSortableDataProvider implements Serializable {
	private static final long serialVersionUID = -1246704563274459067L;
	private List<User> items;

	public UserSortableDataProvider() {
		items = new HibernateListModel<User>(User.class).getObject();
	}

	public List<User> getItems() {
		return items;
	}

	public List<User> selectItems(int first, int count, final SortParam sortParam) {
		List<User> sortItems = new ArrayList<User>(items);
		if(sortParam != null) {
			if(sortParam.getProperty().equals("id")) {
				Collections.sort(sortItems, new Comparator<User>() {
					public int compare(User arg0, User arg1) {
						int result = arg0.getId().compareTo(arg1.getId());
						return sortParam.isAscending() ? result : -result;
					}
				});
			} else if(sortParam.getProperty().equals("userName")) {
				Collections.sort(sortItems, new Comparator<User>() {
					public int compare(User arg0, User arg1) {
						int result = arg0.getUserName().compareTo(arg1.getUserName());
						return sortParam.isAscending() ? result : -result;
					}
				});
			} else if(sortParam.getProperty().equals("firstname")) {
				Collections.sort(sortItems, new Comparator<User>() {
					public int compare(User arg0, User arg1) {
						int result = arg0.getFirstname().compareTo(arg1.getFirstname());
						return sortParam.isAscending() ? result : -result;
					}
				});
			} else if(sortParam.getProperty().equals("surname")) {
				Collections.sort(sortItems, new Comparator<User>() {
					public int compare(User arg0, User arg1) {
						int result = arg0.getSurname().compareTo(arg1.getSurname());
						return sortParam.isAscending() ? result : -result;
					}
				});
			} else if(sortParam.getProperty().equals("active")) {
				Collections.sort(sortItems, new Comparator<User>() {
					public int compare(User arg0, User arg1) {
						int result = arg0.getActive().compareTo(arg1.getActive());
						return sortParam.isAscending() ? result : -result;
					}
				});
			}
		}
		return sortItems.subList(first, first + count);
	}
}
