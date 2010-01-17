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

@Entity
public class ScheduleRow implements Serializable {
	private static final long serialVersionUID = -4652571865145964896L;
	private Long id;
	private List<ScheduleItem> items = new ArrayList<ScheduleItem>();

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(cascade = {CascadeType.ALL})
	public List<ScheduleItem> getItems() {
		return items;
	}

	public void setItems(List<ScheduleItem> items) {
		this.items = items;
	}

	@Transient
	public void add(ScheduleItem item) {
		items.add(item);
	}

	@Transient
	public void clear() {
		items.clear();
	}

	@Transient
	public int size() {
		return items.size();
	}

	@Transient
	public ScheduleItem get(int index) {
		return items.get(index);
	}
}