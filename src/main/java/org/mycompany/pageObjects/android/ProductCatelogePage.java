package org.mycompany.pageObjects.android;

import java.util.List;
import org.mycomapny.actionsMethods.AndroidActionMethod;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductCatelogePage extends AndroidActionMethod {

	AndroidDriver driver;

	public ProductCatelogePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	List<WebElement> addCartBtn;

	@AndroidFindBy(id = "appbar_btn_cart")
	private WebElement appearBtn;

	public void addToCartButton(int index) {
		addCartBtn.get(index).click();

	}

	public CartPage appearBtn() {
		appearBtn.click();
		return new CartPage(driver);
	}

}
