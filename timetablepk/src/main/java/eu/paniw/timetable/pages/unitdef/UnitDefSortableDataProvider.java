package eu.paniw.timetable.pages.unitdef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.databinder.models.hib.CriteriaBuilder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import eu.paniw.timetable.AbstractSortableDataProvider;
import eu.paniw.timetable.domain.entity.UnitDef;

public class UnitDefSortableDataProvider<T extends UnitDef> extends AbstractSortableDataProvider<T> {
	private static final long serialVersionUID = 8843796739070505294L;

	public UnitDefSortableDataProvider(Class<T> clazz) {
		this(clazz, null);
	}

	public UnitDefSortableDataProvider(Class<T> clazz, CriteriaBuilder criteriaBuilder) {
		super(clazz, criteriaBuilder);
	}

	public List<T> selectItems(int first, int count, final SortParam sortParam) {
		List<T> sortItems = new ArrayList<T>(items);
		if(sortParam != null) {
			if(sortParam.getProperty().equals("id")) {
				Collections.sort(sortItems, new Comparator<T>() {
					public int compare(T arg0, T arg1) {
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
				Collections.sort(sortItems, new Comparator<T>() {
					public int compare(T arg0, T arg1) {
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
			} else if(sortParam.getProperty().equals("count")) {
				Collections.sort(sortItems, new Comparator<T>() {
					public int compare(T arg0, T arg1) {
						int result;

						if(arg0.getCount() != null && arg1.getCount() != null) {
							result = arg0.getCount().compareTo(arg1.getCount());
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
			} else if(sortParam.getProperty().equals("parent")) {
				Collections.sort(sortItems, new Comparator<T>() {
					public int compare(T arg0, T arg1) {
						int result;

						if(arg0.getParent() != null && arg1.getParent() != null) {
							result = arg0.getParent().getUnifyName().compareTo(arg1.getParent().getUnifyName());
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
