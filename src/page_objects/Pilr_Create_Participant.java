package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Create_Participant extends AbstractBasePage {

	//Need locators for
	By newParticipantPageWelcome = By.cssSelector("h4");
	By participantCode = By.cssSelector("input[id='code']");
	By participantDescription = By.cssSelector("input[id='description']");
	By saveButton = By.cssSelector("input[id='save']");
	private String part_Description;
	private String part_Code;
	//Participant Code
	//Description
	//Participant Group
	//Template Assignment

	public Pilr_Create_Participant(WebDriver driver){

        super(driver);
	   }
	//Get the Create Participant Welcome
    public String getnewparticipantPageWelcome(){
        return    findElement(newParticipantPageWelcome).getText();
    }
    //fill the form and hit the save key (need Strings for Code and Description)
    public Pilr_ParticipantPage completeCreateParticipantForm(String p_Code, String p_Description){
    	this.part_Code = p_Code;
    	this.part_Description = p_Description;
    	findElement(participantCode).click();
    	findElement(participantCode).sendKeys(p_Code);
    	findElement(participantDescription).click();
    	findElement(participantDescription).sendKeys(p_Description);
    	findElement(saveButton).click();
    	return new Pilr_ParticipantPage(driver);
    }

}
