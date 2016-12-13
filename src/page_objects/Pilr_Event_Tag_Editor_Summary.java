package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Event_Tag_Editor_Summary {
	WebDriver driver;
	
	By welcomeMessage = By.cssSelector("div[class='table-header']");
	By humanParticipant = By.partialLinkText("human : bikerjohn");
	By infusionParticipant = By.partialLinkText("infusion : bikerjohn");
	By burnParticipant = By.partialLinkText("burn : bikerjohn");

	
	public Pilr_Event_Tag_Editor_Summary(WebDriver driver){		 
       this.driver = driver;	       
    }
	
	public String getEventTagSummaryWelcome() {
		return driver.findElement(welcomeMessage).getText();
	}
	
	public Pilr_Event_Tag_Editor_Builder selectHumanParticipant() {
		driver.findElement(humanParticipant).click();
		return new Pilr_Event_Tag_Editor_Builder(driver);
	}
	public Pilr_Event_Tag_Editor_Builder selectInfusionParticipant() {
		driver.findElement(infusionParticipant).click();
		return new Pilr_Event_Tag_Editor_Builder(driver);
	}
	public Pilr_Event_Tag_Editor_Builder selectBurnParticipant() {
		driver.findElement(burnParticipant).click();
		return new Pilr_Event_Tag_Editor_Builder(driver);
	}
}
