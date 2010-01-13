package eu.paniw.timetable.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath(path = "home")
@AuthorizeInstantiation("USER")
public class HomePage extends BasePage {
	public HomePage(PageParameters param) {
		super(param);

	}
}
