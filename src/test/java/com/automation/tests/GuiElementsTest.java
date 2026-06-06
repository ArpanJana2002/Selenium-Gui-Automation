package com.automation.tests;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.GuiElementsPage;

@Listeners(com.automation.listeners.TestListener.class)
public class GuiElementsTest extends BaseTest {

	@Test
	public void verifyGuiElementsPage() {

		GuiElementsPage page = new GuiElementsPage(driver);

		// ==========================
		// Text Fields
		// ==========================
		page.fillTextFields();
		demoPause();

		Assert.assertTrue(page.isElementPresent(By.id("name")));
		Assert.assertTrue(page.isElementPresent(By.id("email")));
		Assert.assertTrue(page.isElementPresent(By.id("phone")));
		Assert.assertTrue(page.isElementPresent(By.id("textarea")));

		// ==========================
		// Radio Button
		// ==========================
		page.selectGender();
		demoPause();

		// ==========================
		// Checkboxes
		// ==========================
		page.selectDays();
		demoPause();

		// ==========================
		// Dropdowns
		// ==========================
		page.selectDropdowns();
		demoPause();

		// ==========================
		// Date Pickers
		// ==========================
		page.enterDatePickers();
		demoPause();

		page.selectDateRange("2026-06-10", "2026-06-20");
		demoPause();

		// ==========================
		// Single File Upload
		// ==========================
		File singleFile = new File("F:\\mySampleGUI.txt");

		page.uploadSingleFile(singleFile.getAbsolutePath());

		demoPause();

		// ==========================
		// Multiple File Upload
		// ==========================
		File file1 = new File("F:\\mySampleGUI.txt");

		File file2 = new File("F:\\mySampleGUI2.txt");

		page.uploadMultipleFiles(file1.getAbsolutePath(), file2.getAbsolutePath());

		demoPause();

		// ==========================
		// Alert
		// ==========================
		page.openAlert();
		demoPause();

		// ==========================
		// Prompt
		// ==========================
		page.openPrompt();
		demoPause();

		// ==========================
		// Confirm
		// ==========================
		page.openConfirm();
		demoPause();

		// ==========================
		// Popup Window
		// ==========================
		page.handlePopupWindow();
		demoPause();

		// ==========================
		// Mouse Hover
		// ==========================
		page.mouseHoverAction();
		demoPause();

		// ==========================
		// Double Click
		// ==========================
		page.doubleClickAction();
		demoPause();

		// ==========================
		// Drag And Drop
		// ==========================
		page.dragAndDropAction();
		demoPause();

		// ==========================
		// Slider
		// ==========================
		page.moveSlider();
		demoPause();

		// =========================
		// scrolling Dropdown
		// =========================
		page.selectItemNumber(20);
		demoPause();

		// ==========================
		// Broken Links
		// ==========================

		page.verifyBrokenLinks();
		demoPause();
		//

		page.submitSection(1, "Automation Testing");
		demoPause();

		page.submitSection(2, "Selenium WebDriver");
		demoPause();

		page.submitSection(3, "TestNG Framework");
		demoPause();

		page.selectProduct("Laptop");
		demoPause();

		Assert.assertTrue(page.isProductPresent("Laptop"));

		// ==========================
		// Final Validation
		// ==========================
		Assert.assertTrue(true, "GUI Elements Test Completed Successfully");
	}
}