package eu.paniw.timetable.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class ScheduleDay implements Serializable {
	private static final long serialVersionUID = -2635781200691236227L;
	private Long id;
	private List<ScheduleRow> rows;
	private Day day;

	public ScheduleDay() {
	}

	public ScheduleDay(Day day) {
		rows = new ArrayList<ScheduleRow>();
		this.day = day;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(cascade = {CascadeType.ALL})
	public List<ScheduleRow> getRows() {
		return rows;
	}

	public void setRows(List<ScheduleRow> rows) {
		this.rows = rows;
	}

	@Enumerated
	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	@Transient
	public void add(ScheduleRow item) {
		rows.add(item);
	}

	@Transient
	public void clear() {
		rows.clear();
	}

	@Transient
	public int size() {
		return rows.size();
	}

	@Transient
	public ScheduleRow get(int index) {
		return rows.get(index);
	}
}
