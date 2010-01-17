package eu.paniw.timetable.algorithm;

import java.util.ArrayList;
import java.util.List;
import net.databinder.models.hib.HibernateListModel;
import eu.paniw.timetable.domain.entity.BeginTimes;
import eu.paniw.timetable.domain.entity.Course;
import eu.paniw.timetable.domain.entity.Room;
import eu.paniw.timetable.domain.entity.Teacher;
import eu.paniw.timetable.domain.entity.UnitDef;

public class SchedulerInput {
	private List<UnitDef> units;
	private List<Course> courses;
	private List<Room> rooms;
	private List<Teacher> teachers;
	private int maxRowsAtDay = 5;
	private List<String> beginTimes;
	private Boolean randomInput = false;

	public SchedulerInput() {
		this(5);
	}

	public SchedulerInput(int maxRowsAtDay) {
		this(maxRowsAtDay, false);
	}

	public SchedulerInput(int maxRowsAtDay, Boolean randomInput) {
		this.maxRowsAtDay = maxRowsAtDay;
		this.randomInput = randomInput;
		init();
	}

	private void init() {
		units = new HibernateListModel<UnitDef>(UnitDef.class).getObject();
		courses = new HibernateListModel<Course>(Course.class).getObject();
		rooms = new HibernateListModel<Room>(Room.class).getObject();
		teachers = new HibernateListModel<Teacher>(Teacher.class).getObject();

		beginTimes = new ArrayList<String>();
		for(BeginTimes bt : BeginTimes.values()) {
			beginTimes.add(bt.getBeginTime());
		}
	}

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