package test_cases;



public final class TestVars {
	 private String usrname;
	 private String passwrd;
	 private String prjct;
	 private String org;
	 private String liad_org;
	 private String part_code;
	 private String part_desc;
	 private String cal_human_part_code;
	 private String cal_infusion_part_code;
	 private String cal_burn_part_code;
	 private String ema_config;
	 private String new_ema_config;
	 private String surv_name;
	 private String surv_desc;
	 private String sect_name;
	 private String sect_desc;
	 private String card_type;
	 private String card_titl;
	 private String card_text;
	 private String new_prjct;
	 private String new_survey_name;
	 private String new_survey_description;
	 private String instrument_url;
	 private String calorimeter_url;
	 private String existing_org;
	 private String dv_start_date;
	 private String dv_end_date;
	 public String import_file_name;
	 private String participant_status;
	 private String default_assignments;
	 private Integer proj_wizard_import_component_li;
	 private Integer proj_wizard_import_bundle_li;
	 public String john_ema_config_defs;
	 public String tyler_ema_config_defs;
	 public String liad_instrument_url;
	 public String tyler_human_data_file;
	 public String tyler_infusion_data_file;
	 public String tyler_burn_data_file;
	 public String tyler_activity_file;
	 public String human_start_date;
	 public String infusion_start_date;
	 public String burn_start_date;
	 //public String ag_Health;
	 
	//set the default value of the test variables
	public TestVars(){
		usrname="bikerjohn";
		passwrd="$Lghtngrtch1x9";
		prjct="Delete EMA Config Test";
		new_prjct="test_project";
		//prjct="test6008";
		org="EMA Standard Surveys";
		liad_org="QA Testing1";
		org="PiLRHealth Auto QA Test Org (OWNER)";
		//org="PiLR Demo (OWNER)";
		part_code="924";
		cal_human_part_code="human";
		cal_infusion_part_code="infusion";
		cal_burn_part_code="burn";
		part_desc="bikerjohn";
		//ema_config="New EMA Config";
		ema_config="Delete Config Test";
		new_ema_config="New EMA Config";
		surv_name="Test Survey";
		surv_desc="this is a survey created by an automated qa script";
		sect_name="weather";
		sect_desc="this section created by an automated test script";
		card_type="QUESTION: Yes or no";
		card_titl="Weather Question";
		card_text="Is the sun shining today?";
		instrument_url = "https://raw.githubusercontent.com/pilrhealth/definition-files/master/premium/PiLR%20EMA/base-instrument.json";
		calorimeter_url = "https://raw.githubusercontent.com/pilrhealth/definition-files/master/standard/CalRQ/setup-bundle-1.json";
		liad_instrument_url = "https://raw.githubusercontent.com/pilrhealth/definition-files/master/projects/142/base-instrument.json";
		new_survey_name = "Test Survey";
		new_survey_description = "This is an automatically generated survey";
		existing_org = "customer_ema_examples";
		dv_start_date = "10/16/2015";
		dv_end_date = "02/10/2016";
		import_file_name = "C:\\srv\\mei\\bulk_participants.csv";
		participant_status = "Enrolled";
		default_assignments = "Default Assignments";
		proj_wizard_import_component_li = 1;
		proj_wizard_import_bundle_li = 0;
		john_ema_config_defs = "C:\\srv\\mei\\emacontent\\ema-configs-standard-surveys-wtriggers.json";
		tyler_ema_config_defs = "/home/tyler/Github/definition-files/premium/PiLR EMA/sample-ema-config-content-v2.json";
		tyler_human_data_file = "/home/tyler/UA_Testing_Files/calrq-human-data.csv";
		tyler_infusion_data_file = "/home/tyler/UA_Testing_Files/calrq-infusion-data.csv";
		tyler_burn_data_file = "/home/tyler/UA_Testing_Files/calrq-burn-data.csv";
		tyler_activity_file = "/home/tyler/UA_Testing_Files/Time_Tracking_Activities.csv";
		human_start_date = "06/22/2015";
		infusion_start_date = "06/29/2015";
		burn_start_date = "03/18/2015";
		//ag_Health = "Ag_Health_Config";		
	    }
	
	// Public methods
		public final String getUserName(){
			return usrname;
		}
		public final void setUserName(String newUsernameSet){
			this.usrname=newUsernameSet;
		}
		public final void setPassWrd(String newPassSet){
			this.passwrd=newPassSet;
		}
		public final String getPassWrd(){
			return passwrd;
		}
		public final String getProject(){
			return prjct;
		}
		public final String getOrg(){
			return org;
		}
		public final String getLiadOrg(){
			return liad_org;
		}
		public final String getPartCode(){
			return part_code;
		}
		public final String getCalHumanPartCode(){
			return cal_human_part_code;
		}
		public final String getCalInfusionPartCode(){
			return cal_infusion_part_code;
		}
		public final String getCalBurnPartCode(){
			return cal_burn_part_code;
		}
		public final String getPartDesc(){
			return part_desc;
		}
		public final String getEmaConfig(){
			return ema_config;
		}
		public final String getSurveyName(){
			return surv_name;
		}
		public final String getSurveyDescription(){
			return surv_desc;
		}
		public final String getSectionName(){
			return sect_name;
		}
		public final String getSectionDescription(){
			return sect_desc;
		}
		public final String getCardTitle(){
			return card_titl;
		}
		public final String getCardText(){
			return card_text;
		}
		public void setnewProject(String newproject){
			this.new_prjct=newproject;
		}
		public final String getNewProject(){
			return new_prjct ;
		}
		public final String getInstrumentURL(){
			return instrument_url ;
		}
		public final String getLiadInstrumentURL(){
			return liad_instrument_url ;
		}
		public final String getCalorimeterURL() {
			return calorimeter_url;
		}
		public final String getNewEMAConfig(){
			return new_ema_config;
		}
		public final String getNewSurveyName(){
			return new_survey_name;
		}
		public final String getNewSurveyDescription(){
			return new_survey_description;
		}
		public final String getExistingOrg(){
			return existing_org;
		}
		public final String get_dv_Start_Date(){
			return dv_start_date;
		}
		public final String get_dv_End_Date(){
			return dv_end_date;
		}
		public final void set_import_File_Name(String newimportpath){
			this.import_file_name=newimportpath;
		}
		public final String get_import_File_Name(){
			return import_file_name;
		}
		public final String get_participant_Status(){
			return participant_status;
		}
		public final String get_default_Assignments(){
			return default_assignments;
		}
		public final Integer get_Import_Component_li(){
			return proj_wizard_import_component_li;
		}
		public final Integer get_Import_Bundle_li(){
			return proj_wizard_import_bundle_li;
		}
		public final void set_EMA_Config_Defs(String newconfigdefs){
			if (System.getProperty("user.dir").equals("C:/serv/mei/MEI_UA_Testing/")) {
				this.john_ema_config_defs=newconfigdefs;
			}
			else if (System.getProperty("user.dir").equals("/home/tyler/Github/MEI_UA_Testing")) {
				this.tyler_ema_config_defs=newconfigdefs;	
			}
		}
		public final String get_EMA_Config_Defs(){
			if (System.getProperty("user.dir").equals("C:/serv/mei/MEI_UA_Testing/")) {
				return john_ema_config_defs;
			}
			else if (System.getProperty("user.dir").equals("/home/tyler/Github/MEI_UA_Testing")) {
				return tyler_ema_config_defs;
			}
			else {
				return null;
			}
		}
		public final void set_EMA_Config_Name(String newconfigname){
			this.ema_config=newconfigname;
		}
		public final String get_calrq_human_data(){
			if (System.getProperty("user.dir").equals("C:/serv/mei/MEI_UA_Testing/")) {
				return null;
			}
			else if (System.getProperty("user.dir").equals("/home/tyler/Github/MEI_UA_Testing")) {
				return tyler_human_data_file;
			}
			else {
				return null;
			}
		}
		public final String get_calrq_infusion_data(){
			if (System.getProperty("user.dir").equals("C:/serv/mei/MEI_UA_Testing/")) {
				return null;
			}
			else if (System.getProperty("user.dir").equals("/home/tyler/Github/MEI_UA_Testing")) {
				return tyler_infusion_data_file;
			}
			else {
				return null;
			}
		}
		public final String get_calrq_burn_data(){
			if (System.getProperty("user.dir").equals("C:/serv/mei/MEI_UA_Testing/")) {
				return null;
			}
			else if (System.getProperty("user.dir").equals("/home/tyler/Github/MEI_UA_Testing")) {
				return tyler_burn_data_file;
			}
			else {
				return null;
			}
		}
		public final String get_activity_file(){
			if (System.getProperty("user.dir").equals("C:/serv/mei/MEI_UA_Testing/")) {
				return null;
			}
			else if (System.getProperty("user.dir").equals("/home/tyler/Github/MEI_UA_Testing")) {
				return tyler_activity_file;
			}
			else {
				return null;
			}
		}
		public final String get_human_start_date(){
			return human_start_date;
		}
		public final String get_infusion_start_date(){
			return infusion_start_date;
		}
		public final String get_burn_start_date(){
			return burn_start_date;
		}
}