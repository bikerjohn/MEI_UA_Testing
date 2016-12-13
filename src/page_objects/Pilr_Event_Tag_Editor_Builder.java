package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Event_Tag_Editor_Builder {
	WebDriver driver;

	By welcomeMessage = By.cssSelector("b[class='green']");
	By addEventButton = By.xpath("//button[3]");
	By newEventStartDate = By.id("newEventStartDate");
	By newEventStartTime = By.id("newEventStartTime");
	By newEventEndDate = By.id("newEventEndDate");
	By newEventEndTime = By.id("newEventEndTime");
	By newEventNote = By.id("newEventNote");
	By chooseTagLabel = By.xpath("//div[3]/div/div/input[2]");
	By saveEventButton = By.id("createEventBtn");
	
	public String getEventTagBuilderWelcome() {
		return driver.findElement(welcomeMessage).getText();
	}

	public Pilr_Event_Tag_Editor_Builder(WebDriver driver) {	 
	       this.driver = driver;	       
    }
	
	public void addNewEvent() {
		driver.findElement(addEventButton).click();
	}
	
	public void setEventStartDate(String date) {
		driver.findElement(newEventStartDate).clear();
		driver.findElement(newEventStartDate).sendKeys(date);
		driver.findElement(newEventStartDate).click();
	}
	
	public void setEventStartTime(String time) {
		driver.findElement(newEventStartTime).clear();
		driver.findElement(newEventStartTime).sendKeys(time);
	}
	
	public void setEventEndDate(String date) {
		driver.findElement(newEventEndDate).clear();
		driver.findElement(newEventEndDate).sendKeys(date);
		driver.findElement(newEventEndDate).click();
	}
	
	public void setEventEndTime(String time) {
		driver.findElement(newEventEndTime).clear();
		driver.findElement(newEventEndTime).sendKeys(time);
	}
	
	public void chooseTagLabel(String label) {
		driver.findElement(chooseTagLabel).clear();
		driver.findElement(chooseTagLabel).sendKeys(label);
		driver.findElement(newEventNote).click();
	}
	
	public void saveEvent() {
		driver.findElement(saveEventButton).click();
	}

}
