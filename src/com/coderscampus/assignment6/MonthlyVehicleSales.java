package com.coderscampus.assignment6;

public class MonthlyVehicleSales {

	int salesMonth; 
	Integer salesYear;
	Integer salesVolume;
	String carModel;

	public MonthlyVehicleSales(String model, int month, Integer year, Integer volume) {
		this.carModel = model;
		this.salesMonth = month;
		this.salesYear = year;
		this.salesVolume = volume;
	}
	public int getMonth() {
		return salesMonth;
	}
	public void setMonth(int month) {
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
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
}
