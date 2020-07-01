package Application.Contact;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.ContactHome;
import PageObject.SearchContact;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.ElementOption;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class ContactSearchTest extends baseContact {

	@Test
	public void ContactSearch() throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		service=StartServer();
		
		AndroidDriver<AndroidElement> driver = Capabilities();
	//	driver.findElementByXPath("//android.widget.TextView[@text='CONTACTS']").click();
		ContactHome ch1 = new ContactHome(driver);
		ch1.CHome.click();
		//WebElement ele =driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Payel Jio\"))");
		
		SearchContact sc= new SearchContact(driver);

		WebElement ele = sc.CSearch;
		
		//driver.findElementByXPath("//android.widget.EditText[@text='  Search']").sendKeys("Payel Jio");
		//Thread.sleep(2000);
		
		//driver.hideKeyboard();
		//WebElement ele = driver.findElementsByClassName("android.view.ViewGroup").get(0);
		
		//int size = driver.findElementsByClassName("android.view.ViewGroup").size();
		//System.out.println(size);
				TouchAction touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(ele))).perform();
		driver.findElementById("com.samsung.android.contacts:id/expand_detail").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='ALLOW']").click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
				

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



