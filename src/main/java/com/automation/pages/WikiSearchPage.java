package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;

public class WikiSearchPage extends BasePage {

	public WikiSearchPage(WebDriver driver) {
		super(driver);
	}

	// ==========================================
	// Locators
	// ==========================================

	private By searchBox = By.id("Wikipedia1_wikipedia-search-input");

	private By searchButton = By.xpath("//input[@type='submit']");

	private By searchResults = By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//a");

	// ==========================================
	// Search Keyword
	// ==========================================

	public void search(String keyword) {

		WebElement box = scrollToElement(searchBox);

		box.clear();

		box.sendKeys(keyword);

		driver.findElement(searchButton).click();

		System.out.println("Searched for : " + keyword);
	}

	// ==========================================
	// Print Search Results
	// ==========================================

	public void printSearchResults() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		List<WebElement> results = driver.findElements(searchResults);

		System.out.println("\n===== SEARCH RESULTS =====");

		for (WebElement result : results) {

			System.out.println(result.getText());
		}
	}

	// ==========================================
	// Open First Result
	// ==========================================

	public void openFirstResult() {

		List<WebElement> results = driver.findElements(searchResults);

		if (!results.isEmpty()) {

			results.get(0).click();

			System.out.println("First Result Opened");
		}
	}

	// ==========================================
	// Clear Search
	// ==========================================

	public void clearSearch() {

		WebElement box = driver.findElement(searchBox);

		box.sendKeys(Keys.CONTROL + "a");

		box.sendKeys(Keys.DELETE);

		System.out.println("Search Box Cleared");
	}

	// ==========================================
	// Complete Flow
	// ==========================================

	public void searchAndClear(String keyword) {

		search(keyword);

		printSearchResults();

		clearSearch();
	}
}