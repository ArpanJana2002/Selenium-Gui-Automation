package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;

public class FileUploadPage extends BasePage {

	public FileUploadPage(WebDriver driver) {
		super(driver);
	}

	// =========================
	// File Upload Locators
	// =========================

	private By fileUpload = By.id("singleFileInput");

	private By multiFileUpload = By.id("multipleFilesInput");

	// ==========================================================
	// Single File Upload
	// ==========================================================

	public void uploadSingleFile(String filePath) {

		WebElement uploadElement = scrollToElement(fileUpload);

		uploadElement.sendKeys(filePath);

		System.out.println("Single file uploaded successfully");
	}

	// ==========================================================
	// Multiple File Upload
	// ==========================================================

	public void uploadMultipleFiles(String file1, String file2) {

		WebElement uploadElement = scrollToElement(multiFileUpload);

		uploadElement.sendKeys(file1 + "\n" + file2);

		System.out.println("Multiple files uploaded successfully");
	}
}