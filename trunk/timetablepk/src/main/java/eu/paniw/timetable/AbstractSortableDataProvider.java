package eu.paniw.timetable;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import net.databinder.models.hib.CriteriaBuilder;
import net.databinder.models.hib.HibernateListModel;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public abstract class AbstractSortableDataProvider<T extends Serializable> extends SortableDataProvider<T> {
	private static final long serialVersionUID = 1568453344987171341L;
	protected List<T> items;
	protected CriteriaBuilder criteriaBuilder;
	protected Class<T> clazz;

	public AbstractSortableDataProvider(Class<T> clazz, CriteriaBuilder criteriaBuilder) {
		this.clazz = clazz;
		this.criteriaBuilder = criteriaBuilder;

		initItems();
	}

	public void refresh() {
		initItems();
	}

	public List<T> getItems() {
		return items;
	}

	private void initItems() {
		items = new HibernateListModel<T>(clazz, criteriaBuilder).getObject();
	}

	@Override
	public Iterator<? extends T> iterator(int first, int count) {
		return selectItems(first, count, getSort()).iterator();
	}

	@Override
	public IModel<T> model(T object) {
		return new Model<T>(object);
	}

	@Override
	public int size() {
		return items.size();
	}

	public abstract List<T> selectItems(int first, int count, final SortParam sortParam);
}
