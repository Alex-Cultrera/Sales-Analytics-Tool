package com.coderscampus.assignment6;

public class MonthlyVehicleSales {

	int salesMonth; // this could be an enum?
	int salesYear;
	int salesVolume;
	String carModel;

	public MonthlyVehicleSales(String model, int month, int year, int volume) {
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
	public int getYear() {
		return salesYear;
	}
	public void setYear(int year) {
		this.salesYear = year;
	}
	public int getSalesVolume() {
		return salesVolume;
	}
	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
}
