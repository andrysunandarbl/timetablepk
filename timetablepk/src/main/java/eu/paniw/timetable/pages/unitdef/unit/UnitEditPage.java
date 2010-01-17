package eu.paniw.timetable.pages.unitdef.unit;

import java.util.ArrayList;
import java.util.List;
import net.databinder.hib.Databinder;
import net.databinder.models.hib.CriteriaBuilder;
import net.databinder.models.hib.HibernateListModel;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.model.PropertyModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;
import eu.paniw.timetable.components.Palette;
import eu.paniw.timetable.domain.entity.Group;
import eu.paniw.timetable.domain.entity.Unit;
import eu.paniw.timetable.pages.unitdef.UnitDefEditPage;

@MountPath(path = "unit/edit", alt = "unit/add")
@MountMixedParam(parameterNames = {"id"})
public class UnitEditPage extends UnitDefEditPage<Unit> {
	private List<Group> groups = new ArrayList<Group>();

	public UnitEditPage(PageParameters param) {
		super(param, "unitTitle", Unit.class, UnitViewPage.class, UnitListPage.class);
		init();
	}

	@Override
	protected void init() {
		super.init();

		if(id != null) {
			groups = new HibernateListModel<Group>(Group.class, new CriteriaBuilder() {
				private static final long serialVersionUID = 5692774854930239294L;

				@Override
				public void build(Criteria criteria) {
					criteria.add(Restrictions.eq("parent", getFormModel().getObject()));
				}
			}).getObject();
		}

		Palette<Group> groupsP = new Palette<Group>("item", new PropertyModel<List<Group>>(this, "groups"),
				new HibernateListModel<Group>(Group.class), new ChoiceRenderer<Group>("unifyName", "id"), 5, false);
		builder.addComponent(groupsP, "unit.groups");
	}

	@Override
	protected void onAfterSubmit() {
		super.onAfterSubmit();

		Session session = Databinder.getHibernateSession();
		session.beginTransaction();
		for(Group g : groups) {
			g.setParent(getFormModel().getObject());
			session.saveOrUpdate(g);
		}
		session.getTransaction().commit();
	}
}
