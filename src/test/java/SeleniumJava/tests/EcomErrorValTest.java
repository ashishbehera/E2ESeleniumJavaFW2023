package SeleniumJava.tests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumJava.TestComponents.BaseTest;
import SeleniumJava.TestComponents.Retry;
import SeleniumJava.pageObjects.LandingPage;
import SeleniumJava.pageObjects.OrderConfirmation;
import SeleniumJava.pageObjects.ProductBilling;
import SeleniumJava.pageObjects.ProductCatalogue;
import SeleniumJava.pageObjects.ProductCheckout;
import io.github.bonigarcia.wdm.WebDriverManager;


public class EcomErrorValTest extends BaseTest {

	@Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
	public void loginValidation() throws IOException {
		String errMsg = "Incorrect email or password.";
		lp.loginApplication("ash110uce@gmail.com", "Ashmit@123457");
		Assert.assertEquals(errMsg, lp.getErrorMessage());

	}

}
