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

	@Test(priority = 1, description = "verify Electric Guitars Department in Amazon")
	public void searchInElectricGuitarsDepartment() throws InterruptedException {
		amazonUI_POM = new AmazonUI_POM(driver);
		Reporter.log("call select guitar emthod");
		amazonUI_POM.selectElectricGuitar();
		electricGuitarValidation();
		Reporter.log("select amazon home");
		amazonUI_POM.selectAmazonHome();

	}

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