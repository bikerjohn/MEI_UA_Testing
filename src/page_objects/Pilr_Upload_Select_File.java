package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Upload_Select_File {
	WebDriver driver;
	 
	   By uploadFilePageWelcome = By.cssSelector("h4");
	   By importFileName = By.cssSelector("input[id='importFile']");
	   By importButton = By.cssSelector("button[id='next']");
	   By periodSelector = By.cssSelector("input[name='date']");

	   public Pilr_Upload_Select_File(WebDriver driver){
			 
	       this.driver = driver;
	   }
	   
	 	//Get the Upload File Page Welcome
	    public String getuploadFilePageWelcome(){
	        return    driver.findElement(uploadFilePageWelcome).getText();
	    }
	    
	    // Enter location of data file, select period radio button, press upload button
		public void enter_upload_file(String filename){
			driver.findElement(importFileName).clear();
			driver.findElement(importFileName).sendKeys(filename);
			driver.findElement(periodSelector).click();
			driver.findElement(importButton).click();
		}
}
