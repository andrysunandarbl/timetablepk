package eu.paniw.timetable.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Grid implements Serializable {
	private static final long serialVersionUID = 2290626186533203554L;
	private Long id;
	private String code;
	private List<Unit> units = new ArrayList<Unit>();
	private List<Course> courses = new ArrayList<Course>();

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToMany(mappedBy = "grid", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToMany(mappedBy = "grid", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
