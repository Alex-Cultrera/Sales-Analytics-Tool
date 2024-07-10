package com.coderscampus.assignment6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExtractDateService {

	public int extractMonth (String date) {
		int salesMonth = 0;
		String monthCode = null;
		if (date.contains(monthCode)) {
			switch (monthCode) {
			case "Jan":
				salesMonth = 1;
				break;
			case "Feb":
				salesMonth = 2;
				break;
			case "Mar":
				salesMonth = 3;
				break;
			case "Apr":
				salesMonth = 4;
				break;
			case "May":
				salesMonth = 5;
				break;
			case "Jun":
				salesMonth = 6;
				break;
			case "Jul":
				salesMonth = 7;
				break;
			case "Aug":
				salesMonth = 8;
				break;
			case "Sep":
				salesMonth = 9;
				break;
			case "Oct":
				salesMonth = 10;
				break;
			case "Nov":
				salesMonth = 11;
				break;
			case "Dec":
				salesMonth = 12;
				break;
			default:
				System.out.println("CSV contains invalid month entry. " + 
						"Check spelling of month in the Date column.\n");
				return 0;
			}
		}
		return salesMonth;
	}
}
//				format(DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm:ss a"));
