package com.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.base.BasePage;

public class AlertPage extends BasePage {

	public AlertPage(WebDriver driver) {
		super(driver);
	}

	// =========================
	// Alert Locators
	// =========================

	private By alertButton = By.id("alertBtn");

	private By promptButton = By.id("promptBtn");

	private By confirmButton = By.id("confirmBtn");

	// ==========================================================
	// Simple Alert
	// ==========================================================

	public void openAlert() {

		scrollToElement(alertButton);

		wait.until(ExpectedConditions.elementToBeClickable(alertButton)).click();

		Alert alert = driver.switchTo().alert();

		alert.accept();

		System.out.println("Simple Alert Accepted");
	}

	// ==========================================================
	// Prompt Alert
	// ==========================================================

	public void openPrompt() {

		scrollToElement(promptButton);

		wait.until(ExpectedConditions.elementToBeClickable(promptButton)).click();

		Alert prompt = driver.switchTo().alert();

		prompt.sendKeys("Automation");

		prompt.accept();

		System.out.println("Prompt Alert Accepted");
	}

	// ==========================================================
	// Confirm Alert
	// ==========================================================

	public void openConfirm() {

		scrollToElement(confirmButton);

		wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();

		Alert confirm = driver.switchTo().alert();

		confirm.accept();

		System.out.println("Confirm Alert Accepted");
	}
}