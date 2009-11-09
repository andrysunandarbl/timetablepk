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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Teacher implements Serializable {
	private static final long serialVersionUID = -4001775565444440479L;
	private Long id;
	private String name;
	// private List<Degree> degree;
	private String surname;
	private List<Ability> abilities = new ArrayList<Ability>();

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

	// public List<Degree> getDegree() {
	// return degree;
	// }
	//
	// public void setDegree(List<Degree> degree) {
	// this.degree = degree;
	// }

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany(targetEntity = Ability.class, cascade = {CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST})
	@JoinTable(name = "Teacher_Ability", joinColumns = {@JoinColumn(name = "teacher_id")}, inverseJoinColumns = {@JoinColumn(name = "ability_id")})
	@Fetch(FetchMode.SUBSELECT)
	public List<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}
}
