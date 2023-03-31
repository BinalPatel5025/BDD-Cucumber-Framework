package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath ="//td[contains(text(),'User: binal patel')]")
	WebElement userNameLable1;
	
	@FindBy(xpath ="//a[contains(text(),'Contacts')]")
	WebElement  contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(css = "a[title =Tasks]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement newContactLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return userNameLable1.isDisplayed();
	}
	
	
	public void clickOnNewContactLink() {
		
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",newContactLink);
		//wait.until(ExpectedConditions.elementToBeClickable(newContactLink));
		//newContactLink.click();
	}

}
