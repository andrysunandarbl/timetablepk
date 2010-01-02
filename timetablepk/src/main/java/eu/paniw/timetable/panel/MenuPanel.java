package eu.paniw.timetable.panel;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import eu.paniw.timetable.domain.app.Menu;

public class MenuPanel extends Panel {
	private static final long serialVersionUID = 7500701667616121474L;

	public MenuPanel(String id, Menu menu) {
		super(id);

		init(menu);
	}

	protected void init(Menu menu) {
		ExternalLink link = new ExternalLink("link", menu.getAddress());
		final String linkCss;
		if(!menu.getSecondLevel()) {
			linkCss = "main";
		} else {
			linkCss = "second";
		}

		link.add(new AttributeModifier("class", true, new AbstractReadOnlyModel<String>() {
			private static final long serialVersionUID = 4558605171050940905L;

			@Override
			public String getObject() {
				return linkCss;
			}
		}));
		add(link);

		String linkName;
		if(menu.getTranslation() != null) {
			linkName = getLocalizer().getString(menu.getTranslation().getKey(), this);
		} else {
			linkName = menu.getName();
		}

		Label linkL = new Label("linkL", linkName);
		linkL.setRenderBodyOnly(true);
		link.add(linkL);
	}
}
