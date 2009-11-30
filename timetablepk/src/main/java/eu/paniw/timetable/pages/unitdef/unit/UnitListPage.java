package eu.paniw.timetable.pages.unitdef.unit;

import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.domain.entity.Unit;
import eu.paniw.timetable.pages.unitdef.UnitDefListPage;
import eu.paniw.timetable.panel.LinksPanel;
import eu.paniw.timetable.tool.LinkTool;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "unit", alt="units")
public class UnitListPage extends UnitDefListPage<Unit> {
	public UnitListPage(PageParameters param) {
		super(param, Unit.class);
		init();
	}

	@Override
	protected void init() {
		columns.add(new AbstractColumn<Unit>(new Model<String>("Actions")) {
			private static final long serialVersionUID = 1701425947686757206L;

			@Override
			public void populateItem(Item<ICellPopulator<Unit>> cellItem, String componentId, IModel<Unit> rowModel) {
				cellItem.add(new LinksPanel(componentId).addLink(
						new BookmarkablePageLink<Page>("link", UnitViewPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "list.view").addLink(
						new BookmarkablePageLink<Page>("link", UnitEditPage.class, new PageParametersTool("id", rowModel
								.getObject().getId()).getPP()), "list.edit").addLink(
						LinkTool.getDeleteLink("link", rowModel.getObject(), "Are you sure?", asdp, wmc), "list.delete"));
			}
		});

		super.init();
	}
}
