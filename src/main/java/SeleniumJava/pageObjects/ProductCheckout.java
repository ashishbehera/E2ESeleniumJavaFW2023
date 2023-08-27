package SeleniumJava.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumJava.AbstractComponents.AbstractComponent;


public class ProductCheckout extends AbstractComponent {
	
	WebDriver driver;

	public ProductCheckout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartList;
	
	@FindBy(css=".totalRow button")
	WebElement chkOutBtn;
	
	
	public List<WebElement> getCartList() {
		return cartList;
	}
	
	public boolean isItemPresent(String productName) {
		
		return getCartList().stream().anyMatch(cart -> cart.getText().equals(productName));	 
		
	}
	
	
	public ProductBilling clickCheckOutBtn() {
		chkOutBtn.click();
		ProductBilling prodBill = new ProductBilling(driver);
		return prodBill;
		
	}
	

}
