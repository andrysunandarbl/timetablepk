package eu.paniw.timetable.pages.translation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.databinder.models.hib.CriteriaBuilder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import eu.paniw.timetable.AbstractSortableDataProvider;
import eu.paniw.timetable.domain.app.Translation;

public class TranslationSortableDataProvider extends AbstractSortableDataProvider<Translation> {
	private static final long serialVersionUID = -393612423537413948L;

	public TranslationSortableDataProvider(Class<Translation> clazz) {
		this(clazz, null);
	}

	public TranslationSortableDataProvider(Class<Translation> clazz, CriteriaBuilder criteriaBuilder) {
		super(clazz, criteriaBuilder);
	}

	public List<Translation> selectItems(int first, int count, final SortParam sortParam) {
		List<Translation> sortItems = new ArrayList<Translation>(items);
		if(sortParam != null) {
			if(sortParam.getProperty().equals("id")) {
				Collections.sort(sortItems, new Comparator<Translation>() {
					public int compare(Translation arg0, Translation arg1) {
						int result;

						if(arg0.getId() != null && arg1.getId() != null) {
							result = arg0.getId().compareTo(arg1.getId());
						} else if(arg0 == null) {
							return -1;
						} else if(arg1 == null) {
							return 1;
						} else {
							return 0;
						}

						return sortParam.isAscending() ? result : -result;
					}
				});
			} else if(sortParam.getProperty().equals("key")) {
				Collections.sort(sortItems, new Comparator<Translation>() {
					public int compare(Translation arg0, Translation arg1) {
						int result;

						if(arg0.getKey() != null && arg1.getKey() != null) {
							result = arg0.getKey().compareTo(arg1.getKey());
						} else if(arg0 == null) {
							return -1;
						} else if(arg1 == null) {
							return 1;
						} else {
							return 0;
						}

						return sortParam.isAscending() ? result : -result;
					}
				});
			} else if(sortParam.getProperty().equals("plTranslation")) {
				Collections.sort(sortItems, new Comparator<Translation>() {
					public int compare(Translation arg0, Translation arg1) {
						int result;

						if(arg0.getPlTranslation() != null && arg1.getPlTranslation() != null) {
							result = arg0.getPlTranslation().compareTo(arg1.getPlTranslation());
						} else if(arg0 == null) {
							return -1;
						} else if(arg1 == null) {
							return 1;
						} else {
							return 0;
						}

						return sortParam.isAscending() ? result : -result;
					}
				});
			} else if(sortParam.getProperty().equals("deTranslation")) {
				Collections.sort(sortItems, new Comparator<Translation>() {
					public int compare(Translation arg0, Translation arg1) {
						int result;

						if(arg0.getDeTranslation() != null && arg1.getDeTranslation() != null) {
							result = arg0.getDeTranslation().compareTo(arg1.getDeTranslation());
						} else if(arg0 == null) {
							return -1;
						} else if(arg1 == null) {
							return 1;
						} else {
							return 0;
						}

						return sortParam.isAscending() ? result : -result;
					}
				});
			} else if(sortParam.getProperty().equals("enTranslation")) {
				Collections.sort(sortItems, new Comparator<Translation>() {
					public int compare(Translation arg0, Translation arg1) {
						int result;

						if(arg0.getEnTranslation() != null && arg1.getEnTranslation() != null) {
							result = arg0.getEnTranslation().compareTo(arg1.getEnTranslation());
						} else if(arg0 == null) {
							return -1;
						} else if(arg1 == null) {
							return 1;
						} else {
							return 0;
						}

						return sortParam.isAscending() ? result : -result;
					}
				});
			}
		}
		return sortItems.subList(first, first + count);
	}
}
