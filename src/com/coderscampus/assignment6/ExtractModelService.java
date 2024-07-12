package com.coderscampus.assignment6;

public class ExtractModelService {
	String model;
	public String extractModel(String fileName) {
		if (fileName.contains("3.")) {
			model = "Model 3";
		} else if (fileName.contains("S.")) {
			model = "Model S";
		} else if (fileName.contains("X.")) {
			model = "Model X";
		} else {
			System.out.println("Invalid file name\n");
			return null;
		}
		return model;
	}
	
}
