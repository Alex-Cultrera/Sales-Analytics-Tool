package com.coderscampus.assignment6;

import java.io.IOException;
import java.util.List;

public class ReportService {

	Integer minSalesYear;
	Integer maxSalesYear;
	
	public void generateSalesReport(String fileName) throws IOException {
		ExtractModelService modelName = new ExtractModelService();
		String model = modelName.extractModel(fileName);
		if (model == null) {
			System.out.println("Unable to generate report. "
					+ "Please make sure CSV file name is in the following format:\n");
			System.out.println("[vehicle model name].csv\n");
		} else {
			FileService fileService = new FileService();
			List<MonthlyVehicleSales> monthlySalesList = fileService.generateListOfMonthlyVehicleSales(fileName);
			System.out.println(model + " Yearly Sales Report\n---------------------------");
			printYearlySalesVolume(monthlySalesList);
			System.out.println("The best month for " + model + " was: ");
			System.out.println("The worst month for " + model + " was: \n\n");
		}
	}

	public void printYearlySalesVolume (List<MonthlyVehicleSales> monthlySalesList) {
		minSalesYear = monthlySalesList.stream()
									   .mapToInt(sales -> sales.getYear())
									   .summaryStatistics()
									   .getMin();
		maxSalesYear = monthlySalesList.stream()
									   .mapToInt(sales -> sales.getYear())
									   .summaryStatistics()
									   .getMax();
		Integer elementToFilter = minSalesYear;
		while (elementToFilter <= maxSalesYear) {
			System.out.println(elementToFilter + " -> " 
					+ sumAnnualVolume(monthlySalesList, elementToFilter)); 
			elementToFilter++;
		}
	}

	public int sumAnnualVolume(List<MonthlyVehicleSales> monthlySalesList, Integer elementToFilter) {
		int annualVolume = monthlySalesList.stream()
				.filter(sales -> sales.getYear().equals(elementToFilter))
				.mapToInt(sales -> sales.getSalesVolume())
				.sum();
		return annualVolume;
	}
	
}
