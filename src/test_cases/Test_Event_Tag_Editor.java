package test_cases;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import page_objects.Pilr_Event_Tag_Editor_Builder;
import page_objects.Pilr_Event_Tag_Editor_Summary;
import page_objects.Pilr_Navbar;
import page_objects.Pilr_Project_Settings_Page;

public class Test_Event_Tag_Editor extends AbstractTestCase{
	
	Pilr_Event_Tag_Editor_Summary objEventTagEditorSummary;
	Pilr_Event_Tag_Editor_Builder objEventTagEditorBuilder;
    
	// Navigate to Event Tag Editor
    @Test
    public void test_Nav_Event_Tag_Editor() {
    	navbar = new Pilr_Navbar(driver);
    	objProjectSettings = new Pilr_Project_Settings_Page(driver);
    	objEventTagEditorSummary = new Pilr_Event_Tag_Editor_Summary(driver);
    	
    	//click the tool icon and click event tag editor
    	navbar.click_Event_Tag_Editor();
    	
    	Assert.assertTrue(objEventTagEditorSummary.getEventTagSummaryWelcome().toLowerCase()
				.contains("tagged participant events"));
    }
    
    // Select human participant
    @Test
    public void test_Select_Human_Participant() {
    	objEventTagEditorSummary = new Pilr_Event_Tag_Editor_Summary(driver);
    	objEventTagEditorBuilder = new Pilr_Event_Tag_Editor_Builder(driver);
    	
    	objEventTagEditorSummary.selectHumanParticipant();
    	
    	Assert.assertTrue(objEventTagEditorBuilder.getEventTagBuilderWelcome().toLowerCase()
				.contains("human : bikerjohn"));
    }
    // Select infusion participant
    @Test
    public void test_Select_Infusion_Participant() {
    	objEventTagEditorSummary = new Pilr_Event_Tag_Editor_Summary(driver);
    	objEventTagEditorBuilder = new Pilr_Event_Tag_Editor_Builder(driver);
    	
    	objEventTagEditorSummary.selectInfusionParticipant();
    	
    	Assert.assertTrue(objEventTagEditorBuilder.getEventTagBuilderWelcome().toLowerCase()
				.contains("infusion : bikerjohn"));
    }
    // Select burn participant
    @Test
    public void test_Select_Burn_Participant() {
    	objEventTagEditorSummary = new Pilr_Event_Tag_Editor_Summary(driver);
    	objEventTagEditorBuilder = new Pilr_Event_Tag_Editor_Builder(driver);
    	
    	objEventTagEditorSummary.selectBurnParticipant();
    	
    	Assert.assertTrue(objEventTagEditorBuilder.getEventTagBuilderWelcome().toLowerCase()
				.contains("burn : bikerjohn"));
    }
    
    // Enter and save human event tags
    @Test
    public void test_Create_Human_Event_Tags() {
    	objEventTagEditorBuilder = new Pilr_Event_Tag_Editor_Builder(driver);
    	
    	// Invalid Data tag
    	objEventTagEditorBuilder.addNewEvent();
    	objEventTagEditorBuilder.setEventStartDate("06/22/15");
    	objEventTagEditorBuilder.setEventStartTime("17:22:24");
    	objEventTagEditorBuilder.setEventEndDate("06/22/15");
    	objEventTagEditorBuilder.setEventEndTime("19:42:56");
    	objEventTagEditorBuilder.chooseTagLabel("Invalid Data");
    	objEventTagEditorBuilder.saveEvent();
    	
    	// Human Study tag
    	objEventTagEditorBuilder.addNewEvent();
    	objEventTagEditorBuilder.setEventStartDate("06/22/15");
    	objEventTagEditorBuilder.setEventStartTime("19:42:56");
    	objEventTagEditorBuilder.setEventEndDate("06/23/15");
    	objEventTagEditorBuilder.setEventEndTime("15:44:47");
    	objEventTagEditorBuilder.chooseTagLabel("Human Study");
    	objEventTagEditorBuilder.saveEvent();
    	
    	// Sleep tag
    	objEventTagEditorBuilder.addNewEvent();
    	objEventTagEditorBuilder.setEventStartDate("06/22/15");
    	objEventTagEditorBuilder.setEventStartTime("23:00:00");
    	objEventTagEditorBuilder.setEventEndDate("06/23/15");
    	objEventTagEditorBuilder.setEventEndTime("05:00:00");
    	objEventTagEditorBuilder.chooseTagLabel("Sleep");
    	objEventTagEditorBuilder.saveEvent();

    	// Rest tag
    	objEventTagEditorBuilder.addNewEvent();
    	objEventTagEditorBuilder.setEventStartDate("06/23/15");
    	objEventTagEditorBuilder.setEventStartTime("05:00:00");
    	objEventTagEditorBuilder.setEventEndDate("06/23/15");
    	objEventTagEditorBuilder.setEventEndTime("06:45:00");
    	objEventTagEditorBuilder.chooseTagLabel("Rest");
    	objEventTagEditorBuilder.saveEvent();    
    	
    	// Exercise tag
    	objEventTagEditorBuilder.addNewEvent();
    	objEventTagEditorBuilder.setEventStartDate("06/23/15");
    	objEventTagEditorBuilder.setEventStartTime("08:00:00");
    	objEventTagEditorBuilder.setEventEndDate("06/23/15");
    	objEventTagEditorBuilder.setEventEndTime("09:00:00");
    	objEventTagEditorBuilder.chooseTagLabel("Exercise");
    	objEventTagEditorBuilder.saveEvent();    

    	// Post Meal tag
    	objEventTagEditorBuilder.addNewEvent();
    	objEventTagEditorBuilder.setEventStartDate("06/23/15");
    	objEventTagEditorBuilder.setEventStartTime("12:00:00");
    	objEventTagEditorBuilder.setEventEndDate("06/23/15");
    	objEventTagEditorBuilder.setEventEndTime("12:30:00");
    	objEventTagEditorBuilder.chooseTagLabel("Post Meal");
    	objEventTagEditorBuilder.saveEvent();    

    	// Regression Data tag
    	objEventTagEditorBuilder.addNewEvent();
    	objEventTagEditorBuilder.setEventStartDate("06/23/15");
    	objEventTagEditorBuilder.setEventStartTime("11:30:00");
    	objEventTagEditorBuilder.setEventEndDate("06/23/15");
    	objEventTagEditorBuilder.setEventEndTime("12:30:00");
    	objEventTagEditorBuilder.chooseTagLabel("Regression Data");
    	objEventTagEditorBuilder.saveEvent();  
    	
    	System.out.println("[Test Case]Human Event Tags Created Successful");
    }
    
    @Test
    public void test_Create_Infusion_Event_Tags() {
    	objEventTagEditorBuilder = new Pilr_Event_Tag_Editor_Builder(driver);
    	
    	// Infusion Study tag
    	objEventTagEditorBuilder.addNewEvent();
    	objEventTagEditorBuilder.setEventStartDate("06/29/15");
    	objEventTagEditorBuilder.setEventStartTime("13:00:00");
    	objEventTagEditorBuilder.setEventEndDate("06/29/15");
    	objEventTagEditorBuilder.setEventEndTime("21:00:00");
    	objEventTagEditorBuilder.chooseTagLabel("Infusion Study");
    	objEventTagEditorBuilder.saveEvent();
    	
    	// Infusion Study tag
    	objEventTagEditorBuilder.addNewEvent();
    	objEventTagEditorBuilder.setEventStartDate("06/29/15");
    	objEventTagEditorBuilder.setEventStartTime("22:30:00");
    	objEventTagEditorBuilder.setEventEndDate("06/30/15");
    	objEventTagEditorBuilder.setEventEndTime("05:30:00");
    	objEventTagEditorBuilder.chooseTagLabel("Infusion Study");
    	objEventTagEditorBuilder.saveEvent(); 	
    	
    	// Short Circuit tag
    	objEventTagEditorBuilder.addNewEvent();
    	objEventTagEditorBuilder.setEventStartDate("06/30/15");
    	objEventTagEditorBuilder.setEventStartTime("05:30:00");
    	objEventTagEditorBuilder.setEventEndDate("06/30/15");
    	objEventTagEditorBuilder.setEventEndTime("09:00:00");
    	objEventTagEditorBuilder.chooseTagLabel("Short Circuit");
    	objEventTagEditorBuilder.saveEvent(); 
    	
    	// Null tag
    	objEventTagEditorBuilder.addNewEvent();
    	objEventTagEditorBuilder.setEventStartDate("06/29/15");
    	objEventTagEditorBuilder.setEventStartTime("10:45:11");
    	objEventTagEditorBuilder.setEventEndDate("06/29/15");
    	objEventTagEditorBuilder.setEventEndTime("13:00:00");
    	objEventTagEditorBuilder.chooseTagLabel("Null");
    	objEventTagEditorBuilder.saveEvent(); 
    	
    	System.out.println("[Test Case]Infusion Event Tags Created Successful");
    }
    
    @Test
    public void test_Create_Burn_Event_Tags() {
    	objEventTagEditorBuilder = new Pilr_Event_Tag_Editor_Builder(driver);
    	
    	// Burn Study tag
    	objEventTagEditorBuilder.addNewEvent();
    	objEventTagEditorBuilder.setEventStartDate("03/18/15");
    	objEventTagEditorBuilder.setEventStartTime("16:00:00");
    	objEventTagEditorBuilder.setEventEndDate("03/19/15");
    	objEventTagEditorBuilder.setEventEndTime("15:00:00");
    	objEventTagEditorBuilder.chooseTagLabel("Burn Study");
    	objEventTagEditorBuilder.saveEvent();	
    	
    	System.out.println("[Test Case]Infusion Event Tags Created Successful");
    }
}
