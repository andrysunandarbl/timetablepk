package eu.paniw.timetable.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDay {
	private List<ScheduleRow> rows;
	private Day day;

	public ScheduleDay() {
	}

	public ScheduleDay(Day day) {
		rows = new ArrayList<ScheduleRow>();
		this.day = day;
	}

	public List<ScheduleRow> getRows() {
		return rows;
	}

	public void add(ScheduleRow item) {
		rows.add(item);
	}

	public void clear() {
		rows.clear();
	}

	public int size() {
		return rows.size();
	}

	public ScheduleRow get(int index) {
		return rows.get(index);
	}
}
