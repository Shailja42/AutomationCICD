package org.mycompany;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.mycompany.pageObjects.android.FormPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	FormPage form ;

	@BeforeClass
	public void BasicConfig() throws MalformedURLException, URISyntaxException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C://Users//akumar94//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		// ("http://127.0.0.1").usingPort(4723).build();
		UiAutomator2Options options = new UiAutomator2Options();
		// options.setAvd("Nexus_5X_API_30") ;
		

		options.setChromedriverExecutable("C://Users//akumar94//Downloads//chromedriver-win64 (1)//chromedriver-win64//chromedriver.exe");
		options.setDeviceName("ShailjasPhone");
		options.setApp("C://Users//akumar94//eclipse-workspace//appiumProject//src//test//java//resources//General-Store.apk");

		//options.setApp("C://Users//akumar94//AndroidApps//resources//ApiDemos-debug.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		form= new FormPage(driver);

		// driver.findElement(AppiumBy.accessibilityId("Preference")).click();

	}

	void LongPressMethod(WebElement ele)
	{
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
		ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
		
	}

	@AfterClass
	void tearDown() {
		// driver.quit();
		// service.stop();
	}
}
