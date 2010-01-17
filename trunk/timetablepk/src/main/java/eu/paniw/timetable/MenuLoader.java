package eu.paniw.timetable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.databinder.models.hib.HibernateListModel;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.authorization.strategies.role.metadata.MetaDataRoleAuthorizationStrategy;
import org.apache.wicket.markup.repeater.RepeatingView;
import eu.paniw.timetable.domain.app.Menu;
import eu.paniw.timetable.panel.MenuPanel;

public class MenuLoader {
	private Boolean loaded = false;
	private List<Menu> topMenus = new ArrayList<Menu>();
	private List<Menu> mainMenus = new ArrayList<Menu>();
	private List<Menu> bottomMenus = new ArrayList<Menu>();

	public MenuLoader() {
	}

	public void addMenuPanel(Page page) {
		if(!loaded) {
			loadMenus();
		}

		/* top menu */
		RepeatingView menuTop = new RepeatingView("menuTop");
		menuTop.setRenderBodyOnly(true);
		for(Menu m : topMenus) {
			MenuPanel mp = new MenuPanel(menuTop.newChildId(), m);
			mp.setRenderBodyOnly(true);
			MetaDataRoleAuthorizationStrategy.authorize(mp, Component.RENDER, m.getRole().name());
			menuTop.add(mp);
		}
		page.add(menuTop);

		/* main menu */
		RepeatingView menuMain = new RepeatingView("menuMain");
		menuMain.setRenderBodyOnly(true);
		for(Menu m : mainMenus) {
			MenuPanel mp = new MenuPanel(menuMain.newChildId(), m);
			mp.setRenderBodyOnly(true);
			MetaDataRoleAuthorizationStrategy.authorize(mp, Component.RENDER, m.getRole().name());
			menuMain.add(mp);
		}
		page.add(menuMain);

		/* bottom menu */
		RepeatingView menuBottom = new RepeatingView("menuBottom");
		menuBottom.setRenderBodyOnly(true);
		for(Menu m : bottomMenus) {
			MenuPanel mp = new MenuPanel(menuBottom.newChildId(), m);
			mp.setRenderBodyOnly(true);
			MetaDataRoleAuthorizationStrategy.authorize(mp, Component.RENDER, m.getRole().name());
			menuBottom.add(mp);
		}
		page.add(menuBottom);
	}

	private void loadMenus() {
		for(Menu m : new HibernateListModel<Menu>(Menu.class).getObject()) {
			switch(m.getMenuPosition()) {
				case TOP:
					topMenus.add(m);
					break;
				case MAIN:
					mainMenus.add(m);
					break;
				case BOTTOM:
					bottomMenus.add(m);
					break;
			}
		}

		Collections.sort(topMenus);
		Collections.sort(mainMenus);
		Collections.sort(bottomMenus);

		loaded = true;
	}

	public void refreshMenus() {
		topMenus.clear();
		mainMenus.clear();
		bottomMenus.clear();
		loadMenus();
	}
}
