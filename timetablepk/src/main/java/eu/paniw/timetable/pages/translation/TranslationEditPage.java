package eu.paniw.timetable.pages.translation;

import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.app.Translation;
import eu.paniw.timetable.pages.EditPage;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "translation/edit", alt = "translation/add")
@MountMixedParam(parameterNames = {"id"})
@AuthorizeInstantiation("ADMIN")
public class TranslationEditPage extends EditPage<Translation> {
	public TranslationEditPage(PageParameters param) {
		super(param, "translationTitle", Translation.class, TranslationViewPage.class, TranslationListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		TextField<String> keyTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "key"));
		keyTF.setRequired(true);
		builder.addComponent(keyTF, "translation.key");

		TextField<String> plTranslationTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(),
				"plTranslation"));
		plTranslationTF.setRequired(true);
		builder.addComponent(plTranslationTF, "translation.plTranslation");

		TextField<String> deTranslationTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(),
				"deTranslation"));
		builder.addComponent(deTranslationTF, "translation.deTranslation");

		TextField<String> enTranslationTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(),
				"enTranslation"));
		builder.addComponent(enTranslationTF, "translation.enTranslation");
	}

	@Override
	public void onAfterSubmit() {
		responseParam = new PageParametersTool("id", getFormModel().getObject().getId()).getPP();
	}
}
