package eu.paniw.timetable.pages.unitdef;

import java.util.ArrayList;
import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import eu.paniw.timetable.domain.entity.UnitDef;
import eu.paniw.timetable.pages.ListPage;

public abstract class UnitDefListPage<T extends UnitDef> extends ListPage<T> {
	public UnitDefListPage(PageParameters param, String titleKey, Class<T> objectClass, Class<? extends Page> addPage) {
		super(param, titleKey, objectClass, addPage);
		preInit();
	}

	private void preInit() {
		asdp = new UnitDefSortableDataProvider<T>(objectClass);

		columns = new ArrayList<IColumn<T>>();
		columns.add(new PropertyColumn<T>(new Model<String>(getString("app.id", null, "app.id")), "id", "id"));
		columns.add(new PropertyColumn<T>(new Model<String>(getString("group.name", null, "group.name")), "name", "name"));
		columns.add(new PropertyColumn<T>(new Model<String>(getString("group.count", null, "group.count")), "count", "count"));
	}

	protected void init() {
		super.init();
	}
}
