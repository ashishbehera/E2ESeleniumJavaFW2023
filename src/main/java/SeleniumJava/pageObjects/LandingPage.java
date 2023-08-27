package SeleniumJava.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumJava.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	private WebElement  userEmail;
	
	@FindBy(id="userPassword")
	private WebElement userPassword;
	
	@FindBy(id="login")
	private WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errMes;
	
	
	public ProductCatalogue loginApplication(String userName, String password) {
		userEmail.sendKeys(userName);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalogue prodCatalogue = new ProductCatalogue(driver);
		return prodCatalogue;			
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errMes);
		return errMes.getText();
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	

}
