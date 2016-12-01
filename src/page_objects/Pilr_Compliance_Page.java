package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pilr_Compliance_Page {
	WebDriver driver;
	By compliancePageWelcome = By.cssSelector("a[href='#compliance']");
	
	public Pilr_Compliance_Page(WebDriver driver){		 
	       this.driver = driver;
	   }
	//Get the application Welcome
    public String getComplianceWelcome(){
        return    driver.findElement(compliancePageWelcome).getText();
    }
 
}
