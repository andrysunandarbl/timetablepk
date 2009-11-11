package eu.paniw.timetable.pages;

import java.util.List;
import org.apache.wicket.PageParameters;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackHeadersToolbar;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxNavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import eu.paniw.timetable.Application;

public abstract class ListPage<T> extends BasePage {
	protected WebMarkupContainer wmc;
	protected DataTable<T> dataTable;
	protected Class<T> objectClass = null;
	protected SortableDataProvider<T> provider;
	protected List<IColumn<T>> columns = null;

	public ListPage(PageParameters param, Class<T> objectClass) {
		super(param);
		this.objectClass = objectClass;
	}

	@SuppressWarnings("unchecked")
	protected void init() {
		if(objectClass == null || provider == null || columns == null) {
			throw new RestartResponseAtInterceptPageException(((Application)getApplication()).getErrorPage());
		}

		wmc = new WebMarkupContainer("listCon");
		wmc.setOutputMarkupId(true);
		add(wmc);

		dataTable = new DataTable<T>("dataTable", (IColumn<T>[]) columns.toArray(new IColumn[columns.size()]), provider,
				ROW_PER_PAGE);
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
		dataTable.addTopToolbar(new AjaxFallbackHeadersToolbar(dataTable, provider));
		dataTable.setOutputMarkupId(true);
		wmc.add(dataTable);
	}
}
