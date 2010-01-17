package eu.paniw.timetable.pages;

import java.util.Locale;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.util.string.StringValueConversionException;
import eu.paniw.timetable.Application;

public abstract class BasePage extends WebPage {
	protected final static Integer ROW_PER_PAGE = 30;
	protected FeedbackPanel feedback;
	protected Long id = null;

	public BasePage(PageParameters param, String titleKey) {
		super(param);

		if(param != null && !param.isEmpty()) {
			try {
				if(param.containsKey("id")) {
					id = param.getLong("id");
				}
			} catch(StringValueConversionException exc) {
				exc.printStackTrace();
			}
		}

		initialize(titleKey);
	}

	private void initialize(String titleKey) {
		feedback = new FeedbackPanel("feedback");
		feedback.setOutputMarkupId(true);
		add(feedback);

		Label titleLabel = new Label("pageTitle", getString(titleKey, null, titleKey));
		titleLabel.setRenderBodyOnly(true);
		add(titleLabel);

		Link<Object> plLangLink = new Link<Object>("plLang") {
			private static final long serialVersionUID = 3288754396147822387L;

			@Override
			public void onClick() {
				getSession().setLocale(new Locale("pl", "pl_PL"));
				setResponsePage(getPage().getClass());
			}
		};
		add(plLangLink);

		Link<Object> enLangLink = new Link<Object>("enLang") {
			private static final long serialVersionUID = 4601930920670566466L;

			@Override
			public void onClick() {
				getSession().setLocale(Locale.ENGLISH);
				setResponsePage(getPage().getClass());
			}
		};
		add(enLangLink);

		((Application) getApplication()).getMenuLoader().addMenuPanel(BasePage.this);
	}
}
