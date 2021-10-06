package Aspiration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class aspirationPlan {
	WebDriver driver;
	
	//Locating all Aspiration web elements
	By aspiration = By.xpath("//div[@class='spend-save-plans']/div/div[1]/div[2]/button");
	By close = By.className("close");
	
	//Initializing the web driver
	public aspirationPlan(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	//Verifying an input field for an email address on the click on Get Aspiration.
	public void getAspirationEmailSignUp() {
		System.out.println("Aspiration Email SignUp Plan:" + driver.findElement(By.xpath("//form[@name='WaitListForm']/fieldset/div[3]/div")).getText());
	}
	
	//Closing the sign-up pop-up
	public void closeAspirationSignup() {
		driver.findElement(close).click();
	}
}
