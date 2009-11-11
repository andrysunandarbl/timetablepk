package eu.paniw.timetable.panel;

import net.databinder.components.hib.DataPanel;
import net.databinder.models.hib.HibernateObjectModel;


public class FormBuilderHtml<T> extends DataPanel<T> {

	public FormBuilderHtml(String id, HibernateObjectModel<T> model) {
		super(id, model);
	}
}
