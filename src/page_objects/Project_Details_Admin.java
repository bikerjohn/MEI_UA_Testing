package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Project_Details_Admin {
	WebDriver driver;
	 
	   private String part_code = "992";
	   By projectDetailsWelcome = By.cssSelector("a[id='edit']");
	   By editBtn = By.cssSelector("a[id='edit']");
	   By AddParticipant = By.id("addParticipant");
	   By ProjectInstrument = By.cssSelector("span.bigger-110");
	   By ViewGroups = By.id("navManagementGroupCategories");
	   By ParticipantDetail = By.id("show" + part_code);
	   By ProjectSettings = By.cssSelector("i[class='icon-cogs']");
	   By BrowseData = By.cssSelector("a[id='navDataBrowse']");
	   By BulkAddParticipant = By.cssSelector("a[id='bulkAddParticipant']");
	   By BulkEditParticipant = By.cssSelector("a[id='bulkEditParticipants']");
	   By featureLocation = By.cssSelector("input[id='featureString']");
	   //By featLoc = By.cssSelector("div[class='col-sm-8 wrap-text']:nth-of-type(5)]");
	   private String featName = "v2_api,activity,media_cards";
	   
	   By configChecker = By.cssSelector("input[id='isConfigLocked']");
	   By projSave = By.cssSelector("button[id*='save']");
	  // By projectDropDown = By.cssSelector("a[id='chooseProject']");
	   //By editFeats = By.cssSelector()
	   
	 public Project_Details_Admin(WebDriver driver){
	 
	       this.driver = driver;
	   }
	   
	 	//Get the Coordinate Page Welcome
	    public String getProjectDetailsWelcome(){
	    	System.out.println("In welcome features");
	        return    driver.findElement(projectDetailsWelcome).getText();
	    }
	      
	    public String getFeatures(){
	    	System.out.println("In get features");
	        //return driver.findElement(featureLocation).getText();
	    	return driver.findElement(By.xpath("(//div[@class='col-sm-8 wrap-text'])[5]")).getText();
	    }
	    
	    public void editFeatures(){
	    	System.out.println("In edit features");
	    	driver.findElement(editBtn).click();
	    }
	    
	    public void setFeatures(){
	    	System.out.println("In set features");
	        driver.findElement(featureLocation).clear();
	    	driver.findElement(featureLocation).sendKeys(featName);	 
	    }
	    
	    public void saveFeatures(){
	    	System.out.println("In save features");
	    	WebElement element = driver.findElement(configChecker);
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    	driver.findElement(projSave).click();
	    }
	   public void clearFeatures(){
		   System.out.println("In set features");
	       driver.findElement(featureLocation).clear();
	    	
		   
	   }
}