package eu.paniw.timetable.panel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.Panel;
import eu.paniw.timetable.domain.app.Menu;

public class MenuPanel extends Panel {
	private static final long serialVersionUID = 7500701667616121474L;

	public MenuPanel(String id, Menu menu) {
		super(id);

		init(menu);
	}

	protected void init(Menu menu) {
		ExternalLink link = new ExternalLink("link", menu.getAddress());
		add(link);

		Label linkL = new Label("linkL", menu.getName());
		linkL.setRenderBodyOnly(true);
		link.add(linkL);
	}
}
