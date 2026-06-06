package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;

public class PopupPage extends BasePage {

	public PopupPage(WebDriver driver) {
		super(driver);
	}

	// =========================
	// Popup Window Locator
	// =========================

	private By popupWindowButton = By.id("PopUp");

	// ==========================================================
	// Handle Popup Window
	// ==========================================================

	public void handlePopupWindow() {

		String parentWindow = driver.getWindowHandle();

		WebElement popupButton = scrollToElement(popupWindowButton);

		popupButton.click();

		wait.until(driver -> driver.getWindowHandles().size() > 1);

		for (String windowHandle : driver.getWindowHandles()) {

			if (!windowHandle.equals(parentWindow)) {

				driver.switchTo().window(windowHandle);

				System.out.println("Popup Title: " + driver.getTitle());

				System.out.println("Popup URL: " + driver.getCurrentUrl());

				driver.close();

				break;
			}
		}

		driver.switchTo().window(parentWindow);

		System.out.println("Returned to Parent Window");
	}
}