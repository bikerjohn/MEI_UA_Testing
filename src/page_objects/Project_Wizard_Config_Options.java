package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Project_Wizard_Config_Options {
	WebDriver driver; 
	By configOptionsWelcome = By.cssSelector(".widget-main h3");
	By buildFromScratch = By.cssSelector("input[id='nextStep_doItYourself']");
	By nextButton = By.cssSelector("button#next");
	By importFromOrgButton = By.cssSelector("input[id='nextStep_organization']");
	By selectDropDown2 = By.cssSelector("span[class='select2-chosen']");
	By selectOrg = By.cssSelector("#s2id_importOrgDef .select2-chosen");
	By fillDropDown2 = By.cssSelector("input[class='select2-input']");
	By liEmaConfig = By.cssSelector("li.select2-results-dept-0.select2-result.select2-result-selectable");
	
	public Project_Wizard_Config_Options(WebDriver driver){
		this.driver = driver;
	}
	//get page welcome text
	public String getConfigOptionsWelcome(){
        return    driver.findElement(configOptionsWelcome).getText();
    }
	//select the build from scratch radio button
	public void selectBuildFromScratch(){
		driver.findElement(buildFromScratch).click();
	}
	//select the import from organization radio button
	public void select_Import_From_Organization(){
		driver.findElement(importFromOrgButton).click();
	}
	//select the "next" button and move to the Project Wizard Duration page
	public Project_Wizard_Duration selectNext(){
		//WebElement nextButton = driver.findElement(By.linkText("next"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
  	  	je.executeScript("arguments[0].scrollIntoView(true);",
  	  	driver.findElement(By.cssSelector("button[id='next']")));
  	  	driver.findElement(nextButton).click();
		
		return new Project_Wizard_Duration(driver);
	}
	//select the copy from organization option send the li position as part of call
	public void import_Component_From_Organization(Integer liPosition){
		driver.findElement(selectOrg).click();
		driver.findElements(liEmaConfig).get(liPosition).click();
		driver.findElement(nextButton).click();
	}
}
