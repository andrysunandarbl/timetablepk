package eu.paniw.timetable.panel;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

public class LinksPanel extends Panel {
	private static final long serialVersionUID = -6280568044817268982L;
	private RepeatingView links;

	public LinksPanel(String id) {
		super(id);
		init();
	}

	private void init() {
		links = new RepeatingView("links");
		links.setRenderBodyOnly(true);
		add(links);
	}

	public LinksPanel addLink(Link<?> link, String labelKey) {
		Label linkLabel = new Label("linkLabel", getLocalizer().getString(labelKey, link, labelKey));
		link.add(linkLabel);

		WebMarkupContainer wmc = new WebMarkupContainer(links.newChildId());
		wmc.setRenderBodyOnly(true);
		wmc.add(link);
		links.add(wmc);

		return this;
	}
}
