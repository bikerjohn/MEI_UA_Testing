package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import test_cases.TestVars;
import java.time.LocalDateTime;

public class Pilr_Org_Page {
	WebDriver driver;
	TestVars objtestvars; 
	By orgPageWelcome = By.cssSelector("h1");
	By createProject = By.cssSelector("a[href*='newProject']");
	private String projectName = "a[href*='";
	By deleteProject = By.cssSelector(projectName);
	Time_Wait objTimeWait;
	
	
	public Pilr_Org_Page(WebDriver driver){
		this.driver = driver;
	}
	
	//Get the Org Page Welcome
	public String getOrgPageWelcome(){
        return    driver.findElement(orgPageWelcome).getText();
    }
	
	//Create a new project by selecting the +New link
	public Pilr_Project_Wizard createProject(){
		driver.findElement(createProject).click();
		return new Pilr_Project_Wizard(driver);
	}
	//Delete a project by selecting the trash can icon
	public Delete_Project_Modal delete_Project(String projName){
		objTimeWait = new Time_Wait();
		//this.projectName = projectName + projName + "']";
		String local_test = "a[href*='" + projName + "']";
		
		
		//System.out.println(projectName);
		//By deleteProject = By.cssSelector(projectName);
		System.out.println("After selector\n");
		System.out.println(local_test);
		WebElement element = driver.findElement(By.cssSelector(local_test));
    	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element );//, element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
		objTimeWait.Duration(1000);
		driver.findElement(By.cssSelector(local_test)).click();
		return new Delete_Project_Modal(driver);
	}
}

