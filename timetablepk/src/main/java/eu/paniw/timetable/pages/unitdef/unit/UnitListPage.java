package eu.paniw.timetable.pages.unitdef.unit;

import org.apache.wicket.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.entity.Unit;
import eu.paniw.timetable.pages.unitdef.UnitDefListPage;

@MountPath(path = "unit")
public class UnitListPage extends UnitDefListPage<Unit> {
	public UnitListPage(PageParameters param) {
		super(param, Unit.class);
		init();
	}

	@Override
	protected void init() {
		super.init();
	}
}
