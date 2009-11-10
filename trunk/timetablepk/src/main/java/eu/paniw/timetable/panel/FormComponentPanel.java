package eu.paniw.timetable.panel;

import net.databinder.components.hib.DataPanel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.AbstractSingleSelectChoice;
import org.apache.wicket.markup.html.form.AbstractTextComponent;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.Model;


public class FormComponentPanel<T>  extends DataPanel<T> {

	public FormComponentPanel(Component component, String label) {
		super("formcomponent");

		Label flabel = new Label("label", label);
		add(flabel);

		DataPanel dataPanel = null;
		if(component instanceof AbstractTextComponent) {
			if(component instanceof PasswordTextField) {
				dataPanel = new PasswordPanel();
			} else if(component instanceof TextArea) {
				dataPanel = new TextAreaPanel();
			} else {
				dataPanel = new InputPanel();
			}
		} else if(component instanceof Button) {
			dataPanel = new ButtonPanel();
		} else if(component instanceof CheckBox) {
			dataPanel = new CheckBoxPanel();
		} else if(component instanceof AbstractSingleSelectChoice) {
			dataPanel = new SelectPanel();
		} else {
			add(component);
		}

		if(dataPanel != null) {
			dataPanel.add(component);
			((FormComponent) component).setLabel(new Model(label));
			add(dataPanel);
		}
	}
}
