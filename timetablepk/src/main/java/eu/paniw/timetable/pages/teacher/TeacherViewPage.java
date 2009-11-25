package eu.paniw.timetable.pages.teacher;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.entity.Teacher;
import eu.paniw.timetable.pages.ViewPage;

@MountPath(path = "teacher/view")
@MountMixedParam(parameterNames = {"id"})
public class TeacherViewPage extends ViewPage<Teacher> {
	public TeacherViewPage(PageParameters param) {
		super(param, Teacher.class, TeacherListPage.class, TeacherEditPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		Label idL = new Label("item", new PropertyModel<String>(hom, "id"));
		builder.addComponent(idL, "course.id");

		Label degreeL = new Label("item", new PropertyModel<String>(hom, "degree"));
		builder.addComponent(degreeL, "teacher.degree");

		Label firstnameL = new Label("item", new PropertyModel<String>(hom, "firstname"));
		builder.addComponent(firstnameL, "teacher.firstname");

		Label surnameL = new Label("item", new PropertyModel<String>(hom, "surnameL"));
		builder.addComponent(surnameL, "teacher.surnameL");
	}
}
