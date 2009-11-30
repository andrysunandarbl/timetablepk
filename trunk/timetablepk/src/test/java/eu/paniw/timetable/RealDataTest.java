package eu.paniw.timetable;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.DefaultComponentSafeNamingStrategy;
import eu.paniw.timetable.domain.app.Menu;
import eu.paniw.timetable.domain.app.MenuPosition;
import eu.paniw.timetable.domain.entity.User;

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
		addUsers();
		addMenus();
	}
	
	public void addUsers() {
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
	
	public void addMenus() {
		/* top */
		Menu m1 = new Menu();
		m1.setPosition(0);
		m1.setMenuPosition(MenuPosition.TOP);
		m1.setName("Home page");
		m1.setAddress("/timetablepk");
		session.save(m1);
		
		Menu m2 = new Menu();
		m2.setPosition(1);
		m2.setMenuPosition(MenuPosition.TOP);
		m2.setName("Politechnika Krakowska");
		m2.setAddress("http://www.pk.edu.pl");
		session.save(m2);
		
		Menu m3 = new Menu();
		m3.setPosition(2);
		m3.setMenuPosition(MenuPosition.TOP);
		m3.setName("WFMIIS");
		m3.setAddress("http://www.wfmiis.pk.edu.pl/");
		session.save(m3);
		
		Menu m4 = new Menu();
		m4.setPosition(3);
		m4.setMenuPosition(MenuPosition.TOP);
		m4.setName("Teacher");
		m4.setAddress("/timetablepk/teacher");
		session.save(m4);
		
		Menu m5 = new Menu();
		m5.setPosition(4);
		m5.setMenuPosition(MenuPosition.TOP);
		m5.setName("Room");
		m5.setAddress("/timetablepk/room");
		session.save(m5);
		
		Menu m6 = new Menu();
		m6.setPosition(5);
		m6.setMenuPosition(MenuPosition.TOP);
		m6.setName("Google");
		m6.setAddress("http://www.google.pl");
		session.save(m6);
		
		/* main */
		Menu m7 = new Menu();
		m7.setPosition(0);
		m7.setMenuPosition(MenuPosition.MAIN);
		m7.setName("Teachers");
		m7.setAddress("/timetablepk/teachers");
		session.save(m7);
		
		Menu m8 = new Menu();
		m8.setPosition(1);
		m8.setMenuPosition(MenuPosition.MAIN);
		m8.setName("Add teacher");
		m8.setAddress("/timetablepk/teacher/add");
		session.save(m8);
		
		Menu m9 = new Menu();
		m9.setPosition(2);
		m9.setMenuPosition(MenuPosition.MAIN);
		m9.setName("Units");
		m9.setAddress("/timetablepk/units");
		session.save(m9);
		
		Menu m10 = new Menu();
		m10.setPosition(3);
		m10.setMenuPosition(MenuPosition.MAIN);
		m10.setName("Add Unit");
		m10.setAddress("/timetablepk/unit/add");
		session.save(m10);
		
		Menu m11 = new Menu();
		m11.setPosition(4);
		m11.setMenuPosition(MenuPosition.MAIN);
		m11.setName("Groups");
		m11.setAddress("/timetablepk/groups");
		session.save(m11);
		
		Menu m12 = new Menu();
		m12.setPosition(5);
		m12.setMenuPosition(MenuPosition.MAIN);
		m12.setName("Add Group");
		m12.setAddress("/timetablepk/group/add");
		session.save(m12);
		
		Menu m13 = new Menu();
		m13.setPosition(6);
		m13.setMenuPosition(MenuPosition.MAIN);
		m13.setName("Room");
		m13.setAddress("/timetablepk/rooms");
		session.save(m13);
		
		Menu m14 = new Menu();
		m14.setPosition(7);
		m14.setMenuPosition(MenuPosition.MAIN);
		m14.setName("Add Room");
		m14.setAddress("/timetablepk/room/add");
		session.save(m14);
		
		Menu m15 = new Menu();
		m15.setPosition(8);
		m15.setMenuPosition(MenuPosition.MAIN);
		m15.setName("Courses");
		m15.setAddress("/timetablepk/courses");
		session.save(m15);
		
		Menu m16 = new Menu();
		m16.setPosition(9);
		m16.setMenuPosition(MenuPosition.MAIN);
		m16.setName("Add Course");
		m16.setAddress("/timetablepk/course/add");
		session.save(m16);
		
		Menu m17 = new Menu();
		m17.setPosition(10);
		m17.setMenuPosition(MenuPosition.MAIN);
		m17.setName("User");
		m17.setAddress("/timetablepk/users");
		session.save(m17);
		
		Menu m18 = new Menu();
		m18.setPosition(11);
		m18.setMenuPosition(MenuPosition.MAIN);
		m18.setName("Add User");
		m18.setAddress("/timetablepk/user/add");
		session.save(m18);
		
		Menu m19 = new Menu();
		m19.setPosition(12);
		m19.setMenuPosition(MenuPosition.MAIN);
		m19.setName("Menus");
		m19.setAddress("/timetablepk/menus");
		session.save(m19);
		
		Menu m20 = new Menu();
		m20.setPosition(13);
		m20.setMenuPosition(MenuPosition.MAIN);
		m20.setName("Add Menu");
		m20.setAddress("/timetablepk/menu/add");
		session.save(m20);
	}
}
