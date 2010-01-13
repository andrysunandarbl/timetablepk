package eu.paniw.timetable.algorithm;

import eu.paniw.timetable.domain.entity.Schedule;

public interface SchedulerAlgorithm {
	public void initialize(SchedulerInput input);
	public Schedule generate() throws Exception;
}