package SeleniumJava.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumJava.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3")); 
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spineer;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartBtn;
	
	
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getCartBtn() {
		
		return cartBtn;
		
	}
	
	public  WebElement getProductByName(String productName) {
		
		WebElement prod = getProductList().stream().filter(product -> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public ProductCheckout addProductToCart(String productName) {
		
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click(); 
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spineer);
		getCartBtn().click();
		ProductCheckout prodCheckout = new ProductCheckout(driver);
		return prodCheckout;
	}
	
	

}
