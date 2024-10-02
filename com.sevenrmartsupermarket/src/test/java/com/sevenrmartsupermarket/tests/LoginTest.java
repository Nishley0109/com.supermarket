package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.Dataproviders;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginTest extends Base {

	LoginPage loginpage;
	HomePage homepage;

	ExcelReader excelReader = new ExcelReader();

	@Test(groups = "Smoke")
	public void verifyLogin() {
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");

		homepage = new HomePage(driver);

		excelReader.setExcelFile("ExcelData", "Login_Credentials");
		String value = excelReader.getCellData(3, 0);
		System.out.println(value);

		String password = excelReader.getCellData(3, 1);
		System.out.println(password);

		String actualProfileName = homepage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
		String name1 = GeneralUtility.getRandomUserName();
		System.out.println(name1);
	}
	@Test(dataProvider = "loginDetails", dataProviderClass = Dataproviders.class)
	public void verifyLoginData(String userName, String password) {
		loginpage = new LoginPage(driver);
		loginpage.login(userName, password);
	}
	@Test(groups = "Smoke")
	public void rememberMeCheckBox() {
		loginpage = new LoginPage(driver);
		boolean actualValue = loginpage.rememberMeFun();
		boolean expectedValue= false;
		Assert.assertEquals(actualValue, expectedValue);
	}
}
