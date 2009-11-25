package eu.paniw.timetable.pages.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.databinder.models.hib.CriteriaBuilder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import eu.paniw.timetable.AbstractSortableDataProvider;
import eu.paniw.timetable.domain.app.Menu;

public class MenuSortableDataProvider extends AbstractSortableDataProvider<Menu> {
	private static final long serialVersionUID = -3321157340128977641L;

	public MenuSortableDataProvider(Class<Menu> clazz) {
		this(clazz, null);
	}

	public MenuSortableDataProvider(Class<Menu> clazz, CriteriaBuilder criteriaBuilder) {
		super(clazz, criteriaBuilder);
	}

	public List<Menu> selectItems(int first, int count, final SortParam sortParam) {
		List<Menu> sortItems = new ArrayList<Menu>(items);
		if(sortParam != null) {
			if(sortParam.getProperty().equals("id")) {
				Collections.sort(sortItems, new Comparator<Menu>() {
					public int compare(Menu arg0, Menu arg1) {
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
				Collections.sort(sortItems, new Comparator<Menu>() {
					public int compare(Menu arg0, Menu arg1) {
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
			} else if(sortParam.getProperty().equals("menuPosition")) {
				Collections.sort(sortItems, new Comparator<Menu>() {
					public int compare(Menu arg0, Menu arg1) {
						int result;

						if(arg0.getMenuPosition() != null && arg1.getMenuPosition() != null) {
							result = arg0.getMenuPosition().compareTo(arg1.getMenuPosition());
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
