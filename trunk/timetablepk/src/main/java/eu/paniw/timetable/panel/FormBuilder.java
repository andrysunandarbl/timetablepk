package eu.paniw.timetable.panel;

import net.databinder.components.hib.DataForm;
import net.databinder.models.hib.HibernateObjectModel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.repeater.RepeatingView;

public class FormBuilder<T> extends DataForm<T> {
	private static final long serialVersionUID = 6549423779326233515L;
	private RepeatingView builder;
	private FormBuilderHtml<T> formBuilderHtml;

	public FormBuilder(String id, HibernateObjectModel<T> model) {
		super(id, model);
		init();
	}

	private void init() {
		formBuilderHtml = new FormBuilderHtml<T>("formBuilderHtml", getPersistentObjectModel());
		formBuilderHtml.setRenderBodyOnly(true);
		add(formBuilderHtml);

		builder = new RepeatingView("builder");
		builder.setRenderBodyOnly(true);
		formBuilderHtml.add(builder);
	}

	private void addComponent(Component component) {
		WebMarkupContainer wmc = new WebMarkupContainer(builder.newChildId());
		wmc.setRenderBodyOnly(true);
		wmc.add(component);
		builder.add(wmc);
	}

	public void addComponent(Component component, String labelKey) {
		FormBuilderItem<T> item = new FormBuilderItem<T>(component, getLocalizer().getString(labelKey, component, labelKey));
		addComponent(item);
	}

	public void addButton(Component component) {
		formBuilderHtml.add(component);
	}
}
