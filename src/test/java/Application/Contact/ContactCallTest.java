package Application.Contact;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.ContactHome;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ContactCallTest extends baseContact {
	
	@Test
	public void ContactCall() throws MalformedURLException {
		// TODO Auto-generated method stub
		service=StartServer();
		
		AndroidDriver<AndroidElement> driver = Capabilities();
	//	driver.findElementByXPath("//android.widget.TextView[@text='CONTACTS']").click();
		ContactHome ch = new ContactHome(driver);
		ch.CHome.click();
		
		
		WebElement ele =driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Payel Jio\"))");
		
		//driver.findElementByXPath("//android.widget.EditText[@text='  Search']").sendKeys("Payel Jio");
		//Thread.sleep(2000);
		
		//driver.hideKeyboard();
		//WebElement ele = driver.findElementsByClassName("android.view.ViewGroup").get(0);
		
		//int size = driver.findElementsByClassName("android.view.ViewGroup").size();
		//System.out.println(size);
				TouchAction touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(ele))).perform();
		driver.findElementById("com.samsung.android.contacts:id/expand_call").click();
		
		//service.stop();
		
		
	}

	@BeforeTest
	public void killprocess() throws IOException, InterruptedException
	{
		
		Runtime.getRuntime().exec("taskkill /f /im node.exe");
		System.out.println("/******************Closed the node.exe****************************/");
		Thread.sleep(5000);
		}
}
