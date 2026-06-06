package com.automation.tests;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.AlertPage;
import com.automation.pages.BrokenLinkPage;
import com.automation.pages.DatePickerPage;
import com.automation.pages.FileUploadPage;
import com.automation.pages.FormPage;
import com.automation.pages.MouseActionPage;
import com.automation.pages.PopupPage;
import com.automation.pages.TablePage;
import com.automation.pages.WikiSearchPage;

@Listeners(com.automation.listeners.TestListener.class)
public class GuiElementsTest extends BaseTest {

	@Test
	public void verifyGuiElementsPage() {

		// ==========================================
		// Page Objects
		// ==========================================

		FormPage formPage = new FormPage(driver);

		DatePickerPage datePickerPage = new DatePickerPage(driver);

		FileUploadPage fileUploadPage = new FileUploadPage(driver);

		WikiSearchPage wiki = new WikiSearchPage(driver);

		AlertPage alertPage = new AlertPage(driver);

		PopupPage popupPage = new PopupPage(driver);

		MouseActionPage mouseActionPage = new MouseActionPage(driver);

		TablePage tablePage = new TablePage(driver);

		BrokenLinkPage brokenLinkPage = new BrokenLinkPage(driver);

		// ==========================================
		// Text Fields
		// ==========================================

		formPage.fillTextFields();
		demoPause();

		Assert.assertTrue(formPage.isElementPresent(By.id("name")));

		Assert.assertTrue(formPage.isElementPresent(By.id("email")));

		Assert.assertTrue(formPage.isElementPresent(By.id("phone")));

		Assert.assertTrue(formPage.isElementPresent(By.id("textarea")));

		// ==========================================
		// Radio Button
		// ==========================================

		formPage.selectGender();
		demoPause();

		// ==========================================
		// Checkboxes
		// ==========================================

		formPage.selectDays();
		demoPause();

		// ==========================================
		// Dropdowns
		// ==========================================

		formPage.selectDropdowns();
		demoPause();

		// ==========================================
		// Date Pickers
		// ==========================================

		datePickerPage.enterDatePickers();
		demoPause();

		datePickerPage.selectDateRange("2026-06-10", "2026-06-20");

		demoPause();

		// ==========================================
		// Single File Upload
		// ==========================================

		File singleFile = new File("F:\\mySampleGUI.txt");

		fileUploadPage.uploadSingleFile(singleFile.getAbsolutePath());

		demoPause();

		// ==========================================
		// Multiple File Upload
		// ==========================================

		File file1 = new File("F:\\mySampleGUI.txt");

		File file2 = new File("F:\\mySampleGUI2.txt");

		fileUploadPage.uploadMultipleFiles(file1.getAbsolutePath(), file2.getAbsolutePath());

		demoPause();

		// ==========================================
		// Wiki search
		// ==========================================

		wiki.searchAndClear("selenium");
		demoPause();

		// ==========================================
		// Alert
		// ==========================================

		alertPage.openAlert();
		demoPause();

		// ==========================================
		// Prompt
		// ==========================================

		alertPage.openPrompt();
		demoPause();

		// ==========================================
		// Confirm
		// ==========================================

		alertPage.openConfirm();
		demoPause();

		// ==========================================
		// Popup Window
		// ==========================================

		popupPage.handlePopupWindow();
		demoPause();

		// ==========================================
		// Mouse Hover
		// ==========================================

		mouseActionPage.mouseHoverAction();
		demoPause();

		// ==========================================
		// Double Click
		// ==========================================

		mouseActionPage.doubleClickAction();
		demoPause();

		// ==========================================
		// Drag And Drop
		// ==========================================

		mouseActionPage.dragAndDropAction();
		demoPause();

		// ==========================================
		// Slider
		// ==========================================

		mouseActionPage.moveSlider();
		demoPause();

		// ==========================================
		// Scrolling Dropdown
		// ==========================================

		formPage.selectItemNumber(20);
		demoPause();

		// ==========================================
		// Broken Links
		// ==========================================

		brokenLinkPage.verifyBrokenLinks();
		demoPause();

		// ==========================================
		// Dynamic Sections
		// ==========================================

		formPage.submitSection(1, "Automation Testing");

		demoPause();

		formPage.submitSection(2, "Selenium WebDriver");

		demoPause();

		formPage.submitSection(3, "TestNG Framework");

		demoPause();

		// ==========================================
		// Pagination Table
		// ==========================================

		// Pagination Demo
		tablePage.traverseAllPages();
		demoPause();

		// Print Products
		tablePage.printAllProducts();
		demoPause();

		// Select Product
		tablePage.selectProduct("Laptop");
		demoPause();

		// Verify Product
		Assert.assertTrue(tablePage.isProductPresent("Laptop"));

		// ==========================================
		// Final Validation
		// ==========================================

		Assert.assertTrue(true, "GUI Elements Test Completed Successfully");
	}
}