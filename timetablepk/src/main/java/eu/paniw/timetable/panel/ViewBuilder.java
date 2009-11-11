package eu.paniw.timetable.panel;

import net.databinder.models.hib.HibernateObjectModel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

public class ViewBuilder<T> extends Panel {
	private static final long serialVersionUID = -8798565503048815743L;
	private RepeatingView builder;
	
	public ViewBuilder(String id, HibernateObjectModel<T> hom) {
		super(id, hom);
		init();
	}
	
	protected void init() {
		builder = new RepeatingView("builder");
		builder.setRenderBodyOnly(true);
		add(builder);
	}
	
	public void addComponent(Component component, String labelTxt) {
		ViewBuilderItem item = new ViewBuilderItem(builder.newChildId(), component, labelTxt);
		item.setRenderBodyOnly(true);
		builder.add(item);
	}
}
