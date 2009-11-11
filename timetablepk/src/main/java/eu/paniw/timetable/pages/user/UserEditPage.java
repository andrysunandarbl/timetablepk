package eu.paniw.timetable.pages.user;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.data.entity.User;
import eu.paniw.timetable.pages.EditPage;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "user/edit")
public class UserEditPage extends EditPage<User> {
	public UserEditPage(PageParameters param) {
		super(param, User.class, UserListPage.class, UserListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		TextField<String> userNameTF = new TextField<String>("formfield", new PropertyModel<String>(getFormModel(), "userName"));
		userNameTF.setRequired(true);
		userNameTF.add(StringValidator.minimumLength(3));
		builder.addComponent(userNameTF, getLocalizer().getString("user.userName", this, "user.userName"));

		if(id == null) {
			PasswordTextField passwordTextField = new PasswordTextField("formfield", new PropertyModel<String>(getFormModel(),
					"password"));
			passwordTextField.setRequired(true);
			builder.addComponent(passwordTextField, getLocalizer().getString("user.password", this, "user.password"));
		}

		TextField<String> firstnameTF = new TextField<String>("formfield", new PropertyModel<String>(getFormModel(), "firstname"));
		builder.addComponent(firstnameTF, getLocalizer().getString("user.firstname", this, "user.firstname"));

		TextField<String> surnameTF = new TextField<String>("formfield", new PropertyModel<String>(getFormModel(), "surname"));
		builder.addComponent(surnameTF, getLocalizer().getString("user.surname", this, "user.surname"));

		TextArea<String> descriptionTA = new TextArea<String>("formfield", new PropertyModel<String>(getFormModel(),
				"description"));
		builder.addComponent(descriptionTA, getLocalizer().getString("user.description", this, "user.description"));

		CheckBox activeCB = new CheckBox("formfield", new PropertyModel<Boolean>(getFormModel(), "active"));
		builder.addComponent(activeCB, getLocalizer().getString("user.active", this, "user.active"));
	}

	@Override
	public void onAfterSubmit() {
		responseParam = new PageParametersTool("id", getFormModel().getObject().getId()).getPP();
	}
}
