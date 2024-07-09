package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
	public List<MonthlyVehicleSales> generateListOfSuspects(String filename) throws IOException {
		List<SuspectLocation> mySuspects = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((header = reader.readLine()) != null) {
				while ((line = reader.readLine()) != null) {
					String[] lineData = line.split(",");
					SuspectLocation suspect = new SuspectLocation(lineData[0], lineData[1]);
					mySuspects.add(suspect);
				}
				reader.close();
				return mySuspects;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
