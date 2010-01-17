package eu.paniw.timetable.pages;

import java.io.Serializable;
import java.util.List;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackHeadersToolbar;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxNavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import eu.paniw.timetable.AbstractSortableDataProvider;
import eu.paniw.timetable.Application;

@AuthorizeInstantiation("USER")
public abstract class ListPage<T extends Serializable> extends BasePage {
	protected WebMarkupContainer wmc;
	protected DataTable<T> dataTable;
	protected Class<T> objectClass = null;
	protected List<IColumn<T>> columns = null;
	protected AbstractSortableDataProvider<T> asdp;
	protected Class<? extends Page> addPage;

	public ListPage(PageParameters param, String titleKey, Class<T> objectClass, Class<? extends Page> addPage) {
		super(param, titleKey);
		this.objectClass = objectClass;
		this.addPage = addPage;

		wmc = new WebMarkupContainer("listCon");
		wmc.setOutputMarkupId(true);
		add(wmc);
	}

	@SuppressWarnings("unchecked")
	protected void init() {
		if(objectClass == null || asdp == null || columns == null || addPage == null) {
			throw new RestartResponseAtInterceptPageException(((Application) getApplication()).getErrorPage());
		}

		BookmarkablePageLink<Page> addItemBPL = new BookmarkablePageLink<Page>("addNew", addPage);
		wmc.add(addItemBPL);

		dataTable = new DataTable<T>("dataTable", (IColumn<T>[]) columns.toArray(new IColumn[columns.size()]), asdp,
				ROW_PER_PAGE) {
			private static final long serialVersionUID = 3731678422086406680L;

			@Override
			protected Item<T> newRowItem(String id, int index, IModel<T> model) {
				Item item = super.newRowItem(id, index, model);
				item.add(new AttributeModifier("class", true, new Model(index % 2 == 0 ? "odd" : "even")));
				return item;
			}
		};
		dataTable.setOutputMarkupId(true);
		dataTable.addTopToolbar(new AjaxNavigationToolbar(dataTable) {
			private static final long serialVersionUID = 755632704320037727L;

			@Override
			public PagingNavigator newPagingNavigator(String navigatorId, final DataTable<?> dataTable) {
				return new AjaxPagingNavigator(navigatorId, dataTable) {
					private static final long serialVersionUID = -3608465367169358807L;

					@Override
					protected void onAjaxEvent(AjaxRequestTarget target) {
						getSession().getFeedbackMessages().clear();
						target.addComponent(feedback);
						target.addComponent(wmc);
					}
				};
			}
		});
		dataTable.addTopToolbar(new AjaxFallbackHeadersToolbar(dataTable, asdp));
		dataTable.setOutputMarkupId(true);
		wmc.add(dataTable);
	}
}
