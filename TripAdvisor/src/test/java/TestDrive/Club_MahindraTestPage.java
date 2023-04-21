package TestDrive;

import org.testng.annotations.Test;

import BaseDriver.BaseClass;
import PageDrive.SearchPage;

public class Club_MahindraTestPage extends BaseClass {
	
	@Test
	public void testPage() throws Exception {
		SearchPage sp = new SearchPage(driver);
		sp.search("Club Mahindra");
		Thread.sleep(5000);
		sp.clickFirstResult();
		Thread.sleep(5000);
		sp.reviewbutton();
		Thread.sleep(5000);
		sp.clickFifthStar();
		Thread.sleep(5000);
		sp.writeReview("hello", "Raj");
		Thread.sleep(5000);
		sp.submitReview();
		
	}

}
