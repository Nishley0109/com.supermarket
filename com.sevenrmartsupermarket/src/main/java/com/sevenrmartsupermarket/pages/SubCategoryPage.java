package com.sevenrmartsupermarket.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class SubCategoryPage {

	WebDriver driver;
	GeneralUtility utility = new GeneralUtility();
	PageUtility pageUtility;
	WaitUtility waitutility;

	@FindBy(xpath = "//h1[text()='List Sub Categories']")
	private WebElement subcategoryheader;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> subCategoryNames;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newSubCategory;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement selectCategoryElement;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement enterSubCategoryElement;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement uploadImage;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;

	@FindBy(xpath = "//table//tbody//td[text()='Fridge']")
	WebElement tableText;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;
	
	@FindBy(xpath = "//table//tr[1]//td[1]")
	WebElement firstColValue;
	
	@FindBy(xpath = "//table//tr[1]//td[2]")
	WebElement secColValue;
	
	@FindBy(xpath = "//a[text()='Home']")
	WebElement home;

	public SubCategoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageUtility = new PageUtility(driver);

	}

	public String subCategoryPageHeader() {
		return subcategoryheader.getText();

	}

	public void getAllSubCategoryName() {

		List<String> names = new ArrayList<String>();
		names = utility.get_textofelements(subCategoryNames);
		System.out.println(names);

	}

	public String firstSubCategoryColValue() {
		return firstColValue.getText();

	}
	public String secondSubCategoryColValue() {
		return secColValue.getText();

	}
	public SubCategoryPage clickOnNew() {

		newSubCategory.click();
		return this;

	}
	public SubCategoryPage clickOnHome() {

		home.click();
		return this;

	}
	public SubCategoryPage selectCategory() {

		pageUtility.selectByIndex(selectCategoryElement, 7);
		return this;
	}

	public SubCategoryPage addCategory() {
		pageUtility.selectByVisibleText(enterSubCategoryElement, "Apple");
		return this;
	}
	
	
	public SubCategoryPage addSubCategory(String subcategory) {

		enterSubCategoryElement.sendKeys(subcategory);

		return this;

	}

	public SubCategoryPage enterSubcategory(String subcategory) {
		enterSubCategoryElement.sendKeys(subcategory);
		return this;
	}

	public void imageUpload() {
		pageUtility.imageUpload(uploadImage);

	}

	public SubCategoryPage clickOnSave() {

		waitutility = new WaitUtility(driver);
		waitutility.waitforElementtobeClickable(saveButton);
		saveButton.click();
		return this;
	}

	public void createSubCategory(String category, String subCategory) {
		clickOnNew();
		pageUtility.selectByVisibleText(selectCategoryElement, category);
		enterSubcategory(subCategory);
		imageUpload();
		clickOnSave();

	}

	public String tableCheck() {
		return tableText.getText();
	}

	public void getAlertMessage() {
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
	}

}
