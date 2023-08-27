package SeleniumJava.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumJava.AbstractComponents.AbstractComponent;

public class ProductBilling extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductBilling(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//input[@placeholder='Select Country']")
	private WebElement txtAutoSugCntry;
	
	@FindBy(xpath="//span[@class='ng-star-inserted']")
	private List<WebElement> listCntry;
	
	@FindBy(css=".action__submit")
	private WebElement btnPlaceOrder;
	
	public WebElement txtAutoSugCntry() {
		return txtAutoSugCntry;
	}
	
	public List<WebElement> listCntry() {
		return listCntry;
	}
	
	public WebElement btnPlaceOrder() {
		return btnPlaceOrder;
	}
	
	public OrderConfirmation placeOrder(String countryName) {
		txtAutoSugCntry().sendKeys(countryName);
		WebElement autoCountry = listCntry().stream().filter(list -> list.getText().equals(countryName)).findFirst().orElse(null);
		autoCountry.click();
		btnPlaceOrder().click();
		OrderConfirmation ordCon = new OrderConfirmation(driver);
		return ordCon;
		
	}
	
	
	
	

}
