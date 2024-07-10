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
		ExtractModelService modelName = new ExtractModelService();
		ExtractDateService salesDate = new ExtractDateService();
		String model = modelName.extractModel(filename);
		List<MonthlyVehicleSales> myMonthlySales = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((header = reader.readLine()) != null) {
				while ((line = reader.readLine()) != null) {
					String[] lineData = line.split(",");
					String[] lineDataSplit = lineData[0].split("-");
					MonthlyVehicleSales mySales = new MonthlyVehicleSales(model, salesDate.extractMonth(lineData[0]), Integer.parseInt(lineDataSplit[1]), Integer.parseInt(lineData[1])); // (Mon-YR, salesVolume)
					myMonthlySales.add(mySales);
				}
				reader.close();
				return myMonthlySales;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}