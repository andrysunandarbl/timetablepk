package eu.paniw.timetable.algorithm;

import eu.paniw.timetable.domain.entity.*;
import java.util.List;
import java.util.ArrayList;

public class SchedulerInput {
	private List<UnitDef> units = new ArrayList<UnitDef>();
	private List<Course> courses = new ArrayList<Course>();
	private List<Room> rooms = new ArrayList<Room>();
	private List<Teacher> teachers = new ArrayList<Teacher>();
	private int maxRowsAtDay = 0;
	private List<String> beginTimes = new ArrayList<String>();
	private boolean randomInput = false;

	public boolean isRandomInput() {
		return randomInput;
	}

	public void setRandomInput(boolean randomInput) {
		this.randomInput = randomInput;
	}

	public List<UnitDef> getUnits() {
		return units;
	}

	public void setUnits(List<UnitDef> units) {
		this.units = units;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public int getMaxRowsAtDay() {
		return maxRowsAtDay;
	}

	public void setMaxRowsAtDay(int maxRowsAtDay) {
		this.maxRowsAtDay = maxRowsAtDay;
	}

	public List<String> getBeginTimes() {
		return beginTimes;
	}

	public void setBeginTimes(List<String> beginTimes) {
		this.beginTimes = beginTimes;
	}
}