package com.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LaunchBrowserer {

	@Test
	public void launchbrowser() throws InterruptedException, AWTException{
		
		Robot robot=new Robot();
		System.out.println("Welcome to Dell Inspiron 15 3000");
		// System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// FirefoxDriver driver=new FirefoxDriver();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");

		WebElement login = driver.findElementByXPath("//div[text()='Login']");
		login.click();

		WebElement uname = driver.findElementByCssSelector("input[id='eLoginNew']");
		uname.clear();
		uname.sendKeys("srinivasoptimist7@gmail.com");

		WebElement pwd = driver.findElementByCssSelector("input[id='pLogin']");
		pwd.clear();
		pwd.sendKeys("naganaga");

		WebElement mainlogin = driver.findElementByCssSelector("button[value='Login']");
		mainlogin.click();
		Thread.sleep(5000);

		WebElement updateprofile = driver.findElementByCssSelector("a[class='btn btn-block btn-large white-text']");
		updateprofile.click();
		
		
		
		
		//em[class='icon edit']
		//input[id='name']
		//button[id='saveBasicDetailsBtn']
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		
		WebElement updateresume = driver.findElementByXPath("(//a[@class='secondary-content'])[4]");
		updateresume.click();
		Thread.sleep(3000);
		
		WebElement attachcv = driver.findElementByCssSelector("input[id='attachCV']");
		attachcv.click();
			
	    robot.setAutoDelay(2000);
	    ClipboardOwner owner=null;
	    String resumepath="C:\\SREENIVASULU BORUGULA.docx";
	 
		StringSelection attachmentpath=new StringSelection(resumepath);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(attachmentpath, owner);
	    robot.setAutoDelay(3000);
	    
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    
	    
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);
	    
	    robot.setAutoDelay(3000);
	    
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    
	    
	    robot.setAutoDelay(5000);
	    
	  
	  /*  WebElement mynaukari = driver.findElementByXPath("//div[text()='My Naukri']");
	  
		 
        Actions actions = new Actions(driver);
 
        actions.moveToElement(mynaukari).perform();
        robot.setAutoDelay(3000);
        WebElement logout = driver.findElementByCssSelector("a[class='logout-gnb']");
        System.out.println(logout);
        actions.moveToElement(logout);
        actions.click().build().perform();*/
        //action.click();
 
        //action.perform();	
	  // logout.click();
	    driver.close();
        driver.quit();
      
				
	}
}
