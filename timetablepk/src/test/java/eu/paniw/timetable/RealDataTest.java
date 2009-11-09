package eu.paniw.timetable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.DefaultComponentSafeNamingStrategy;
import eu.paniw.timetable.data.User;
import junit.framework.TestCase;

public class RealDataTest extends TestCase {
	private Session session;
	private SessionFactory sessionFactory;

	@Override
	protected void setUp() throws Exception {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.setNamingStrategy(new DefaultComponentSafeNamingStrategy());
		config.configure();
		sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	@Override
	protected void tearDown() throws Exception {
		try {
			if(session.getTransaction().isActive()) {
				session.getTransaction().commit();
			}
		} finally {
			session.close();
		}
	}

	public void testData() throws Exception {
		User user1 = new User();
		user1.setUserName("webgp");
		user1.setPassword("pass.word");
		user1.setFirstname("Grzegorz");
		user1.setSurname("Paniw");
		user1.setDescription("Main administratior of application");
		session.save(user1);
		
		User user2 = new User();
		user2.setUserName("revis");
		user2.setPassword("pass.word");
		user2.setFirstname("Marcin");
		user2.setSurname("Kościelniak");
		user2.setDescription("Sub-administratior of application");
		session.save(user2);
		
		User user3 = new User();
		user3.setUserName("michal");
		user3.setPassword("pass.word");
		user3.setFirstname("Michał");
		user3.setSurname("Derecki");
		user3.setDescription("Sub-administratior of application");
		session.save(user3);
	}
}
