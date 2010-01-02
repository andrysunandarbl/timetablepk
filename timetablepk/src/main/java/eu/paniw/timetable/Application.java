package eu.paniw.timetable;

import net.databinder.hib.DataApplication;
import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.DefaultComponentSafeNamingStrategy;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;
import eu.paniw.timetable.pages.HomePage;
import eu.paniw.timetable.pages.LoginPage;

public class Application extends DataApplication {
	private Class<? extends Page> errorPage = HomePage.class;
	private MenuLoader menuLoader;
	private TranslationLoader translationLoader = new TranslationLoader();

	@Override
	protected void init() {
		super.init();

		// getSecuritySettings().setAuthorizationStrategy(new
		// RoleAuthorizationStrategy(new UserAuthorizer()));
		getApplicationSettings().setAccessDeniedPage(LoginPage.class);
		getMarkupSettings().setDefaultMarkupEncoding("UTF-8");
		getApplicationSettings().setInternalErrorPage(getHomePage());
		getApplicationSettings().setPageExpiredErrorPage(getHomePage());
		getResourceSettings().addStringResourceLoader(translationLoader);
		
		new AnnotatedMountScanner().scanPackage("eu.paniw").mount(this);
		
		menuLoader = new MenuLoader();
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new TimeTableSession(request);
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

	public Class<? extends Page> getErrorPage() {
		return errorPage;
	}

	public MenuLoader getMenuLoader() {
		return menuLoader;
	}
}
