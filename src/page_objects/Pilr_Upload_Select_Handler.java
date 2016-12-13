package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Upload_Select_Handler {
	WebDriver driver;
	 
	   By uploadFilePageWelcome = By.cssSelector("h4");
	   By handlerDropdown = By.cssSelector("span[class='select2-chosen']");
	   By liCalrqHandler = By.cssSelector("li[class='select2-results-dept-0 select2-result select2-result-selectable']");
	   By nextButton = By.cssSelector("button[id='next']");
	   
	   private Integer li_Position = 1;

	   public Pilr_Upload_Select_Handler(WebDriver driver){
			 
	       this.driver = driver;
	   }
	   
	 	//Get the Upload File Page Welcome
	    public String getuploadFilePageWelcome(){
	        return    driver.findElement(uploadFilePageWelcome).getText();
	    }
	    
	    // Select CalRQ Data file handler and click 
		public void select_calrq_handler(Integer liPosition){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.li_Position=liPosition;
			driver.findElements(handlerDropdown).get(0).click();
			driver.findElements(liCalrqHandler).get(li_Position).click();
			driver.findElement(nextButton).click();
		}
}
