package eu.paniw.timetable.pages;

import net.databinder.models.hib.HibernateObjectModel;
import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import eu.paniw.timetable.Application;
import eu.paniw.timetable.pages.BasePage;
import eu.paniw.timetable.panel.ViewBuilder;

public abstract class ViewPage<T> extends BasePage {
	protected Class<T> clazz;
	protected HibernateObjectModel<T> hom;
	protected Class<? extends Page> responsePage;
	protected ViewBuilder<T> builder;

	public ViewPage(PageParameters param, Class<T> clazz, Class<? extends Page> responsePage) {
		super(param);
		
		this.clazz = clazz;
		this.responsePage = responsePage;
	}

	protected void init() {
		if(clazz == null || responsePage == null || id == null) {
			throw new RestartResponseAtInterceptPageException(((Application) getApplication()).getErrorPage());
		}

		hom = new HibernateObjectModel<T>(clazz, id);
		if(hom.getObject() == null) {
			throw new RestartResponseAtInterceptPageException(((Application) getApplication()).getErrorPage());
		}

		builder = new ViewBuilder<T>("builder", hom);
		builder.setRenderBodyOnly(true);
		add(builder);
	}
}
