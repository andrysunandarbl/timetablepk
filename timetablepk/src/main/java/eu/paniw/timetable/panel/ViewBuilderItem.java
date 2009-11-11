package eu.paniw.timetable.panel;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class ViewBuilderItem extends Panel {
	private static final long serialVersionUID = 4070426414067171343L;

	public ViewBuilderItem(String id, Component component, String labelTxt) {
		super(id);
		init(component, labelTxt);
	}
	
	private void init(Component component, String labelTxt) {
		component.setRenderBodyOnly(true);
		add(component);
		
		Label label = new Label("label", labelTxt);
		label.setRenderBodyOnly(true);
		add(label);
	}
}
