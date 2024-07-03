package org.mycompany.pageObjects.android;

import org.mycomapny.actionsMethods.AndroidActionMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.bytebuddy.implementation.bind.annotation.Super;

public class FormPage extends AndroidActionMethod {
	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "nameField")
	private WebElement nameField;

	@AndroidFindBy(id = "radioFemale")
	private WebElement gender;

	@AndroidFindBy(id = "spinnerCountry")
	private WebElement country;
	
	@AndroidFindBy(id = "btnLetsShop")
	private WebElement shopBtn;

	public void ActionClass(String name) {
		nameField.sendKeys(name);
	}

	public void GenderClass() {
		gender.click();
	}

	public void CountryClass() {
		country.click();
	}

	public void selectCountry(String countryName) {
		country.click();
		scrollMethod(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryName + "']")).click();
	}
	
	public ProductCatelogePage shopButton()
	{
		shopBtn.click();
		return new ProductCatelogePage(driver) ;
	}
	

}
