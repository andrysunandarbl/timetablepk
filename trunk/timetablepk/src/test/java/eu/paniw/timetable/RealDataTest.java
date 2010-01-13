package eu.paniw.timetable;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.DefaultComponentSafeNamingStrategy;
import eu.paniw.timetable.domain.app.Menu;
import eu.paniw.timetable.domain.app.MenuPosition;
import eu.paniw.timetable.domain.app.Translation;
import eu.paniw.timetable.domain.app.UserAppRole;
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
		addTranslations();
		addMenus();
	}

	private void addUsers() {
		User user1 = new User();
		user1.setUserName("webgp");
		user1.setPassword("pass.word");
		user1.setFirstname("Grzegorz");
		user1.setSurname("Paniw");
		user1.setDescription("Main administratior of application");
		user1.setUserAppRole(UserAppRole.ADMIN);
		session.save(user1);

		User user2 = new User();
		user2.setUserName("revis");
		user2.setPassword("pass.word");
		user2.setFirstname("Marcin");
		user2.setSurname("Kościelniak");
		user2.setDescription("Sub-administratior of application");
		user2.setUserAppRole(UserAppRole.ADMIN);
		session.save(user2);

		User user3 = new User();
		user3.setUserName("michal");
		user3.setPassword("pass.word");
		user3.setFirstname("Michał");
		user3.setSurname("Derecki");
		user3.setDescription("Sub-administratior of application");
		user3.setUserAppRole(UserAppRole.ADMIN);
		session.save(user3);

		User user4 = new User();
		user4.setUserName("test");
		user4.setPassword("pass.word");
		user4.setFirstname("Jan");
		user4.setSurname("Kowalski");
		user4.setDescription("Normal user");
		user4.setUserAppRole(UserAppRole.USER);
		session.save(user4);
	}

	private void addTranslations() {
		Translation t1 = new Translation();
		t1.setKey("course.name");
		t1.setPlTranslation("Nazwa");
		t1.setEnTranslation("Name");
		session.save(t1);

		Translation t2 = new Translation();
		t2.setKey("course.lecture");
		t2.setPlTranslation("Wykład");
		t2.setEnTranslation("Lecture");
		session.save(t2);

		Translation t3 = new Translation();
		t3.setKey("course.units");
		t3.setPlTranslation("Jednostka");
		t3.setEnTranslation("Unit");
		session.save(t3);

		Translation t4 = new Translation();
		t4.setKey("course.teachers");
		t4.setPlTranslation("Prowadzący");
		t4.setEnTranslation("Teachers");
		session.save(t4);

		Translation t5 = new Translation();
		t5.setKey("app.id");
		t5.setPlTranslation("Id");
		t5.setEnTranslation("Id");
		session.save(t5);

		Translation t6 = new Translation();
		t6.setKey("app.actions");
		t6.setPlTranslation("Akcje");
		t6.setEnTranslation("Actions");
		session.save(t6);

		Translation t7 = new Translation();
		t7.setKey("app.view");
		t7.setPlTranslation("Zobacz");
		t7.setEnTranslation("View");
		session.save(t7);

		Translation t8 = new Translation();
		t8.setKey("app.edit");
		t8.setPlTranslation("Edytuj");
		t8.setEnTranslation("Edit");
		session.save(t8);

		Translation t9 = new Translation();
		t9.setKey("app.delete");
		t9.setPlTranslation("Skasuj");
		t9.setEnTranslation("Delete");
		session.save(t9);

		Translation t10 = new Translation();
		t10.setKey("menu.name");
		t10.setPlTranslation("Nazwa");
		t10.setEnTranslation("Name");
		session.save(t10);

		Translation t11 = new Translation();
		t11.setKey("menu.menuPosition");
		t11.setPlTranslation("Położenie");
		t11.setEnTranslation("Location");
		session.save(t11);

		Translation t12 = new Translation();
		t12.setKey("menu.position");
		t12.setPlTranslation("Pozycja");
		t12.setEnTranslation("Position");
		session.save(t12);

		Translation t13 = new Translation();
		t13.setKey("menu.address");
		t13.setPlTranslation("Adres URL");
		t13.setEnTranslation("URL address");
		session.save(t13);

		Translation t14 = new Translation();
		t14.setKey("menu.secondLevel");
		t14.setPlTranslation("Drugi poziom");
		t14.setEnTranslation("Second level");
		session.save(t14);

		Translation t15 = new Translation();
		t15.setKey("translation");
		t15.setPlTranslation("Klucz tłumaczenia");
		t15.setEnTranslation("Translation key");
		session.save(t15);

		Translation t16 = new Translation();
		t16.setKey("room.name");
		t16.setPlTranslation("Nazwa");
		t16.setEnTranslation("Name");
		session.save(t16);

		Translation t17 = new Translation();
		t17.setKey("room.capacity");
		t17.setPlTranslation("Pojemność");
		t17.setEnTranslation("Capacity");
		session.save(t17);

		Translation t18 = new Translation();
		t18.setKey("room.lecture");
		t18.setPlTranslation("Sala wykładowa");
		t18.setEnTranslation("Lecture room");
		session.save(t18);

		Translation t19 = new Translation();
		t19.setKey("teacher.degree");
		t19.setPlTranslation("Stopień");
		t19.setEnTranslation("Degree");
		session.save(t19);

		Translation t20 = new Translation();
		t20.setKey("teacher.firstname");
		t20.setPlTranslation("Imię");
		t20.setEnTranslation("Firstname");
		session.save(t20);

		Translation t21 = new Translation();
		t21.setKey("teacher.surname");
		t21.setPlTranslation("Nazwisko");
		t21.setEnTranslation("Surname");
		session.save(t21);

		Translation t22 = new Translation();
		t22.setKey("teacher.courses");
		t22.setPlTranslation("Zajęcia");
		t22.setEnTranslation("Courses");
		session.save(t22);

		Translation t23 = new Translation();
		t23.setKey("translation.key");
		t23.setPlTranslation("Klucz");
		t23.setEnTranslation("Key");
		session.save(t23);

		Translation t24 = new Translation();
		t24.setKey("translation.plTranslation");
		t24.setPlTranslation("Tłumaczenie polskie");
		t24.setEnTranslation("Polish translation");
		session.save(t24);

		Translation t25 = new Translation();
		t25.setKey("translation.deTranslation");
		t25.setPlTranslation("Tłumaczenie niemieckie");
		t25.setEnTranslation("German translation");
		session.save(t25);

		Translation t26 = new Translation();
		t26.setKey("translation.enTranslation");
		t26.setPlTranslation("Tłumaczenie angielskie");
		t26.setEnTranslation("English translation");
		session.save(t26);

		Translation t27 = new Translation();
		t27.setKey("group.name");
		t27.setPlTranslation("Nazwa");
		t27.setEnTranslation("Name");
		session.save(t27);

		Translation t28 = new Translation();
		t28.setKey("group.count");
		t28.setPlTranslation("Liczebność");
		t28.setEnTranslation("Count");
		session.save(t28);

		Translation t29 = new Translation();
		t29.setKey("group.parent");
		t29.setPlTranslation("Rodzic");
		t29.setEnTranslation("Parent");
		session.save(t29);

		Translation t30 = new Translation();
		t30.setKey("course.units");
		t30.setPlTranslation("Grupy");
		t30.setEnTranslation("Units");
		session.save(t30);

		Translation t31 = new Translation();
		t31.setKey("user.userName");
		t31.setPlTranslation("Nazwa użytkownika");
		t31.setEnTranslation("User name");
		session.save(t31);

		Translation t32 = new Translation();
		t32.setKey("user.password");
		t32.setPlTranslation("Hasło");
		t32.setEnTranslation("Password");
		session.save(t32);

		Translation t33 = new Translation();
		t33.setKey("user.firstname");
		t33.setPlTranslation("Imię");
		t33.setEnTranslation("Firstname");
		session.save(t33);

		Translation t34 = new Translation();
		t34.setKey("user.surname");
		t34.setPlTranslation("Nazwisko");
		t34.setEnTranslation("Surname");
		session.save(t34);

		Translation t35 = new Translation();
		t35.setKey("user.description");
		t35.setPlTranslation("Opis");
		t35.setEnTranslation("Description");
		session.save(t35);

		Translation t36 = new Translation();
		t36.setKey("user.active");
		t36.setPlTranslation("Aktywny");
		t36.setEnTranslation("Active");
		session.save(t36);

		Translation t37 = new Translation();
		t37.setKey("palette.available");
		t37.setPlTranslation("Dostępne");
		t37.setEnTranslation("Available");
		session.save(t37);

		Translation t38 = new Translation();
		t38.setKey("palette.selected");
		t38.setPlTranslation("Wybrane");
		t38.setEnTranslation("Selected");
		session.save(t38);

		Translation t39 = new Translation();
		t39.setKey("app.delquestion");
		t39.setPlTranslation("Czy jesteś pewny?");
		t39.setEnTranslation("Are you sure?");
		session.save(t39);

		Translation t40 = new Translation();
		t40.setKey("app.add");
		t40.setPlTranslation("Dodaj");
		t40.setEnTranslation("Add");
		session.save(t40);

		Translation t41 = new Translation();
		t41.setKey("app.back");
		t41.setPlTranslation("Cofnij");
		t41.setEnTranslation("Back");
		session.save(t41);

		Translation t42 = new Translation();
		t42.setKey("user.role");
		t42.setPlTranslation("Rola");
		t42.setEnTranslation("Role");
		session.save(t42);

		Translation t43 = new Translation();
		t43.setKey("menu.role");
		t43.setPlTranslation("Uprawnienie");
		t43.setEnTranslation("Permission");
		session.save(t43);

		Translation t44 = new Translation();
		t44.setKey("loginInfo");
		t44.setPlTranslation("Dostęp do aplikacji wymaga zalogowania.<br />Proszę podać poniższe dane:");
		t44.setEnTranslation("Access to applications requires login.<br />Please insert the following data:");
		session.save(t44);

		Translation t45 = new Translation();
		t45.setKey("login");
		t45.setPlTranslation("Login");
		t45.setEnTranslation("Login");
		session.save(t45);

		Translation t46 = new Translation();
		t46.setKey("password");
		t46.setPlTranslation("Hasło");
		t46.setEnTranslation("Password");
		session.save(t46);

		 Translation t47 = new Translation();
		 t47.setKey("loginbutton");
		 t47.setPlTranslation("Zaloguj");
		 t47.setEnTranslation("Login");
		 session.save(t47);
				
		// Translation t48 = new Translation();
		// t48.setKey(key);
		// t48.setPlTranslation(plTranslation);
		// t48.setEnTranslation(enTranslation);
		// session.save(t48);
		//		
		// Translation t49 = new Translation();
		// t49.setKey(key);
		// t49.setPlTranslation(plTranslation);
		// t49.setEnTranslation(enTranslation);
		// session.save(t49);
		//		
		// Translation t50 = new Translation();
		// t50.setKey(key);
		// t50.setPlTranslation(plTranslation);
		// t50.setEnTranslation(enTranslation);
		// session.save(t50);
		//		
		// Translation t51 = new Translation();
		// t51.setKey(key);
		// t51.setPlTranslation(plTranslation);
		// t51.setEnTranslation(enTranslation);
		// session.save(t51);
		//		
		// Translation t52 = new Translation();
		// t52.setKey(key);
		// t52.setPlTranslation(plTranslation);
		// t52.setEnTranslation(enTranslation);
		// session.save(t52);
		//		
		// Translation t53 = new Translation();
		// t53.setKey(key);
		// t53.setPlTranslation(plTranslation);
		// t53.setEnTranslation(enTranslation);
		// session.save(t53);
		//		
		// Translation t54 = new Translation();
		// t54.setKey(key);
		// t54.setPlTranslation(plTranslation);
		// t54.setEnTranslation(enTranslation);
		// session.save(t54);
		//		
		// Translation t55 = new Translation();
		// t55.setKey(key);
		// t55.setPlTranslation(plTranslation);
		// t55.setEnTranslation(enTranslation);
		// session.save(t55);
		//		
		// Translation t56 = new Translation();
		// t56.setKey(key);
		// t56.setPlTranslation(plTranslation);
		// t56.setEnTranslation(enTranslation);
		// session.save(t56);
		//		
		// Translation t57 = new Translation();
		// t57.setKey(key);
		// t57.setPlTranslation(plTranslation);
		// t57.setEnTranslation(enTranslation);
		// session.save(t57);
		//		
		// Translation t58 = new Translation();
		// t58.setKey(key);
		// t58.setPlTranslation(plTranslation);
		// t58.setEnTranslation(enTranslation);
		// session.save(t58);
		//		
		// Translation t59 = new Translation();
		// t59.setKey(key);
		// t59.setPlTranslation(plTranslation);
		// t59.setEnTranslation(enTranslation);
		// session.save(t59);
		//		
		// Translation t60 = new Translation();
		// t60.setKey(key);
		// t60.setPlTranslation(plTranslation);
		// t60.setEnTranslation(enTranslation);
		// session.save(t60);
		//		
		// Translation t61 = new Translation();
		// t61.setKey(key);
		// t61.setPlTranslation(plTranslation);
		// t61.setEnTranslation(enTranslation);
		// session.save(t61);
		//		
		// Translation t62 = new Translation();
		// t62.setKey(key);
		// t62.setPlTranslation(plTranslation);
		// t62.setEnTranslation(enTranslation);
		// session.save(t62);
		//		
		// Translation t63 = new Translation();
		// t63.setKey(key);
		// t63.setPlTranslation(plTranslation);
		// t63.setEnTranslation(enTranslation);
		// session.save(t63);
		//		
		// Translation t64 = new Translation();
		// t64.setKey(key);
		// t64.setPlTranslation(plTranslation);
		// t64.setEnTranslation(enTranslation);
		// session.save(t64);
		//		
		// Translation t65 = new Translation();
		// t65.setKey(key);
		// t65.setPlTranslation(plTranslation);
		// t65.setEnTranslation(enTranslation);
		// session.save(t65);
		//		
		// Translation t66 = new Translation();
		// t66.setKey(key);
		// t66.setPlTranslation(plTranslation);
		// t66.setEnTranslation(enTranslation);
		// session.save(t66);
		//		
		// Translation t67 = new Translation();
		// t67.setKey(key);
		// t67.setPlTranslation(plTranslation);
		// t67.setEnTranslation(enTranslation);
		// session.save(t67);
		//		
		// Translation t68= new Translation();
		// t68.setKey(key);
		// t68.setPlTranslation(plTranslation);
		// t68.setEnTranslation(enTranslation);
		// session.save(t68);
		//		
		// Translation t69 = new Translation();
		// t69.setKey(key);
		// t69.setPlTranslation(plTranslation);
		// t69.setEnTranslation(enTranslation);
		// session.save(t69);
		//		
		// Translation t70 = new Translation();
		// t70.setKey(key);
		// t70.setPlTranslation(plTranslation);
		// t70.setEnTranslation(enTranslation);
		// session.save(t70);
		//		
		// Translation t71 = new Translation();
		// t71.setKey(key);
		// t71.setPlTranslation(plTranslation);
		// t71.setEnTranslation(enTranslation);
		// session.save(t71);
		//		
		// Translation t72 = new Translation();
		// t72.setKey(key);
		// t72.setPlTranslation(plTranslation);
		// t72.setEnTranslation(enTranslation);
		// session.save(t72);
		//		
		// Translation t73 = new Translation();
		// t73.setKey(key);
		// t73.setPlTranslation(plTranslation);
		// t73.setEnTranslation(enTranslation);
		// session.save(t73);
	}

	private void addMenus() {
		/* top */
		Translation t1 = new Translation();
		t1.setKey("menu.homePage");
		t1.setPlTranslation("Strona główna");
		t1.setEnTranslation("Home page");
		session.save(t1);

		Menu m1 = new Menu();
		m1.setPosition(0);
		m1.setMenuPosition(MenuPosition.TOP);
		m1.setName("Home page");
		m1.setAddress("/timetablepk");
		m1.setTranslation(t1);
		session.save(m1);

		Translation t2 = new Translation();
		t2.setKey("menu.pk");
		t2.setPlTranslation("Politechnika Krakowska");
		t2.setEnTranslation("Cracow University of Technology");
		session.save(t2);

		Menu m2 = new Menu();
		m2.setPosition(1);
		m2.setMenuPosition(MenuPosition.TOP);
		m2.setName("Politechnika Krakowska");
		m2.setAddress("http://www.pk.edu.pl");
		m2.setTranslation(t2);
		session.save(m2);

		Translation t3 = new Translation();
		t3.setKey("menu.wfmiis");
		t3.setPlTranslation("WFMIIS");
		t3.setEnTranslation("WFMIIS");
		session.save(t3);

		Menu m3 = new Menu();
		m3.setPosition(2);
		m3.setMenuPosition(MenuPosition.TOP);
		m3.setName("WFMIIS");
		m3.setAddress("http://www.wfmiis.pk.edu.pl/");
		m3.setTranslation(t3);
		session.save(m3);

		Translation t6 = new Translation();
		t6.setKey("menu.google");
		t6.setPlTranslation("Google");
		t6.setEnTranslation("Google");
		session.save(t6);

		Menu m6 = new Menu();
		m6.setPosition(3);
		m6.setMenuPosition(MenuPosition.TOP);
		m6.setName("Google");
		m6.setAddress("http://www.google.pl");
		m6.setTranslation(t6);
		session.save(m6);

		Translation t23 = new Translation();
		t23.setKey("menu.logout");
		t23.setPlTranslation("Wyloguj");
		t23.setEnTranslation("Logout");
		session.save(t23);

		Menu m23 = new Menu();
		m23.setPosition(4);
		m23.setMenuPosition(MenuPosition.TOP);
		m23.setName("Add Translation");
		m23.setAddress("/timetablepk/logout");
		m23.setTranslation(t23);
		session.save(m23);

		/* main */
		Translation t7 = new Translation();
		t7.setKey("menu.teachers");
		t7.setPlTranslation("Wykładowcy");
		t7.setEnTranslation("Teachers");
		session.save(t7);

		Menu m7 = new Menu();
		m7.setPosition(0);
		m7.setMenuPosition(MenuPosition.MAIN);
		m7.setName("Teachers");
		m7.setAddress("/timetablepk/teachers");
		m7.setTranslation(t7);
		session.save(m7);

		Translation t8 = new Translation();
		t8.setKey("menu.teacher.add");
		t8.setPlTranslation("Dodaj wykładowcę");
		t8.setEnTranslation("Add Teacher");
		session.save(t8);

		Menu m8 = new Menu();
		m8.setPosition(1);
		m8.setMenuPosition(MenuPosition.MAIN);
		m8.setName("Add teacher");
		m8.setAddress("/timetablepk/teacher/add");
		m8.setSecondLevel(true);
		m8.setTranslation(t8);
		session.save(m8);

		Translation t9 = new Translation();
		t9.setKey("menu.units");
		t9.setPlTranslation("Jednostki");
		t9.setEnTranslation("Units");
		session.save(t9);

		Menu m9 = new Menu();
		m9.setPosition(2);
		m9.setMenuPosition(MenuPosition.MAIN);
		m9.setName("Units");
		m9.setAddress("/timetablepk/units");
		m9.setTranslation(t9);
		session.save(m9);

		Translation t10 = new Translation();
		t10.setKey("menu.unit.add");
		t10.setPlTranslation("Dodaj jednostkę");
		t10.setEnTranslation("Add unit");
		session.save(t10);

		Menu m10 = new Menu();
		m10.setPosition(3);
		m10.setMenuPosition(MenuPosition.MAIN);
		m10.setName("Add Unit");
		m10.setAddress("/timetablepk/unit/add");
		m10.setSecondLevel(true);
		m10.setTranslation(t10);
		session.save(m10);

		Translation t11 = new Translation();
		t11.setKey("menu.groups");
		t11.setPlTranslation("Grupy");
		t11.setEnTranslation("Groups");
		session.save(t11);

		Menu m11 = new Menu();
		m11.setPosition(4);
		m11.setMenuPosition(MenuPosition.MAIN);
		m11.setName("Groups");
		m11.setAddress("/timetablepk/groups");
		m11.setTranslation(t11);
		session.save(m11);

		Translation t12 = new Translation();
		t12.setKey("menu.group.add");
		t12.setPlTranslation("Dodaj grupę");
		t12.setEnTranslation("Add group");
		session.save(t12);

		Menu m12 = new Menu();
		m12.setPosition(5);
		m12.setMenuPosition(MenuPosition.MAIN);
		m12.setName("Add Group");
		m12.setAddress("/timetablepk/group/add");
		m12.setSecondLevel(true);
		m12.setTranslation(t12);
		session.save(m12);

		Translation t13 = new Translation();
		t13.setKey("menu.rooms");
		t13.setPlTranslation("Sale");
		t13.setEnTranslation("Rooms");
		session.save(t13);

		Menu m13 = new Menu();
		m13.setPosition(6);
		m13.setMenuPosition(MenuPosition.MAIN);
		m13.setName("Room");
		m13.setAddress("/timetablepk/rooms");
		m13.setTranslation(t13);
		session.save(m13);

		Translation t14 = new Translation();
		t14.setKey("menu.room.add");
		t14.setPlTranslation("Dodaj salę");
		t14.setEnTranslation("Add room");
		session.save(t14);

		Menu m14 = new Menu();
		m14.setPosition(7);
		m14.setMenuPosition(MenuPosition.MAIN);
		m14.setName("Add Room");
		m14.setAddress("/timetablepk/room/add");
		m14.setSecondLevel(true);
		m14.setTranslation(t14);
		session.save(m14);

		Translation t15 = new Translation();
		t15.setKey("menu.courses");
		t15.setPlTranslation("Zajęcia");
		t15.setEnTranslation("Courses");
		session.save(t15);

		Menu m15 = new Menu();
		m15.setPosition(8);
		m15.setMenuPosition(MenuPosition.MAIN);
		m15.setName("Courses");
		m15.setAddress("/timetablepk/courses");
		m15.setTranslation(t15);
		session.save(m15);

		Translation t16 = new Translation();
		t16.setKey("menu.course.add");
		t16.setPlTranslation("Dodaj zajęcie");
		t16.setEnTranslation("Add course");
		session.save(t16);

		Menu m16 = new Menu();
		m16.setPosition(9);
		m16.setMenuPosition(MenuPosition.MAIN);
		m16.setName("Add Course");
		m16.setAddress("/timetablepk/course/add");
		m16.setSecondLevel(true);
		m16.setTranslation(t16);
		session.save(m16);

		Translation t17 = new Translation();
		t17.setKey("menu.users");
		t17.setPlTranslation("Użytkownicy");
		t17.setEnTranslation("Users");
		session.save(t17);

		Menu m17 = new Menu();
		m17.setPosition(10);
		m17.setMenuPosition(MenuPosition.MAIN);
		m17.setName("User");
		m17.setAddress("/timetablepk/users");
		m17.setTranslation(t17);
		m17.setRole(UserAppRole.ADMIN);
		session.save(m17);

		Translation t18 = new Translation();
		t18.setKey("menu.user.add");
		t18.setPlTranslation("Dodaj użytkownika");
		t18.setEnTranslation("Add user");
		session.save(t18);

		Menu m18 = new Menu();
		m18.setPosition(11);
		m18.setMenuPosition(MenuPosition.MAIN);
		m18.setName("Add User");
		m18.setAddress("/timetablepk/user/add");
		m18.setSecondLevel(true);
		m18.setTranslation(t18);
		m18.setRole(UserAppRole.ADMIN);
		session.save(m18);

		Translation t19 = new Translation();
		t19.setKey("menu.menus");
		t19.setPlTranslation("Menu");
		t19.setEnTranslation("Menu");
		session.save(t19);

		Menu m19 = new Menu();
		m19.setPosition(12);
		m19.setMenuPosition(MenuPosition.MAIN);
		m19.setName("Menus");
		m19.setAddress("/timetablepk/menus");
		m19.setTranslation(t19);
		m19.setRole(UserAppRole.ADMIN);
		session.save(m19);

		Translation t20 = new Translation();
		t20.setKey("menu.menus.add");
		t20.setPlTranslation("Dodaj menu");
		t20.setEnTranslation("Add menu");
		session.save(t20);

		Menu m20 = new Menu();
		m20.setPosition(13);
		m20.setMenuPosition(MenuPosition.MAIN);
		m20.setName("Add Menu");
		m20.setAddress("/timetablepk/menu/add");
		m20.setSecondLevel(true);
		m20.setTranslation(t20);
		m20.setRole(UserAppRole.ADMIN);
		session.save(m20);

		Translation t21 = new Translation();
		t21.setKey("menu.translations");
		t21.setPlTranslation("Tłumaczenia");
		t21.setEnTranslation("Translations");
		session.save(t21);

		Menu m21 = new Menu();
		m21.setPosition(14);
		m21.setMenuPosition(MenuPosition.MAIN);
		m21.setName("Translations");
		m21.setAddress("/timetablepk/translations");
		m21.setTranslation(t21);
		m21.setRole(UserAppRole.ADMIN);
		session.save(m21);

		Translation t22 = new Translation();
		t22.setKey("menu.translations.add");
		t22.setPlTranslation("Dodaj tłumaczenie");
		t22.setEnTranslation("Add translation");
		session.save(t22);

		Menu m22 = new Menu();
		m22.setPosition(15);
		m22.setMenuPosition(MenuPosition.MAIN);
		m22.setName("Add Translation");
		m22.setAddress("/timetablepk/translation/add");
		m22.setSecondLevel(true);
		m22.setTranslation(t22);
		m22.setRole(UserAppRole.ADMIN);
		session.save(m22);
	}
}
