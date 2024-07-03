package org.mycompany;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.mycompany.pageObjects.android.CartPage;
import org.mycompany.pageObjects.android.FormPage;
import org.mycompany.pageObjects.android.ProductCatelogePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_3 extends BaseClass {

	@Test
	void FillForm() throws InterruptedException {

		form.ActionClass("Shailja");
		form.GenderClass();
		form.CountryClass();
		form.selectCountry("Austria");
		form.shopButton();
		ProductCatelogePage productCatelogePage = form.shopButton();

		productCatelogePage.addToCartButton(0);
		productCatelogePage.addToCartButton(0);
		CartPage cartPage = productCatelogePage.appearBtn();
		cartPage.productPrice();
		cartPage.amountValidation();

//		List<WebElement> productPrices = driver.findElements(By.id("productPrice"));
//
//		int count = productPrices.size();
//		double TotalSum = 0;
//		for (int i = 0; i < count; i++) {
//			String amountString = productPrices.get(i).getText();
//			System.out.println(amountString);
//			Double actualValue = Double.parseDouble(amountString.substring(1));
//			TotalSum = TotalSum + actualValue;
//
//		}
//		System.out.println("Products sum is" + TotalSum);
//		String totalAmount = driver.findElement(By.id("totalAmountLbl")).getText();
//		double sumAmount = Double.parseDouble(totalAmount.substring(1));
//		System.out.println("Total sum is: " + sumAmount);

		double TotalSum = cartPage.getProductSum();
		double sumAmount = cartPage.amountValidation();

		Assert.assertEquals(TotalSum, sumAmount);

		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(AppiumBy.id("btnProceed")).click();
		Thread.sleep(6000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Set<String> context = driver.getContextHandles();
		for (String contxtHandles : context) {
			System.out.println(contxtHandles);
		}
		Thread.sleep(2000);
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Gmail");
		// System.out.println(driver.getContext());

	}

}
