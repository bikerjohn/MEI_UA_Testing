package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Bulk_Edit_Participants_Page extends AbstractBasePage {
	By bulkEditPageWelcome = By.cssSelector("li[class='white bigger-150']");
	By selectTemplateAssignment = By.cssSelector("select[id='search.templateAssignment']");
	By selectAllCheckbox = By.cssSelector("input[id='editSelectAll']");
	By selectEditButton	= By.cssSelector("button[id='dataTableEdit']");
	By selectEditGroups = By.cssSelector("a[id='editGroupsModalTrigger']");
	By selectEditDevices = By.cssSelector("a[id='editDevicesModalTrigger']");
	By selectEditSchedule = By.cssSelector("a[id='editScheduleParticipantActivePeriodModalTrigger']");

	public Bulk_Edit_Participants_Page(WebDriver driver){
		super(driver);
	}

	//return welcome text
	public String get_bulk_Edit_Welcome(){
		return findElement(bulkEditPageWelcome).getText();
	}
	//select edit all checkbox
	public void select_Edit_All_Checkbox(){
		findElement(selectAllCheckbox).click();
	}
	//select default template in template assignments column
	public void select_Default_Assignment_Column(String defaultassignments){
		WebElement selector = findElement(selectTemplateAssignment);
		selector.click();
		selector.sendKeys(defaultassignments + "\r");
	}
	//select Edit Button
	public void select_Edit_Button(){
//		findElement(selectEditButton).click();
		findElement(selectEditButton, 5000).click();
	}
	//select Groups li under Edit Button (creates Bulk Update Group modal)
	public Update_Group_Modal select_Edit_Groups(){
		findElement(selectEditGroups).click();
		return new Update_Group_Modal(driver);
	}
	//select Groups li under Edit Button (creates Bulk Update Group modal)
		public Update_Device_Modal select_Edit_Devices(){
			findElement(selectEditDevices).click();
			return new Update_Device_Modal(driver);
		}
	//select Schedule li under Edit Button (creates Bulk Update Schedule modal)
	public Update_Schedule_Modal select_Edit_Schedule(){
		findElement(selectEditSchedule).click();
		return new Update_Schedule_Modal(driver);
	}

}
