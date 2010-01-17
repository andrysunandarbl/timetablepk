package eu.paniw.timetable.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.TimeTableSession;

@MountPath(path = "logout")
public class LogoutPage extends BasePage {
	public LogoutPage(PageParameters param) {
		super(param, "Logout");

		if((TimeTableSession) getSession() != null) {
			((TimeTableSession) getSession()).setUser(null);
			((TimeTableSession) getSession()).invalidateNow();
		}

		throw new RestartResponseAtInterceptPageException(LoginPage.class);
	}
}