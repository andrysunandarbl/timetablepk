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
public class Classification implements Serializable {
	private static final long serialVersionUID = -6431762752150495916L;
	private Long id;
	private String code;
	private List<Unit> units = new ArrayList<Unit>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@OneToMany(mappedBy = "classification", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}
}
