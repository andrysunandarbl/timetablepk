package eu.paniw.timetable.pages.teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.databinder.models.hib.CriteriaBuilder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import eu.paniw.timetable.AbstractSortableDataProvider;
import eu.paniw.timetable.domain.entity.Teacher;

public class TeacherSortableDataProvider extends AbstractSortableDataProvider<Teacher> {
	private static final long serialVersionUID = 4407454712450741477L;

	public TeacherSortableDataProvider(Class<Teacher> clazz) {
		this(clazz, null);
	}

	public TeacherSortableDataProvider(Class<Teacher> clazz, CriteriaBuilder criteriaBuilder) {
		super(clazz, criteriaBuilder);
	}

	public List<Teacher> selectItems(int first, int count, final SortParam sortParam) {
		List<Teacher> sortItems = new ArrayList<Teacher>(items);
		if(sortParam != null) {
			if(sortParam.getProperty().equals("id")) {
				Collections.sort(sortItems, new Comparator<Teacher>() {
					public int compare(Teacher arg0, Teacher arg1) {
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
			} else if(sortParam.getProperty().equals("firstname")) {
				Collections.sort(sortItems, new Comparator<Teacher>() {
					public int compare(Teacher arg0, Teacher arg1) {
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
				Collections.sort(sortItems, new Comparator<Teacher>() {
					public int compare(Teacher arg0, Teacher arg1) {
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
			} else if(sortParam.getProperty().equals("degree")) {
				Collections.sort(sortItems, new Comparator<Teacher>() {
					public int compare(Teacher arg0, Teacher arg1) {
						int result;

						if(arg0.getDegree() != null && arg1.getDegree() != null) {
							result = arg0.getDegree().compareTo(arg1.getDegree());
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
