package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.Pilr_ParticipantPage;
import page_objects.Pilr_Participant_Setting;
import page_objects.Pilr_Upload_Select_File;
import page_objects.Pilr_Upload_Select_Handler;
import page_objects.Query_Project_Data;
import page_objects.Schedule_Participant_Modal;
import page_objects.Time_Wait;
import page_objects.Pilr_GroupPage;
import page_objects.Add_Device_Modal;
import page_objects.Delete_Data_Details_Page;
import page_objects.Delete_Data_Page;
import page_objects.Pilr_CoordinatePage;
import page_objects.Pilr_Create_Participant;

//this CLASS extends the AbstractTestCase which contains basic site
//navigation.  It will not run correctly if you attempt to run it directly 
//from Eclipse, as there are extra navigation steps in AbstractTestCase
//which will cause this test to be at the wrong page
//on the site when it starts.  Instead, this test case should be called from
//an xml file call Pilr_Verify_Coordinate_Page
//in there you will see a series of method calls that select only the 
//navigation methods necessary for this test case.
//methods are:
//<include name="SETUP" />
//<include name="TEST_LOGIN" />
//<include name="TEST_SELECT_PROJECT" /> CAPS INDICATES ABSTRACTTESTCASE METHOD
//<include name="test_Verify_NewParticipant_Page" />
//<include name="test_Verify_ViewGroups_Page" />
//<include name="test_View_Participant_Detail" />
//<include name="TEARDOWN" />
//Last update = 12/14/2015 by jjs


public class Test_Coordinate_Page extends AbstractTestCase {
    Pilr_Create_Participant objAddParticipant;
    Pilr_GroupPage objViewGroups;
    Pilr_ParticipantPage objParticipantPage;
    Schedule_Participant_Modal objScheduleParticipantModal;
    Add_Device_Modal objAddParticipantDevice;
    Time_Wait objTimeWait;
    Pilr_Upload_Select_Handler objUploadHandlerPage;
    Pilr_Upload_Select_File objUploadFilePage;
    Pilr_Participant_Setting objParticipantSetting;
    Delete_Data_Page objDeleteDataPage;
    Delete_Data_Details_Page objDeleteDataDetailsPage;
    Query_Project_Data objQueryDataPage;
   
    @Test (groups={"page_test"})
    public void test_Verify_NewParticipant_Page() {
    	
    	//select the Add Participant option
    	objAddParticipant = new Pilr_Create_Participant(driver);
    	objCoordinatePage.Create_Participant();
    	objTimeWait = new Time_Wait();
    	
    	System.out.println("[Test Case]Add Participant");
    	objTimeWait.Duration(3000);   	
    	Assert.assertTrue(objAddParticipant.getnewparticipantPageWelcome()
    			.toLowerCase().contains("new participant"));
    	System.out.println("[Test Case]New Participant Page Verified");
    	driver.navigate().back();
    }
    @Test
    //select the add participant option in the Action group
    public void test_Add_Participant_Action(){
    	objAddParticipant = new Pilr_Create_Participant(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objTimeWait = new Time_Wait();
    	
    	objCoordinatePage.Create_Participant();
    	objTimeWait.Duration(1000);
    	Assert.assertTrue(objAddParticipant.getnewparticipantPageWelcome().toLowerCase()
    			.contains("new participant"));
    }
    @Test
    //complete the fields in the add participant modal and hit save
    public void test_Create_New_Participant_Calorimeter_Human(){
    	objAddParticipant = new Pilr_Create_Participant(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objTimeWait = new Time_Wait();
    	
    	objAddParticipant.completeCreateParticipantForm(objtestvars.getCalHumanPartCode(), objtestvars.getPartDesc());
    }
    @Test
    //complete the fields in the add participant modal and hit save
    public void test_Create_New_Participant_Calorimeter_Infusion(){
    	objAddParticipant = new Pilr_Create_Participant(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objTimeWait = new Time_Wait();
    	
    	objAddParticipant.completeCreateParticipantForm(objtestvars.getCalInfusionPartCode(), objtestvars.getPartDesc());
    }
    @Test
    //complete the fields in the add participant modal and hit save
    public void test_Create_New_Participant_Calorimeter_Burn(){
    	objAddParticipant = new Pilr_Create_Participant(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objTimeWait = new Time_Wait();
    	
    	objAddParticipant.completeCreateParticipantForm(objtestvars.getCalBurnPartCode(), objtestvars.getPartDesc());
    }
    @Test
    //complete the fields in the add participant modal and hit save
    public void test_Create_New_Participant(){
    	objAddParticipant = new Pilr_Create_Participant(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objTimeWait = new Time_Wait();
    	
    	objAddParticipant.completeCreateParticipantForm(objtestvars.getPartCode(), objtestvars.getPartDesc());
    }
    @Test
    //Schedule the new participants active period
    public void test_Schedule_Participant_Active_Period(){
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objScheduleParticipantModal = new Schedule_Participant_Modal(driver);
    	objTimeWait = new Time_Wait();
    	
    	objParticipantPage.select_Participant_Schedule();
    	objTimeWait.Duration(2000);
    	objScheduleParticipantModal.get_Schedule_Participant_Welcome();
    	objScheduleParticipantModal.set_Participant_Start_Date();
    	objTimeWait.Duration(2000);
    }
    @Test
    //Schedule the new participants active period
    public void test_Schedule_Human_Participant(){
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objScheduleParticipantModal = new Schedule_Participant_Modal(driver);
    	objTimeWait = new Time_Wait();
    	
    	objParticipantPage.select_Participant_Schedule();
    	objTimeWait.Duration(2000);
    	objScheduleParticipantModal.get_Schedule_Participant_Welcome();
    	objScheduleParticipantModal.set_Past_Start_Date(objtestvars.get_human_start_date());
    	objTimeWait.Duration(2000);
    }
    @Test
    //Schedule the new participants active period
    public void test_Schedule_Infusion_Participant(){
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objScheduleParticipantModal = new Schedule_Participant_Modal(driver);
    	objTimeWait = new Time_Wait();
    	
    	objParticipantPage.select_Participant_Schedule();
    	objTimeWait.Duration(2000);
    	objScheduleParticipantModal.get_Schedule_Participant_Welcome();
    	objScheduleParticipantModal.set_Past_Start_Date(objtestvars.get_infusion_start_date());
    	objTimeWait.Duration(2000);
    }
    @Test
    //Schedule the new participants active period
    public void test_Schedule_Burn_Participant(){
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objScheduleParticipantModal = new Schedule_Participant_Modal(driver);
    	objTimeWait = new Time_Wait();
    	
    	objParticipantPage.select_Participant_Schedule();
    	objTimeWait.Duration(2000);
    	objScheduleParticipantModal.get_Schedule_Participant_Welcome();
    	objScheduleParticipantModal.set_Past_Start_Date(objtestvars.get_burn_start_date());
    	objTimeWait.Duration(2000);
    }
    @Test
    //Add a device to the new participants setup
    public void test_Add_Participant_Device(){
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objAddParticipantDevice = new Add_Device_Modal(driver);
    	objTimeWait=new Time_Wait();
    	
    	objParticipantPage.Add_Participant_Device();
    	objTimeWait.Duration(1000);
    	Assert.assertTrue(objAddParticipantDevice.Get_addDevice_Welcome().toLowerCase()
    			.contains("setup device activation information"));
    	objAddParticipantDevice.createLoginID(objtestvars.getUserName());
    	
    }
    
    @Test (groups={"page_test"})
    public void test_Verify_ViewGroups_Page() {
    	
    	//select the Add Participant option
    	objViewGroups = new Pilr_GroupPage(driver);
    	objCoordinatePage.selectViewGroups();
    	objTimeWait = new Time_Wait();
    	
    	objTimeWait.Duration(3000); 
    	Assert.assertTrue(objViewGroups.getGroupPageWelcome()
    			.toLowerCase().contains("participant category memberships"));
    	System.out.println("[Test Case]View Groups Page Verified");
    	driver.navigate().back();
    }
    
    @Test (groups={"page_test"})
    public void test_View_Participant_Detail() {
    	
    	//select the Participant link
    	//need to change this to right code
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objCoordinatePage.selectParticipant(objtestvars.getPartCode());
    	objTimeWait = new Time_Wait();
    	
    	objTimeWait.Duration(5000); 
    	Assert.assertTrue(objParticipantPage.getparticipantPageWelcome()
    			.toLowerCase().contains("participant "+objtestvars.getPartCode()));
    	System.out.println("[Test Case]Participant Page Verified");
    }
    // Navigate to Upload a File page from participant page
    @Test
    public void test_Select_Upload_File() {
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objUploadHandlerPage = new Pilr_Upload_Select_Handler(driver);
    	
    	objParticipantPage.Select_Upload_File();
    }
    @Test
    public void test_Upload_Human_Data() {
    	objUploadHandlerPage = new Pilr_Upload_Select_Handler(driver);
    	objUploadFilePage = new Pilr_Upload_Select_File(driver);
    	objtestvars = new TestVars();
		
		// Select CalRQ handler and click next
    	objUploadHandlerPage.select_calrq_handler(0);
    	
    	// Enter file location (set by system in TestVars)
    	objUploadFilePage.enter_upload_file(objtestvars.get_calrq_human_data());
    	
    	// Use date range selector
    	objUploadFilePage.enterDateRange("06/22/2015 - 06/23/2015");
    	objUploadFilePage.importFile();
    	
    	objQueryDataPage = new Query_Project_Data(driver);
    	// Wait 120 seconds for file to upload/process
    	try {
			Thread.sleep(180000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	objQueryDataPage.select_File();
    	
    	Assert.assertTrue(objQueryDataPage.getFileOutputMessage()
    			.toLowerCase().contains("successfully parsed"));    	
    	
    	System.out.println("[Test Case]Human Data File Upload Successful");
    }
    @Test
    public void test_Upload_Infusion_Data() {
    	objUploadHandlerPage = new Pilr_Upload_Select_Handler(driver);
    	objUploadFilePage = new Pilr_Upload_Select_File(driver);
    	objtestvars = new TestVars();
		
		// Select CalRQ handler and click next
    	objUploadHandlerPage.select_calrq_handler(0);
    	
    	// Enter file location (set by system in TestVars)
    	objUploadFilePage.enter_upload_file(objtestvars.get_calrq_infusion_data());
    	objUploadFilePage.periodSelector();
    	objUploadFilePage.importFile();
    	
    	objQueryDataPage = new Query_Project_Data(driver);
    	// Wait 120 seconds for file to upload/process
    	try {
			Thread.sleep(180000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	objQueryDataPage.select_File();
    	
    	Assert.assertTrue(objQueryDataPage.getFileOutputMessage()
    			.toLowerCase().contains("successfully parsed")); 
    	
    	System.out.println("[Test Case]Infusion Data File Upload Successful");
    }
    @Test
    public void test_Upload_Burn_Data() {
    	objUploadHandlerPage = new Pilr_Upload_Select_Handler(driver);
    	objUploadFilePage = new Pilr_Upload_Select_File(driver);
    	objtestvars = new TestVars();
		
		// Select CalRQ handler and click next
    	objUploadHandlerPage.select_calrq_handler(0);
    	
    	// Enter file location (set by system in TestVars)
    	objUploadFilePage.enter_upload_file(objtestvars.get_calrq_burn_data());
    	objUploadFilePage.periodSelector();
    	objUploadFilePage.importFile();
    	
    	objQueryDataPage = new Query_Project_Data(driver);
    	// Wait 120 seconds for file to upload/process
    	try {
			Thread.sleep(180000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	objQueryDataPage.select_File();
    	
    	Assert.assertTrue(objQueryDataPage.getFileOutputMessage()
    			.toLowerCase().contains("successfully parsed")); 
    	
    	System.out.println("[Test Case]Burn Data File Upload Successful");
    }
    @Test
    public void test_Set_Human_Settings() {
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objParticipantSetting = new Pilr_Participant_Setting(driver);
    	
    	objParticipantPage.navCalrqVariables();
    	
    	objParticipantPage.navMultipleN2Setting();
    	objParticipantSetting.setHumanMultipleN2();
    }
    @Test
    public void test_Set_Infusion_Settings() {
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objParticipantSetting = new Pilr_Participant_Setting(driver);
    	
    	objParticipantPage.navCalrqSettings();
    	
    	objParticipantPage.navCO2Setting();
    	objParticipantSetting.setMFC1();
    	
    	objParticipantPage.navN2Setting();
    	objParticipantSetting.setMFC1();
    }
    @Test
    public void test_Set_Burn_Settings() {
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objParticipantSetting = new Pilr_Participant_Setting(driver);
    	
    	objParticipantPage.navCalrqSettings();
    	
    	objParticipantPage.navConfigSetting();
    	objParticipantSetting.setPullDifferential();

    	objParticipantPage.navGasSetting();
    	objParticipantSetting.setPropane();
    }
    @Test
    public void test_Nav_Delete_Data(){
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objDeleteDataPage = new Delete_Data_Page(driver);
    	
    	objCoordinatePage.select_Delete_Data();
    	Assert.assertTrue(objDeleteDataPage.getdeleteDataPageWelcome()
    			.toLowerCase().contains("dataset history"));
    	}
    @Test public void test_Nav_Calrq_Delete_Data() {
    	objDeleteDataPage = new Delete_Data_Page(driver);
    	objDeleteDataDetailsPage = new Delete_Data_Details_Page(driver);
    	
    	objDeleteDataPage.select_calrq_data();
    	Assert.assertTrue(objDeleteDataDetailsPage.getdeleteDataDetailsPageWelcome()
    			.toLowerCase().contains("calrq data"));
    }
    @Test public void test_Nav_Haldane_Delete_Data() {
    	objDeleteDataPage = new Delete_Data_Page(driver);
    	objDeleteDataDetailsPage = new Delete_Data_Details_Page(driver);
    	
    	objDeleteDataPage.select_haldane_data();
    	Assert.assertTrue(objDeleteDataDetailsPage.getdeleteDataDetailsPageWelcome()
    			.toLowerCase().contains("calrq data"));
    }
    @Test public void test_Attempt_Delete_Calrq_Data() {
    	objDeleteDataDetailsPage = new Delete_Data_Details_Page(driver);
    	objDeleteDataDetailsPage.delete_row2_data();
    	
    	Assert.assertTrue(objDeleteDataDetailsPage.get_warning_message()
    			.toLowerCase().contains("this dataset is used to derive"));
    	
    	objDeleteDataDetailsPage.back_nav();
    }
    @Test public void test_Delete_Haldane_Data() {
    	objDeleteDataDetailsPage = new Delete_Data_Details_Page(driver);
    	objDeleteDataDetailsPage.delete_row1_data();
    	
    	objDeleteDataDetailsPage.back_nav();
    }
}
