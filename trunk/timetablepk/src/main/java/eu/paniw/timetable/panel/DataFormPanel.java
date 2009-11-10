package eu.paniw.timetable.panel;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import net.databinder.components.hib.DataForm;
import net.databinder.components.hib.DataPanel;
import net.databinder.models.hib.HibernateObjectModel;

public class DataFormPanel<T> extends DataForm<T>{
	private RepeatingView formcomponent;
	private RepeatingView buttons;
	
	public DataFormPanel(String id, HibernateObjectModel<T> model) {
		super(id, model);
		init();
	}
	
	private void init() {
		formcomponent = new RepeatingView("formcomponents");
		add(formcomponent);

		buttons = new RepeatingView("buttons");
		add(buttons);
	}

	public void addComponent(Component component) {
		WebMarkupContainer wmc = new WebMarkupContainer(formcomponent.newChildId());
		formcomponent.add(wmc);
		wmc.add(component);
	}

	public void addComponent(Component component, String label) {
		FormComponentPanel<T> ff = new FormComponentPanel(component, label);
		addComponent(ff);
	}

	public void addButton(Component component) {
		WebMarkupContainer wmc = new WebMarkupContainer(buttons.newChildId());
		buttons.add(wmc);
		wmc.add(component);
	}
}
