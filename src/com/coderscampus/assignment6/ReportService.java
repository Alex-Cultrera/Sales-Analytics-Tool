package com.coderscampus.assignment6;

import java.io.IOException;

public class ReportService {

	public void generateSalesReport(String fileName) throws IOException {
		ExtractModelService modelName = new ExtractModelService();
		String model = modelName.extractModel(fileName);
		if (model == null) {
			System.out.println("Unable to generate report. "
					+ "Please make sure CSV file name is in the following format:\n");
			System.out.println("[vehicle model name].csv\n");
		} else {
			FileService fileService = new FileService();
			fileService.generateListOfMonthlyVehicleSales(fileName);
			System.out.println(model + " Yearly Sales Report\n---------------------------");
			System.out.println("2016 -> "); // use optional ???
			System.out.println("2017 -> ");
			System.out.println("2018 -> ");
			System.out.println("2019 -> ");
			System.out.println("The best month for " + model + " was: ");
			System.out.println("The worst month for " + model + " was: \n\n");
		}
	}
}
