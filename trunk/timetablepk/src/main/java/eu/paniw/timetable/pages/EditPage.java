package eu.paniw.timetable.pages;

import java.io.Serializable;
import net.databinder.models.hib.HibernateObjectModel;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.ResourceModel;
import eu.paniw.timetable.Application;
import eu.paniw.timetable.panel.FormBuilder;

@AuthorizeInstantiation("USER")
public abstract class EditPage<T extends Serializable> extends BasePage {
	protected Class<T> clazz;
	protected Class<? extends Page> responseAfterSave;
	protected Class<? extends Page> responseAfterCancel;
	protected HibernateObjectModel<T> hom;
	protected FormBuilder<T> builder;
	protected PageParameters responseParam;

	public EditPage(PageParameters param, String titleKey, Class<T> clazz, Class<? extends Page> responseAfterSave,
			Class<? extends Page> responseAfterCancel) {
		this(param, titleKey, clazz, responseAfterSave, responseAfterCancel, null);
	}

	public EditPage(PageParameters param, String titleKey, Class<T> clazz, Class<? extends Page> responseAfterSave,
			Class<? extends Page> responseAfterCancel, PageParameters responseParam) {
		super(param, titleKey);

		this.clazz = clazz;
		this.responseAfterSave = responseAfterSave;
		this.responseAfterCancel = responseAfterCancel;
		this.responseParam = responseParam;
	}

	protected void init() {
		if(clazz == null || responseAfterSave == null || responseAfterCancel == null) {
			throw new RestartResponseAtInterceptPageException(((Application) getApplication()).getErrorPage());
		}

		if(id != null) {
			hom = new HibernateObjectModel<T>(clazz, id);
			if(hom.getObject() == null) {
				throw new RestartResponseAtInterceptPageException(((Application) getApplication()).getErrorPage());
			}
		} else {
			hom = new HibernateObjectModel<T>(clazz);
		}

		builder = new FormBuilder<T>("formBuilder", hom) {
			private static final long serialVersionUID = 7134813837809729375L;

			@Override
			protected void onSubmit() {
				EditPage.this.onBeforeSubmit();

				if(!EditPage.this.hasErrorMessage()) {
					super.onSubmit();
					EditPage.this.onAfterSubmit();

					setResponsePage(responseAfterSave, responseParam);
				}
			}

		};
		add(builder);

		Button submit = new Button("submit") {
			private static final long serialVersionUID = 6507620370177620275L;

			@Override
			public void onSubmit() {
				super.onSubmit();
			}
		};
		submit.add(new AttributeModifier("value", true, new ResourceModel("app.submit", "app.submit")));
		builder.addButton(submit);

		Link<T> cancel = new Link<T>("cancel") {
			private static final long serialVersionUID = 336880884522921843L;

			@Override
			public void onClick() {
				setResponsePage(responseAfterCancel);
			}
		};
		cancel.add(new AttributeModifier("value", true, new ResourceModel("app.cancel", "app.cancel")));
		builder.addButton(cancel);
	}

	public HibernateObjectModel<T> getFormModel() {
		return builder.getPersistentObjectModel();
	}

	protected void onBeforeSubmit() {
	}

	protected void onAfterSubmit() {
	}
}
