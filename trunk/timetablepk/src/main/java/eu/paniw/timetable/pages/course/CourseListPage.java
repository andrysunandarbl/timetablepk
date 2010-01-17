package eu.paniw.timetable.pages.course;

import java.util.ArrayList;
import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.entity.Course;
import eu.paniw.timetable.pages.ListPage;
import eu.paniw.timetable.panel.LinksPanel;
import eu.paniw.timetable.tool.LinkTool;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "course", alt = "courses")
public class CourseListPage extends ListPage<Course> {
	public CourseListPage(PageParameters param) {
		super(param, "courseTitle", Course.class, CourseEditPage.class);
		init();
	}

	@Override
	protected void init() {
		asdp = new CourseSortableDataProvider(Course.class);

		columns = new ArrayList<IColumn<Course>>();
		columns.add(new PropertyColumn<Course>(new Model<String>(getString("app.id", null, "app.id")), "id", "id"));
		columns.add(new PropertyColumn<Course>(new Model<String>(getString("course.name", null, "course.name")), "name",
				"name"));
		columns.add(new PropertyColumn<Course>(new Model<String>(getString("course.lecture", null, "course.lecture")),
				"lecture", "lecture"));
		columns.add(new AbstractColumn<Course>(new Model<String>(getString("app.actions", null, "app.actions"))) {
			private static final long serialVersionUID = 4573394368293618764L;

			@Override
			public void populateItem(Item<ICellPopulator<Course>> cellItem, String componentId, IModel<Course> rowModel) {
				cellItem.add(new LinksPanel(componentId).addLink(
						new BookmarkablePageLink<Page>("link", CourseViewPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "app.view").addLink(
						new BookmarkablePageLink<Page>("link", CourseEditPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "app.edit").addLink(
						LinkTool.getDeleteLink("link", rowModel.getObject(), getString("app.delquestion", null,
								"app.delquestion"), asdp, wmc), "app.delete"));
			}
		});

		super.init();
	}
}
