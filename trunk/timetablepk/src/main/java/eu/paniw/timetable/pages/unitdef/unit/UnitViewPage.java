package eu.paniw.timetable.pages.unitdef.unit;

import org.apache.wicket.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.entity.Unit;
import eu.paniw.timetable.pages.unitdef.UnitDefViewPage;

@MountPath(path = "unit/view")
@MountMixedParam(parameterNames = {"id"})
public class UnitViewPage extends UnitDefViewPage<Unit> {
	public UnitViewPage(PageParameters param) {
		super(param, Unit.class, UnitListPage.class, UnitEditPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();
	}
}