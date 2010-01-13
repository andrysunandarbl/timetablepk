package eu.paniw.timetable.domain.entity;

import java.util.HashMap;
import eu.paniw.timetable.algorithm.SchedulerAlgorithm;

public class Schedule {
	private HashMap<Day, ScheduleDay> schedule;

	private Schedule() {
		schedule = new HashMap<Day, ScheduleDay>();
		for(Day day : Day.values()) {
			schedule.put(day, new ScheduleDay());
		}
	}

	public static Schedule create(SchedulerAlgorithm algorithm) throws Exception {
		return algorithm.generate();
	}

	public static Schedule create() {
		return new Schedule();
	}

	public HashMap<Day, ScheduleDay> getSchedule() {
		return schedule;
	}

	public ScheduleDay get(Day day) {
		ScheduleDay sday = schedule.get(day);
		if(sday == null) {
			sday = new ScheduleDay();
			schedule.put(day, sday);
		}
		return sday;
	}

	public void set(Day day, ScheduleDay sday) {
		schedule.put(day, sday);
	}

	public void add(Day day, ScheduleDay sday) {
		schedule.put(day, sday);
	}

	public void clear() {
		schedule.clear();
	}
}
