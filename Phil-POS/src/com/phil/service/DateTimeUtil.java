package com.phil.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeUtil {
	
	SimpleDateFormat sdf;
	Calendar calendar;
	
	public DateTimeUtil() {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		calendar = Calendar.getInstance();
	}
	
	public String getFistdayOfMonth(int year, int month) {
		calendar.set(year, month - 1, 1);
		String start = sdf.format(calendar.getTime());

		return start;
	}
	
	public String getLastdayOfMonth(int year, int month) {
		calendar.set(year, month, 1);
		calendar.add(Calendar.DATE, -1);
		String end = sdf.format(calendar.getTime());

		return end;
	}

}
