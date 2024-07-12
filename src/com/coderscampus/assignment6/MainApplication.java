package com.coderscampus.assignment6;

import java.io.IOException;

public class MainApplication {

	public static void main(String[] args) throws IOException {
	ReportService salesReport = new ReportService();
	salesReport.generateSalesReport("model3.csv");
	salesReport.generateSalesReport("modelS.csv");
	salesReport.generateSalesReport("modelX.csv");
	}
}
