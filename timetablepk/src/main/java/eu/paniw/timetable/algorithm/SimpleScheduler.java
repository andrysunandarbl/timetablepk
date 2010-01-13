package eu.paniw.timetable.algorithm;

import eu.paniw.timetable.domain.entity.*;

import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class SimpleScheduler implements SchedulerAlgorithm {
	public SchedulerInput input = null;

	@Override
	public void initialize(SchedulerInput input) {
		this.input = input;

	}

	@Override
	public Schedule generate() throws Exception {
		if (input == null) {
			throw new Exception("SimpleScheduler is not initialized or null");
		}

		int maxItemsAtRow = calculateMaxItemsAtRow();
		Queue<ScheduleItem> availableItems = createAvailableItemsQueue();
		ScheduleRow row = null;
		Queue<ScheduleRow> filledRows = new LinkedList<ScheduleRow>();

		while (availableItems.size() != 0) {
			row = createScheduledRow(availableItems, maxItemsAtRow);
			filledRows.add(row);
			/*
			System.out.println("RowSize: "+row.size()+"\tAvailItemSize: "+ availableItems.size());
			for(ScheduleItem item: row.getItems()) {
				System.out.print("\t"+item.getUnit().getName()+" "+ item.getCourse().getName()+" ");
				System.out.println(item.getTeacher().getSurname()+ " " + item.getRoom().getName());
			}
			System.out.print("\n");
			*/
		}

		Schedule schedule = Schedule.create();
		fillSchedule(schedule, filledRows, input.getBeginTimes());

		return schedule;
	}

	private void fillSchedule(Schedule schedule, Queue<ScheduleRow> filledRows, List<String> times) {
		int maxRowsAtDay = input.getMaxRowsAtDay();
		for (Day day : Day.values()) {
			ScheduleDay sday = new ScheduleDay(day);
			for (int i = 0; i < maxRowsAtDay && filledRows.size() > 0; i++) {
				ScheduleRow row = filledRows.poll();
				for(ScheduleItem item: row.getItems()) {
					item.setBeginTime(times.get(i));
				}
				sday.add(row);
			}
			schedule.set(day, sday);
		}

	}

	private ScheduleRow createScheduledRow(Queue<ScheduleItem> availableItems,
			int maxItemsAtRow) {
		ScheduleRow row = new ScheduleRow();
		int maxFindingLoopCount = availableItems.size();
		int findingLoopCounter = 0;
		while (row.size() < maxItemsAtRow
				&& findingLoopCounter < maxFindingLoopCount) {
			findingLoopCounter += 1;
			ScheduleItem item = availableItems.poll();
			if (item == null) {
				break;
			}
			if (isUnitAlreadyInRow(item.getUnit(), row) == true) {
				availableItems.add(item);
				continue;
			}
			Teacher teacher = findFreeTeacher(item.getCourse(), row);
			if (teacher == null) {
				availableItems.add(item);
				continue;
			}
			Room room = findFreeRoom(item.getCourse().getLecture(), item
					.getUnit().getCount(), row);
			if (room == null) {
				availableItems.add(item);
				continue;
			}
			item.setTeacher(teacher);
			item.setRoom(room);
			row.add(item);
		}
		return row;
	}

	private Room findFreeRoom(Boolean lecture, Integer count, ScheduleRow row) {
		Room roomResult = null;
		boolean isInRow = false;
		List<Room> rooms = input.getRooms();
		if (row.size() == rooms.size()) {
			return null;
		}
		for (Room room : rooms) {
			if (room.getLecture() == lecture && room.getCapacity() >= count) {
				isInRow = false;
				for (ScheduleItem item : row.getItems()) {
					if (item.getRoom().getId() == room.getId()) {
						isInRow = true;
						break;
					}
				}
				if (isInRow == false) {
					roomResult = room;
					break;
				}
			}
		}
		return roomResult;
	}

	private Teacher findFreeTeacher(Course course, ScheduleRow row) {
		Teacher teacherResult = null;
		boolean isInRow = false;
		List<Teacher> teachers = input.getTeachers();
		if (row.size() == teachers.size()) {
			return null;
		}
		for (Teacher teacher : teachers) {
			if (canTeacherLearn(teacher, course) == true) {
				isInRow = false;
				for (ScheduleItem item : row.getItems()) {
					if (item.getTeacher().getId() == teacher.getId()) {
						isInRow = true;
						break;
					}
				}
				if (isInRow == false) {
					teacherResult = teacher;
					break;
				}
			}
		}
		return teacherResult;
	}

	private boolean canTeacherLearn(Teacher teacher, Course course) {
		List<Course> courses = teacher.getCourses();
		boolean result = false;
		for (Course teacherCourse : courses) {
			if (teacherCourse.getId() == course.getId()) {
				result = true;
				break;
			}
		}
		return result;
	}

	private boolean isUnitAlreadyInRow(UnitDef unitdef, ScheduleRow row) {

		boolean isUnitInRow = false;
		Unit unit = unitdef.getParent() == null ? (Unit) unitdef
				: (Unit) unitdef.getParent();

		for (ScheduleItem sitem : row.getItems()) {
			UnitDef item = sitem.getUnit();
			UnitDef parent = item.getParent();
			if (parent == null) {
				if (unit.getId() == item.getId()) {
					isUnitInRow = true;
					break;
				}
			} else {
				if (unit.getId() == parent.getId()) {
					isUnitInRow = true;
					break;
				}
			}
		}
		return isUnitInRow;
	}

	private int calculateMaxItemsAtRow() {
		int unitSize = input.getUnits().size();
		int courseSize = input.getCourses().size();
		int teacherSize = input.getTeachers().size();
		int roomSize = input.getRooms().size();
		int min = unitSize;
		min = courseSize < min ? courseSize : min;
		min = teacherSize < min ? teacherSize : min;
		min = roomSize < min ? roomSize : min;
		return min;
	}

	
	private Queue<ScheduleItem> createAvailableItemsQueue() {
		ArrayList<ScheduleItem> items = new ArrayList<ScheduleItem>();
		for (UnitDef unit : input.getUnits()) {
			for (Course course : unit.getCourses()) {
				ScheduleItem item = new ScheduleItem();
				item.setUnit(unit);
				item.setCourse(course);
				items.add(item);
			}
		}
		if(input.isRandomInput()==true) {
			Collections.shuffle(items);
		}
		return new LinkedList<ScheduleItem>(items);
	}
}