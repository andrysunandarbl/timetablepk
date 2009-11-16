package eu.paniw.timetable.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Unit implements Serializable {
	private static final long serialVersionUID = -1865001406662382358L;
	private Long id;
	private String name;
	private Integer count;
	private List<Course> courses = new ArrayList<Course>();
	private List<Group> groups = new ArrayList<Group>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany(targetEntity = Course.class, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinTable(name = "Grid", joinColumns = {@JoinColumn(name = "unit_id")}, inverseJoinColumns = {@JoinColumn(name = "course_id")})
	@Fetch(FetchMode.SUBSELECT)
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToMany(mappedBy="unit")
	@Fetch(FetchMode.SUBSELECT)
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
}
