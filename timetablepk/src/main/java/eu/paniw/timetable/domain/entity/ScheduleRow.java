package eu.paniw.timetable.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class ScheduleRow {
	private List<ScheduleItem> items;

	public ScheduleRow() {
		items = new ArrayList<ScheduleItem>();
	}

	public List<ScheduleItem> getItems() {
		return items;
	}

	public void add(ScheduleItem item) {
		items.add(item);
	}

	public void clear() {
		items.clear();
	}

	public int size() {
		return items.size();
	}

	public ScheduleItem get(int index) {
		return items.get(index);
	}
}
