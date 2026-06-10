package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;

public class TablePage extends BasePage {

	public TablePage(WebDriver driver) {
		super(driver);
	}

	// ==========================================
	// Locators
	// ==========================================

	private By paginationLinks = By.cssSelector("#pagination li a");

	private By tableRows = By.xpath("//table[@id='productTable']/tbody/tr");

	// ==========================================
	// Traverse All Pages
	// ==========================================

	public void traverseAllPages() {

		List<WebElement> pages = driver.findElements(paginationLinks);

		int totalPages = pages.size();

		System.out.println("\n===== PAGINATION DEMO =====");

		for (int page = 1; page <= totalPages; page++) {

			driver.findElement(By.linkText(String.valueOf(page))).click();

			System.out.println("Clicked Page : " + page);

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		System.out.println("===== PAGINATION COMPLETED =====");
	}

	// ==========================================
	// Print Products From All Pages
	// ==========================================

	public void printAllProducts() {

		List<WebElement> pages = driver.findElements(paginationLinks);

		int totalPages = pages.size();

		System.out.println("\n===== PRODUCT LIST =====");

		for (int page = 1; page <= totalPages; page++) {

			driver.findElement(By.linkText(String.valueOf(page))).click();

			System.out.println("\nPAGE : " + page);

			List<WebElement> rows = driver.findElements(tableRows);

			for (WebElement row : rows) {

				String id = row.findElement(By.xpath("./td[1]")).getText();

				String name = row.findElement(By.xpath("./td[2]")).getText();

				String price = row.findElement(By.xpath("./td[3]")).getText();

				System.out.println(id + " | " + name + " | " + price);
			}
		}
	}

	// ==========================================
	// Select Product By Name
	// ==========================================

	public void selectProduct(String productName) {

		List<WebElement> pages = driver.findElements(paginationLinks);

		int totalPages = pages.size();

		for (int page = 1; page <= totalPages; page++) {

			driver.findElement(By.linkText(String.valueOf(page))).click();

			List<WebElement> rows = driver.findElements(tableRows);

			for (WebElement row : rows) {

				String name = row.findElement(By.xpath("./td[2]")).getText();

				if (name.equalsIgnoreCase(productName)) {

					WebElement checkbox = row.findElement(By.xpath("./td[4]/input"));

					if (!checkbox.isSelected()) {

						checkbox.click();
					}

					System.out.println("Selected Product : " + productName);

					return;
				}
			}
		}

		throw new RuntimeException("Product Not Found : " + productName);
	}

	// ==========================================
	// Verify Product Exists
	// ==========================================

	public boolean isProductPresent(String productName) {

		List<WebElement> pages = driver.findElements(paginationLinks);

		int totalPages = pages.size();

		for (int page = 1; page <= totalPages; page++) {

			driver.findElement(By.linkText(String.valueOf(page))).click();

			List<WebElement> rows = driver.findElements(tableRows);

			for (WebElement row : rows) {

				String name = row.findElement(By.xpath("./td[2]")).getText();

				if (name.equalsIgnoreCase(productName)) {

					return true;
				}
			}
		}

		return false;
	}
}