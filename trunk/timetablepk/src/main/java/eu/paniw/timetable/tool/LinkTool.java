package eu.paniw.timetable.tool;

import java.io.Serializable;
import net.databinder.hib.Databinder;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.IAjaxCallDecorator;
import org.apache.wicket.ajax.calldecorator.AjaxPreprocessingCallDecorator;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxFallbackLink;
import org.apache.wicket.model.Model;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import eu.paniw.timetable.AbstractSortableDataProvider;

public class LinkTool {
	public static <T extends Serializable> IndicatingAjaxFallbackLink<T> getDeleteLink(String id, final T obj,
			final String question, final AbstractSortableDataProvider<T> asdp, final Component... targetComponents) {
		IndicatingAjaxFallbackLink<T> link = new IndicatingAjaxFallbackLink<T>(id, new Model<T>(obj)) {
			private static final long serialVersionUID = 5820423634859354605L;

			@Override
			protected IAjaxCallDecorator getAjaxCallDecorator() {
				return new AjaxPreprocessingCallDecorator(super.getAjaxCallDecorator()) {
					private static final long serialVersionUID = 2516878799034321457L;

					@Override
					public CharSequence preDecorateScript(CharSequence script) {
						return "if(!confirm('" + question + "')) return false;" + script;
					}
				};
			}

			@Override
			public void onClick(AjaxRequestTarget target) {
				Session session = Databinder.getHibernateSession();
				try {
					session.beginTransaction();
					session.delete(obj);
					session.getTransaction().commit();
					asdp.refresh();
					for(Component c : targetComponents) {
						target.addComponent(c);
					}
				} catch(HibernateException exc) {
					session.getTransaction().rollback();
					exc.printStackTrace();
				}
			}
		};

		return link;
	}
}
