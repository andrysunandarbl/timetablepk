package eu.paniw.timetable.pages.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.databinder.models.hib.CriteriaBuilder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import eu.paniw.timetable.AbstractSortableDataProvider;
import eu.paniw.timetable.domain.entity.Course;

public class CourseSortableDataProvider extends AbstractSortableDataProvider<Course> {
	private static final long serialVersionUID = -3115307782215371131L;

	public CourseSortableDataProvider(Class<Course> clazz) {
		this(clazz, null);
	}

	public CourseSortableDataProvider(Class<Course> clazz, CriteriaBuilder criteriaBuilder) {
		super(clazz, criteriaBuilder);
	}

	public List<Course> selectItems(int first, int count, final SortParam sortParam) {
		List<Course> sortItems = new ArrayList<Course>(items);
		if(sortParam != null) {
			if(sortParam.getProperty().equals("id")) {
				Collections.sort(sortItems, new Comparator<Course>() {
					public int compare(Course arg0, Course arg1) {
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
				Collections.sort(sortItems, new Comparator<Course>() {
					public int compare(Course arg0, Course arg1) {
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
			} else if(sortParam.getProperty().equals("lecture")) {
				Collections.sort(sortItems, new Comparator<Course>() {
					public int compare(Course arg0, Course arg1) {
						int result;

						if(arg0.getLecture() != null && arg1.getLecture() != null) {
							result = arg0.getLecture().compareTo(arg1.getLecture());
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
