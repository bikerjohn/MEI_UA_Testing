package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_R_Processing_History {
	WebDriver driver;
	
	By welcomeMessage = By.cssSelector("div[class='table-header']");
	By runButton = By.id("run");
	
	public Pilr_R_Processing_History(WebDriver driver){		 
       this.driver = driver;	       
    }
	
	public String getJobHistoryWelcome() {
		return driver.findElement(welcomeMessage).getText();
	}
	
	public void runJob() {
		driver.findElement(runButton).click();
	}
	
	public void selectRanJob(String jobName) {
		By jobButton = By.linkText(jobName);
		driver.findElement(jobButton).click();
	}
}
