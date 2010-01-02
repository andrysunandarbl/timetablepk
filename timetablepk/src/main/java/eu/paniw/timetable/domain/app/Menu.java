package eu.paniw.timetable.domain.app;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Menu implements Serializable, Comparable<Menu> {
	private static final long serialVersionUID = -3802342871162168829L;
	private Long id;
	private String name;
	private MenuPosition menuPosition;
	private Integer position;
	private String address;
	private Boolean secondLevel = false;
	private Translation translation;

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

	@Enumerated(EnumType.ORDINAL)
	public MenuPosition getMenuPosition() {
		return menuPosition;
	}

	public void setMenuPosition(MenuPosition menuPosition) {
		this.menuPosition = menuPosition;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getSecondLevel() {
		return secondLevel;
	}

	public void setSecondLevel(Boolean secondLevel) {
		this.secondLevel = secondLevel;
	}

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	public Translation getTranslation() {
		return translation;
	}

	public void setTranslation(Translation translation) {
		this.translation = translation;
	}

	@Transient
	public String getUnifyName() {
		return name;
	}

	@Override
	public int compareTo(Menu menu) {
		return this.position.compareTo(menu.getPosition());
	}
}
