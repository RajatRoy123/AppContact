package Application.Contact;

import java.net.MalformedURLException;

import javax.xml.crypto.Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class LaunchContactTest extends baseContact {

	@Test(dataProvider="InputData", dataProviderClass=TestData.class)
	public void LaunchContact(String name, String number) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		//driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.findElementByXPath("//android.widget.TextView[@text='CONTACTS']").click();
		driver.findElementById("com.samsung.android.contacts:id/create_contact_header").click();
		
		TouchAction touch = new TouchAction(driver);
		Thread.sleep(2000);
		WebElement ele = driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='Phone. Not selected']");
		touch.tap(tapOptions().withElement(element(ele))).perform();
		driver.findElementById("android:id/button2").click();
		Thread.sleep(2000);
		driver.hideKeyboard();
		driver.findElementByXPath("//android.widget.EditText[@text='Name']").sendKeys(name);
		driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys(number);
		driver.findElementById("com.samsung.android.contacts:id/menu_done").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='ALLOW']").click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
	}	

}
	