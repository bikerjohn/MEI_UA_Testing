package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Builder_EMAConfig_Page extends AbstractBasePage {
	
	//Their are 2 actions on this page -- name the Configuration, and click the Save button
	By emaConfig_Page_Welcome = By.cssSelector("div[class='widget-header']");
	By emaConfigName = By.cssSelector("input[name='name']");
	By saveButton = By.cssSelector("input[name='Save']");
	private String EmaConfigName = "test_config";
	
	public Builder_EMAConfig_Page(WebDriver driver){
		super(driver);
	}
	//get the Builder EMAConfig Welcome message
	public String getEmaConfigBuilderWelcome(){
		return findElement(emaConfig_Page_Welcome).getText();
	}
	//need a method to set the value of EMAConfigName
	public void setEMAConfigName(String EMAName){
		findElement(emaConfigName).clear();
		findElement(emaConfigName).sendKeys(EMAName);
	}
	//need a method to be fill in the name field and then to click the submit button
	public Pilr_Builder_Page createEMAConfig(String EMAName){
		this.setEMAConfigName(EMAName);
		findElement(saveButton).click();
		return new Pilr_Builder_Page(driver);
	}
}
