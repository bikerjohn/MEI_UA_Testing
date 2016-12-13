package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pilr_Languages_Page {
	WebDriver driver;
	By languagesPageWelcome = By.cssSelector("div[class='table-header']");
	
	public Pilr_Languages_Page(WebDriver driver){		 
	       this.driver = driver;
	   }
	//Get the languages Welcome
    public String getLanguagesWelcome(){
        return    driver.findElement(languagesPageWelcome).getText();
    }
}
