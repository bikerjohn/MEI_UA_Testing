package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_R_Processing_Select_Period extends AbstractBasePage {

	By welcomeMessage = By.cssSelector("h4");
	By nextButton = By.id("preview");

	public Pilr_R_Processing_Select_Period(WebDriver driver){
        super(driver);
    }

	public String getSelectPeriodWelcome() {
		return findElement(welcomeMessage).getText();
	}

	public void nextStep() {
		findElement(nextButton).click();
	}
}
