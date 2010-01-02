package eu.paniw.timetable;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;
import eu.paniw.timetable.domain.entity.User;

public class TimeTableSession extends WebSession {
	private static final long serialVersionUID = 6226062206238755082L;
	private User user;

	public TimeTableSession(Request request) {
		super(request);

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void logoutUser() {
		user = null;
	}

	public Boolean isUserLoggedIn() {
		return(user != null);
	}
}