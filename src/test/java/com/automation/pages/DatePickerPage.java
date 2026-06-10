package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;

public class DatePickerPage extends BasePage {

	public DatePickerPage(WebDriver driver) {
		super(driver);
	}

	// =========================
	// Date Pickers
	// =========================

	private By datePicker1 = By.id("datepicker");

	private By datePicker2 = By.id("txtDate");

	// Date Range Picker

	private By startDate = By.id("start-date");

	private By endDate = By.id("end-date");

	private By dateRangeSubmit = By.className("submit-btn");

	// ==========================================================
	// Date Picker 1 & 2
	// ==========================================================

	public void enterDatePickers() {

		WebElement date1 = scrollToElement(datePicker1);

		js.executeScript("arguments[0].value='06/06/2026';", date1);

		WebElement date2 = scrollToElement(datePicker2);

		js.executeScript("arguments[0].value='10/06/2026';", date2);

		System.out.println("Date Pickers filled");
	}

	// ==========================================================
	// Date Range Picker
	// ==========================================================

	public void selectDateRange(String start, String end) {

		WebElement startField = scrollToElement(startDate);

		js.executeScript("arguments[0].value=arguments[1]", startField, start);

		WebElement endField = scrollToElement(endDate);

		js.executeScript("arguments[0].value=arguments[1]", endField, end);

		driver.findElement(dateRangeSubmit).click();

		System.out.println("Date Range Selected Successfully");
	}
}