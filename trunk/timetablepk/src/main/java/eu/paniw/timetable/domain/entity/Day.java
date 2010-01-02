package eu.paniw.timetable.domain.entity;

public enum Day {
	MONDAY("Monday"),
	TUESDAY("Tuesday"),
	WEDNESDAY("Wednesday"),
	THURSDAY("Thursday"),
	FRIDAY("Friday"),
	SATURDAY("Saturday"),
	SUNDAY("Sunday");

	private final String name;

	private Day(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
