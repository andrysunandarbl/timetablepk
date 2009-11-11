package eu.paniw.timetable.tool;

import java.io.Serializable;
import org.apache.wicket.PageParameters;

public class PageParametersTool implements Serializable {
	private static final long serialVersionUID = 2317506493991060453L;
	private PageParameters param;

	public PageParametersTool() {
		param = new PageParameters();
	}

	public PageParametersTool(PageParameters param) {
		this.param = param;
	}
	
	public PageParametersTool(String key, Long value) {
		this(key, String.valueOf(value));
	}

	public PageParametersTool(String key, Integer value) {
		this(key, String.valueOf(value));
	}

	public PageParametersTool(String key, String value) {
		param = new PageParameters();
		param.add(key, value);
	}

	public PageParametersTool add(String key, Long value) {
		return this.add(key, String.valueOf(value));
	}

	public PageParametersTool add(String key, Integer value) {
		return this.add(key, String.valueOf(value));
	}

	public PageParametersTool add(String key, String value) {
		if(!param.containsKey(key)) {
			param.add(key, value);
		}
		return this;
	}

	public PageParametersTool remove(String key) {
		if(param.containsKey(key)) {
			param.remove(key);
		}
		return this;
	}

	public PageParameters getPP() {
		return param;
	}
}
