package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Delete_Data_Page {
	WebDriver driver;
	 
	   By deleteDataPageWelcome = By.cssSelector("h1");
	   By calrqData = By.id("showDatasetCalRQData");
	   By haldaneData = By.id("showDatasetHaldanePreEventTagData");
	   
	   public Delete_Data_Page(WebDriver driver){
			 
	       this.driver = driver;
	   }
	   
	 	//Get the Delete Data Page Welcome
	    public String getdeleteDataPageWelcome(){
	        return    driver.findElement(deleteDataPageWelcome).getText();
	    }
	    //select calrq dataset
	    public void select_calrq_data(){
	    	driver.findElement(calrqData).click();
	    }
	    //select haldane pre event tag dataset
	    public void select_haldane_data(){
	    	driver.findElement(haldaneData).click();
	    }
}
