package eu.paniw.timetable.pages.room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.databinder.models.hib.CriteriaBuilder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import eu.paniw.timetable.AbstractSortableDataProvider;
import eu.paniw.timetable.domain.entity.Room;

public class RoomSortableDataProvider extends AbstractSortableDataProvider<Room> {
	private static final long serialVersionUID = -932313643680589123L;

	public RoomSortableDataProvider(Class<Room> clazz) {
		this(clazz, null);
	}

	public RoomSortableDataProvider(Class<Room> clazz, CriteriaBuilder criteriaBuilder) {
		super(clazz, criteriaBuilder);
	}

	public List<Room> selectItems(int first, int count, final SortParam sortParam) {
		List<Room> sortItems = new ArrayList<Room>(items);
		if(sortParam != null) {
			if(sortParam.getProperty().equals("id")) {
				Collections.sort(sortItems, new Comparator<Room>() {
					public int compare(Room arg0, Room arg1) {
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
				Collections.sort(sortItems, new Comparator<Room>() {
					public int compare(Room arg0, Room arg1) {
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
			} else if(sortParam.getProperty().equals("capacity")) {
				Collections.sort(sortItems, new Comparator<Room>() {
					public int compare(Room arg0, Room arg1) {
						int result;

						if(arg0.getCapacity() != null && arg1.getCapacity() != null) {
							result = arg0.getCapacity().compareTo(arg1.getCapacity());
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
				Collections.sort(sortItems, new Comparator<Room>() {
					public int compare(Room arg0, Room arg1) {
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