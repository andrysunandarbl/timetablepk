package eu.paniw.timetable.pages.course;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.entity.Course;
import eu.paniw.timetable.pages.ViewPage;

@MountPath(path = "course/view")
@MountMixedParam(parameterNames = {"id"})
public class CourseViewPage extends ViewPage<Course> {
	public CourseViewPage(PageParameters param) {
		super(param, Course.class, CourseListPage.class, CourseEditPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		Label idL = new Label("item", new PropertyModel<String>(hom, "id"));
		builder.addComponent(idL, "app.id");

		Label nameL = new Label("item", new PropertyModel<String>(hom, "name"));
		builder.addComponent(nameL, "course.name");

		Label lectureL = new Label("item", new PropertyModel<String>(hom, "lecture"));
		builder.addComponent(lectureL, "course.lecture");
	}
}
