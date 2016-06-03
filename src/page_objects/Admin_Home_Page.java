package page_objects;
import java.lang.management.ManagementFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import test_cases.TestVars;

public class Admin_Home_Page {
	WebDriver driver;

	
	private String project = "${project_name}";
	//private String organization = "test_org";
	By homePageWelcome = By.cssSelector("i.icon-double-angle-right");
	By PilrProject = By.cssSelector("a[title='"+project+"']");
	//By PilrOrg = By.partialLinkText(organization);
	By PilrTable = By.cssSelector("table[class^='table table-responsive']");
	//By PilrOrgExp = By.cssSelector("i[class='icon-chevron-right'] + *");
	//By PilrChooseProj = By.cssSelector("a[title='Choose a Project']");
     
	By HideFeedback = By.cssSelector("a[id='hide-feedback']");
	By PilrChooseProj= By.cssSelector("a[href='#collapseFour']");
	By AdminProjectChoice= By.cssSelector("a[href='/projectAdmin/show/5612d1cce4b03f1a21c2500f']");
	By projectDropDown = By.cssSelector("a[id='chooseProject']");
	By projectDropDownSelect = By.cssSelector("a[id='projectEMA_copy_test']");
	
   public Admin_Home_Page(WebDriver driver){
 
       this.driver = driver;
       
   }
 
   //Get the User name from Home Page
      public String getHomePageWelcome(){
        return    driver.findElement(homePageWelcome).getText();
       }
      
      //Select a project to work on
      public Project_Details_Admin selectProject(String prjct) {
    	  
    	  //this.project = prjct;
    	  driver.findElement(HideFeedback).click();
    	  driver.findElement(PilrChooseProj).click();
	      this.PilrProject = By.partialLinkText(project);
	      System.out.println("[Page Object]Select Project");
	      WebElement element = driver.findElement(PilrProject);
    	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	  //driver.findElement(PilrChooseProj).click();
    	  driver.findElement(AdminProjectChoice).click();
    	  return new Project_Details_Admin(driver);
      }
     
      public void projDropdown(){
	    	driver.findElement(projectDropDown).click();
	    }
	  public void projDropdownSelect(){
		  driver.findElement(projectDropDownSelect).click();
	  }
      
}
	
	

	 