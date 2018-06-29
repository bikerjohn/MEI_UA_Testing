
package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Admin_Home_Page extends AbstractBasePage {

	
	private String project = "${project_name}";
	//private String organization = "test_org";
	By homePageWelcome = By.cssSelector("i.icon-double-angle-right");
	By PilrProject = By.cssSelector("a[title='"+project+"']");
	//By PilrOrg = By.partialLinkText(organization);
	By PilrTable = By.cssSelector("table[class^='table table-responsive']");
	//By PilrOrgExp = By.cssSelector("i[class='icon-chevron-right'] + *");
	//By PilrChooseProj = By.cssSelector("a[title='Choose a Project']");
     
	By HideFeedback = By.cssSelector("a[id='hide-feedback']");
	By projListToggle= By.cssSelector("a[href='#collapseFour']");
	By AdminProjectChoice= By.cssSelector("a[href='/projectAdmin/show/5612d1cce4b03f1a21c2500f']");
	By projectDropDown = By.cssSelector("a[id='chooseProject']");
	By projectDropDownSelect = By.cssSelector("a[id='projectEMA_copy_test']");
	By projectSearch = By.cssSelector("#project-list > div.row > div.col-sm-8 > div.dataTables_length > form > #search");
	
   public Admin_Home_Page(WebDriver driver){
	   super(driver);
   }
 
   //Get the User name from Home Page
      public String getHomePageWelcome(){
        return    findElement(homePageWelcome).getText();
       }
      
      //Select a project to work on
      public Project_Details_Admin selectProject(String prjct) {
    	  
    	  //this.project = prjct;
//    	  findElement(HideFeedback).click();
    	  
    	  WebElement toggle = findElement(projListToggle);
	      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toggle);
    	  toggle.click();
    	  findElement(By.id("term")).clear();
    	  findElement(By.id("term")).sendKeys(prjct);
    	  findElement(projectSearch).click();
	      findElement(By.partialLinkText(prjct)).click();;
	      
	      System.out.println("[Page Object]Select Project");
    	  return new Project_Details_Admin(driver);
      }
      
      
     
      public void projDropdown(){
	    	findElement(projectDropDown).click();
	    }
	  public void projDropdownSelect(){
		  findElement(projectDropDownSelect).click();
	  }
      
}
	
	

	 