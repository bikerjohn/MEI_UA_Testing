package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Navbar {
	WebDriver driver;
	
	By Navbar_useraccount = By.id("yourAccountDropdown");
	By Account_option = By.id("logout");
	By projectSettingsIcon = By.cssSelector("i[class='icon-cogs']");
	By coordinateProjectIcon = By.cssSelector("i[class='icon-dashboard']");
	By toolsDropdown = By.cssSelector("i[class='icon-wrench']");
	By eventTagEditorNav = By.cssSelector("a[id='navToolsEventTagEditor']");
	By rProcessingNav = By.cssSelector("a[id='navToolsProcessingwithR']");
	By selectOrganizationLink = By.cssSelector("a[id='chooseOrganization']");
	private String orgName = "a[title='";
	By selectOrganization = By.cssSelector(orgName);
	
	
	public Pilr_Navbar(WebDriver driver){
		this.driver = driver;
	}
	//Logout of the Home page
    public void clickLogout(){
   	 driver.findElement(Navbar_useraccount).click();
   	 driver.findElement(Account_option).click(); 
    }
    
    //Select the Project Settings Navbar Icon to navigate to the Project Settings Page
    public Pilr_Project_Settings_Page click_Project_Settings_Icon(){
    	driver.findElement(projectSettingsIcon).click();
    	return new Pilr_Project_Settings_Page(driver);
    }
    
    //Select the Coordinate Project Coordinate Page icon to navigate to the Coordinate Page
    public Pilr_CoordinatePage click_Project_Coordinate_Icon(){
    	driver.findElement(coordinateProjectIcon).click();
    	return new Pilr_CoordinatePage(driver);
    }
    
    //Select the Event Tag Editor
    public Pilr_Event_Tag_Editor_Summary click_Event_Tag_Editor(){
    	driver.findElement(toolsDropdown).click();
    	driver.findElement(eventTagEditorNav).click();
    	return new Pilr_Event_Tag_Editor_Summary(driver);
    }
    
    //Select the R Processing Tool
    public Pilr_Event_Tag_Editor_Summary click_R_Processing_Tool(){
    	driver.findElement(toolsDropdown).click();
    	driver.findElement(rProcessingNav).click();
    	return new Pilr_Event_Tag_Editor_Summary(driver);
    }
    
    //Select the Organization to Navigate to from the Navbar link
    public Pilr_Org_Page Nav_to_Org_Page(String organizationName){
    	this.orgName = orgName + organizationName + "']";
    	By selectOrganization = By.cssSelector(orgName);
    	driver.findElement(selectOrganizationLink).click();
    	driver.findElement(selectOrganization).click();
    	return new Pilr_Org_Page(driver);
    }
}
