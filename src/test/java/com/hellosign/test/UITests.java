package com.hellosign.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import com.hellosign.POM.AmazonUI_POM;

import DriverBase.Driver;

public class UITests extends Driver {

	public WebDriver driver;
	AmazonUI_POM amazonUI_POM;

	@BeforeClass
	public void beforeClass() {

		driver = start();

	}

	@Test(priority = 1, description = "verify Electric Guitars Department in Amazon", enabled = true)
	public void searchInElectricGuitarsDepartment() throws InterruptedException {
		amazonUI_POM = new AmazonUI_POM(driver);
		Reporter.log("call select guitar emthod");
		amazonUI_POM.selectElectricGuitar();
		electricGuitarValidation();
		Reporter.log("select amazon home");
		amazonUI_POM.selectAmazonHome();

	}

	@Test(priority = 2, description = "verify Electric Guitars with search feature in Amazon")
	public void searchInElectricGuitarsFromAmazonSearch() throws InterruptedException {
		amazonUI_POM = new AmazonUI_POM(driver);
		Reporter.log("search Electric Guitars in searchBox");
		amazonUI_POM.searchInAmazonHome("Electric Guitars");
		searchElectricGuitarValidation();

	}
//Search Electric guitat word in Amazon search and Do validation
	public void searchElectricGuitarValidation() throws InterruptedException {
		Reporter.log("validate  Left Pane Electric guitar title in amazon");
		Assert.assertEquals(amazonUI_POM.getEGuitarSeachResultTitle(), "\"Electric Guitars\"",
				"Electric Guitars Title did not match");
		Reporter.log("validate  Left Pane Solid Body Electric guitar title in amazon");
		Assert.assertEquals(amazonUI_POM.getLeftPaneEGuitarTitle(), "Solid Body Electric Guitars",
				"Solid Body Electric Guitars Title did not match");
		Reporter.log("validate left pane Electric guitar beginner kit title in amazon");
		Assert.assertEquals(amazonUI_POM.getLeftPaneEGBegineerKitTitle(), "Electric Guitar Beginner Kits",
				"Electric Guitars begineer Kits Title did not match");
		Reporter.log("validate Kids Electric guitar title in amazon");
		Assert.assertEquals(amazonUI_POM.getKidsGuitarTitle(), "Kids' Guitars & Strings",
				"Electric Guitars for Kids Title did not match");
	}

	//Search Electric Guitar form department and do validation
	public void electricGuitarValidation() {
		Reporter.log("validate  Electric guitar title in amazon");
		Assert.assertEquals(amazonUI_POM.getGuitarTitle(), "Electric Guitars", "Electric Guitars Title did not match");
		Reporter.log("validate  Beginner Kits title in amazon");

		Assert.assertEquals(amazonUI_POM.getBegineerKitTitle(), "Beginner Kits", "Beginner Kits Title did not match");
		Reporter.log("validate  Hollow & Semi-Hollow Body title in amazon");

		Assert.assertEquals(amazonUI_POM.gethnsHollowBodyTitle(), "Hollow & Semi-Hollow Body",
				"Hollow & Semi-Hollow Body Title did not match");
		Reporter.log("validate  Lap & Pedal Steel Guitars title in amazon");

		Assert.assertEquals(amazonUI_POM.getpadelSteelTitle(), "Lap & Pedal Steel Guitars",
				"Lap & Pedal Steel Guitars Title did not match");
		Reporter.log("validate  Solid Body title in amazon");

		Assert.assertEquals(amazonUI_POM.getSolidBodyTitle(), "Solid Body", "Solid Body Title did not match");
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}
}