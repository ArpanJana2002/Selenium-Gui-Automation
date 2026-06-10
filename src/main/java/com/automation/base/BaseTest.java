package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;
	protected WebDriverWait wait;

	// Demo delay (3 seconds)
	protected static final int DEMO_DELAY = 3000;

	@BeforeClass
	public void setUp() {

		WebDriverManager.edgedriver().setup();

		EdgeOptions options = new EdgeOptions();

		// Required for Jenkins
		options.addArguments("--headless=new");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080");

		driver = new EdgeDriver(options);

		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(5));

		wait = new WebDriverWait(
				driver,
				Duration.ofSeconds(15));

		driver.get(
				"https://testautomationpractice.blogspot.com/");

		demoPause();
	}

	protected void demoPause() {
		try {
			Thread.sleep(DEMO_DELAY);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	@AfterClass
	public void tearDown() {

		demoPause();

		if (driver != null) {
			driver.quit();
		}
	}
}
