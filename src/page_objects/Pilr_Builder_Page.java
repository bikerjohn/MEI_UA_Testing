package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pilr_Builder_Page {
	WebDriver driver;
	String csv_LocationMatt = "/Users/matt/Downloads/liad_test1.csv";
	String emaconfig = "Test Config";
	String project = "test_project";
	By ebuilderPageWelcome = By.cssSelector("div[class='widget-box transparent']");
	By emaconfigBuilder = By.partialLinkText(emaconfig);
	By pickEMAConfig = By.cssSelector("a[href*='" + project + "']");
	By addConfig = By.cssSelector("a[href='/project/project_name/emaOtsConfig/createConfig']");
	By importConfig = By.partialLinkText("import");
	By exportConfig = By.partialLinkText("export");
	By tableHeaderCheck = By.cssSelector("[class='table-header']");
	By importActivity = By.cssSelector("input[name='importFile']");
	By HideFeedback = By.cssSelector("a[id='hide-feedback']");
	By importButton = By.id("next");
	By startCheckBox = By.cssSelector("label[for='start']");
	By startCheckBox2 = By.cssSelector("[type='checkbox']");
	By surveyAdd = By.cssSelector("a[href='#addSurveyModal']");
	By surveyName = By.cssSelector("input[id='name']");
	By createButton = By.cssSelector("a[id='create']");
	By backToBuilder = By.cssSelector("a[href='/project/ema_copy_test/emaOtsConfig/config']");
	By selectSurvey = By.cssSelector("");
	
	public Pilr_Builder_Page(WebDriver driver){
		 
	       this.driver = driver;	       
	   }
	//Get the Builder Page Welcome
    public String getBuilderPageWelcome(){
        return    driver.findElement(ebuilderPageWelcome).getText();
    }
    public String getBuilderPageWelcome2(){
        return    driver.findElement(tableHeaderCheck).getText();
    }
    
    public void import_Activity_Database_Click(){
    	driver.findElement(HideFeedback).click();
    	//CLICK IMPORT BUTTON
    	WebElement element = driver.findElement(importActivity);
  	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  	    //driver.findElement(importActivity).click();
  	    WebElement file_input = driver.findElement(importActivity);
  	    System.out.println("Yeah");
  	    file_input.sendKeys("/Users/matt/Downloads/liad_test1.csv");
  	    driver.findElement(importButton).click();
    }
    public void start_Activities(){
    	System.out.println("Yeah1");
    	driver.findElement(startCheckBox).click();
    	try {
    		Thread.sleep(5000); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
    	System.out.println("Yeah2");
    	driver.findElement(startCheckBox2).click();
    	try {
    		Thread.sleep(5000); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
    	System.out.println("Apparent success");
    }
    public void create_followUp_Surveys(){
    	driver.findElement(surveyAdd).click();
    	WebElement surveyNamer = driver.findElement(surveyName);
    	surveyNamer.sendKeys("NewSurv");
    	driver.findElement(createButton).click();
    	//Back to builder
    	driver.findElement(backToBuilder).click();
    }
    public void select_followUp_Surveys(){
    	driver.findElement(HideFeedback).click();
    	WebElement element = driver.findElement(selectSurvey);
  	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    //Select the EMA Configuration
    //need to build a ConfigBuilder Page Object
    //Select an existing EMA Config to Open the Config Builder Page
    public Pilr_Config_Builder selectEMAConfig(String emaconfig) {
      this.emaconfig = emaconfig;
      By emaconfigBuilder = By.partialLinkText(emaconfig);
  	  driver.findElement(emaconfigBuilder).click();
  	  System.out.println("[Page Object]Select EMA Config");
  	  return new Pilr_Config_Builder(driver);
    }	
    public Pilr_Config_Builder verifyNewlyAdded(String newconfigname) {
       // this.emaconfig = emaconfig;
        By newConfigName = By.partialLinkText(newconfigname);
    	  driver.findElement(newConfigName).click();
    	  System.out.println("[Page Object]Verify New Config Exists");
    	  return new Pilr_Config_Builder(driver);
      }
    //this method uses a slightly different selector so I can do a partial match on project
    //name
    public Pilr_Config_Builder pickEMAConfig(String project_name){
    	this.project = project_name;
    	By pickEMAConfig = By.partialLinkText("New EMA Config");
    	driver.findElement(pickEMAConfig).click();
    	return new Pilr_Config_Builder(driver);
    	
    }
    //Create a new EMA Configuration
    public Builder_EMAConfig_Page addEMAConfig(String ema_config){
    	this.emaconfig = ema_config;
    	By addConfig = By.cssSelector("a[href='/project/" + emaconfig + "/emaOtsConfig/createConfig']");
    	driver.findElement(addConfig).click();
    	return new Builder_EMAConfig_Page(driver);
    }
    //Import the ema config (needs to be split because of need to create import def modal)
    public Import_EMA_Defs_Modal import_EMAConfig(){
    	driver.findElement(importConfig).click();
    	return new Import_EMA_Defs_Modal(driver);
    }
    //Export ema config, split due to creation of export modal
    public Export_EMA_Defs_Modal Export_EMAConfig(){
    	driver.findElement(exportConfig).click();
    	//Return new Import?
    	return new Export_EMA_Defs_Modal(driver);
    }
 
}
