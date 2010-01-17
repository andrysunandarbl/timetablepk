package eu.paniw.timetable.domain.entity;

public enum BeginTimes {
	g730("7.30"), g915("9.15"), g1100("11.00"), g1245("12.45"), g1430("14.30"), g1615("16.15"), g1800("18.00"), g1945("19.45");

	private String beginTime;

	private BeginTimes(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getBeginTime() {
		return beginTime;
	}
}
