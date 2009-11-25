package eu.paniw.timetable.pages.teacher;

import java.util.ArrayList;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.entity.Teacher;
import eu.paniw.timetable.pages.ListPage;

@MountPath(path = "teacher", alt = "teachers")
public class TeacherListPage extends ListPage<Teacher> {
	public TeacherListPage(PageParameters param) {
		super(param, Teacher.class);
		init();
	}

	@Override
	protected void init() {
		asdp = new TeacherSortableDataProvider(Teacher.class);

		columns = new ArrayList<IColumn<Teacher>>();
		columns.add(new PropertyColumn<Teacher>(new Model<String>("ID"), "id", "id"));
		columns.add(new PropertyColumn<Teacher>(new Model<String>("Degree"), "degree", "degree"));
		columns.add(new PropertyColumn<Teacher>(new Model<String>("Firstname"), "firstname", "firstname"));
		columns.add(new PropertyColumn<Teacher>(new Model<String>("Surname"), "surname", "surname"));

		super.init();
	}
}