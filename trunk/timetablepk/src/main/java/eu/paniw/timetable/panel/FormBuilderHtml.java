package eu.paniw.timetable.panel;

import net.databinder.components.hib.DataPanel;
import net.databinder.models.hib.HibernateObjectModel;

public class FormBuilderHtml<T> extends DataPanel<T> {
	private static final long serialVersionUID = -1903436169220168686L;

	public FormBuilderHtml(String id, HibernateObjectModel<T> model) {
		super(id, model);
	}
}
