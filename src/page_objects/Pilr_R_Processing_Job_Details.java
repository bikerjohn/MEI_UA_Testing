package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_R_Processing_Job_Details {
	WebDriver driver;
	
	By jobOutputMessage = By.cssSelector("div[class='alert alert-info']");
	
	public Pilr_R_Processing_Job_Details(WebDriver driver){		 
       this.driver = driver;	       
    }
	
	public String getJobDetailsOutput() {
		return driver.findElement(jobOutputMessage).getText();
	}
}
