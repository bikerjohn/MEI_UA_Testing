package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Add_Device_Modal extends AbstractBasePage {
	By addDeviceWelcome = By.cssSelector("h4");
	By loginID = By.cssSelector("input[id='activationName']");
	By createLogin = By.cssSelector("input[id='Create login credentials']");
	private String loginId;
	
	public Add_Device_Modal(WebDriver driver){
		super(driver);
	}
	//return the modal welcome message
	public String Get_addDevice_Welcome(){
		return findElement(addDeviceWelcome).getText();
	}
	//fill the login id field and hit the create button
	public Pilr_ParticipantPage createLoginID(String loginid){
		this.loginId = loginid;
		findElement(loginID).click();
		findElement(loginID).sendKeys(loginId);
		findElement(createLogin).click();
		return new Pilr_ParticipantPage(driver);
	}

}
