package eu.paniw.timetable.panel.schedule;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import eu.paniw.timetable.domain.entity.ScheduleItem;

public class ScheduleItemPanel extends Panel {
	private static final long serialVersionUID = 5034896076203724078L;

	public ScheduleItemPanel(String id, ScheduleItem item) {
		super(id);
		init(item);
	}

	private void init(ScheduleItem item) {
		Label beginTimeL = new Label("beginTime", item.getBeginTime());
		beginTimeL.setRenderBodyOnly(true);
		add(beginTimeL);

		Label courseL = new Label("course", item.getCourse().getUnifyName());
		courseL.setRenderBodyOnly(true);
		add(courseL);

		Label roomL = new Label("room", item.getRoom().getUnifyName());
		roomL.setRenderBodyOnly(true);
		add(roomL);

		Label teacherL = new Label("teacher", item.getTeacher().getUnifyName());
		teacherL.setRenderBodyOnly(true);
		add(teacherL);

		Label unitL = new Label("unit", item.getUnit().getUnifyName());
		unitL.setRenderBodyOnly(true);
		add(unitL);
	}
}
