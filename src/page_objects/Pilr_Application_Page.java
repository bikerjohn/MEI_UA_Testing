package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pilr_Application_Page {
	WebDriver driver;
	By applicationPageWelcome = By.cssSelector("div[class='table-header']");
	
	public Pilr_Application_Page(WebDriver driver){		 
	       this.driver = driver;
	   }
	//Get the application Welcome
    public String getApplicationWelcome(){
        return    driver.findElement(applicationPageWelcome).getText();
    }
 
}
