package eu.paniw.timetable.panel.schedule;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import eu.paniw.timetable.domain.entity.ScheduleItem;
import eu.paniw.timetable.domain.entity.ScheduleRow;

public class ScheduleRowPanel extends Panel {
	private static final long serialVersionUID = -941211233475377911L;

	public ScheduleRowPanel(String id, ScheduleRow row) {
		super(id);
		init(row);
	}

	private void init(ScheduleRow row) {
		RepeatingView rv = new RepeatingView("itemRV");
		rv.setRenderBodyOnly(true);
		add(rv);

		for(ScheduleItem item : row.getItems()) {
			ScheduleItemPanel itemPanel = new ScheduleItemPanel(rv.newChildId(), item);
			itemPanel.setRenderBodyOnly(true);
			rv.add(itemPanel);
		}
	}
}
