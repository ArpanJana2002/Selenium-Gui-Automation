package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.base.BasePage;

public class MouseActionPage extends BasePage {

	private Actions actions;

	public MouseActionPage(WebDriver driver) {
		super(driver);
		this.actions = new Actions(driver);
	}

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
	// Drag And Drop
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
}