package DriverBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;


public class Driver extends DriverFactory{
	private String BaseUrl;
	private static WebDriver driver;

	// we can add multiple browser for different OS(get OS from system prop and
	// run for multiple browsers)
	public WebDriver start() {
		System.setProperty("webdriver.gecko.driver", ".//geckodriver");
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(BASE_URI);
		return driver;

	}
}