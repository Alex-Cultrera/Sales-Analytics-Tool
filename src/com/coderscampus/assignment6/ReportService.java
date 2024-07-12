package com.coderscampus.assignment6;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
			System.out.println("The best month for " + model + " was: " + getBestSalesYearMonth(monthlySalesList));
			System.out.println("The worst month for " + model + " was: " + getWorstSalesYearMonth(monthlySalesList) + "\n\n");
		}
	}

	public void printYearlySalesVolume (List<MonthlyVehicleSales> monthlySalesList) {
		minSalesYear = monthlySalesList.stream()
									   .mapToInt(sales -> sales.getSalesYear())
									   .summaryStatistics()
									   .getMin();
		maxSalesYear = monthlySalesList.stream()
									   .mapToInt(sales -> sales.getSalesYear())
									   .summaryStatistics()
									   .getMax();
		Integer elementToFilter = minSalesYear;
		while (elementToFilter <= maxSalesYear) {
			System.out.println(elementToFilter + " -> " 
					+ withLargeIntegers(sumAnnualVolume(monthlySalesList, elementToFilter))); 
			elementToFilter++;
		}
	}

	public int sumAnnualVolume(List<MonthlyVehicleSales> monthlySalesList, Integer elementToFilter) {
		int annualVolume = monthlySalesList.stream()
				.filter(sales -> sales.getSalesYear().equals(elementToFilter))
				.mapToInt(sales -> sales.getSalesVolume())
				.sum();
		return annualVolume;
	}
	
	public String getBestSalesYearMonth(List<MonthlyVehicleSales> monthlySalesList) {
		List<String> bestSalesYearMonthList = monthlySalesList.stream()
				.sorted(Comparator.comparingInt(sales -> sales.getSalesVolume()))
				.map(sales -> sales.getSalesYearMonth())
				.collect(Collectors.toList());
		int lastIndex = bestSalesYearMonthList.size()-1;
		String bestSalesYearMonth = bestSalesYearMonthList.get(lastIndex);
		return bestSalesYearMonth;
	}
	
	public String getWorstSalesYearMonth(List<MonthlyVehicleSales> monthlySalesList) {
		List<String> worstSalesYearMonthList = monthlySalesList.stream()
				.sorted(Comparator.comparingInt(sales -> sales.getSalesVolume()))
				.map(sales -> sales.getSalesYearMonth())
				.collect(Collectors.toList());
		String worstSalesYearMonth = worstSalesYearMonthList.get(0);
		return worstSalesYearMonth;
	}
	
	public static String withLargeIntegers(Integer value) {
	    DecimalFormat df = new DecimalFormat("###,###,###");
	    return df.format(value);
	}
	
}
