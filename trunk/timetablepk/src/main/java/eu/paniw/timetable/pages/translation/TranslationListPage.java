package eu.paniw.timetable.pages.translation;

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
import eu.paniw.timetable.domain.app.Translation;
import eu.paniw.timetable.pages.ListPage;
import eu.paniw.timetable.panel.LinksPanel;
import eu.paniw.timetable.tool.LinkTool;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "translation", alt = "translations")
public class TranslationListPage extends ListPage<Translation> {
	public TranslationListPage(PageParameters param) {
		super(param, Translation.class);
		init();
	}

	@Override
	protected void init() {
		asdp = new TranslationSortableDataProvider(Translation.class);

		columns = new ArrayList<IColumn<Translation>>();
		columns.add(new PropertyColumn<Translation>(new Model<String>(getString("app.id", null, "app.id")), "id", "id"));
		columns.add(new PropertyColumn<Translation>(new Model<String>(getString("translation.key", null, "translation.key")),
				"key", "key"));
		columns.add(new PropertyColumn<Translation>(new Model<String>(getString("translation.plTranslation", null,
				"translation.plTranslation")), "plTranslation", "plTranslation"));
		columns.add(new PropertyColumn<Translation>(new Model<String>(getString("translation.deTranslation", null,
				"translation.deTranslation")), "deTranslation", "deTranslation"));
		columns.add(new PropertyColumn<Translation>(new Model<String>(getString("translation.enTranslation", null,
				"translation.enTranslation")), "enTranslation", "enTranslation"));
		columns.add(new AbstractColumn<Translation>(new Model<String>(getString("app.actions", null, "app.actions"))) {
			private static final long serialVersionUID = 3894049827743589642L;

			@Override
			public void populateItem(Item<ICellPopulator<Translation>> cellItem, String componentId,
					IModel<Translation> rowModel) {
				cellItem.add(new LinksPanel(componentId).addLink(
						new BookmarkablePageLink<Page>("link", TranslationViewPage.class, new PageParametersTool("id",
								rowModel.getObject().getId()).getPP()), "app.view").addLink(
						new BookmarkablePageLink<Page>("link", TranslationEditPage.class, new PageParametersTool("id",
								rowModel.getObject().getId()).getPP()), "app.edit").addLink(
						LinkTool.getDeleteLink("link", rowModel.getObject(), getString("app.delquestion", null,
								"app.delquestion"), asdp, wmc), "app.delete"));
			}
		});

		super.init();
	}
}
