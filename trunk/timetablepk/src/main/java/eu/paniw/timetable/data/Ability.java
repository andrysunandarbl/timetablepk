package eu.paniw.timetable.data;

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
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Ability implements Serializable {
	private static final long serialVersionUID = -6218048469498822901L;
	private Long id;
	private String name;
	private List<Course> courses = new ArrayList<Course>();
	private List<Teacher> teachers = new ArrayList<Teacher>();

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

	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToMany(mappedBy = "ability", cascade = {CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST})
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany(targetEntity = Teacher.class, cascade = {CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST})
	@JoinTable(name = "Teacher_Ability", joinColumns = {@JoinColumn(name = "ability_id")}, inverseJoinColumns = {@JoinColumn(name = "teacher_id")})
	@Fetch(FetchMode.SUBSELECT)
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
}
