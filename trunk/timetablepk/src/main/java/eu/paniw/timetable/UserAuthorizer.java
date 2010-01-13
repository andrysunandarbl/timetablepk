package eu.paniw.timetable;

import org.apache.wicket.Session;
import org.apache.wicket.authorization.strategies.role.IRoleCheckingStrategy;
import org.apache.wicket.authorization.strategies.role.Roles;

public class UserAuthorizer implements IRoleCheckingStrategy {

	public UserAuthorizer() {
	}

	public boolean hasAnyRole(Roles roles) {
		TimeTableSession timeTableSession = (TimeTableSession) Session.get();
		if(timeTableSession.getUser() != null) {
			return timeTableSession.getUser().hasAnyRole(roles);
		} else {
			return false;
		}
	}
}
