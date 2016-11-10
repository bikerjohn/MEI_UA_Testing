package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Participant_Setting {
	WebDriver driver;
	 
	   By mfc1Setting = By.xpath("//p/input");
	   By saveButton = By.id("save");
	   By pullDifferential = By.xpath("//p[3]/input");
	   By propaneSetting = By.xpath("//p/input");

	   public Pilr_Participant_Setting(WebDriver driver){
			 
	       this.driver = driver;
	   }
	   public void setMFC1() {
		   driver.findElement(mfc1Setting).click();
		   driver.findElement(saveButton).click();
	   }
	   public void setPullDifferential() {
		   driver.findElement(pullDifferential).click();
		   driver.findElement(saveButton).click();
	   }
	   public void setPropane() {
		   driver.findElement(propaneSetting).click();
		   driver.findElement(saveButton).click();
	   }
}
