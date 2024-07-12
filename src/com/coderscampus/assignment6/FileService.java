package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

	String filename;
	String header;

	public List<MonthlyVehicleSales> generateListOfMonthlyVehicleSales(String filename) throws IOException {
		List<MonthlyVehicleSales> myMonthlySalesList = new ArrayList<>();
		ExtractModelService modelName = new ExtractModelService();
		String model = modelName.extractModel(filename);
		ExtractDateService date = new ExtractDateService();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((header = reader.readLine()) != null) {
				while ((line = reader.readLine()) != null) {
					String[] lineData = line.split(",");
					String[] lineDataSplit = lineData[0].split("-");
					Integer extractedMonth = date.extractMonth(lineDataSplit[0]);
					Integer extractedYear = date.extractYear(lineDataSplit[1]);
					MonthlyVehicleSales mySales = new MonthlyVehicleSales(model,
							date.salesMonth(extractedYear, extractedMonth), 
							date.salesYear(extractedYear, extractedMonth),
							Integer.parseInt(lineData[1]), 
							date.salesYearMonth((date.salesYear(extractedYear, extractedMonth)), 
									(date.salesMonth(extractedYear, extractedMonth))));
					myMonthlySalesList.add(mySales);
				}
				reader.close();
				return myMonthlySalesList;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}