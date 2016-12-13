package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_EMA_App_Home {
	WebDriver driver;
	
	By EmaappPageWelcome = By.cssSelector("h4[class='lighter smaller']");
	By SurvResponseLink = By.linkText("Survey Responses");
	By ebuilderLink = By.linkText("Builder");
	By applicationLink = By.linkText("Application");
	By languagesLink = By.linkText("Languages");
	By complianceLink = By.linkText("Compliance");
	
	public Pilr_EMA_App_Home(WebDriver driver){
		 
	       this.driver = driver;
	   }
	//Get the EMA App Page Welcome
    public String getEMAAppPageWelcome(){
        return    driver.findElement(EmaappPageWelcome).getText();
    }
    //Navigate to the Survey Response Page
    public Pilr_Survey_ResponsePage selectSurvResponse() {
  	  driver.findElement(SurvResponseLink).click();
  	  System.out.println("[Page Object]Select Survey Reponse Link");
  	  return new Pilr_Survey_ResponsePage(driver);
    }
    //Navigate to the EMA Builder Page
    public Pilr_Builder_Page selectEMABuilder() {
  	  driver.findElement(ebuilderLink).click();
  	  System.out.println("[Page Object]Select EMA Builder Link");
  	  return new Pilr_Builder_Page(driver);
    }
    //Navigate to the EMA Application Page
    public Pilr_Application_Page selectEMAApplication() {
  	  driver.findElement(applicationLink).click();
  	  System.out.println("[Page Object]Select EMA Application Link");
  	  return new Pilr_Application_Page(driver);
    }
    //Navigate to the EMA Languages Page
    public Pilr_Languages_Page selectEMALanguages() {
  	  driver.findElement(languagesLink).click();
  	  System.out.println("[Page Object]Select EMA Languages Link");
  	  return new Pilr_Languages_Page(driver);
    }
    //Navigate to the EMA Compliance Page
    public Pilr_Compliance_Page selectEMACompliance() {
  	  driver.findElement(complianceLink).click();
  	  System.out.println("[Page Object]Select EMA Compliance Link");
  	  return new Pilr_Compliance_Page(driver);
    }
	   
}
