package com.sevenrmartsupermarket.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.model.ScreenCapture;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubCategoryPage;
//import com.sevenrmartsupermarket.utilities.ScreenShotCapture;
import com.sevenrmartsupermarket.utilities.ScreenShotCapture;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class SubCategoryTest extends Base {

	LoginPage loginPage;
	HomePage homePage;
	SubCategoryPage subCategoryPage;
	SoftAssert softAssert = new SoftAssert();

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifySubCategoryHeader() {

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		subCategoryPage = new SubCategoryPage(driver);

		loginPage.login();
		homePage.clickOnSubcategory();
		String actualHeader = subCategoryPage.subCategoryPageHeader();
		String expectedHeader = "List Sub Categories";
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	@Test(groups = { "Smoke", "Regression" })
	public void verifyAllSubCategoryNames() {

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		subCategoryPage = new SubCategoryPage(driver);
		loginPage.login();
		homePage.clickOnSubcategory();
		subCategoryPage.getAllSubCategoryName();
	}
	/** SubCategory Data Validation **/
	@Test(groups = "Smoke")
	public void verifyNewSubCategory() {

		loginPage = new LoginPage(driver);
		homePage = loginPage.loginFunction();
		subCategoryPage = homePage.clickOnSubcategorywithReturn();
		subCategoryPage.createSubCategory("Appliances", "Fridge");
		subCategoryPage.clickOnHome();
		homePage.clickOnSubcategorywithReturn();
		String actualFirstValue = subCategoryPage.firstSubCategoryColValue();
		System.out.println(actualFirstValue);
		String expectedFirstValue = "Fridge";
		String actualSectValue = subCategoryPage.secondSubCategoryColValue();
		System.out.println(actualSectValue);
		String expectedSecValue = "Appliances";
		softAssert.assertEquals(actualFirstValue, expectedFirstValue);
		softAssert.assertEquals(actualSectValue, expectedSecValue);
	}
	@Test(groups = "Smoke")
	public void enterSubCategoryInfo() {// change name
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		subCategoryPage = new SubCategoryPage(driver);
		loginPage.login();
		homePage.clickOnSubcategory();
		subCategoryPage.clickOnNew().selectCategory().addSubCategory("iPad").clickOnSave();
	}
}
