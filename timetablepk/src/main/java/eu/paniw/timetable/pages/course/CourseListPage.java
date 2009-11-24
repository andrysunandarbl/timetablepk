package eu.paniw.timetable.pages.course;

import java.util.ArrayList;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.entity.Course;
import eu.paniw.timetable.pages.ListPage;

@MountPath(path = "course")
public class CourseListPage extends ListPage<Course> {
	public CourseListPage(PageParameters param) {
		super(param, Course.class);
		init();
	}

	@Override
	protected void init() {
		asdp = new CourseSortableDataProvider(Course.class);
		
		columns = new ArrayList<IColumn<Course>>();
		columns.add(new PropertyColumn<Course>(new Model<String>("ID"), "id", "id"));
		columns.add(new PropertyColumn<Course>(new Model<String>("Name"), "name", "name"));
		columns.add(new PropertyColumn<Course>(new Model<String>("Lecture"), "lecture", "lecture"));

		super.init();
	}
}
