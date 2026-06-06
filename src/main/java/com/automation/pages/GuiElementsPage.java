package com.automation.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuiElementsPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	private JavascriptExecutor js;

	public GuiElementsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.actions = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
	}

	// =========================
	// Text Fields
	// =========================
	private By nameField = By.id("name");
	private By emailField = By.id("email");
	private By phoneField = By.id("phone");
	private By addressField = By.id("textarea");

	// =========================
	// Radio Buttons
	// =========================
	private By maleRadio = By.id("male");
	private By femaleRadio = By.id("female");

	// =========================
	// Checkboxes
	// =========================
	private By sundayCheck = By.id("sunday");
	private By mondayCheck = By.id("monday");
	private By tuesdayCheck = By.id("tuesday");

	// =========================
	// Dropdowns
	// =========================
	private By countryDropDown = By.id("country");
	private By colorsDropDown = By.id("colors");
	private By animalsDropDown = By.id("animals");

	// =========================
	// Date Pickers
	// =========================
	private By datePicker1 = By.id("datepicker");
	private By datePicker2 = By.id("txtDate");

	private By startDate = By.id("start-date");
	private By endDate = By.id("end-date");
	private By dateRangeSubmit = By.className("submit-btn");

	// =========================
	// File Upload
	// =========================
	private By fileUpload = By.id("singleFileInput");
	private By multiFileUpload = By.id("multipleFilesInput");

	// =========================
	// Alerts
	// =========================
	private By alertButton = By.id("alertBtn");
	private By promptButton = By.id("promptBtn");
	private By confirmButton = By.id("confirmBtn");
	private By popupWindowButton = By.id("PopUp");

	// =========================
	// Mouse Hover
	// =========================
	private By hoverButton = By.xpath("//button[text()='Point Me']");
	private By mobilesOption = By.xpath("//a[text()='Mobiles']");

	// =========================
	// Drag and Drop
	// =========================
	private By dragBox = By.id("draggable");
	private By dropBox = By.id("droppable");

	// =========================
	// Double Click
	// =========================
	private By doubleClickBtn = By.xpath("//button[contains(text(),'Copy Text')]");

	// =========================
	// Slider
	// =========================
	private By slider = By.id("slider-range");

	// =========================
	// scrolling Dropdown
	// =========================

	private By scrollingDropdown = By.id("comboBox");

	// Section 1
	private By section1Input = By.id("input1");
	private By section1Submit = By.id("btn1");

	// Section 2
	private By section2Input = By.id("input2");
	private By section2Submit = By.id("btn2");

	// Section 3
	private By section3Input = By.id("input3");
	private By section3Submit = By.id("btn3");

	// ==========================================================
	// Text Fields
	// ==========================================================

	public void fillTextFields() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys("Arpan Jana");

		driver.findElement(emailField).sendKeys("arpan@example.com");

		driver.findElement(phoneField).sendKeys("9876543210");

		driver.findElement(addressField).sendKeys("Kolkata, WB");
	}

	// ==========================================================
	// Radio Buttons
	// ==========================================================

	public void selectGender() {
		wait.until(ExpectedConditions.elementToBeClickable(maleRadio)).click();
	}

	// ==========================================================
	// Checkboxes
	// ==========================================================

	public void selectDays() {

		driver.findElement(sundayCheck).click();
		driver.findElement(mondayCheck).click();
		driver.findElement(tuesdayCheck).click();
	}

	// ==========================================================
	// Dropdowns
	// ==========================================================

	public void selectDropdowns() {

		new Select(driver.findElement(countryDropDown)).selectByVisibleText("India");

		new Select(driver.findElement(colorsDropDown)).selectByVisibleText("Red");

		new Select(driver.findElement(animalsDropDown)).selectByVisibleText("Cat");
	}

	// ==========================================================
	// Date Pickers
	// ==========================================================

	public void enterDatePickers() {

		WebElement date1 = scrollToElement(datePicker1);

		js.executeScript("arguments[0].value='06/06/2026';", date1);

		WebElement date2 = scrollToElement(datePicker2);

		js.executeScript("arguments[0].value='10/06/2026';", date2);

		System.out.println("Date Pickers filled");
	}

	public void selectDateRange(String start, String end) {

		WebElement startField = scrollToElement(startDate);

		js.executeScript("arguments[0].value=arguments[1]", startField, start);

		WebElement endField = scrollToElement(endDate);

		js.executeScript("arguments[0].value=arguments[1]", endField, end);

		driver.findElement(dateRangeSubmit).click();

		System.out.println("Date Range Selected Successfully");
	}

	// ==========================================================
	// File Upload
	// ==========================================================

	public void uploadSingleFile(String filePath) {

		WebElement uploadElement = scrollToElement(fileUpload);

		uploadElement.sendKeys(filePath);

		System.out.println("Single file uploaded");
	}

	public void uploadMultipleFiles(String file1, String file2) {

		WebElement uploadElement = scrollToElement(multiFileUpload);

		uploadElement.sendKeys(file1 + "\n" + file2);

		System.out.println("Multiple files uploaded");
	}

	// ==========================================================
	// Alerts
	// ==========================================================

	public void openAlert() {

		scrollToElement(alertButton);

		wait.until(ExpectedConditions.elementToBeClickable(alertButton)).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void openPrompt() {

		scrollToElement(promptButton);

		wait.until(ExpectedConditions.elementToBeClickable(promptButton)).click();

		Alert prompt = driver.switchTo().alert();

		prompt.sendKeys("Automation");

		prompt.accept();
	}

	public void openConfirm() {

		scrollToElement(confirmButton);

		wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();

		Alert confirm = driver.switchTo().alert();

		confirm.accept();
	}

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

		System.out.println("Switched back to Parent Window");
	}

	// ==========================================================
	// Mouse Hover
	// ==========================================================

	public void mouseHoverAction() {

		WebElement hoverElement = scrollToElement(hoverButton);

		actions.moveToElement(hoverElement).perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(mobilesOption));

		System.out.println("Mouse Hover Successful");
	}

	// ==========================================================
	// Double Click
	// ==========================================================

	public void doubleClickAction() {

		WebElement button = scrollToElement(doubleClickBtn);

		actions.doubleClick(button).perform();

		System.out.println("Double Click Successful");
	}

	// ==========================================================
	// Drag and Drop
	// ==========================================================

	public void dragAndDropAction() {

		WebElement drag = scrollToElement(dragBox);

		WebElement drop = driver.findElement(dropBox);

		actions.dragAndDrop(drag, drop).perform();

		System.out.println("Drag And Drop Successful");
	}

	// ==========================================================
	// Slider
	// ==========================================================

	public void moveSlider() {

		WebElement sliderElement = scrollToElement(slider);

		actions.dragAndDropBy(sliderElement, 100, 0).perform();

		System.out.println("Slider moved successfully");
	}

	// =========================
	// scrolling Dropdown
	// =========================

	public void selectItemNumber(int itemNo) {

		WebElement dropdown = scrollToElement(scrollingDropdown);

		dropdown.clear();

		dropdown.sendKeys("Item " + itemNo);

		System.out.println("Selected Item " + itemNo);
	}

	public void verifyBrokenLinks() {

		List<WebElement> links = driver.findElements(By.cssSelector("#broken-links a"));

		for (WebElement link : links) {

			String url = link.getAttribute("href");

			try {

				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

				connection.connect();

				int responseCode = connection.getResponseCode();

				System.out.println("URL : " + url + " | Response : " + responseCode);

			} catch (Exception e) {

				System.out.println("Unable to validate : " + url);
			}
		}
	}

	public void submitSection(int sectionNumber, String text) {

		By input = By.id("input" + sectionNumber);

		By button = By.id("btn" + sectionNumber);

		WebElement inputField = scrollToElement(input);

		inputField.clear();
		inputField.sendKeys(text);

		driver.findElement(button).click();

		System.out.println("Section " + sectionNumber + " Submitted");
	}

	public void selectProduct(String productName) {

		List<WebElement> pages = driver.findElements(By.cssSelector("#pagination li"));

		int totalPages = pages.size();

		for (int page = 1; page <= totalPages; page++) {

			driver.findElement(By.linkText(String.valueOf(page))).click();

			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

			for (WebElement row : rows) {

				String name = row.findElement(By.xpath("./td[2]")).getText();

				if (name.equalsIgnoreCase(productName)) {

					WebElement checkbox = row.findElement(By.xpath("./td[4]/input"));

					checkbox.click();

					System.out.println("Selected Product: " + productName);

					return;
				}
			}
		}

		throw new RuntimeException("Product not found: " + productName);
	}

	public boolean isProductPresent(String productName) {

		List<WebElement> pages = driver.findElements(By.cssSelector("#pagination li"));

		int totalPages = pages.size();

		for (int page = 1; page <= totalPages; page++) {

			driver.findElement(By.linkText(String.valueOf(page))).click();

			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

			for (WebElement row : rows) {

				if (row.findElement(By.xpath("./td[2]")).getText().equalsIgnoreCase(productName)) {

					return true;
				}
			}
		}

		return false;
	}

	// ==========================================================
	// Utility Methods
	// ==========================================================

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

	public void verifyBasicElementsPresent() {

		isElementPresent(nameField);
		isElementPresent(emailField);
		isElementPresent(phoneField);
		isElementPresent(addressField);
		isElementPresent(maleRadio);
		isElementPresent(femaleRadio);
	}
}