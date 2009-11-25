package eu.paniw.timetable.pages.menu;

import java.util.Arrays;
import java.util.List;
import net.databinder.models.hib.CriteriaBuilder;
import net.databinder.models.hib.HibernateListModel;
import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.form.palette.Palette;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.domain.app.Menu;
import eu.paniw.timetable.domain.app.MenuItem;
import eu.paniw.timetable.domain.app.MenuPosition;
import eu.paniw.timetable.pages.EditPage;
import eu.paniw.timetable.tool.PageParametersTool;

@MountPath(path = "menu/menu/edit", alt = "menu/menu/add")
@MountMixedParam(parameterNames = {"id"})
public class MenuEditPage extends EditPage<Menu> {
	private Palette<MenuItem> itemsP;

	public MenuEditPage(PageParameters param) {
		super(param, Menu.class, MenuViewPage.class, MenuListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		TextField<String> nameTF = new TextField<String>("item", new PropertyModel<String>(getFormModel(), "name"));
		nameTF.setRequired(true);
		builder.addComponent(nameTF, "menu.name");

		DropDownChoice<MenuPosition> menuPositionDDC = new DropDownChoice<MenuPosition>("item",
				new PropertyModel<MenuPosition>(getFormModel(), "menuPosition"), Arrays.asList(MenuPosition.values())) {
			private static final long serialVersionUID = -3965739261427409287L;

			@Override
			protected CharSequence getDefaultChoice(Object selected) {
				return MenuPosition.MAIN.toString();
			}

		};
		builder.addComponent(menuPositionDDC, "menu.menuPosition");

		itemsP = new Palette<MenuItem>("item", new PropertyModel<List<MenuItem>>(getFormModel(), "items"),
				new HibernateListModel<MenuItem>(MenuItem.class, new CriteriaBuilder() {
					private static final long serialVersionUID = 6905873763368691472L;

					@Override
					public void build(Criteria criteria) {
						criteria.addOrder(Order.asc("position"));
					}
				}), new ChoiceRenderer<MenuItem>("unifyName", "id"), 5, true);
		builder.addComponent(itemsP, "menu.items");
	}

	@Override
	public void onBeforeSubmit() {
//		itemsP.getSelectedChoices();
	}

	@Override
	public void onAfterSubmit() {
		responseParam = new PageParametersTool("id", getFormModel().getObject().getId()).getPP();
	}
}
