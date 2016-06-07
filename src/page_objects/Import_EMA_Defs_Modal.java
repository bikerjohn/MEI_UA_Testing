package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Import_EMA_Defs_Modal {
	WebDriver driver;
	By inputImportFName = By.cssSelector("input[id='importFile']");
	By importButton = By.cssSelector("button[id='next']");
	By importEMADefsWelcome = By.cssSelector("h4");
	By importConfig = By.partialLinkText("import");
	By addConfig = By.partialLinkText("Add");
	By configName = By.cssSelector("input[id='name']");
	By addButton = By.id("save");
	
	public Import_EMA_Defs_Modal(WebDriver driver){
		this.driver = driver;
	}
	public void import_EMAConfig(){
		driver.findElement(importConfig).click();
	}
	
	public void add_NewConfig(){
		driver.findElement(addConfig).click();
	}
	
	public Pilr_Config_Builder enter_NewConfig(String def_name){
		System.out.println(def_name);
		driver.findElement(configName).click();
		driver.findElement(configName).sendKeys(def_name);
		driver.findElement(addButton).click();
		return new Pilr_Config_Builder(driver);
	}
	
	//return ema config defs welcome
	public String get_EMA_Config_Defs_Welcome(){
		return driver.findElement(importEMADefsWelcome).getText();
	}
	//put the ema config def file name in the input box and hit the import button
	public Pilr_Builder_Page import_EMA_Config_Def_File(String ema_def_file){
		driver.findElement(inputImportFName).click();
    	driver.findElement(inputImportFName).sendKeys(ema_def_file);
    	driver.findElement(importButton).click();
    	return new Pilr_Builder_Page(driver);
	}
}
