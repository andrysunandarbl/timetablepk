package eu.paniw.timetable.pages.unitdef;

import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import eu.paniw.timetable.domain.entity.UnitDef;
import eu.paniw.timetable.pages.ViewPage;

public abstract class UnitDefViewPage<T extends UnitDef> extends ViewPage<T> {
	public UnitDefViewPage(PageParameters param, Class<T> clazz, Class<? extends Page> listPage, Class<? extends Page> editPage) {
		super(param, clazz, listPage, editPage);
	}

	@Override
	protected void init() {
		super.init();

		Label idL = new Label("item", new PropertyModel<String>(hom, "id"));
		builder.addComponent(idL, "app.id");

		Label nameL = new Label("item", new PropertyModel<String>(hom, "name"));
		builder.addComponent(nameL, "group.name");

		Label countL = new Label("item", new PropertyModel<String>(hom, "count"));
		builder.addComponent(countL, "group.count");
	}
}
