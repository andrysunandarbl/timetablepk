package eu.paniw.timetable.domain.app;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Translation implements Serializable {
	private static final long serialVersionUID = -7339480484469811537L;
	private Long id;
	private String key;
	private String plTranslation;
	private String deTranslation;
	private String enTranslation;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPlTranslation() {
		return plTranslation;
	}

	public void setPlTranslation(String plTranslation) {
		this.plTranslation = plTranslation;
	}

	public String getDeTranslation() {
		return deTranslation;
	}

	public void setDeTranslation(String deTranslation) {
		this.deTranslation = deTranslation;
	}

	public String getEnTranslation() {
		return enTranslation;
	}

	public void setEnTranslation(String enTranslation) {
		this.enTranslation = enTranslation;
	}
}
