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
		List<MonthlyVehicleSales> myMonthlySales = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((header = reader.readLine()) != null) {
				while ((line = reader.readLine()) != null) {
					String[] lineData = line.split(",");
					MonthlyVehicleSales mySales = new MonthlyVehicleSales(lineData[0], lineData[0], lineData[1]); // (Mon-YR, salesVolume)
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