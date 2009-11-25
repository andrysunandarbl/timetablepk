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
		columns.add(new PropertyColumn<Teacher>(new Model<String>("ID"), "id", "id"));
		columns.add(new PropertyColumn<Teacher>(new Model<String>("Degree"), "degree", "degree"));
		columns.add(new PropertyColumn<Teacher>(new Model<String>("Firstname"), "firstname", "firstname"));
		columns.add(new PropertyColumn<Teacher>(new Model<String>("Surname"), "surname", "surname"));
		columns.add(new AbstractColumn<Teacher>(new Model<String>("Actions")) {
			private static final long serialVersionUID = 2155719884042421074L;

			@Override
			public void populateItem(Item<ICellPopulator<Teacher>> cellItem, String componentId, IModel<Teacher> rowModel) {
				cellItem.add(new LinksPanel(componentId).addLink(
						new BookmarkablePageLink<Page>("link", TeacherViewPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "list.view").addLink(
						new BookmarkablePageLink<Page>("link", TeacherEditPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "list.edit").addLink(
						LinkTool.getDeleteLink("link", rowModel.getObject(), "Are you sure?", asdp, wmc), "list.delete"));
			}
		});

		super.init();
	}
}