package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Update_Device_Modal {
	WebDriver driver;
	By updateGroupWelcome = By.cssSelector("div[class='table-header']");
	By saveButton = By.cssSelector("input[id='Save']");
	By doneButton = By.xpath("//div[2]/div[2]/button");
	By updateSuccess = By.cssSelector("div[class='table-header']");
	
	public Update_Device_Modal(WebDriver driver){
		this.driver = driver;
	}
	
	//return welcome message
	public String get_Device_Modal_Welcome(){
		return driver.findElement(updateGroupWelcome).getText();
	}
	//select and add devices to participants
	public void bulk_add_devices(){
		driver.findElement(saveButton).click();
	}
	//return success message
	public String Bulk_Update_Status(){
		return driver.findElement(updateSuccess).getText();
	}
	//close modal
	public Bulk_Edit_Participants_Page close_Update_Group_Modal(){
		driver.findElement(doneButton).click();
		return new Bulk_Edit_Participants_Page(driver);
	}

}
