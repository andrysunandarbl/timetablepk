package eu.paniw.timetable;

import java.util.HashMap;
import java.util.Locale;
import net.databinder.models.hib.HibernateListModel;
import org.apache.wicket.Component;
import org.apache.wicket.resource.loader.IStringResourceLoader;
import eu.paniw.timetable.domain.app.Translation;

public class TranslationLoader implements IStringResourceLoader {
	private HashMap<String, Translation> translations = null;

	@Override
	public String loadStringResource(Component component, String key) {
		return getTranslation(component.getLocale(), key);
	}

	@Override
	public String loadStringResource(Class<?> clazz, String key, Locale locale, String style) {
		return getTranslation(locale, key);
	}

	private String getTranslation(Locale locale, String key) {
		if(translations == null) {
			loadTranslations();
		}

		if(translations.containsKey(key)) {
			Translation t = translations.get(key);
			if(locale.equals(Locale.ENGLISH)) {
				return t.getEnTranslation();
			} else if(locale.equals(Locale.GERMAN)) {
				return t.getDeTranslation();
			} else {
				return t.getPlTranslation();
			}
		} else {
			return null;
		}
	}

	private void loadTranslations() {
		translations = new HashMap<String, Translation>();
		for(Translation t : new HibernateListModel<Translation>(Translation.class).getObject()) {
			translations.put(t.getKey(), t);
		}
	}

	public void clearTranslations() {
		translations = null;
	}
}
