package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Export_EMA_Defs_Modal extends AbstractBasePage {
	/*By inputImportFName = By.cssSelector("input[id='importFile']");
	By importButton = By.cssSelector("button[id='next']");
	By importEMADefsWelcome = By.cssSelector("h4");
	*/
	public Export_EMA_Defs_Modal(WebDriver driver){
        super(driver);
	}
	/*
	//return ema config defs welcome
	public String get_EMA_Config_Defs_Welcome(){
		return findElement(importEMADefsWelcome).getText();
	}
	//put the ema config def file name in the input box and hit the import button
	public Pilr_Builder_Page import_EMA_Config_Def_File(String ema_def_file){
		findElement(inputImportFName).click();
    	findElement(inputImportFName).sendKeys(ema_def_file);
    	findElement(importButton).click();
    	return new Pilr_Builder_Page(driver);
	}*/
}
