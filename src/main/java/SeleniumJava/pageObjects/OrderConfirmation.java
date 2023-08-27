package SeleniumJava.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumJava.AbstractComponents.AbstractComponent;

public class OrderConfirmation extends AbstractComponent {

	WebDriver driver;
	
	public OrderConfirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(css=".hero-primary")
	private WebElement lblConfirmMsg;
	
	public WebElement lblConfirmMsg() {
		return lblConfirmMsg;
	}
	
	public String getConfirmMessage() {
		return  lblConfirmMsg().getText().trim();
	}
	

}
