package eu.paniw.timetable.panel;

import net.databinder.models.hib.HibernateObjectModel;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import eu.paniw.timetable.tool.PageParametersTool;

public class ViewBuilder<T> extends Panel {
	private static final long serialVersionUID = -8798565503048815743L;
	private RepeatingView builder;

	public ViewBuilder(String id, HibernateObjectModel<T> hom, Class<? extends Page> listPage, Class<? extends Page> editPage,
			Long objectId) {
		super(id, hom);
		init(listPage, editPage, objectId);
	}

	protected void init(final Class<? extends Page> listPage, final Class<? extends Page> editPage, final Long objectId) {
		Link<T> addLink = new Link<T>("add") {
			private static final long serialVersionUID = -5015722713098420016L;

			@Override
			public void onClick() {
				setResponsePage(editPage);
			}
		};
		addLink.add(new SimpleAttributeModifier("value", "Add"));
		add(addLink);

		Link<T> editLink = new Link<T>("edit") {
			private static final long serialVersionUID = -2514399401593650141L;

			@Override
			public void onClick() {
				setResponsePage(editPage, new PageParametersTool("id", objectId).getPP());
			}
		};
		editLink.add(new SimpleAttributeModifier("value", "Edit"));
		add(editLink);

		Link<T> backLink = new Link<T>("back") {
			private static final long serialVersionUID = -4452037053472353362L;

			@Override
			public void onClick() {
				setResponsePage(listPage);
			}
		};
		backLink.add(new SimpleAttributeModifier("value", "Back"));
		add(backLink);

		builder = new RepeatingView("builder");
		builder.setRenderBodyOnly(true);
		add(builder);
	}

	public void addComponent(Component component, String labelKey) {
		ViewBuilderItem item = new ViewBuilderItem(builder.newChildId(), component, getLocalizer().getString(labelKey,
				component, labelKey));
		item.setRenderBodyOnly(true);
		builder.add(item);
	}
}
