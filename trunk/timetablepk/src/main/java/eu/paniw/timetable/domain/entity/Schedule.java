package eu.paniw.timetable.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import eu.paniw.timetable.algorithm.SchedulerAlgorithm;

@Entity
public class Schedule implements Serializable {
	private static final long serialVersionUID = 8158459654031121191L;
	private Long id;
	private String name;
	private String description;
	private List<ScheduleDay> scheduleDays = new ArrayList<ScheduleDay>();

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL)
	public List<ScheduleDay> getScheduleDays() {
		return scheduleDays;
	}

	public void setScheduleDays(List<ScheduleDay> scheduleDays) {
		this.scheduleDays = scheduleDays;
	}

	@Transient
	public static Schedule create(SchedulerAlgorithm algorithm) throws Exception {
		return algorithm.generate();
	}

	@Transient
	public static Schedule create() {
		return new Schedule();
	}
}
