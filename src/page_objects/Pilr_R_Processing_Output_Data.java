package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_R_Processing_Output_Data extends AbstractBasePage {

	By jobOutputDataWelcome = By.cssSelector("li[class='white bigger-150']");

	public Pilr_R_Processing_Output_Data(WebDriver driver){
        super(driver);
    }

	public String getJobOutputDataWelcome(){
	       return findElement(jobOutputDataWelcome).getText();
	}
}
