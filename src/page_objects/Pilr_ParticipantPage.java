package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_ParticipantPage extends AbstractBasePage {
	 
	   By participantPageWelcome = By.cssSelector("h1");
	   By scheduleParticipant = By.cssSelector("a[id='startDateParticipantActivePeriod']");
	   By addDeviceTab = By.cssSelector("a[title='Devices']");
	   By settingsTab = By.cssSelector("a[title='Settings']");
	   By variablesTab = By.cssSelector("a[title='Variables']");
	   By calrqSettings = By.cssSelector("a[title='CalRQ']");
	   By addDeviceLink = By.cssSelector("a[id='deviceActivation']");
	   By uploadFileButton = By.cssSelector("a[id='uploadParticipantFiles']");
	   By co2MfcSetting = By.xpath("//tr[2]/td[2]/form/input[4]");
	   By n2MfcSetting = By.xpath("//tr[7]/td[2]/form/input[4]");
	   By configSetting = By.xpath("//tr[3]/td[2]/form/input[4]");
	   By gasSetting = By.xpath("//tr[4]/td[2]/form/input[4]");
	   By multipleN2Setting = By.xpath("//ol[2]/li/ol/li/div/table/tbody/tr[8]/td[2]/form/input[4]");
	   
	   

	   public Pilr_ParticipantPage(WebDriver driver){
		   super(driver);
	   }
	   
	 	//Get the Coordinate Page Welcome
	    public String getparticipantPageWelcome(){
	        return    driver.findElement(participantPageWelcome).getText();
	    }
	    //schedule the participant active period
	    public Schedule_Participant_Modal select_Participant_Schedule(){
	    	findElement(scheduleParticipant).click();
	    	return new Schedule_Participant_Modal(driver);
	    }
	    //add a device for a participant
	    public Add_Device_Modal Add_Participant_Device(){
	    	driver.findElement(addDeviceTab).click();
	    	driver.findElement(addDeviceLink).click();
	    	return new Add_Device_Modal(driver);
	    }
	    // click on upload a file button
	    public Pilr_Upload_Select_Handler Select_Upload_File() {
	    	driver.findElement(uploadFileButton).click();
	    	return new Pilr_Upload_Select_Handler(driver);
	    }
	    // Navigate to Calrq settings
	    public void navCalrqSettings() {
	    	driver.findElement(settingsTab).click();
	    	driver.findElement(calrqSettings).click();
	    }
	    // Navigate to Calrq variables
	    public void navCalrqVariables() {
	    	driver.findElement(variablesTab).click();
	    }
	    public Pilr_Participant_Setting navCO2Setting() {
	    	driver.findElement(co2MfcSetting).click();
	    	return new Pilr_Participant_Setting(driver);
	    }
	    public Pilr_Participant_Setting navN2Setting() {
	    	driver.findElement(n2MfcSetting).click();
	    	return new Pilr_Participant_Setting(driver);
	    }
	    public Pilr_Participant_Setting navConfigSetting() {
	    	driver.findElement(configSetting).click();
	    	return new Pilr_Participant_Setting(driver);
	    }
	    public Pilr_Participant_Setting navGasSetting() {
	    	driver.findElement(gasSetting).click();
	    	return new Pilr_Participant_Setting(driver);
	    }
	    public Pilr_Participant_Setting navMultipleN2Setting() {
	    	driver.findElement(multipleN2Setting).click();
	    	return new Pilr_Participant_Setting(driver);
	    }
}
