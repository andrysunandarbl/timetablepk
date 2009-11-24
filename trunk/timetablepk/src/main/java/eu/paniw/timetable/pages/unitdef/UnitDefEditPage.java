package eu.paniw.timetable.pages.unitdef;

import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;
import eu.paniw.timetable.domain.entity.UnitDef;
import eu.paniw.timetable.pages.EditPage;
import eu.paniw.timetable.tool.PageParametersTool;

public abstract class UnitDefEditPage<T extends UnitDef> extends EditPage<T> {
	public UnitDefEditPage(PageParameters param, Class<T> clazz, Class<? extends Page> responseAfterSave,
			Class<? extends Page> responseAfterCancel) {
		super(param, clazz, responseAfterSave, responseAfterCancel);
	}

	@Override
	protected void init() {
		super.init();

		TextField<String> nameTF = new TextField<String>("formfield", new PropertyModel<String>(getFormModel(), "name"));
		nameTF.setRequired(true);
		nameTF.add(StringValidator.minimumLength(3));
		builder.addComponent(nameTF, "group.name");

		TextField<Integer> countTF = new TextField<Integer>("formfield", new PropertyModel<Integer>(getFormModel(), "count"));
		builder.addComponent(countTF, "group.count");
	}

	@Override
	public void onAfterSubmit() {
		responseParam = new PageParametersTool("id", getFormModel().getObject().getId()).getPP();
	}
}
