package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Pilr_R_Processing_Select_Job {
	WebDriver driver;
	
	By welcomeMessage = By.cssSelector("h4");
	By nextButton = By.id("preview");
	By participantSelect = By.id("participantCode");
	By jobSelect = By.id("jobDefCode");
	
	public Pilr_R_Processing_Select_Job(WebDriver driver){		 
       this.driver = driver;	       
    }
	
	public String getSelectJobWelcome() {
		return driver.findElement(welcomeMessage).getText();
	}
	
	public void chooseHuman() {
		Select selectPt =  new Select(driver.findElement(participantSelect));
		selectPt.selectByVisibleText("human : bikerjohn");
		
		Select selectJob =  new Select(driver.findElement(jobSelect));
		selectJob.selectByVisibleText("Human CalRQ Summary v1.2");
	}
	public void chooseInfusion() {
		Select selectPt =  new Select(driver.findElement(participantSelect));
		selectPt.selectByVisibleText("infusion : bikerjohn");
		
		Select selectJob =  new Select(driver.findElement(jobSelect));
		selectJob.selectByVisibleText("Infusion CalRQ Summary RC1");
	}
	public void chooseBurn() {
		Select selectPt =  new Select(driver.findElement(participantSelect));
		selectPt.selectByVisibleText("burn : bikerjohn");
		
		Select selectJob =  new Select(driver.findElement(jobSelect));
		selectJob.selectByVisibleText("Burn CalRQ Summary RC1");
	}
	
	public void nextStep() {
		driver.findElement(nextButton).click();
	}
}
