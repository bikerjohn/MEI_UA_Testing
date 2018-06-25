package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PilrHomePage extends AbstractBasePage {	 
		private String project = "DualCohortStudy (OWNER)";
		private String organization = "test_org";
		By homePageWelcome = By.cssSelector("i.icon-double-angle-right");
		By PilrTable = By.cssSelector("table[class^='table table-responsive']");
		By PilrOrgExp = By.cssSelector("i[class='icon-chevron-right'] + *");
		By PilrChooseProj = By.cssSelector("a[title='Choose a Project']");
		By PilrCurrentUser = By.cssSelector("a[id='yourAccountDropdown']"); 
		
		
	   public PilrHomePage(WebDriver driver){
		   super(driver);
	   }
	 
	   //Get the User name from Home Page
	      public String getHomePageWelcome(){
	        return findElement(homePageWelcome).getText();
	    	//  return    driver.findElement(PilrCurrentUser).getText();
	       }
	      
	      //Select a project to work on
	      public Pilr_CoordinatePage selectProject(String prjct) {
	    	  this.project = prjct;
		      System.out.println("[Page Object]Select Project");
	    	  findElement(PilrChooseProj).click();
	    	  findElement(By.partialLinkText(project)).click();
	    	  return new Pilr_CoordinatePage(driver);
	      }
	      //Select an organization to work on
	      public Pilr_Org_Page selectOrganization(String org){
	    	  this.organization = org;
	    	  String href = "/organization/" + organization + "/show";
	    	  String xpath = "//div[contains(@class, 'organization-title')]//a[@href='" + href + "']";
	    	  WebElement linkToOrg = findElement(By.xpath(xpath));
	    	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkToOrg);
//	    	  linkToOrg = findElement(By.xpath(xpath));
	    	  linkToOrg.click();
	    	  return new Pilr_Org_Page(driver);
	      }
	      //Expand an Org group in order to be able to select a project
	      public void expandOrg(String Org){
	    	  this.organization = Org;
	    	  this.PilrOrgExp = By.cssSelector("i[class='icon-chevron-right']");
	    	  findElement(PilrTable).click();
	    	  driver.findElements(PilrOrgExp).get(1).click(); 
	      }
	      
}

