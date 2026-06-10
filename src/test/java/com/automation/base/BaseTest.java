package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	protected WebDriver driver;
	protected WebDriverWait wait;

	// Demo delay
	protected static final int DEMO_DELAY = 3000;

	@BeforeClass
	public void setUp() {

		ChromeOptions options = new ChromeOptions();

		// Read system property
		String headless = System.getProperty("headless", "false");

		if (headless.equalsIgnoreCase("true")) {

			System.out.println("Running in Headless Mode");

			options.addArguments("--headless=new");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");

		} else {

			System.out.println("Running in Normal Browser Mode");
		}

		driver = new ChromeDriver(options);

		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(5));

		// Only maximize in non-headless mode
		if (!headless.equalsIgnoreCase("true")) {
			driver.manage().window().maximize();
		}

		wait = new WebDriverWait(
				driver,
				Duration.ofSeconds(15));

		driver.get("https://testautomationpractice.blogspot.com/");

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
