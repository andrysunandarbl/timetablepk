package eu.paniw.timetable.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath(path = "home")
@AuthorizeInstantiation("USER")
public class HomePage extends BasePage {
	public HomePage(PageParameters param) {
		super(param, "homeTitle");
		init();
	}

	private void init() {
		Label homeWelcomeL = new Label("homeWelcome", getString("homeWelcome", null, "homeWelcome"));
		homeWelcomeL.setRenderBodyOnly(true);
		add(homeWelcomeL);

		Label homeInfo1L = new Label("homeInfo1", getString("homeInfo1", null, "homeInfo1"));
		homeInfo1L.setRenderBodyOnly(true);
		add(homeInfo1L);

		Label homeInfo2L = new Label("homeInfo2", getString("homeInfo2", null, "homeInfo2"));
		homeInfo2L.setRenderBodyOnly(true);
		add(homeInfo2L);
	}
}
