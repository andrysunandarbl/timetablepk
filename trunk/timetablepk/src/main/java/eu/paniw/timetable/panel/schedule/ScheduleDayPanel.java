package eu.paniw.timetable.panel.schedule;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import eu.paniw.timetable.domain.entity.ScheduleDay;
import eu.paniw.timetable.domain.entity.ScheduleRow;

public class ScheduleDayPanel extends Panel {
	private static final long serialVersionUID = -6590544154718293619L;

	public ScheduleDayPanel(String id, ScheduleDay sd) {
		super(id);
		init(sd);
	}

	private void init(ScheduleDay sd) {
		Label dayNameL = new Label("dayName", sd.getDay().getName());
		add(dayNameL);

		RepeatingView rv = new RepeatingView("rowRV");
		rv.setRenderBodyOnly(true);
		add(rv);

		for(ScheduleRow row : sd.getRows()) {
			ScheduleRowPanel rowPanel = new ScheduleRowPanel(rv.newChildId(), row);
			rowPanel.setRenderBodyOnly(true);
			rv.add(rowPanel);
		}
	}
}
