package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.BasePage;

public class FormPage extends BasePage {

	public FormPage(WebDriver driver) {
		super(driver);
	}

	// =========================
	// Text Fields
	// =========================

	private By nameField = By.id("name");
	private By emailField = By.id("email");
	private By phoneField = By.id("phone");
	private By addressField = By.id("textarea");

	// =========================
	// Radio Buttons
	// =========================

	private By maleRadio = By.id("male");
	private By femaleRadio = By.id("female");

	// =========================
	// Checkboxes
	// =========================

	private By sundayCheck = By.id("sunday");
	private By mondayCheck = By.id("monday");
	private By tuesdayCheck = By.id("tuesday");

	// =========================
	// Dropdowns
	// =========================

	private By countryDropDown = By.id("country");
	private By colorsDropDown = By.id("colors");
	private By animalsDropDown = By.id("animals");

	// =========================
	// Scrolling Dropdown
	// =========================

	private By scrollingDropdown = By.id("comboBox");

	// ==========================================================
	// Text Fields
	// ==========================================================

	public void fillTextFields() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys("Arpan Jana");

		driver.findElement(emailField).sendKeys("arpan@example.com");

		driver.findElement(phoneField).sendKeys("9876543210");

		driver.findElement(addressField).sendKeys("Kolkata, WB");
	}

	// ==========================================================
	// Radio Buttons
	// ==========================================================

	public void selectGender() {

		wait.until(ExpectedConditions.elementToBeClickable(maleRadio)).click();
	}

	// ==========================================================
	// Checkboxes
	// ==========================================================

	public void selectDays() {

		driver.findElement(sundayCheck).click();
		driver.findElement(mondayCheck).click();
		driver.findElement(tuesdayCheck).click();
	}

	// ==========================================================
	// Dropdowns
	// ==========================================================

	public void selectDropdowns() {

		new Select(driver.findElement(countryDropDown)).selectByVisibleText("India");

		new Select(driver.findElement(colorsDropDown)).selectByVisibleText("Red");

		new Select(driver.findElement(animalsDropDown)).selectByVisibleText("Cat");
	}

	// ==========================================================
	// Scrolling Dropdown
	// ==========================================================

	public void selectItemNumber(int itemNo) {

		WebElement dropdown = scrollToElement(scrollingDropdown);

		dropdown.clear();

		dropdown.sendKeys("Item " + itemNo);

		System.out.println("Selected Item " + itemNo);
	}

	// ==========================================================
	// Dynamic Sections
	// ==========================================================

	public void submitSection(int sectionNumber, String text) {

		By input = By.id("input" + sectionNumber);

		By button = By.id("btn" + sectionNumber);

		WebElement inputField = scrollToElement(input);

		inputField.clear();

		inputField.sendKeys(text);

		driver.findElement(button).click();

		System.out.println("Section " + sectionNumber + " Submitted");
	}

	// ==========================================================
	// Validation
	// ==========================================================

	public void verifyBasicElementsPresent() {

		isElementPresent(nameField);
		isElementPresent(emailField);
		isElementPresent(phoneField);
		isElementPresent(addressField);
		isElementPresent(maleRadio);
		isElementPresent(femaleRadio);
	}
}