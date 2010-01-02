package eu.paniw.timetable.panel;

import net.databinder.components.hib.DataPanel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.AbstractSingleSelectChoice;
import org.apache.wicket.markup.html.form.AbstractTextComponent;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.Model;

public class FormBuilderItem<T> extends DataPanel<T> {
	private static final long serialVersionUID = 8098872750323622595L;

	public FormBuilderItem(Component component, String labelTxt) {
		super("item");
		init(component, labelTxt);
	}

	@SuppressWarnings("unchecked")
	private void init(Component component, String labelTxt) {
		Label label = new Label("label", labelTxt);
		label.setRenderBodyOnly(true);
		add(label);

		DataPanel<T> dataPanel = null;
		if(component instanceof AbstractTextComponent<?>) {
			if(component instanceof PasswordTextField) {
				dataPanel = new PasswordPanel<T>();
			} else if(component instanceof TextArea<?>) {
				dataPanel = new TextAreaPanel<T>();
			} else {
				dataPanel = new InputPanel<T>();
			}
		} else if(component instanceof CheckBox) {
			dataPanel = new CheckBoxPanel<T>();
		} else if(component instanceof AbstractSingleSelectChoice<?>) {
			dataPanel = new SelectPanel<T>();
		} else {
			add(component);
		}

		if(dataPanel != null) {
			((FormComponent<T>) component).setLabel(new Model<String>(labelTxt));
			dataPanel.add(component);
			dataPanel.setRenderBodyOnly(true);
			add(dataPanel);
		}
	}
}
