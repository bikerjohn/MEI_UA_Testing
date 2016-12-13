package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Delete_Data_Details_Page {
	WebDriver driver;
	 
	   By deleteDataDetailsPageWelcome = By.cssSelector("h1");
	   By warningMessage = By.cssSelector("div[class='alert alert-danger']");
	   By row1DeleteButton = By.xpath("//td[6]/a/i");
	   By row2DeleteButton = By.xpath("//tr[2]/td[6]/a/i");
	   By deleteModalConfirm = By.id("modalConfirm");
	   By backNavButton = By.id("selectDataset");

	   public Delete_Data_Details_Page(WebDriver driver){
			 
	       this.driver = driver;
	   }
	   
	 	//Get the Delete Data Page Welcome
	    public String getdeleteDataDetailsPageWelcome(){
	        return    driver.findElement(deleteDataDetailsPageWelcome).getText();
	    }
	    // Get warning message
	    public String get_warning_message() {
	    	return driver.findElement(warningMessage).getText();
	    }
	    public void delete_row1_data(){
	    	driver.findElement(row1DeleteButton).click();
	    	driver.findElement(deleteModalConfirm).click();
	    }
	    public void delete_row2_data(){
	    	driver.findElement(row2DeleteButton).click();
	    	driver.findElement(deleteModalConfirm).click();
	    }
	    //Navigate back to select datasets page
	    public void back_nav() {
	    	driver.findElement(backNavButton).click();
	    }
}
