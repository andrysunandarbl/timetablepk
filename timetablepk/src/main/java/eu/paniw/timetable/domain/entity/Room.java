package eu.paniw.timetable.domain.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Room implements Serializable {
	private static final long serialVersionUID = 8881263204112445886L;
	private Long id;
	private String name;
	private Integer capacity;
	private Boolean lecture;

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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Boolean getLecture() {
		return lecture;
	}

	public void setLecture(Boolean lecture) {
		this.lecture = lecture;
	}

	@Transient
	public String getUnifyName() {
		return name;
	}
}
