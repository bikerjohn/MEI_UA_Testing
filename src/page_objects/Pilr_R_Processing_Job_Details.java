package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_R_Processing_Job_Details {
	WebDriver driver;
	
	By jobOutputMessage = By.cssSelector("div[class='alert alert-info']");
	By hideFeedback = By.cssSelector("a[id='hide-feedback']");
	By outputDataButton = By.xpath("//tr[2]/td[4]/span/a/i");
	
	public Pilr_R_Processing_Job_Details(WebDriver driver){		 
       this.driver = driver;	       
    }
	
	public String getJobDetailsOutput() {
		return driver.findElement(jobOutputMessage).getText();
	}
	
	public void navJobOutputData() {
		driver.findElement(hideFeedback).click();
		driver.findElement(outputDataButton).click();
	}
}
