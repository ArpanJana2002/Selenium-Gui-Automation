package com.automation.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;

public class BrokenLinkPage extends BasePage {

	public BrokenLinkPage(WebDriver driver) {
		super(driver);
	}

	// =========================
	// Broken Links Section
	// =========================

	private By brokenLinks = By.cssSelector("#broken-links a");

	// ==========================================================
	// Verify All Broken Links
	// ==========================================================

	public void verifyBrokenLinks() {

		List<WebElement> links = driver.findElements(brokenLinks);

		System.out.println("\n===== BROKEN LINK REPORT =====");

		System.out.println("Total Links Found: " + links.size());

		for (WebElement link : links) {

			String url = link.getAttribute("href");

			try {

				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

				connection.setRequestMethod("HEAD");

				connection.connect();

				int responseCode = connection.getResponseCode();

				if (responseCode >= 400) {

					System.out.println("[BROKEN] " + responseCode + " -> " + url);

				} else {

					System.out.println("[VALID ] " + responseCode + " -> " + url);
				}

				connection.disconnect();

			} catch (Exception e) {

				System.out.println("[ERROR ] " + url + " -> " + e.getMessage());
			}
		}

		System.out.println("===== END OF REPORT =====\n");
	}

	// ==========================================================
	// Count Broken Links
	// ==========================================================

	public int getBrokenLinkCount() {

		int brokenCount = 0;

		List<WebElement> links = driver.findElements(brokenLinks);

		for (WebElement link : links) {

			String url = link.getAttribute("href");

			try {

				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

				connection.setRequestMethod("HEAD");

				connection.connect();

				int responseCode = connection.getResponseCode();

				if (responseCode >= 400) {

					brokenCount++;
				}

				connection.disconnect();

			} catch (Exception e) {

				brokenCount++;
			}
		}

		return brokenCount;
	}
}