package eu.paniw.timetable;

import org.apache.wicket.Session;
import org.apache.wicket.authorization.strategies.role.IRoleCheckingStrategy;
import org.apache.wicket.authorization.strategies.role.Roles;

public class UserAuthorizer implements IRoleCheckingStrategy {

	public UserAuthorizer() {

	}

	public boolean hasAnyRole(Roles roles) {
		TimeTableSession authSession = (TimeTableSession) Session.get();
		if(authSession.getUser() != null) {
			return true;
		} else {
			return false;
		}
	}

}
