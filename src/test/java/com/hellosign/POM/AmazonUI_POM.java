package com.hellosign.POM;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AmazonUI_POM {

	/**
	 * 
	 * All WebElements are identified by @FindBy annotation
	 * 
	 */

	WebDriver driver;
	@FindBy(xpath = ".//*[@id='nav-link-shopall']")
	WebElement department;

	@FindBy(xpath = ".//*[@id='nav-flyout-shopAll']/div[2]/span[11]")
	WebElement electronicsDept;

	@FindBy(css = "div.nav-template:nth-child(11) > div:nth-child(3) > div:nth-child(2) > a:nth-child(9) > span:nth-child(1)")
	WebElement musicalDept;

	@FindBy(xpath = ".//*[@id='nav-subnav']/a[1]/span")
	WebElement mDept;

	@FindBy(xpath = ".//*[@id='nav-subnav']/a[3]")
	WebElement selectGuitar;

	@FindBy(xpath = ".//*[@id='nav-flyout-ab:musical-instruments-subnav-flyout-content-1,musical-instruments-subnav-flyout-promo-1:verticalstores-subnav-flyout']/div[2]/div/div[1]/ul/li[1]/a/div")
	WebElement selectElectricGuitar;

	@FindBy(xpath = ".//*[@id='anonCarousel1']/ol/li[1]/div/a/div[2]/span")
	WebElement solidBody;

	@FindBy(xpath = ".//*[@id='anonCarousel1']/ol/li[3]/div/a/div[2]/span")
	WebElement beginnerKit;

	@FindBy(xpath = ".//*[@id='anonCarousel1']/ol/li[2]/div/a/div[2]/span")
	WebElement HnSemiHollowBody;

	@FindBy(xpath = ".//*[@id='anonCarousel1']/ol/li[4]/div/a/div[2]/span")
	WebElement padelSteelGuitar;

	@FindBy(xpath = ".//*[@id='merchandised-content']/div[1]/h1")
	WebElement selectGuitarTitle;

	@FindBy(xpath = ".//*[@id='nav-logo']/a[1]/span[1]")
	WebElement selectAmazonHome;

	@FindBy(xpath = ".//*[@id='twotabsearchtextbox']")
	WebElement searchBox;

	@FindBy(xpath = ".//*[@id='nav-search']/form/div[2]/div/input")
	WebElement clickSearchButton;

	@FindBy(xpath = ".//*[@id='s-result-count']/span/span")
	WebElement guitarSearchResult;

	@FindBy(xpath = ".//*[@id='leftNavContainer']/ul[1]/div/li[1]/span/ul/div/li[2]/span/a/span")
	WebElement leftPaneElectricGuitar;

	@FindBy(xpath = ".//*[@id='leftNavContainer']/ul[1]/div/li[1]/span/ul/div/li[4]/span/a/span")
	WebElement leftPaneBeginnerKit;

	@FindBy(xpath = ".//*[@id='leftNavContainer']/ul[1]/div/li[2]/span/ul/div/li[2]/span/a/span")
	WebElement leftPaneKidsGuitar;

	public AmazonUI_POM(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public void selectElectricGuitar() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10, TimeUnit.SECONDS.toMillis(1));
		Actions action = new Actions(driver);
		Reporter.log("select department in amazon");
		action.moveToElement(department).build().perform();
		action.pause(TimeUnit.SECONDS.toMillis(1));
		action.release();
		Reporter.log("wait until Electronics, Computers & Office to be displayed");

		wait.until(ExpectedConditions.textToBePresentInElement(electronicsDept, "Electronics, Computers & Office"));
		Reporter.log("select electronics department in amazon");

		action.moveToElement(electronicsDept).build().perform();
		Reporter.log("wait until Musical Instruments to be displayed");

		wait.until(ExpectedConditions.textToBePresentInElement(musicalDept, "Musical Instruments"));
		Reporter.log("select musical department in amazon");

		action.moveToElement(musicalDept).click().build().perform();
		Reporter.log("wait until Guitars to be displayed");

		wait.until(ExpectedConditions.textToBePresentInElement(selectGuitar, "Guitars"));
		action.pause(TimeUnit.SECONDS.toMillis(1));
		action.release();
		Reporter.log("select guitar department in amazon");

		action.moveToElement(selectGuitar).build().perform();
		Reporter.log("wait until Electric Guitar to be displayed");

		wait.until(ExpectedConditions.textToBePresentInElement(selectElectricGuitar, "Electric"));
		Reporter.log("select  Electric guitar in amazon");

		action.moveToElement(selectElectricGuitar).click().build().perform();
		wait.until(ExpectedConditions.textToBePresentInElement(selectGuitarTitle, "Electric Guitars"));
	}

	public String getGuitarTitle() {
		return selectGuitarTitle.getText().toString();
	}

	public String getSolidBodyTitle() {
		return solidBody.getText().toString();
	}

	public String getBegineerKitTitle() {
		return beginnerKit.getText().toString();
	}

	public String gethnsHollowBodyTitle() {
		return HnSemiHollowBody.getText().toString();
	}

	public String getpadelSteelTitle() {
		return padelSteelGuitar.getText().toString();
	}

	public void selectAmazonHome() {
		selectAmazonHome.click();
	}

	public void searchInAmazonHome(String searchText) throws InterruptedException {
		searchBox.clear();
		Reporter.log("clear and send text searchbox");
		searchBox.sendKeys(searchText);
		searchBox.sendKeys(Keys.ENTER);
	}

	public String getEGuitarSeachResultTitle() {
		return guitarSearchResult.getText().toString();
	}

	public String getLeftPaneEGuitarTitle() throws InterruptedException {
		return leftPaneElectricGuitar.getText().toString();
	}

	public String getLeftPaneEGBegineerKitTitle() {
		return leftPaneBeginnerKit.getText().toString();
	}

	public String getKidsGuitarTitle() {
		return leftPaneKidsGuitar.getText().toString();
	}
}
