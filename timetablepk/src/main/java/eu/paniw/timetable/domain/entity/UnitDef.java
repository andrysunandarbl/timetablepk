package eu.paniw.timetable.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UnitDef implements Serializable {
	private static final long serialVersionUID = -6487548106318178077L;
	protected Long id;
	protected String name;
	protected Integer count;
	protected UnitDef parent;
	protected List<Course> courses = new ArrayList<Course>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
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
	@JoinTable(name = "Grid", joinColumns = {@JoinColumn(name = "unitdef_id")}, inverseJoinColumns = {@JoinColumn(name = "course_id")})
	@Fetch(FetchMode.SUBSELECT)
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public UnitDef getParent() {
		return parent;
	}

	public void setParent(UnitDef parent) {
		this.parent = parent;
	}
	
	@Transient
	public String getUnifyName() {
		return name;
	}
}
