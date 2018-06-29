package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Bulk_Add_Participants_Page extends AbstractBasePage {
	By bulkAddParticipantsWelcome = By.cssSelector("h4");
	By importFileName = By.cssSelector("input[id='importFile']");
	By importButton = By.cssSelector("button[id='next']");
	By importMessage = By.cssSelector("div[class='alert alert-success']");
	By closePage = By.cssSelector("i[class='icon-remove']");
	private String message="Bulk add participants finished.";

	public Bulk_Add_Participants_Page(WebDriver driver){
        super(driver);
	}

	//return the welcome message text
	public String getbulkAddParticipantsWelcome(){
		return findElement(bulkAddParticipantsWelcome).getText();
	}

	//select the import file input text box and populate it with the import file name
	//and hit the import button
	public void bulk_add_Participants(String filename){
		findElement(importFileName).clear();
		findElement(importFileName).sendKeys(filename);
		findElement(importButton).click();
	}
	//return the message indicating import status
	public String getImportFileMessage(){
		return findElement(importMessage).getText();
	}
	//close the import message bar
	public void close_Page(){
		findElement(closePage).click();
	}

}
