package eu.paniw.timetable.pages.teacher;

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
import eu.paniw.timetable.domain.entity.Teacher;
import eu.paniw.timetable.pages.ListPage;
import eu.paniw.timetable.panel.LinksPanel;
import eu.paniw.timetable.tool.LinkTool;
import eu.paniw.timetable.tool.PageParametersTool;

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
		columns.add(new PropertyColumn<Teacher>(new Model<String>(getString("app.id", null, "app.id")), "id", "id"));
		columns.add(new PropertyColumn<Teacher>(new Model<String>(getString("teacher.degree", null, "teacher.degree")),
				"degree", "degree"));
		columns.add(new PropertyColumn<Teacher>(new Model<String>(getString("teacher.firstname", null, "teacher.firstname")),
				"firstname", "firstname"));
		columns.add(new PropertyColumn<Teacher>(new Model<String>(getString("teacher.surname", null, "teacher.surname")),
				"surname", "surname"));
		columns.add(new AbstractColumn<Teacher>(new Model<String>(getString("app.actions", null, "app.actions"))) {
			private static final long serialVersionUID = 2155719884042421074L;

			@Override
			public void populateItem(Item<ICellPopulator<Teacher>> cellItem, String componentId, IModel<Teacher> rowModel) {
				cellItem.add(new LinksPanel(componentId).addLink(
						new BookmarkablePageLink<Page>("link", TeacherViewPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "app.view").addLink(
						new BookmarkablePageLink<Page>("link", TeacherEditPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "app.edit").addLink(
						LinkTool.getDeleteLink("link", rowModel.getObject(), getString("app.delquestion", null,
								"app.delquestion"), asdp, wmc), "app.delete"));
			}
		});

		super.init();
	}
}