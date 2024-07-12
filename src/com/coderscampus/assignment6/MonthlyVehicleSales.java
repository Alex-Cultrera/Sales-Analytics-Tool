package com.coderscampus.assignment6;

public class MonthlyVehicleSales {

	Integer salesMonth; 
	Integer salesYear;
	Integer salesVolume;
	String carModel;
	String salesYearMonth;

	public MonthlyVehicleSales(String model, Integer salesMonth, Integer salesYear, Integer volume, String salesYearMonth) {
		this.carModel = model;
		this.salesMonth = salesMonth;
		this.salesYear = salesYear;
		this.salesVolume = volume;
		this.salesYearMonth = salesYearMonth;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public Integer getSalesMonth() {
		return salesMonth;
	}
	public void setSalesMonth(Integer salesMonth) {
		this.salesMonth = salesMonth;
	}
	public Integer getSalesYear() {
		return salesYear;
	}
	public void setSalesYear(Integer salesYear) {
		this.salesYear = salesYear;
	}
	public Integer getSalesVolume() {
		return salesVolume;
	}
	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}
	public String getSalesYearMonth() {
		return salesYearMonth;
	}
	public void setSalesYearMonth(String salesYearMonth) {
		this.salesYearMonth = salesYearMonth;
	}
	
}
