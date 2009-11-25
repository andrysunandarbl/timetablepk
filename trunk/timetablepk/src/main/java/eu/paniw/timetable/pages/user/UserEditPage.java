package eu.paniw.timetable.pages.user;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.entity.User;
import eu.paniw.timetable.pages.EditPage;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "user/edit", alt = "user/add")
@MountMixedParam(parameterNames = {"id"})
public class UserEditPage extends EditPage<User> {
	public UserEditPage(PageParameters param) {
		super(param, User.class, UserViewPage.class, UserListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		TextField<String> userNameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "userName"));
		userNameTF.setRequired(true);
		userNameTF.add(StringValidator.minimumLength(3));
		builder.addComponent(userNameTF, "user.userName");

		if(id == null) {
			PasswordTextField passwordTextField = new PasswordTextField("item", new PropertyModel<String>(getFormModel(),
					"password"));
			passwordTextField.setRequired(true);
			builder.addComponent(passwordTextField, "user.password");
		}

		TextField<String> firstnameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "firstname"));
		builder.addComponent(firstnameTF, "user.firstname");

		TextField<String> surnameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "surname"));
		builder.addComponent(surnameTF, "user.surname");

		TextArea<String> descriptionTA = new TextArea<String>("item", new PropertyModel<String>(getFormModel(),
				"description"));
		builder.addComponent(descriptionTA, "user.description");

		CheckBox activeCB = new CheckBox("item", new PropertyModel<Boolean>(getFormModel(), "active"));
		builder.addComponent(activeCB, "user.active");
	}

	@Override
	public void onAfterSubmit() {
		responseParam = new PageParametersTool("id", getFormModel().getObject().getId()).getPP();
	}
}
