package eu.paniw.timetable;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;
import eu.paniw.timetable.data.User;

public class AuthSession extends WebSession {
	private static final long serialVersionUID = 6226062206238755082L;
	private User user;

	public AuthSession(Request request) {
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