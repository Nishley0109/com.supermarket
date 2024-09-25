package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;

public class LoginPage {

	WebDriver driver;
	Properties properties = new Properties();

	@FindBy(xpath = "//input[@name=\"username\"]")
	WebElement userNameField;

	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		try {
			FileInputStream inputstream = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(inputstream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void signin() {
		signInButton.click();
	}

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		signin();

	}

	public void login() {
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");

		enterUserName(userName);
		enterPassword(password);
		signin();
	}

	public HomePage loginFunction() {
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");

		enterUserName(userName);
		enterPassword(password);
		signin();
		return new HomePage(driver);
	}
}
