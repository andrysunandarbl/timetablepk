package eu.paniw.timetable.pages.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.databinder.models.hib.CriteriaBuilder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import eu.paniw.timetable.AbstractSortableDataProvider;
import eu.paniw.timetable.domain.entity.User;

public class UserSortableDataProvider extends AbstractSortableDataProvider<User> {
	private static final long serialVersionUID = -6847701513084846982L;

	public UserSortableDataProvider(Class<User> clazz) {
		this(clazz, null);
	}

	public UserSortableDataProvider(Class<User> clazz, CriteriaBuilder criteriaBuilder) {
		super(clazz, criteriaBuilder);
	}

	public List<User> selectItems(int first, int count, final SortParam sortParam) {
		List<User> sortItems = new ArrayList<User>(items);
		if(sortParam != null) {
			if(sortParam.getProperty().equals("id")) {
				Collections.sort(sortItems, new Comparator<User>() {
					public int compare(User arg0, User arg1) {
						int result;

						if(arg0.getId() != null && arg1.getId() != null) {
							result = arg0.getId().compareTo(arg1.getId());
						} else if(arg0 == null) {
							return -1;
						} else if(arg1 == null) {
							return 1;
						} else {
							return 0;
						}

						return sortParam.isAscending() ? result : -result;
					}
				});
			} else if(sortParam.getProperty().equals("userName")) {
				Collections.sort(sortItems, new Comparator<User>() {
					public int compare(User arg0, User arg1) {
						int result;

						if(arg0.getUserName() != null && arg1.getUserName() != null) {
							result = arg0.getUserName().compareTo(arg1.getUserName());
						} else if(arg0 == null) {
							return -1;
						} else if(arg1 == null) {
							return 1;
						} else {
							return 0;
						}

						return sortParam.isAscending() ? result : -result;
					}
				});
			} else if(sortParam.getProperty().equals("firstname")) {
				Collections.sort(sortItems, new Comparator<User>() {
					public int compare(User arg0, User arg1) {
						int result;

						if(arg0.getFirstname() != null && arg1.getFirstname() != null) {
							result = arg0.getFirstname().compareTo(arg1.getFirstname());
						} else if(arg0 == null) {
							return -1;
						} else if(arg1 == null) {
							return 1;
						} else {
							return 0;
						}

						return sortParam.isAscending() ? result : -result;
					}
				});
			} else if(sortParam.getProperty().equals("surname")) {
				Collections.sort(sortItems, new Comparator<User>() {
					public int compare(User arg0, User arg1) {
						int result;

						if(arg0.getSurname() != null && arg1.getSurname() != null) {
							result = arg0.getSurname().compareTo(arg1.getSurname());
						} else if(arg0 == null) {
							return -1;
						} else if(arg1 == null) {
							return 1;
						} else {
							return 0;
						}

						return sortParam.isAscending() ? result : -result;
					}
				});
			} else if(sortParam.getProperty().equals("active")) {
				Collections.sort(sortItems, new Comparator<User>() {
					public int compare(User arg0, User arg1) {
						int result;

						if(arg0.getActive() != null && arg1.getActive() != null) {
							result = arg0.getActive().compareTo(arg1.getActive());
						} else if(arg0 == null) {
							return -1;
						} else if(arg1 == null) {
							return 1;
						} else {
							return 0;
						}

						return sortParam.isAscending() ? result : -result;
					}
				});
			}
		}
		return sortItems.subList(first, first + count);
	}
}
