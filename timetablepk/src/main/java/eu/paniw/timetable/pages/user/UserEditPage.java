package eu.paniw.timetable.pages.user;

import java.util.Arrays;
import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.app.UserAppRole;
import eu.paniw.timetable.domain.entity.User;
import eu.paniw.timetable.pages.EditPage;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "user/edit", alt = "user/add")
@MountMixedParam(parameterNames = {"id"})
@AuthorizeInstantiation("ADMIN")
public class UserEditPage extends EditPage<User> {
	private String passwordRe;
	private String password;

	public UserEditPage(PageParameters param) {
		super(param, "userTitle", User.class, UserViewPage.class, UserListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		TextField<String> userNameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "userName"));
		userNameTF.setRequired(true);
		userNameTF.add(StringValidator.minimumLength(3));
		builder.addComponent(userNameTF, "user.userName");

		PasswordTextField passwordTextField = new PasswordTextField("item", new PropertyModel<String>(this, "password"));
		builder.addComponent(passwordTextField, "user.password");

		PasswordTextField passwordReTextField = new PasswordTextField("item", new PropertyModel<String>(this, "passwordRe"));;
		builder.addComponent(passwordReTextField, "user.passwordRe");

		if(id == null) {
			passwordTextField.setRequired(true);
			passwordReTextField.setRequired(true);
		} else {
			passwordTextField.setRequired(false);
			passwordReTextField.setRequired(false);
		}

		TextField<String> firstnameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "firstname"));
		builder.addComponent(firstnameTF, "user.firstname");

		TextField<String> surnameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "surname"));
		builder.addComponent(surnameTF, "user.surname");

		TextArea<String> descriptionTA = new TextArea<String>("item", new PropertyModel<String>(getFormModel(), "description"));
		builder.addComponent(descriptionTA, "user.description");

		CheckBox activeCB = new CheckBox("item", new PropertyModel<Boolean>(getFormModel(), "active"));
		builder.addComponent(activeCB, "user.active");

		DropDownChoice<UserAppRole> userAppRoleDDC = new DropDownChoice<UserAppRole>("item", new PropertyModel<UserAppRole>(
				getFormModel(), "userAppRole"), Arrays.asList(UserAppRole.values()));
		userAppRoleDDC.setRequired(true);
		userAppRoleDDC.setNullValid(false);
		builder.addComponent(userAppRoleDDC, "user.role");
	}

	@Override
	public void onBeforeSubmit() {
		if(password != null && passwordRe != null) {
			if(password.equals(passwordRe)) {
				getFormModel().getObject().setPassword(password);
			} else {
				getPage().error(getString("passwordDontMatch", null, "passwordDontMatch"));
			}
		} else if(password != null || passwordRe != null) {
			getPage().error(getString("repeatPassword", null, "repeatPassword"));
		}
	}

	@Override
	public void onAfterSubmit() {
		responseParam = new PageParametersTool("id", getFormModel().getObject().getId()).getPP();
	}
}
