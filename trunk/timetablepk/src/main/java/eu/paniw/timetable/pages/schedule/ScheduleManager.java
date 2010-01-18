package eu.paniw.timetable.pages.schedule;

import java.io.Serializable;
import eu.paniw.timetable.algorithm.SchedulerAlgorithm;
import eu.paniw.timetable.algorithm.SchedulerInput;
import eu.paniw.timetable.algorithm.SimpleScheduler;
import eu.paniw.timetable.domain.entity.Schedule;

public class ScheduleManager implements Serializable {
	private static final long serialVersionUID = 7859044842224723669L;

	public ScheduleManager() {
	}

	public Schedule order() {
		return order(false);
	}

	public Schedule order(Boolean randomization) {
		SchedulerInput input = new SchedulerInput();
		input.setRandomInput(randomization);

		SchedulerAlgorithm algorithm = new SimpleScheduler();
		algorithm.initialize(input);

		Schedule schedule = null;
		try {
			schedule = algorithm.generate();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return schedule;
	}
}
