package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//a[@class='d-block']")
	WebElement profileName;

	@FindBy(xpath = "//div[@class='inner']//p[(text()='Sub Category')]//following::a[1]")
	WebElement category;
	@FindBy(xpath="//span[text()='7rmart supermarket']")
	WebElement title;
	
	@FindBy(xpath="//p[text()='Admin Users']")
	WebElement dashColName;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return profileName.getText();
	}
	public String getDashboardCol() {
		return dashColName.getText();
	}
	
	public String getTitle() {
		return title.getText();
	}

	public void clickOnSubcategory() {
		category.click();
	}

	public SubCategoryPage clickOnSubcategorywithReturn() {
		category.click();
		return new SubCategoryPage(driver);
	}
}
