package eu.paniw.timetable.pages.schedule;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.wicket.Page;
import eu.paniw.timetable.domain.entity.Schedule;
import eu.paniw.timetable.domain.entity.ScheduleDay;
import eu.paniw.timetable.domain.entity.ScheduleItem;
import eu.paniw.timetable.domain.entity.ScheduleRow;

public class ScheduleXls {
	public static final String SHEET_NAME = "TimeTable PK";
	public static final String tmpFilePath = "schedule.xls";

	public ScheduleXls(Schedule schedule, Page page) {
		init(schedule, page);
	}

	private void init(Schedule schedule, Page page) {
		try {
			HSSFWorkbook wb = new HSSFWorkbook();

			HSSFFont dayNamefont = wb.createFont();
			dayNamefont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			dayNamefont.setColor(HSSFColor.WHITE.index);

			HSSFFont thfont = wb.createFont();
			thfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			thfont.setFontHeightInPoints((short) 10);

			HSSFCellStyle thStyle = wb.createCellStyle();
			thStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
			thStyle.setFont(thfont);
			thStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			thStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			thStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			thStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);

			HSSFCellStyle dayNameStyle = wb.createCellStyle();
			dayNameStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
			dayNameStyle.setFont(dayNamefont);
			dayNameStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			dayNameStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			dayNameStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			dayNameStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			dayNameStyle.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			dayNameStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

			HSSFCellStyle tdStyle = wb.createCellStyle();
			tdStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			tdStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			tdStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			tdStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			tdStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);

			/* create sheet */
			HSSFSheet sheet = wb.createSheet(SHEET_NAME);
			sheet.setAutobreaks(true);
			sheet.setDisplayGridlines(false);
			sheet.setDisplayRowColHeadings(true);
			sheet.setDisplayGuts(true);
			sheet.setGridsPrinted(false);
			sheet.setPrintGridlines(false);

			HSSFPrintSetup ps = sheet.getPrintSetup();
			ps.setLandscape(true);
			ps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);
			sheet.setFitToPage(true);
			ps.setFitWidth((short) 1);
			ps.setFitHeight((short) 0);

			int i = 0;
			HSSFRow row;

			for(ScheduleDay scheduleDay : schedule.getScheduleDays()) {
				row = sheet.createRow(i++);
				row.createCell(0).setCellValue(scheduleDay.getDay().getName());
				row.getCell(0).setCellStyle(dayNameStyle);
				row.createCell(1).setCellStyle(dayNameStyle);
				row.createCell(2).setCellStyle(dayNameStyle);
				row.createCell(3).setCellStyle(dayNameStyle);
				row.createCell(4).setCellStyle(dayNameStyle);
				sheet.addMergedRegion(new CellRangeAddress(i - 1, i - 1, 0, 4));

				row = sheet.createRow(i++);
				row.createCell(0).setCellValue(page.getString("beginTime", null, "beginTime"));
				row.getCell(0).setCellStyle(thStyle);
				row.createCell(1).setCellValue(page.getString("course", null, "course"));
				row.getCell(1).setCellStyle(thStyle);
				row.createCell(2).setCellValue(page.getString("room", null, "room"));
				row.getCell(2).setCellStyle(thStyle);
				row.createCell(3).setCellValue(page.getString("teacher", null, "teacher"));
				row.getCell(3).setCellStyle(thStyle);
				row.createCell(4).setCellValue(page.getString("unit", null, "unit"));
				row.getCell(4).setCellStyle(thStyle);

				for(ScheduleRow scheduleRow : scheduleDay.getRows()) {
					for(ScheduleItem scheduleItem : scheduleRow.getItems()) {
						row = sheet.createRow(i++);
						row.createCell(0).setCellValue(scheduleItem.getBeginTime());
						row.getCell(0).setCellStyle(tdStyle);
						row.createCell(1).setCellValue(scheduleItem.getCourse().getUnifyName());
						row.getCell(1).setCellStyle(tdStyle);
						row.createCell(2).setCellValue(scheduleItem.getRoom().getUnifyName());
						row.getCell(2).setCellStyle(tdStyle);
						row.createCell(3).setCellValue(scheduleItem.getTeacher().getUnifyName());
						row.getCell(3).setCellStyle(tdStyle);
						row.createCell(4).setCellValue(scheduleItem.getUnit().getUnifyName());
						row.getCell(4).setCellStyle(tdStyle);
					}
				}
			}

			sheet.autoSizeColumn(0, true);
			sheet.autoSizeColumn(1, true);
			sheet.autoSizeColumn(2, true);
			sheet.autoSizeColumn(3, true);
			sheet.autoSizeColumn(4, true);

			File file = new File(tmpFilePath);
			if(!file.exists()) {
				file.createNewFile();
			}
			file.setExecutable(true);
			file.setReadable(true);
			file.setWritable(true);

			FileOutputStream fileOut = new FileOutputStream(tmpFilePath);
			wb.write(fileOut);
			fileOut.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
