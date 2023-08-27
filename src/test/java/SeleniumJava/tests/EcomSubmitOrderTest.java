package SeleniumJava.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumJava.TestComponents.BaseTest;
import SeleniumJava.pageObjects.OrderConfirmation;
import SeleniumJava.pageObjects.OrderPage;
import SeleniumJava.pageObjects.ProductBilling;
import SeleniumJava.pageObjects.ProductCatalogue;
import SeleniumJava.pageObjects.ProductCheckout;
import io.github.bonigarcia.wdm.WebDriverManager;


public class EcomSubmitOrderTest extends BaseTest {
	//String productName = "ZARA COAT 3";
	String path = System.getProperty("user.dir")+"/src/test/java/SeleniumJava/data/PurchaseOrder.json";

	@Test(dataProvider = "getData")
	public void productOrderValidation(HashMap<String, String> input) throws IOException {
		String confirmOrderMsg = "THANKYOU FOR THE ORDER.";
    	ProductCatalogue prodCatalogue = lp.loginApplication(input.get("email"), input.get("password"));
		ProductCheckout prodCheckout  = prodCatalogue.addProductToCart(input.get("product"));
		Assert.assertTrue(prodCheckout.isItemPresent(input.get("product")));
		ProductBilling prodBill = prodCheckout.clickCheckOutBtn();
		OrderConfirmation ordCon = prodBill.placeOrder("India");
		Assert.assertEquals(confirmOrderMsg, ordCon.getConfirmMessage());
	}
	
	@Test(dependsOnMethods = {"productOrderValidation"},dataProvider = "getData")
	public void orderHistoryTest(HashMap<String, String> input) throws IOException {
		ProductCatalogue prodCatalogue = lp.loginApplication(input.get("email"), input.get("password"));
		OrderPage orderPage = prodCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(input.get("product")));


	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
	  List<HashMap<String, String>> data = 	getJsonDatatoMap(path);
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
//	@DataProvider
//	public Object[][] getData() throws IOException {
////		HashMap<String, String> map = new HashMap<String, String>();
////		map.put("email", "ash110uce@gmail.com");
////		map.put("password", "Ashmit@12345");
////		map.put("product", "ZARA COAT 3");
////		HashMap<String, String> map1 = new HashMap<String, String>();
////		map1.put("email", "ash85uce@gmail.com");
////		map1.put("password", "Ashmit@12345");
////		map1.put("product", "ADIDAS ORIGINAL");
//		
//	  List<HashMap<String, String>> data = 	getJsonDatatoMap(path);
//		return new Object[][] {{data.get(0)},{data.get(1)}};
//	}

}
