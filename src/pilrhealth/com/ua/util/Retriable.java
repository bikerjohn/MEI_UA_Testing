package pilrhealth.com.ua.util;

import java.util.List;

import org.openqa.selenium.WebElement;

public abstract class Retriable<T> {
	
	private long retryInterval;
	private long timeout;

	public Retriable(long timeout, long retryInterval) {
		this.timeout = timeout;
		this.retryInterval = retryInterval;
	}

	public Retriable(long timeout) {
		this(timeout, 500);
	}
	public Retriable() {
		this(15000);
	}
	
	protected abstract T tryOnce();
	
	public T run() {
		long deadline = System.currentTimeMillis() + timeout;
		while (System.currentTimeMillis() < deadline) {
			T result = tryOnce();
			if (result != null) 
				return result;
			else {
				try {
		    		Thread.sleep(retryInterval); 
		    	}
		    	catch(InterruptedException ex) {
		    		Thread.currentThread().interrupt();
		    	}

			}
		}
		throw new RuntimeException("failed after retries");
	}
}
