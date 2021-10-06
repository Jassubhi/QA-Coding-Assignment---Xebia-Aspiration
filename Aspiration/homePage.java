package Aspiration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class homePage {
	WebDriver driver;
	
	//Initializing the web driver
	public homePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	//Locating SPEND&SAVE link in Aspiration.com landing page.
	By spendsave =By.xpath("//header/ul[1]/li[1]");         
		
	//Performing click operation of SPENT&SAVE link.
	public void spendAndSaveClick() {
		driver.findElement(spendsave).click();
	}

}
