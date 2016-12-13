package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_R_Processing_Preview {
	WebDriver driver;
	
	By welcomeMessage = By.cssSelector("h4");
	By runButton = By.id("run");
	
	public Pilr_R_Processing_Preview(WebDriver driver){		 
       this.driver = driver;	       
    }
	
	public String getJobPreviewWelcome() {
		return driver.findElement(welcomeMessage).getText();
	}
	
	public void runJob() {
		driver.findElement(runButton).click();
	}
}
