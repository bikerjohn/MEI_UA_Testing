package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pilrhealth.com.ua.util.Retriable;

public class AbstractBasePage {
		
	protected WebDriver driver;

	public AbstractBasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected WebElement findElement(By by, long timeout) {
		return new Retriable<WebElement>(timeout) {
			@Override
			protected WebElement tryOnce() {
				return driver.findElement(by);
			}
		}.run();
	}
	protected WebElement findElement(By by) {
		return findElement(by, 15000);
	}
}
