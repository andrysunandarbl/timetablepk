package eu.paniw.timetable.pages.unitdef.unit;

import java.util.List;
import net.databinder.models.hib.HibernateListModel;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.form.palette.Palette;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.entity.Course;
import eu.paniw.timetable.domain.entity.Unit;
import eu.paniw.timetable.pages.unitdef.UnitDefEditPage;

@MountPath(path = "unit/edit", alt = "unit/add")
@MountMixedParam(parameterNames = {"id"})
public class UnitEditPage extends UnitDefEditPage<Unit> {
	public UnitEditPage(PageParameters param) {
		super(param, Unit.class, UnitViewPage.class, UnitListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		Palette<Course> coursesP = new Palette<Course>("item", new PropertyModel<List<Course>>(getFormModel(), "courses"),
				new HibernateListModel<Course>(Course.class), new ChoiceRenderer<Course>("unifyName", "id"), 5, false);
		builder.addComponent(coursesP, "course.units");
	}
}
