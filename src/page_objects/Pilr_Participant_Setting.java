package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Participant_Setting {
	WebDriver driver;
	 
	   By mfc1Setting = By.xpath("//p/input");
	   By saveButton = By.id("save");
	   By addNodeButton = By.id("addAnotherNode");
	   By pullDifferential = By.xpath("//p[3]/input");
	   By propaneSetting = By.xpath("//p/input");
	   By n2ValueNode1 = By.id("values00name");
	   By n2TimeNode1 = By.id("values[0][1].name");
	   By n2DateNode1 = By.id("values[0][2].name");
	   By n2ValueNode2 = By.id("values10name");
	   By n2TimeNode2 = By.id("values[1][1].name");
	   By n2DateNode2 = By.id("values[1][2].name");

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
	   public void setHumanMultipleN2() {
		   driver.findElement(addNodeButton).click();
		   
		   driver.findElement(n2ValueNode1).sendKeys("1.02");
		   driver.findElement(n2TimeNode1).sendKeys("06/22/2015");
		   driver.findElement(n2DateNode1).sendKeys("17:30:00");

		   driver.findElement(n2ValueNode2).sendKeys("1.05");
		   driver.findElement(n2TimeNode2).sendKeys("06/23/2015");
		   driver.findElement(n2DateNode2).sendKeys("06:30:00");
		   
		   driver.findElement(saveButton).click();
	   }
}
