package eu.paniw.timetable.pages.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.databinder.models.hib.CriteriaBuilder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import eu.paniw.timetable.AbstractSortableDataProvider;
import eu.paniw.timetable.domain.app.MenuItem;

public class MenuItemSortableDataProvider extends AbstractSortableDataProvider<MenuItem> {
	private static final long serialVersionUID = 9166199360826774763L;

	public MenuItemSortableDataProvider(Class<MenuItem> clazz) {
		this(clazz, null);
	}

	public MenuItemSortableDataProvider(Class<MenuItem> clazz, CriteriaBuilder criteriaBuilder) {
		super(clazz, criteriaBuilder);
	}

	public List<MenuItem> selectItems(int first, int count, final SortParam sortParam) {
		List<MenuItem> sortItems = new ArrayList<MenuItem>(items);
		if(sortParam != null) {
			if(sortParam.getProperty().equals("id")) {
				Collections.sort(sortItems, new Comparator<MenuItem>() {
					public int compare(MenuItem arg0, MenuItem arg1) {
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
			} else if(sortParam.getProperty().equals("name")) {
				Collections.sort(sortItems, new Comparator<MenuItem>() {
					public int compare(MenuItem arg0, MenuItem arg1) {
						int result;

						if(arg0.getName() != null && arg1.getName() != null) {
							result = arg0.getName().compareTo(arg1.getName());
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
			} else if(sortParam.getProperty().equals("position")) {
				Collections.sort(sortItems, new Comparator<MenuItem>() {
					public int compare(MenuItem arg0, MenuItem arg1) {
						int result;

						if(arg0.getPosition() != null && arg1.getPosition() != null) {
							result = arg0.getPosition().compareTo(arg1.getPosition());
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
			} else if(sortParam.getProperty().equals("address")) {
				Collections.sort(sortItems, new Comparator<MenuItem>() {
					public int compare(MenuItem arg0, MenuItem arg1) {
						int result;

						if(arg0.getAddress() != null && arg1.getAddress() != null) {
							result = arg0.getAddress().compareTo(arg1.getAddress());
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
