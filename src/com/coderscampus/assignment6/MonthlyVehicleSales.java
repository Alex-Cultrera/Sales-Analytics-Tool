package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class MonthlyVehicleSales {

	Integer salesMonth; 
	Integer salesYear;
	Integer salesVolume;
	String carModel;
	YearMonth salesYearMonth;

	public YearMonth salesYearMonth (Integer year, Integer month) {
		YearMonth yearMonth = YearMonth.of(year, month).format(DateTimeFormatter.ofPattern("yyyy-MM");
		this.salesYear=year;
		this.salesMonth=month;
		return yearMonth;
	}
	
	public MonthlyVehicleSales(String model, Integer month, Integer year, Integer volume) {
		this.carModel = model;
		this.salesMonth = month;
		this.salesYear = year;
		this.salesVolume = volume;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public Integer getMonth() {
		return salesMonth;
	}
	public void setMonth(Integer month) {
		this.salesMonth = month;
	}
	public Integer getYear() {
		return salesYear;
	}
	public void setYear(Integer year) {
		this.salesYear = year;
	}
	public Integer getSalesVolume() {
		return salesVolume;
	}
	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}
	
}
