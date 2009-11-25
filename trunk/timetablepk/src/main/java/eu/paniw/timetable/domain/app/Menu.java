package eu.paniw.timetable.domain.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Menu implements Serializable {
	private static final long serialVersionUID = -3802342871162168829L;
	private Long id;
	private String name;
	private MenuPosition menuPosition;
	private List<MenuItem> items = new ArrayList<MenuItem>();

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

	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	public List<MenuItem> getItems() {
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
	}
	
	@Transient
	public String getUnifyName() {
		return name;
	}
}
