package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Pilr_Survey_Builder {
	WebDriver driver;
	private String surv_name="Test Survey";
	By survBuilderWelcome = By.cssSelector("div[class='widget-box transparent']");
	By selectSurvey = By.linkText(surv_name);
	By addSection = By.cssSelector("i[class='icon icon-plus']");
	By addCard = By.linkText("Add a Card");
	By importActivities = By.name("importFile");
	By importSelect = By.id("next");
	By activityLink0 = By.xpath("//td[6]");
	By activityStart0 = By.name("activities[0].start");
	By activityStart1 = By.name("activities[1].start");
	By activityStart2 = By.name("activities[2].start");
	By activityStart3 = By.name("activities[3].start");
	By activityLinkDropdown = By.cssSelector("li[class='select2-results-dept-0 select2-result select2-result-selectable']");
	By activitySave = By.id("Save");
	By configNavButton = By.linkText("New EMA Config");
	String sec_refid = "123";
	Actions action;
	//need a selector for the trigger editor
	//need a selector for the App Tabs cards (edit/delete)
	public Pilr_Survey_Builder(WebDriver driver){
		 
	       this.driver = driver;
	   }
	//Get the Survey_Builder Page Welcome
    public String getsurveyBuilderWelcome(){
        return    driver.findElement(survBuilderWelcome).getText();
    }
    
    //Create Section Method
    public Section_Modal create_Section(){
    	driver.findElement(addSection).click();
    	return new Section_Modal(driver);   	
    }
    //Create Card Method
    public Card_Modal create_Card(String ref_id){
    	this.sec_refid = ref_id;
    	driver.findElement(By.cssSelector("input[class='section'][value='" + ref_id + "']"));
    	//By addCard = By.cssSelector("a[onclick='isChangesSaved();'][href='#addSurveyCardModal - " + sec_refid + "']");
    	driver.findElement(addCard).click();
    	return new Card_Modal(driver);
    }
    //Import Activities
    public void import_Activities(String fileName) {
    	driver.findElement(importActivities).clear();
    	driver.findElement(importActivities).sendKeys(fileName);
    	driver.findElement(importSelect).click();
    }
    // Link survey to activity
    public void link_Activity(String surveyName) {
    	action = new Actions(driver); 
    	driver.findElement(activityLink0).click();
    	driver.findElements(activityLinkDropdown).get(0).click();
    	driver.findElement(activitySave).click();
    }
    // Select start on first 4 activities
    public void select_start_activities() {
    	driver.findElement(activityStart0).click();
    	driver.findElement(activityStart1).click();
    	driver.findElement(activityStart2).click();
    	driver.findElement(activityStart3).click();
    	driver.findElement(activitySave).click();
    }
    // Navigate back to config page
    public void nav_Config_Page() {
    	driver.findElement(configNavButton).click();
    }
}

