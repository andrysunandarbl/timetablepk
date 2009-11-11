package eu.paniw.timetable.pages.user;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.data.entity.User;
import eu.paniw.timetable.pages.ViewPage;

@MountPath(path = "user/view")
@MountMixedParam(parameterNames = { "id" })
public class UserViewPage extends ViewPage<User> {
	public UserViewPage(PageParameters param) {
		super(param, User.class, UserListPage.class);
		init();
	}
	
	@Override
	protected void init() {
		super.init();
		
		Label userNameL = new Label("item", new PropertyModel<String>(hom, "userName"));
		builder.addComponent(userNameL, getLocalizer().getString("user.userName", this, "user.userName"));
	}
}
