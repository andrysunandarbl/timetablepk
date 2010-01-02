package eu.paniw.timetable.pages.translation;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.app.Translation;
import eu.paniw.timetable.pages.ViewPage;

@MountPath(path = "translation/view")
@MountMixedParam(parameterNames = {"id"})
public class TranslationViewPage extends ViewPage<Translation> {
	public TranslationViewPage(PageParameters param) {
		super(param, Translation.class, TranslationListPage.class, TranslationEditPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		Label idL = new Label("item", new PropertyModel<String>(hom, "id"));
		builder.addComponent(idL, "app.id");

		Label keyL = new Label("item", new PropertyModel<String>(hom, "key"));
		builder.addComponent(keyL, "translation.key");

		Label plTranslationL = new Label("item", new PropertyModel<String>(hom, "plTranslation"));
		builder.addComponent(plTranslationL, "translation.plTranslation");

		Label deTranslationL = new Label("item", new PropertyModel<String>(hom, "deTranslation"));
		builder.addComponent(deTranslationL, "translation.deTranslation");

		Label enTranslationL = new Label("item", new PropertyModel<String>(hom, "enTranslation"));
		builder.addComponent(enTranslationL, "translation.enTranslation");
	}
}
