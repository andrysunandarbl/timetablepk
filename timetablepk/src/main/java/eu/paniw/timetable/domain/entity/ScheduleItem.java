package eu.paniw.timetable.domain.entity;

public class ScheduleItem {
	private UnitDef unit = null;
	private Course course = null;
	private Room room = null;
	private Teacher teacher = null;

	public UnitDef getUnit() {
		return unit;
	}

	public void setUnit(UnitDef unit) {
		this.unit = unit;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
