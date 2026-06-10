package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;

	public BasePage(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		this.js = (JavascriptExecutor) driver;
	}

	public boolean isElementPresent(By locator) {

		return !driver.findElements(locator).isEmpty();
	}

	public int countVisibleButtons() {

		return driver.findElements(By.tagName("button")).size();
	}

	public WebElement scrollToElement(By locator) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", element);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		return element;
	}
}