package com.sevenrmartsupermarket.constants;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class Dataproviders 
{
	ExcelReader excelReader= new ExcelReader();
	@DataProvider(name="loginDetails")
	public Object[][] login()
	{
		excelReader.setExcelFile("ExcelData", "Admin_users");
		return excelReader.getMultidimentionalData(4,2);
	}
	
	

}
