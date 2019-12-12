package com.duy.demo.excel.model;

import java.util.List;

public class ExcelSheetDataBO {
	
	private String sheetName;
	
	private List<List<String>> sheetData;

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public List<List<String>> getSheetData() {
		return sheetData;
	}

	public void setSheetData(List<List<String>> sheetData) {
		this.sheetData = sheetData;
	}
}
