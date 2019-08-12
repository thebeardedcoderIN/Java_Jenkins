package com.bs.Jenkins;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Sample
{
    public static void main( String[] args )
    {
    	String BROWSERSTACK_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    	String BROWSERSTACK_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    	
    	String URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    	
    	WebDriver driver = null;
    	DesiredCapabilities caps = null;
    	
    	try {
    		caps = new DesiredCapabilities();
    		caps.setCapability("os", "windows");
    		caps.setCapability("os_version", "10");
    		caps.setCapability("browser", "Chrome");
    		caps.setCapability("browser_version", "72.0");
    		
    		caps.setCapability("project", "Test_Project_KM");
    		caps.setCapability("build", "ADP");
    		caps.setCapability("name", "Test : Jenkins [java]");
    		
    		driver = new RemoteWebDriver(new URL(URL), caps);
    		
    		driver.get("https://www.browserstack.com");
			
		} catch (Exception e) {
			e.printStackTrace();			
		} finally {
			if(driver != null) {
				driver.quit();
			}
		}
    	
    	
    }
}
