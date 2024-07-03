package org.mycompany.pageObjects.android;

import java.util.List;
import org.mycomapny.actionsMethods.AndroidActionMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage extends AndroidActionMethod {

	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@AndroidFindBy(xpath = "productPrice")
	List<WebElement> productList;

	@AndroidFindBy(id = "totalAmountLbl")
	WebElement totalAmnt;

	public List<WebElement> productPrice() {
		return productList;
	}

	public double getProductSum() {

		// List<WebElement> productPrices = driver.findElements(By.id("productPrice"));

		int count = productList.size();
		double TotalSum = 0;
		for (int i = 0; i < count; i++) {
			String amountString = productList.get(i).getText();
			System.out.println(amountString);
			Double actualValue = Double.parseDouble(amountString.substring(1));
			TotalSum = TotalSum + actualValue;
			// return TotalSum;
		}
		return TotalSum;
	}

	public double amountValidation() {
		// System.out.println("Products sum is" + TotalSum);
		String totalAmount = totalAmnt.getText();
		double sumAmount = Double.parseDouble(totalAmount.substring(1));
		return sumAmount;
	}

	 
	
//		if (TotalSum == sumAmount) {
//
//		} else
//			System.out.println("Amount not matched");
//	}

	// addCartBtn.get(index).click();

}
