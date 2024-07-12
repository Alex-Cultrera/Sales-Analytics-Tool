package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class ExtractDateService {

	String salesYearMonth;
	
	public Integer extractYear(String year) {
		Integer extractedYear = Integer.parseInt(year)+2000;
		return extractedYear;
	}

	public Integer extractMonth(String month) {
		Integer extractedMonth = 0;
		String monthCode = month;
		if (month.contains(monthCode)) {
			switch (monthCode) {
			case "Jan":
				extractedMonth = 1;
				break;
			case "Feb":
				extractedMonth = 2;
				break;
			case "Mar":
				extractedMonth = 3;
				break;
			case "Apr":
				extractedMonth = 4;
				break;
			case "May":
				extractedMonth = 5;
				break;
			case "Jun":
				extractedMonth = 6;
				break;
			case "Jul":
				extractedMonth = 7;
				break;
			case "Aug":
				extractedMonth = 8;
				break;
			case "Sep":
				extractedMonth = 9;
				break;
			case "Oct":
				extractedMonth = 10;
				break;
			case "Nov":
				extractedMonth = 11;
				break;
			case "Dec":
				extractedMonth = 12;
				break;
			default:
				System.out.println(
						"CSV contains invalid month entry. " 
				+ "Check spelling of month in the Date column.\n");
				break;
			}
		}
		return extractedMonth;
	}
	
	public Integer salesYear (Integer year, Integer month) {
		String yearMonth = YearMonth.of(year, month)
									.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		String[] date = yearMonth.split("-");
		Integer salesYear = Integer.parseInt(date[0]);
		return salesYear;
	}
	
	public Integer salesMonth (Integer year, Integer month) {
		String yearMonth = YearMonth.of(year, month)
									.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		String[] date = yearMonth.split("-");
		Integer salesMonth = Integer.parseInt(date[1]);
		return salesMonth;
	}
	public String salesYearMonth (Integer year, Integer month) {
		salesYearMonth = YearMonth.of(year, month)
				.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		return salesYearMonth;
	}

}
