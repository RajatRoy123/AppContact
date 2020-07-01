package Application.Contact;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidElement;

public class DeleteContactTest extends baseContact {

	@Test
	public void DeleteContact() throws MalformedURLException, InterruptedException {
		
	service=StartServer();
	
		// TODO Auto-generated method stub
		System.out.println("debug");
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("debug1");
		driver.findElementByXPath("//android.widget.TextView[@text='CONTACTS']").click();
		//WebElement ele =driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Payel-rel-bangalor\"))");
		WebElement ele = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Payel-rel-bangalor\"))");
		TouchAction touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(ele))).perform();
		driver.findElementById("com.samsung.android.contacts:id/expand_detail").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='ALLOW']").click();
		Thread.sleep(3000);
		
		driver.findElementsByClassName("android.widget.Button").get(2).click();
	//	findElementByClassName("android.widget.Button").click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Delete']")).click();
		Thread.sleep(3000);
		driver.findElementById("android:id/button1").click();
		
		
		
	
	}
	public static void getScreenShot(String testname) throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+testname+".png"));
		
		//File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Contact"+testname+".png"));
		
		
	}
	
	
	@BeforeTest
	public void killprocess() throws IOException, InterruptedException
	{
		
		Runtime.getRuntime().exec("taskkill /f /im node.exe");
		System.out.println("/******************Closed the node.exe****************************/");
		Thread.sleep(5000);
		}
}
