package eu.paniw.timetable.pages;

import net.databinder.models.hib.CriteriaBuilder;
import net.databinder.models.hib.HibernateObjectModel;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.QueryException;
import org.hibernate.criterion.Restrictions;
import org.wicketstuff.annotation.mount.MountPath;
import eu.paniw.timetable.TimeTableSession;
import eu.paniw.timetable.domain.entity.User;

@MountPath(path = "login")
public class LoginPage extends WebPage {
	public LoginPage(PageParameters param) {
		super(param);
		init();
	}

	private void init() {

		LoginForm loginForm = new LoginForm("loginForm");
		add(loginForm);
	}

	private class LoginForm extends Form<Object> {
		private static final long serialVersionUID = -5028422235738739356L;
		private String username;
		private String password;

		public LoginForm(String id) {
			super(id);

			TextField<String> loginTF = new TextField<String>("login", new PropertyModel<String>(this, "username"));
			loginTF.setRequired(true);
			add(loginTF);

			PasswordTextField passwordPTF = new PasswordTextField("password", new PropertyModel<String>(this, "password"));
			passwordPTF.setRequired(false);
			add(passwordPTF);

			Button submitB = new Button("submit");
			submitB.add(new AttributeModifier("value", true, new ResourceModel("submit", "submit")));
			add(submitB);
		}

		@Override
		protected void onSubmit() {
			if(checkUser()) {
				setResponsePage(HomePage.class);
			} else {
				getPage().error("Failed");
			}
		}

		private Boolean checkUser() {
			User user = null;
			try {
				HibernateObjectModel<User> hom = new HibernateObjectModel<User>(User.class, new CriteriaBuilder() {
					private static final long serialVersionUID = 6059404900526650739L;

					@Override
					public void build(Criteria criteria) {
						criteria.add(Restrictions.sqlRestriction("lower({alias}.username) like lower(?)", username
								.toLowerCase(), Hibernate.STRING));
						criteria.add(Restrictions.eq("active", Boolean.TRUE));
					}
				});

				user = hom.getObject();
				if(user != null && user.getPassword().equals(password)) {
					TimeTableSession authSession = (TimeTableSession) getSession();
					authSession.setUser(user);
				} else {
					return false;
				}
			} catch(QueryException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
	}
}
