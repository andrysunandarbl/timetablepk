package eu.paniw.timetable;

import net.databinder.hib.DataApplication;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.authorization.strategies.role.RoleAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.DefaultComponentSafeNamingStrategy;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;
import eu.paniw.timetable.pages.HomePage;
import eu.paniw.timetable.pages.LoginPage;

public class Application extends DataApplication {

	@Override
	protected void init() {
		super.init();

		getSecuritySettings().setAuthorizationStrategy(new RoleAuthorizationStrategy(new UserAuthorizer()));
		getApplicationSettings().setAccessDeniedPage(LoginPage.class);
		
		// set output default markup encoding
		getMarkupSettings().setDefaultMarkupEncoding("UTF-8");

		// getApplicationSettings().setInternalErrorPage(getHomePage());
		// getExceptionSettings().setUnexpectedExceptionDisplay(IExceptionSettings.SHOW_INTERNAL_ERROR_PAGE);
		// getApplicationSettings().setPageExpiredErrorPage(HomePage.class);

		// create nice URLs
		new AnnotatedMountScanner().scanPackage("eu.paniw").mount(this);
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new AuthSession(request);
	}

	@Override
	protected void configureHibernate(AnnotationConfiguration config) {
		super.configureHibernate(config);
		config.setNamingStrategy(new DefaultComponentSafeNamingStrategy());
		config.configure();
	}

	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}
}
