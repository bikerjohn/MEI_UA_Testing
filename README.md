# MEI_UA_Testing
Cleaned up repo for the Selenium WebDriver User Acceptance Tests

## Test Scenarios
* pilr_Create_Project_from_Scratch.xml
  * Create empty project
  * Import EMA instrument from Github
  * Create survey and card
  * Add instrument and EMA config to template
  * Bulk add and schedule participants and devices
  
* pilr_Create_Project_from_Bundle.xml
  * Create project, importing bundle from organization
  * Create participant, schedule it, and add a device
  
* pilr_Create_Project_Import_Instrument.xml
  * Create empty project
  * Import EMA instrument from organization
  * Import EMA configuration
  * Add instrument and EMA config to template

* pilr_Create_Project_With_Feature_Enabled.
  * Create empty project
  * Import EMA instrument from Github
  * Enable media feature
  * Create survey and media card
  * Add instrument and EMA config to template
  * Bulk add and schedule participants and devices

* pilr_Create_Project_from_Scratch_Liad_Activities.xml
  * Create empty project
  * Import EMA instrument from Github
  * Enable Activity feature
  * Create survey and card
  * Import activities from csv file
  * Link survey to activity
  * Select start activities
  
* pilr_Calorimeter_Summaries_And_Delete_Data.xml
  * Create empty project
  * Import CalRQ bundle from Github
  * For each summary (human/infusion/burn)
    * Create and schedule participant
    * Set variables/settings
    * Upload data
    * Create event tags
    * Run summary
  * Attempt to delete CalRQ data (gives linked data notification)
  * Delete haldane data
  
* pilr_EMA_Verify_Home_and_Compliance
  * Navigate to existing project with EMA instrument
  * Navigate to EMA instrument
  * Verify proper navigation to EMA pages 
    * (Participants, Survey Responses, Builder, Application, Languages, Compliance)
