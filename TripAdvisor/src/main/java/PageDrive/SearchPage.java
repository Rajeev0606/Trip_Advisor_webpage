package PageDrive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilsDriver.UtilsClass;

public class SearchPage extends UtilsClass {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//input[@aria-label='Search'])[2]")
	WebElement search;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement submit;
	
	@FindBy(xpath = "(//div[@class='result-title'])[1]")
	WebElement firstResult;
	
	@FindBy(xpath = "//a[@class='kNGcD Cg f']")
	WebElement reviewbut;
	
	@FindBy(id = "traveler-rating_5")
	WebElement rating;
	
	@FindBy(id = "review-text")
	WebElement review;
	
	@FindBy(id = "review-title")
	WebElement reviewTitle;
	
	@FindBy(xpath = "//button[@data-automation='submit']")
	WebElement submitButt;
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void search(String query) {
		search.sendKeys(query);
		submit.click();
	}
	public void clickFirstResult() {
		firstResult.click();
	}
	public void reviewbutton() {
		reviewbut.click();
	}
	public void clickFifthStar() {
		Actions act = new Actions(driver);
		act.moveToElement(rating).click().build().perform();
	}
	public void writeReview(String title, String text) {
		review.sendKeys(text);
		reviewTitle.sendKeys(title);
	}
	public void submitReview() {
		submitButt.click();
	}
	
	


}
