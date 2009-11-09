package eu.paniw.timetable.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

@AuthorizeInstantiation({"Application"})
public abstract class BasePage extends WebPage {
	protected final static Integer ROW_PER_PAGE = 30;
	protected FeedbackPanel feedback;

	public BasePage(PageParameters param) {
		super(param);

		initialize();
	}

	private void initialize() {
		feedback = new FeedbackPanel("feedback");
		feedback.setOutputMarkupId(true);
		add(feedback);
	}
}
