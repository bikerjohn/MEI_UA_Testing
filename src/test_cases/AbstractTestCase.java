package test_cases;

import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import page_objects.Admin_Home_Page;
import page_objects.Delete_Project_Modal;
import page_objects.Import_EMA_Defs_Modal;
import page_objects.PilrHomePage;
import page_objects.PilrLogin;
import page_objects.Pilr_Builder_Page;
import page_objects.Pilr_Config_Builder;
import page_objects.Pilr_CoordinatePage;
import page_objects.Pilr_EMA_App_Home;
import page_objects.Pilr_Navbar;
import page_objects.Pilr_Org_Page;
import page_objects.Pilr_Project_Design;
import page_objects.Pilr_Project_Settings_Page;
import page_objects.Pilr_Project_Wizard;
import page_objects.Pilr_Survey_ResponsePage;
import page_objects.Project_Details_Admin;

public class AbstractTestCase {

	WebDriver driver;
	PilrLogin objLogin;
    PilrHomePage objHomePage;
    Admin_Home_Page objAdminHomePage;
    Project_Details_Admin objProjectDetailsAdmin;
    Pilr_Navbar navbar;
    Pilr_CoordinatePage objCoordinatePage;
    Pilr_EMA_App_Home objEMAAppPage;
	TestVars objtestvars;
	Pilr_Builder_Page objEMABuilderPage;
	Pilr_Config_Builder objConfigBuilder;
	Pilr_Survey_ResponsePage objSurvResponsePage;
	Pilr_Org_Page objOrgPage;
	Pilr_Project_Wizard objProjWizard;
	Pilr_Project_Settings_Page objProjectSettings;
	Pilr_Project_Design objProjectDesign;
	Delete_Project_Modal objDeleteProjectModal;
	String new_project_name = "test"+ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
	String pilr_org;
	//String ag_Health;
	
	Import_EMA_Defs_Modal objImportModal;

	public AbstractTestCase() {
		super();
	}
	
	@BeforeSuite
	public void loadProperties () { 
		// Read mei.properties from classpath
		InputStream in = ClassLoader.getSystemResourceAsStream("mei.properties");
		if (in ==  null) {
			throw new RuntimeException("can't load mei.properites");
		}
		try {
			System.getProperties().load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}

	//THIS 
	@Test(priority=0)
	public void setup() throws Exception {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));

		setEnvironment();
		
		driver = new ChromeDriver();
	    //driver = new FirefoxDriver();
	    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //driver.manage().window().maximize();
	    //driver.get("https://staging.pilrhealth.com/");
	    //driver.get("https://qa.pilrhealth.com/");
	    //objtestvars = new TestVars();
	    //final Logger log = Logger.getLogger(AbstractTestCase.class);
		
        String baseUrl = System.getProperty("pilr.base_url");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("Title : " + driver.getTitle());
      
	}
	
	private void setEnvironment() {
		objtestvars = new TestVars();
		objtestvars.set_EMA_Config_Defs(System.getProperty("ema.config.json"));
		objtestvars.set_Activity_File(System.getProperty("ema.activity"));
		objtestvars.set_calrq_burn_data(System.getProperty("calrq.burn_data_file"));
		objtestvars.set_calrq_infusion_data(System.getProperty("calrq.infusion_data_file"));
		objtestvars.set_calrq_human_data(System.getProperty("calrq.human_data_file"));
		objtestvars.setUserName(System.getProperty("pilr.user.name"));
		objtestvars.setPassWrd(System.getProperty("pilr.user.password"));
		objtestvars.org = System.getProperty("pilr.org");
	}

	private void setEnvironment_OLD() {
		String matt = "/Users/matt/Documents/workspace/Copy of Selenium_WebDriver_Testing";
		String john = "C:/serv/mei/MEI_UA_Testing/";
		String tyler = "/home/tyler/Github/MEI_UA_Testing";

		
		//Check if it's Matt's system via string comparison
		if((System.getProperty("user.dir")).equals(matt)){
			
			//Matt
			System.setProperty("webdriver.chrome.driver", "/Users/matt/Desktop/MEI/chromedriver");
			
			//Set path related variables
			objtestvars = new TestVars();
			//objtestvars.set_import_File_Name("/Users/matt/Desktop/MEI/bulk_participants.csv");
			objtestvars.set_EMA_Config_Defs("/Users/matt/Desktop/MEI/ema-configs-standard-surveys-wtriggers.json");
			
			//System.out.println(objtestvars.get_import_File_Name());
			System.out.println(objtestvars.get_EMA_Config_Defs());
			System.out.println("Matt's System");
		}
		else if((System.getProperty("user.dir")).equals(john)){
			
			//John
			System.setProperty("webdriver.chrome.driver", "C:/Users/eagle/Program Files/chromedriver_win32/chromedriver.exe");
			
			//Set path related variables
			objtestvars = new TestVars();
			//objtestvars.set_import_File_Name("C:\\srv\\mei\\bulk_participants.csv");
			objtestvars.set_EMA_Config_Defs("C:\\srv\\mei\\emacontent\\ema-configs-standard-surveys-wtriggers.json");
			System.out.println("John's System");
			
		}
		else if((System.getProperty("user.dir")).equals(tyler)){
			
			//Tyler
			System.setProperty("webdriver.chrome.driver", "/home/tyler/UA_Testing_Files/chromedriver");
			
			//Set path related variables
			objtestvars = new TestVars();
			//objtestvars.set_import_File_Name("/Users/matt/Desktop/MEI/bulk_participants.csv");
			objtestvars.set_EMA_Config_Defs("/home/tyler/UA_Testing_Files/ema-configs-standard-surveys-wtriggers.json");
			System.out.println("Tyler's System");

		}
	}
	@Test(priority=0)
	public void setup1() throws Exception {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		
		String matt = "/Users/matt/Documents/workspace/Copy of Selenium_WebDriver_Testing";
		String john = "C:/serv/mei/MEI_UA_Testing/";
		String tyler = "/home/tyler/Github/MEI_UA_Testing";

		
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
		
        driver = new RemoteWebDriver(
        new URL("http://localhost:4444/wd/hub"), 
        capabilities);
				
        String baseUrl = "https://qa.pilrhealth.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("Title : " + driver.getTitle());
        String browserName = capabilities.getBrowserName().toLowerCase();
        System.out.println("Browser : " + browserName);
      
	}
    @Test(priority=0)
    public void test_Login(){
    	
    	//Create Login Page object
    	objLogin = new PilrLogin(driver);
    
    	System.out.println("Here2");
    	//Verify login page title
    	String loginPageTitle = objLogin.getPageSource();
    	Assert.assertTrue(loginPageTitle.toLowerCase().contains("sign in"));

 
    	//login to application
    	objLogin.loginToPilr(objtestvars.getUserName(), 
    			objtestvars.getPassWrd());
 
    	// go the next page
    	objHomePage = new PilrHomePage(driver);
 
    	System.out.println(objHomePage.getHomePageWelcome().toLowerCase());
    	//Verify home page
		Assert.assertTrue(objHomePage.getHomePageWelcome().contains(
				objtestvars.getUserName()));
    	
    	System.out.println("[Test Case]Home Page Verified");
    	//System.out.println(a);
    	
    }
    @Test
    public void test_Login_Admin(){
    	
    	//Create Login Page object
    	objLogin = new PilrLogin(driver);
    
    	//Verify admin login page title
    	String loginPageTitle = objLogin.getPageSource();
    	Assert.assertTrue(loginPageTitle.toLowerCase().contains("sign in"));
    	//System.out.println(loginPageTitle.toLowerCase());
    	
    	//Override username and password to admin ones
    	objtestvars.setUserName("admin");
    	
    	//Check that name was properly set
    	Assert.assertTrue((objtestvars.getUserName()).equals("admin"));
    	//System.out.println(objtestvars.getUserName());
    	
    	//Override password
    	objtestvars.setPassWrd("password");
    	
    	//Check that pass was properly set
    	Assert.assertTrue((objtestvars.getPassWrd()).equals("password"));
    	//System.out.println(objtestvars.getPassWrd());
    	
    	//login to application
    	objLogin.loginToPilr(objtestvars.getUserName(), 
    			objtestvars.getPassWrd());
 
    	// go the next page
    	objAdminHomePage = new Admin_Home_Page(driver);
 
    	//Verify home page
    	//System.out.println(objHomePage.getHomePageWelcome().toLowerCase());
    	Assert.assertTrue(objAdminHomePage.getHomePageWelcome().toLowerCase().contains(
    		"system summary and access control"));
    	System.out.println("[Test Case]Home Page Verified");
    	
    }
	@Test
	public void test_Select_New_Project_Name(){
		//Select the new project created in the Create Project From Scratch Test Case
		objHomePage = new PilrHomePage(driver);
		objCoordinatePage = new Pilr_CoordinatePage(driver);
		
		//Selects new project
		objHomePage.selectProject(new_project_name);
		Assert.assertTrue(objCoordinatePage.getcoordinatePageWelcome().toLowerCase()
				.contains("coordinate participants and data"));
	}
	@Test
	public void test_Select_New_Project_Name_Admin(){
		objAdminHomePage = new Admin_Home_Page(driver);
    	
    	//Check on Admin home
    	//System.out.println(objAdminHomePage.getHomePageWelcome().toLowerCase());
    	Assert.assertTrue(objAdminHomePage.getHomePageWelcome().toLowerCase()
    			.contains("system summary and access control"));
    	
        //select the Project link based on the testvars project value
    	objAdminHomePage.selectProject(new_project_name);
	}
    @Test 
    public void test_Select_Project() {
    	objHomePage = new PilrHomePage(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	
    	Assert.assertTrue(objHomePage.getHomePageWelcome().toLowerCase()
    			.contains("welcome back, bikerjohn!"));
    	
    	//expand the org group for this project
    	objHomePage.expandOrg(objtestvars.getExistingOrg());
        //select the Project link based on the testvars project value
    	objHomePage.selectProject(objtestvars.getProject());
    	try {
    		Thread.sleep(10000); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
    }
    @Test 
    public void test_Select_Project_Dropdown() {
    	objAdminHomePage = new Admin_Home_Page(driver);
    	//objCoordinatePage = new Pilr_CoordinatePage(driver);
    	//Assert.assertTrue(objAdminHomePage.getHomePageWelcome().toLowerCase()
    	//		.contains("system summary and access control"));
    	
    	//Click dropdown for projects
    	objAdminHomePage.projDropdown();
    	//Select a project
    	objAdminHomePage.projDropdownSelect();
    	try {
    		Thread.sleep(10000); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
    	
    	//objCoordinatePage.selectProjectSettings();
    }
    
    @Test 
    public void test_Select_Project_Admin() {
    	objAdminHomePage = new Admin_Home_Page(driver);
    	
    	//Check on Admin home
    	//System.out.println(objAdminHomePage.getHomePageWelcome().toLowerCase());
    	Assert.assertTrue(objAdminHomePage.getHomePageWelcome().toLowerCase()
    			.contains("system summary and access control"));
    	
        //select the Project link based on the testvars project value
    	objAdminHomePage.selectProject(objtestvars.getProject());
    	try {
    		Thread.sleep(10000); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
    	System.out.println("Made it here");
    }
    @Test 
    public void test_Select_New_Project() {
    	objHomePage = new PilrHomePage(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	
    	//Double check welcome
    	Assert.assertTrue(objHomePage.getHomePageWelcome().toLowerCase()
    			.contains("welcome back, bikerjohn!"));
    	
        //select the Project link based on the testvars project value
    	objHomePage.selectProject(objtestvars.getNewProject());
    }	
    @Test 
    public void test_Select_EMA_Instrument() {
    	objEMAAppPage = new Pilr_EMA_App_Home(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	System.out.println(objCoordinatePage.getcoordinatePageWelcome()
    			.toLowerCase());
    	Assert.assertTrue(objCoordinatePage.getcoordinatePageWelcome()
    			.toLowerCase().contains(
    			"coordinate participants and data"));
    	System.out.println("[Test Case]Coordinate Page Verified");
    	  	
    	//select the Instrument link 
    	objCoordinatePage.selectEMAInstrument();
    	System.out.println("[Test Case]Select Instrument");
    	
        // verify that the correct project Coordinate Page is displayed
    	Assert.assertTrue(objEMAAppPage.getEMAAppPageWelcome()
    			.toLowerCase().contains(
    			"participant summaries"));
    	
    }
    @Test 
    public void test_Select_Instrument_Import() {
    	objProjectSettings = new Pilr_Project_Settings_Page(driver);
    	
    	//Select instrument for import
    	System.out.println(objProjectSettings.getprojectSettingsWelcome().toLowerCase());
    	//Assert.assertTrue(objProjectSettings.getprojectSettingsWelcome().toLowerCase().contains());
    	objProjectSettings.selectInstrumentImport();
    	
    }
    @Test
    public void test_Select_EMA_App_Page(){
    	objEMAAppPage = new Pilr_EMA_App_Home(driver);
    	objSurvResponsePage = new Pilr_Survey_ResponsePage(driver);
    	
    	//Verify location
    	String result = objEMAAppPage.getEMAAppPageWelcome();
    	
		Assert.assertTrue(result
    			.toLowerCase().contains(
    			"participant summaries"));
    }
    @Test
    public void test_Select_Survey_Response_Page(){
    	objSurvResponsePage = new Pilr_Survey_ResponsePage(driver);
    	objEMAAppPage = new Pilr_EMA_App_Home(driver);
    	
    	//navigate to survey response page
    	objEMAAppPage.selectSurvResponse();
    	
    	//verify that we landed on survey response page
    	Assert.assertTrue(objSurvResponsePage.getSurvey_ResponsePageWelcome().toLowerCase()
    			.contains(" view participant survey responses"));
    	objCoordinatePage.browseData();	
    }
    @Test
    public void test_Select_EMA_Builder_Page(){
    	objEMABuilderPage = new Pilr_Builder_Page(driver);
    	//navigate to survey response page
    	objEMAAppPage.selectEMABuilder();
    	//verify that we landed on the EMA Builder page
    	Assert.assertTrue(objEMABuilderPage.getBuilderPageWelcome2().toLowerCase()
    			.contains("ema configurations"));
    }
    @Test
    public void test_Select_Config_Ag(){
    	objEMABuilderPage = new Pilr_Builder_Page(driver);
    	//System.out.println("Here");
    	
    	objEMABuilderPage.selectEMAConfig("Ag_Health");
    }
    @Test
    public void test_Import_Activity_Database(){
    	objEMABuilderPage = new Pilr_Builder_Page(driver);
    	
    	//Import activity db steps
    	objEMABuilderPage.import_Activity_Database_Click();
    }
    @Test
    public void test_start_Activities(){
    	objEMABuilderPage = new Pilr_Builder_Page(driver);
    	objEMABuilderPage.start_Activities();
    	System.out.println("Shoulda worked");
    }
    @Test
    public void test_followUp_Surveys(){
    	objEMABuilderPage = new Pilr_Builder_Page(driver);
    	
    	//Creates a survey to be selected
    	objEMABuilderPage.create_followUp_Surveys();
    	objEMABuilderPage.selectEMAConfig("Ag_Health");
    	objEMABuilderPage.select_followUp_Surveys();
    }
    @Test
    public void test_Select_Add_Config_Builder_Page_AgHealth(){
    	objConfigBuilder = new Pilr_Config_Builder(driver);
    	objEMABuilderPage = new Pilr_Builder_Page(driver);
    	objImportModal = new Import_EMA_Defs_Modal(driver);
    	
    	objImportModal.add_NewConfig();
    	
    	System.out.println(objImportModal.get_EMA_Config_Defs_Welcome());
    	Assert.assertTrue(objImportModal.get_EMA_Config_Defs_Welcome().toLowerCase().contains("create an ema configuration"));
    	objImportModal.enter_NewConfig("Ag_Health");
    	objEMABuilderPage.verifyNewlyAdded("Ag_Health");
    	//objEMABuilderPage.selectEMAConfig("Ag_Health");
    }
   /* @Test
    public void test_Select_Add_Config_Builder_Page(){
    	objConfigBuilder = new Pilr_Config_Builder(driver);
    	objImportModal = new Import_EMA_Defs_Modal(driver);
    	objImportModal.add_NewConfig();
    	objImportModal.enter_NewConfig();
    }*/
    @Test
    public void test_Import_Config_Builder_Page(){
    	objConfigBuilder = new Pilr_Config_Builder(driver);
    	objImportModal = new Import_EMA_Defs_Modal(driver);
    	
    	//Import ema config
    	objImportModal.import_EMAConfig();
    	Assert.assertTrue(objImportModal.get_EMA_Config_Defs_Welcome().toLowerCase()
    			.contains("import ema configurations"));
    }
    @Test
    public void test_Import_Modal_Import_Ag(){
    	objConfigBuilder = new Pilr_Config_Builder(driver);
    	objImportModal = new Import_EMA_Defs_Modal(driver);
    	
    	
    	System.out.println(objImportModal.get_EMA_Config_Defs_Welcome().toLowerCase());
    	Assert.assertTrue(objImportModal.get_EMA_Config_Defs_Welcome().toLowerCase()
    			.contains("import ema configurations"));
    	
    	//objtestvars.set_EMA_Config_Defs("Ag_Health_Config");
    	//Assert.assertTrue(objtestvars.get_EMA_Config_Defs().toLowerCase().contains("ag_health_config"));
    	System.out.println(objtestvars.get_EMA_Config_Defs().toLowerCase());
    	Assert.assertTrue(objtestvars.get_EMA_Config_Defs().contains("/Users/matt/Desktop/MEI/ema-configs-standard-surveys-wtriggers.json"));
    	
    	//Import the config via modal
    	objImportModal.import_EMA_Config_Def_File(objtestvars.get_EMA_Config_Defs());
    	System.out.println("Success!");
    }
    @Test
    public void test_Select_Config_Builder_Page(){
    	objConfigBuilder = new Pilr_Config_Builder(driver);
    	
    	//navigate to survey response page
    	objEMABuilderPage.selectEMAConfig(objtestvars.getEmaConfig());
    	
    	//verify that we landed on the EMA Builder page
    	Assert.assertTrue(objConfigBuilder.getconfigbuilderPageWelcome().toLowerCase()
    			.contains("ema configuration builder"));
    }
    @Test
    public void test_Select_Organization_Page(){
    	objOrgPage = new Pilr_Org_Page(driver);
    	//navigate to organization page
    	objHomePage.selectOrganization(objtestvars.getOrg());
    	
    	//verify that we landed on the Organization page
    	Assert.assertTrue((objOrgPage.getOrgPageWelcome().toLowerCase()
    			.contains("organization settings")));
    }
    @Test
    public void test_Select_Organization_Page_Liad(){
    	objOrgPage = new Pilr_Org_Page(driver);
    	//navigate to organization page
    	objHomePage.selectOrganization(objtestvars.getLiadOrg());
    	
    	//verify that we landed on the Organization page
    	Assert.assertTrue((objOrgPage.getOrgPageWelcome().toLowerCase()
    			.contains("organization settings")));
    }
    @Test
    public void test_Create_Project(){
    	objProjWizard = new Pilr_Project_Wizard(driver);
    	
    	//navigate to organization page
    	objOrgPage.createProject();
    	
    	//verify that we landed on the Project Wizard Page
    	String welcome = objProjWizard.getProjWizardPageWelcome();
		Assert.assertTrue((welcome.toLowerCase().contains("new project wizard")));
    }
    @Test
    //navigate to the Project Design Page
    public void test_Nav_Project_Design(){
    	objProjectSettings = new Pilr_Project_Settings_Page(driver);
    	objProjectDesign = new Pilr_Project_Design(driver);
    	
    	//nav to project Design
    	objProjectSettings.nav_Project_Design();
    	
    	//verify we landed on the Project Settings Page
    	Assert.assertTrue(objProjectDesign.getProjectDesignWelcome().toLowerCase()
    			.contains("setup and edit the design of the project (i.e. who uses what, when?)"));
    }
    @Test
    //navigate to the Project Settings Page
    public void test_Nav_Project_Settings(){
    	navbar = new Pilr_Navbar(driver);
    	objProjectSettings = new Pilr_Project_Settings_Page(driver);
    	
    	//click the gear icons to go to the Project Settings Page
    	navbar.click_Project_Settings_Icon();
    	
    	//verify we landed on the Project Settings Page
    	Assert.assertTrue(objProjectSettings.getprojectSettingsWelcome().toLowerCase()
    			.contains("add, edit, or remove the components used on this project."));   	
    }
    @Test
    //navigate to the Project Settings Page for Admin
    public void test_Project_Settings_Admin(){
    	//Page
    	objProjectDetailsAdmin = new Project_Details_Admin(driver);
    	
    	//Make sure on correct page
    	System.out.println(objProjectDetailsAdmin.getProjectDetailsWelcome().toLowerCase());
    	//verify we landed on the Project Settings for Admin Page
    	Assert.assertTrue(objProjectDetailsAdmin.getProjectDetailsWelcome().toLowerCase()
    			.contains("edit"));   	
    }
    @Test
    //navigate to the Coordinate Projects Page
    public void test_Nav_Coordinate_Page(){
    	navbar = new Pilr_Navbar(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	
    	//click the dashboard icon to go the Coordinate Project page
    	navbar.click_Project_Coordinate_Icon();
    	Assert.assertTrue(objCoordinatePage.getcoordinatePageWelcome().toLowerCase()
    			.contains("coordinate participants and data"));
    	
    }
    @Test
    //delete new project --Doesn't work properly
    public void test_Delete_Newly_Added_Project(){
    	objOrgPage = new Pilr_Org_Page(driver);
    	navbar = new Pilr_Navbar(driver);
    	objDeleteProjectModal = new Delete_Project_Modal(driver);
 
    	pilr_org = (objtestvars.getOrg());
    	navbar.Nav_to_Org_Page(pilr_org);
    	Assert.assertTrue(objOrgPage.getOrgPageWelcome()
    			.contains(objtestvars.getOrg()));
    	objOrgPage.delete_Project(new_project_name);
    	Assert.assertTrue(objDeleteProjectModal.get_Delete_Project_Welcome().toLowerCase()
    			.contains("are you sure you want to delete this project?"));
    	objDeleteProjectModal.click_Confirm_Delete();
    }
    @Test
    //delete new project -- DOesn't work properly
    public void test_Delete_Newly_Added_Project_Liad(){
    	objOrgPage = new Pilr_Org_Page(driver);
    	navbar = new Pilr_Navbar(driver);
    	objDeleteProjectModal = new Delete_Project_Modal(driver);
 
    	pilr_org = (objtestvars.getLiadOrg());
    	navbar.Nav_to_Org_Page(pilr_org);
    	Assert.assertTrue(objOrgPage.getOrgPageWelcome()
    			.contains(objtestvars.getLiadOrg()));
    	objOrgPage.delete_Project(objtestvars.getNewProject());
    	System.out.println("Before ARE YOU SURE\n");
    	Assert.assertTrue(objDeleteProjectModal.get_Delete_Project_Welcome().toLowerCase()
    			.contains("are you sure you want to delete this project?"));
    	objDeleteProjectModal.click_Confirm_Delete();
    }
    @Test
    public void test_set_Features_Admin(){
    	System.out.println("Set feature admin");
    	//New page driver
    	objProjectDetailsAdmin = new Project_Details_Admin(driver);
    	
    	System.out.println("Edit features");
    	objProjectDetailsAdmin.editFeatures();
    	
    	System.out.println("Set features");
    	objProjectDetailsAdmin.setFeatures();
    	
    	System.out.println("Save features");
    	objProjectDetailsAdmin.saveFeatures();
    	
    	System.out.println("Check features");
    	System.out.println(objProjectDetailsAdmin.getFeatures().toLowerCase());
    	Assert.assertTrue(objProjectDetailsAdmin.getFeatures().toLowerCase().contains("v2_api,activity"));
    	
    	
    }
    @Test
    public void test_unset_Features_Admin(){
    	System.out.println("Set feature admin");
    	//New page driver
    	objProjectDetailsAdmin = new Project_Details_Admin(driver);
    	
    	System.out.println("Edit features");
    	objProjectDetailsAdmin.editFeatures();
    	
    	System.out.println("Clear features");
    	objProjectDetailsAdmin.clearFeatures();
    	
    	System.out.println("Save features");
    	objProjectDetailsAdmin.saveFeatures();
    	
    	System.out.println("Check features");
    	System.out.println(objProjectDetailsAdmin.getFeatures().toLowerCase());
    	Assert.assertTrue(objProjectDetailsAdmin.getFeatures().toLowerCase().contains(""));
    	
    	
    }
    
    @Test
    public void test_Logout(){
    	navbar = new Pilr_Navbar(driver);
    	navbar.clickLogout();
    }
	@AfterTest
    public void tearDown() throws Exception {
    	driver.quit();
    }

}