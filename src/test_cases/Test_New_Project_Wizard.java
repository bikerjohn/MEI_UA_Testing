package test_cases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_objects.Pilr_CoordinatePage;
import page_objects.Pilr_Project_Settings_Page;
import page_objects.Pilr_Project_Wizard;
import page_objects.Project_Import_Modal;
import page_objects.Project_Wizard_Config_Options;
import page_objects.Project_Wizard_Duration;


public class Test_New_Project_Wizard extends AbstractTestCase {
	Pilr_Project_Wizard objProjectWizard;
	Project_Wizard_Config_Options objProjectConfig;
	Project_Wizard_Duration objProjectDuration;
	Pilr_Project_Settings_Page objProjectSettings;
	Project_Import_Modal objImportInstrumentModal;
	Pilr_CoordinatePage objCoordinatePage;
	
	@Test
    public void test_Name_New_Project(){
    	objProjectWizard = new Pilr_Project_Wizard(driver);

		makeFreshNewProjectName();

    	//verify that we landed on survey response page
    	Assert.assertTrue(objProjectWizard.getProjWizardPageWelcome().toLowerCase()
    			.contains("new project wizard"));
    	//start the project creation process by naming it
//    	makeFreshNewProjectName();
    	objProjectWizard.createProject(new_project_name);
    	//update the new project name in the TestVars object
    	objtestvars.setnewProject(new_project_name);
    }
	@Test
	public void test_Select_New_Project_Config_From_Scratch(){
		objProjectConfig = new Project_Wizard_Config_Options(driver);
		Assert.assertTrue(objProjectConfig.getConfigOptionsWelcome().toLowerCase()
    			.contains("setup the project design"));
		//select the Build from Scratch option
		objProjectConfig.selectBuildFromScratch();
		objProjectConfig.selectNext();
	}
	@Test
	public void test_Set_New_Project_Duration(){
		objProjectDuration = new Project_Wizard_Duration(driver);
		//Assert.assertTrue(objProjectDuration.getDurationWelcome().toLowerCase()
    	//		.contains("a little more help to get started quicker"));
		//select the Finish button to finish creating a project
		objProjectDuration.selectFinish();
	}
	@Test
	public void test_Select_Project_Settings(){
		objProjectSettings = new Pilr_Project_Settings_Page(driver);
		objCoordinatePage = new Pilr_CoordinatePage(driver);
		Assert.assertTrue(objCoordinatePage.getcoordinatePageWelcome().toLowerCase()
				.contains("coordinate participants and data"));
		//select the Import option in the Instrument Div
		objCoordinatePage.selectProjectSettings();
	}
	@Test
	public void test_Select_Import_Instrument(){
		Assert.assertTrue(objProjectSettings.getprojectSettingsWelcome()
				.toLowerCase().contains("add, edit, or remove the components used on this project"));
		objProjectSettings.selectInstrumentImport();
	}
	@Test
	public void test_Select_Import_Bundle(){
		Assert.assertTrue(objProjectSettings.getprojectSettingsWelcome()
				.toLowerCase().contains("add, edit, or remove the components used on this project"));
		objProjectSettings.selectBundleImport();
	}
	@Test
	public void test_Import_Instrument_JSON_from_Raw() {
		objImportInstrumentModal = new Project_Import_Modal(driver);
		try {
    		Thread.sleep(5000); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
		Assert.assertTrue(objImportInstrumentModal.getProjectImportModalWelcome()
			.toLowerCase().contains("import instruments"));
		objImportInstrumentModal.importInstrumentfromURL(objtestvars.getInstrumentURL());
		Assert.assertTrue(objProjectSettings.getprojectSuccessMsg()
				.toLowerCase().contains("project components were added successfully"));
	}
	@Test
	public void test_Import_Calorimeter_JSON_from_Raw() {
		objImportInstrumentModal = new Project_Import_Modal(driver);
		try {
    		Thread.sleep(5000); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
		Assert.assertTrue(objImportInstrumentModal.getProjectImportModalWelcome()
			.toLowerCase().contains("import bundle"));
		objImportInstrumentModal.importInstrumentfromURL(objtestvars.getCalorimeterURL());
		Assert.assertTrue(objProjectSettings.getprojectSuccessMsg()
				.toLowerCase().contains("project components were added successfully"));
	}
	@Test
	public void test_Import_Instrument_JSON_from_Raw_Liad() {
		objImportInstrumentModal = new Project_Import_Modal(driver);
		try {
			System.out.println("Before sleep\n");
    		Thread.sleep(5000); 
    	}
    	catch(InterruptedException ex) {
    		System.out.println("Exception handler\n");
    		Thread.currentThread().interrupt();
    	}
		System.out.println(objImportInstrumentModal.getProjectImportModalWelcome2()
			.toLowerCase());
		Assert.assertTrue(objImportInstrumentModal.getProjectImportModalWelcome2()
			.toLowerCase().contains("select components from the marketplace."));
		objImportInstrumentModal.importInstrumentfromURL(objtestvars.getLiadInstrumentURL());
		Assert.assertTrue(objProjectSettings.getprojectSuccessMsg()
				.toLowerCase().contains("project components were added successfully"));
	}
	@Test
	//select the Import Component from Organization to Import Instrument
	public void test_Import_EMA_Instrument_From_Organization(){
		objProjectConfig = new Project_Wizard_Config_Options(driver);
		objImportInstrumentModal = new Project_Import_Modal(driver);
		
		Assert.assertTrue(objProjectConfig.getConfigOptionsWelcome().toLowerCase()
				.contains("setup the project design"));
		objProjectConfig.select_Import_From_Organization();
		objProjectConfig.import_Component_From_Organization(objtestvars.get_Import_Component_li());
	}
	@Test
	//select the Import Component from Organization to import Bundle
	public void test_Import_Project_Bundle_From_Organization(){
		objProjectConfig = new Project_Wizard_Config_Options(driver);
		objImportInstrumentModal = new Project_Import_Modal(driver);
		
		Assert.assertTrue(objProjectConfig.getConfigOptionsWelcome().toLowerCase()
				.contains("setup the project design"));
		objProjectConfig.select_Import_From_Organization();
		objProjectConfig.import_Component_From_Organization(objtestvars.get_Import_Bundle_li());
	}
	
}
 