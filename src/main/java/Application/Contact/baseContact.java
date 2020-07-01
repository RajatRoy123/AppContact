package Application.Contact;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class baseContact {
	
	public static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service;
	
	AppiumDriverLocalService StartServer()
	{
		System.out.println("Entered start server");
		boolean serverRunning = checkIfServerIsRunnning(4723);
		if(!serverRunning)
		
			{ 
			System.out.println("Entered start server");
			AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
			service.start();
			
			}
		return service;
			
		
	}

	public boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}	
 

	
	
	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability("appPackage", "com.samsung.android.contacts");
		//cap.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		cap.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
		
		
	}
	

	public static void getScreenShot(String testname) throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+testname+".png"));
		
		//File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Contact"+testname+".png"));
		
		
	}
	
		
		
	}
