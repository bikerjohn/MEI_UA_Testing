package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_R_Processing_Select_Period {
	WebDriver driver;
	
	By welcomeMessage = By.cssSelector("h4");
	By nextButton = By.id("preview");
	
	public Pilr_R_Processing_Select_Period(WebDriver driver){		 
       this.driver = driver;	       
    }
	
	public String getSelectPeriodWelcome() {
		return driver.findElement(welcomeMessage).getText();
	}
	
	public void nextStep() {
		driver.findElement(nextButton).click();
	}
}
