package eu.paniw.timetable.pages.user;

import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.entity.User;
import eu.paniw.timetable.pages.ViewPage;

@MountPath(path = "user/view")
@MountMixedParam(parameterNames = {"id"})
@AuthorizeInstantiation("ADMIN")
public class UserViewPage extends ViewPage<User> {
	public UserViewPage(PageParameters param) {
		super(param, "userTitle", User.class, UserListPage.class, UserEditPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		Label idL = new Label("item", new PropertyModel<String>(hom, "id"));
		builder.addComponent(idL, "app.id");

		Label userNameL = new Label("item", new PropertyModel<String>(hom, "userName"));
		builder.addComponent(userNameL, "user.userName");

		Label firstnameL = new Label("item", new PropertyModel<String>(hom, "firstname"));
		builder.addComponent(firstnameL, "user.firstname");

		Label surnameL = new Label("item", new PropertyModel<String>(hom, "surname"));
		builder.addComponent(surnameL, "user.surname");

		Label activeL = new Label("item", new PropertyModel<String>(hom, "active"));
		builder.addComponent(activeL, "user.active");

		Label userAppRoleL = new Label("item", new PropertyModel<String>(hom, "userAppRole"));
		builder.addComponent(userAppRoleL, "user.role");
	}
}
