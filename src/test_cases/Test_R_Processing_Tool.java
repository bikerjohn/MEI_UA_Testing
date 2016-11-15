package test_cases;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.Pilr_Navbar;
import page_objects.Pilr_R_Processing_History;
import page_objects.Pilr_R_Processing_Job_Details;
import page_objects.Pilr_R_Processing_Preview;
import page_objects.Pilr_R_Processing_Select_Job;
import page_objects.Pilr_R_Processing_Select_Period;
import page_objects.Pilr_R_Processing_Output_Data;

public class Test_R_Processing_Tool extends AbstractTestCase{
	
	Pilr_R_Processing_Select_Job objRProcessingSelectJob;
	Pilr_R_Processing_Select_Period objRProcessingSelectPeriod;
	Pilr_R_Processing_Preview objRProcessingPreview;
	Pilr_R_Processing_History objRProcessingHistory;
	Pilr_R_Processing_Job_Details objRProcessingJobDetails;
	Pilr_R_Processing_Output_Data objRProcessingJobOutputData;
    
	// Navigate to R Processing Tool
    @Test
    public void test_Nav_R_Processing_Tool() {
    	navbar = new Pilr_Navbar(driver);
    	objRProcessingSelectJob = new Pilr_R_Processing_Select_Job(driver);
    	
    	//click the tool icon and click event tag editor
    	navbar.click_R_Processing_Tool();
    	
    	Assert.assertTrue(objRProcessingSelectJob.getSelectJobWelcome().toLowerCase()
				.contains("start a job for participant"));
    }
    
    // Choose Human Job and Participant
    @Test
    public void test_Choose_Human_Job() {
    	objRProcessingSelectJob = new Pilr_R_Processing_Select_Job(driver);
    	objRProcessingSelectPeriod = new Pilr_R_Processing_Select_Period(driver);
    	
    	objRProcessingSelectJob.chooseHuman();
    	
    	objRProcessingSelectJob.nextStep();
    	Assert.assertTrue(objRProcessingSelectPeriod.getSelectPeriodWelcome().toLowerCase()
				.contains("start a new job"));
    }
    // Choose Infusion Job and Participant
    @Test
    public void test_Choose_Infusion_Job() {
    	objRProcessingSelectJob = new Pilr_R_Processing_Select_Job(driver);
    	objRProcessingSelectPeriod = new Pilr_R_Processing_Select_Period(driver);
    	
    	objRProcessingSelectJob.chooseInfusion();
    	
    	objRProcessingSelectJob.nextStep();
    	Assert.assertTrue(objRProcessingSelectPeriod.getSelectPeriodWelcome().toLowerCase()
				.contains("start a new job"));
    }
    // Choose Burn Job and Participant
    @Test
    public void test_Choose_Burn_Job() {
    	objRProcessingSelectJob = new Pilr_R_Processing_Select_Job(driver);
    	objRProcessingSelectPeriod = new Pilr_R_Processing_Select_Period(driver);
    	
    	objRProcessingSelectJob.chooseBurn();
    	
    	objRProcessingSelectJob.nextStep();
    	Assert.assertTrue(objRProcessingSelectPeriod.getSelectPeriodWelcome().toLowerCase()
				.contains("start a new job"));
    }
    
    // Choose Participant Active Period
    @Test
    public void test_Choose_Active_Period() {
    	objRProcessingSelectPeriod = new Pilr_R_Processing_Select_Period(driver);
    	objRProcessingPreview = new Pilr_R_Processing_Preview(driver);
    	
    	objRProcessingSelectPeriod.nextStep();
    	Assert.assertTrue(objRProcessingPreview.getJobPreviewWelcome().toLowerCase()
				.contains("preview job data"));
    }
    
    // Run Job and Verify Successful
    @Test
    public void test_Run_Human_Job() {
    	objRProcessingPreview = new Pilr_R_Processing_Preview(driver);
    	objRProcessingHistory = new Pilr_R_Processing_History(driver);
    	objRProcessingJobDetails = new Pilr_R_Processing_Job_Details(driver);
    	
    	objRProcessingPreview.runJob();
    	Assert.assertTrue(objRProcessingHistory.getJobHistoryWelcome().toLowerCase()
				.contains("processing job history"));
    	
    	// Wait 2 minutes for job to run
    	try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	objRProcessingHistory.selectRanJob("Human CalRQ Summary v1.2");
    	
    	Assert.assertTrue(objRProcessingJobDetails.getJobDetailsOutput().toLowerCase()
				.contains("job completed successfully"));
    }
    // Run Job and Verify Successful
    @Test
    public void test_Run_Infusion_Job() {
    	objRProcessingPreview = new Pilr_R_Processing_Preview(driver);
    	objRProcessingHistory = new Pilr_R_Processing_History(driver);
    	objRProcessingJobDetails = new Pilr_R_Processing_Job_Details(driver);
    	
    	objRProcessingPreview.runJob();
    	Assert.assertTrue(objRProcessingHistory.getJobHistoryWelcome().toLowerCase()
				.contains("processing job history"));
    	
    	// Wait 2 minutes for job to run
    	try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	objRProcessingHistory.selectRanJob("Infusion CalRQ Summary RC1");
    	
    	Assert.assertTrue(objRProcessingJobDetails.getJobDetailsOutput().toLowerCase()
				.contains("job completed successfully"));
    }
    // Run Job and Verify Successful
    @Test
    public void test_Run_Burn_Job() {
    	objRProcessingPreview = new Pilr_R_Processing_Preview(driver);
    	objRProcessingHistory = new Pilr_R_Processing_History(driver);
    	objRProcessingJobDetails = new Pilr_R_Processing_Job_Details(driver);
    	
    	objRProcessingPreview.runJob();
    	Assert.assertTrue(objRProcessingHistory.getJobHistoryWelcome().toLowerCase()
				.contains("processing job history"));
    	
    	// Wait 2 minutes for job to run
    	try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	objRProcessingHistory.selectRanJob("Burn CalRQ Summary RC1");
    	
    	Assert.assertTrue(objRProcessingJobDetails.getJobDetailsOutput().toLowerCase()
				.contains("job completed successfully"));
    }
    // View Output Data
    @Test
    public void test_View_Human_Data() {
    	objRProcessingJobDetails = new Pilr_R_Processing_Job_Details(driver);
    	objRProcessingJobOutputData = new Pilr_R_Processing_Output_Data(driver);
    	
    	objRProcessingJobDetails.navJobOutputData();
    	
    	Assert.assertTrue(objRProcessingJobOutputData.getJobOutputDataWelcome().toLowerCase()
    			.contains("viewing dataset"));    	
    }
    // View Output Data
    @Test
    public void test_View_Infusion_Data() {
    	objRProcessingJobDetails = new Pilr_R_Processing_Job_Details(driver);
    	objRProcessingJobOutputData = new Pilr_R_Processing_Output_Data(driver);
    	
    	objRProcessingJobDetails.navJobOutputData();
    	
    	Assert.assertTrue(objRProcessingJobOutputData.getJobOutputDataWelcome().toLowerCase()
    			.contains("viewing dataset"));    	
    }
    // View Output Data
    @Test
    public void test_View_Burn_Data() {
    	objRProcessingJobDetails = new Pilr_R_Processing_Job_Details(driver);
    	objRProcessingJobOutputData = new Pilr_R_Processing_Output_Data(driver);
    	
    	objRProcessingJobDetails.navJobOutputData();
    	
    	Assert.assertTrue(objRProcessingJobOutputData.getJobOutputDataWelcome().toLowerCase()
    			.contains("viewing dataset"));    	
    }
}
