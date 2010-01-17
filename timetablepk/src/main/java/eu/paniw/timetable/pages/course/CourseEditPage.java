package eu.paniw.timetable.pages.course;

import java.util.List;
import net.databinder.models.hib.HibernateListModel;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.components.Palette;
import eu.paniw.timetable.domain.entity.Course;
import eu.paniw.timetable.domain.entity.Teacher;
import eu.paniw.timetable.domain.entity.UnitDef;
import eu.paniw.timetable.pages.EditPage;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "course/edit", alt = "course/add")
@MountMixedParam(parameterNames = {"id"})
public class CourseEditPage extends EditPage<Course> {
	public CourseEditPage(PageParameters param) {
		super(param, "courseTitle", Course.class, CourseViewPage.class, CourseListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		TextField<String> nameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "name"));
		nameTF.setRequired(true);
		nameTF.add(StringValidator.minimumLength(3));
		builder.addComponent(nameTF, "course.name");

		TextField<String> lectureTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "lecture"));
		builder.addComponent(lectureTF, "course.lecture");

		Palette<UnitDef> unitsP = new Palette<UnitDef>("item", new PropertyModel<List<UnitDef>>(getFormModel(), "units"),
				new HibernateListModel<UnitDef>(UnitDef.class), new ChoiceRenderer<UnitDef>("unifyName", "id"), 5, false);
		builder.addComponent(unitsP, "course.units");

		Palette<Teacher> teachersP = new Palette<Teacher>("item",
				new PropertyModel<List<Teacher>>(getFormModel(), "teachers"), new HibernateListModel<Teacher>(Teacher.class),
				new ChoiceRenderer<Teacher>("unifyName", "id"), 5, false);
		builder.addComponent(teachersP, "course.teachers");
	}

	@Override
	public void onAfterSubmit() {
		responseParam = new PageParametersTool("id", getFormModel().getObject().getId()).getPP();
	}
}
