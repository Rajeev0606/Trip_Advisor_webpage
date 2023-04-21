package UtilsDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilsClass {
	
	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws Exception {
		prop = new Properties();
		String propPath = System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties";
		FileInputStream file = new FileInputStream(propPath);
		prop.load(file);
		String browser = prop.getProperty("browser");
		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("disable-notifications");
			driver = new FirefoxDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String takeScreenshot(String testName, WebDriver driver) throws IOException {

		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotFilePath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";
		FileUtils.copyFile(srcScreenshot, new File(screenshotFilePath));
		return screenshotFilePath;
	}

	public static void Switchclass() {

		String parentwindow = driver.getWindowHandle();

		Set<String> windowhandles = driver.getWindowHandles();

		for (String childwindow : windowhandles) {
			if (!childwindow.contentEquals(parentwindow)) {

				driver.switchTo().window(childwindow);
				break;
			}
		}
	}

}
