package Aspiration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcaseSpendAndSave {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jasme\\chromedriver.exe");
		
		//Initializing ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aspiration.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Creating instance of homePage, productPage, aspirationPlan, aspirationPlanPlus classes
		homePage home = new homePage(driver);
		productPage product = new productPage(driver);
		aspirationPlan ap =new aspirationPlan(driver);
		aspirationPlusPlan app =new aspirationPlusPlan(driver);
		
		//Navigating “Spend & Save” link from Home Page
		home.spendAndSaveClick();
		
		//Verifying both card visibility
		product.cardVisiblity();
		
		//Verifying Get Aspiration Plan with sign-up window.
		product.getAspiration();
		
		//Putting wait time to load the page.
		Thread.sleep(2000);
		
		//Verifying the Email Signup field
		ap.getAspirationEmailSignUp();
		
		//Closing the Sign up pop-up
		ap.closeAspirationSignup();
		Thread.sleep(2000);
		
		//Navigating to Get Aspiration Plus Plan.
		product.getAspirationPlus();
		
		//Verifying Aspiration Plus Plan and its Yearly and Monthly Plan.
		app.getAspirationPlusPlan();
		app.verifyYearlyPlan();
		app.verifyMonthlyPlan();
		
		//Closing the current opened window.
		Thread.sleep(1000);
		driver.close();
	}
			
}
