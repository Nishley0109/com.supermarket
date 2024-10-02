package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class HomeTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	
	@Test(groups = "Smoke") 
	public void verifyDashBoardColumn() 
	{
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");

		homepage = new HomePage(driver);
		
		String actualDashboard = homepage.getDashboardCol();
		System.out.println(actualDashboard);
		String expectedDashboard = "Admin Users";
		Assert.assertEquals(actualDashboard, expectedDashboard);
	}
	@Test(groups = { "Smoke", "Regression" })
	public void verifyDashBoardTitle() 
	{
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");

		homepage = new HomePage(driver);
		
		String actualTitle = homepage.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "7rmart supermarket";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test(groups = "Smoke") 
	public void dashBoardProfileName() 
	{
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");

		homepage = new HomePage(driver);
		
		String actualProfile = homepage.getProfileName();
		System.out.println(actualProfile);
		String expectedProfile = "Admin";
		Assert.assertEquals(actualProfile, expectedProfile);
	}

}
