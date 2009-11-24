package eu.paniw.timetable.pages.unitdef;

import java.util.ArrayList;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import eu.paniw.timetable.domain.entity.UnitDef;
import eu.paniw.timetable.pages.ListPage;

public abstract class UnitDefListPage<T extends UnitDef>  extends ListPage<T> {
	public UnitDefListPage(PageParameters param, Class<T> objectClass) {
		super(param, objectClass);
		preInit();
	}

	private void preInit() {
		asdp = new UnitDefSortableDataProvider<T>(objectClass);

		columns = new ArrayList<IColumn<T>>();
		columns.add(new PropertyColumn<T>(new Model<String>("ID"), "id", "id"));
		columns.add(new PropertyColumn<T>(new Model<String>("Name"), "name", "name"));
		columns.add(new PropertyColumn<T>(new Model<String>("Count"), "count", "count"));
	}
	
	protected void init() {
		super.init();
	}
}
