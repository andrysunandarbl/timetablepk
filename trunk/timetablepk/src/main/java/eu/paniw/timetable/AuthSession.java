package eu.paniw.timetable;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

public class AuthSession extends WebSession {
	private static final long serialVersionUID = 6226062206238755082L;

	public AuthSession(Request request) {
		super(request);

	}
}