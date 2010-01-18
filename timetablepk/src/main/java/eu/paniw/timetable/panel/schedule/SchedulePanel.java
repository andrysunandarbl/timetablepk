package eu.paniw.timetable.panel.schedule;

import java.io.File;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import eu.paniw.timetable.domain.entity.Schedule;
import eu.paniw.timetable.domain.entity.ScheduleDay;
import eu.paniw.timetable.pages.schedule.SchedulePage;
import eu.paniw.timetable.pages.schedule.ScheduleXls;
import eu.paniw.timetable.tool.LinkTool;

public class SchedulePanel extends Panel {
	private static final long serialVersionUID = -1900402181496952809L;

	public SchedulePanel(String id, Schedule schedule, Page page) {
		super(id);
		init(schedule, page);
	}

	private void init(final Schedule schedule, final Page page) {
		Label scheduleNameL = new Label("scheduleName", schedule.getName());
		scheduleNameL.setRenderBodyOnly(true);
		add(scheduleNameL);

		MultiLineLabel scheduleDescriptionML = new MultiLineLabel("scheduleDescription", schedule.getDescription());
		scheduleDescriptionML.setRenderBodyOnly(true);
		add(scheduleDescriptionML);

		add(LinkTool.getDeleteLink("delete", schedule, getString("app.delquestion", null, "app.delquestion"),
				SchedulePage.class));

		File downloadfile = new File(ScheduleXls.tmpFilePath);
		DownloadLink exportToXlsDL = new DownloadLink("exportToXls", new Model<File>(downloadfile), ScheduleXls.tmpFilePath) {
			private static final long serialVersionUID = -7030087903371757152L;

			@Override
			public void onClick() {
				try {
					new ScheduleXls(schedule, page);
					super.onClick();
				} catch(Exception exc) {
					exc.printStackTrace();
				}
			}
		};
		exportToXlsDL.setDeleteAfterDownload(true);
		add(exportToXlsDL);

		RepeatingView rv = new RepeatingView("dayRV");
		rv.setRenderBodyOnly(true);
		add(rv);

		for(ScheduleDay sd : schedule.getScheduleDays()) {
			ScheduleDayPanel sdp = new ScheduleDayPanel(rv.newChildId(), sd);
			sdp.setRenderBodyOnly(true);
			rv.add(sdp);
		}
	}
}
