package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractBasePage {
		
	protected WebDriver driver;

	public AbstractBasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected void sleep(Integer mSeconds){
		try {
    		Thread.sleep(mSeconds); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
	}

	protected WebElement findElement(By by) {
		System.out.println("findElement " + by.toString());
		return driver.findElement(by);
	}
	
	protected WebElement findElement(By by, long timeout) {
		System.out.println("findElements " + by.toString());
		long deadline = System.currentTimeMillis() + timeout;
		while (System.currentTimeMillis() < deadline) {
			List<WebElement> els = driver.findElements(by);
			if (els.size() == 1) {
				return els.get(0);
			}
			else if (els.size() > 1) {
				System.out.println("WARNING: multiple results for " + by.toString());
				return els.get(0);
			}
			else {
				System.out.println("Sleeping for " + by.toString());
				sleep(500);
				// and try again
			}
		}
		throw new RuntimeException("findElement failed: by="+by.toString());
	}
}
