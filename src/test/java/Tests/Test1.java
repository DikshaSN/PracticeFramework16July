package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.CheckPage;
import Pages.ProductPage;
import TestComponent.BaseTest;

public class Test1 extends BaseTest{
	
	@Test(dataProvider="jsonData")
	public void submitOrder(HashMap<String,String> input) throws InterruptedException {
		ProductPage product = landing.lauchApplication(input.get("email"),input.get("password"));
		product.waitforListtoAppear();
		product.addToCart(input.get("product"));
		CartPage cart = product.goToCart();
		Boolean match = cart.verifyTitles(input.get("product"));
		Assert.assertTrue(match);
		CheckPage check = cart.goToCheckPage();
		check.selectCountry("India");
		check.goToConfirmationPage();
	}
	
	@DataProvider(name="jsonData")
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>> data = getJsonData("D:\\Selenium\\Scripts\\PracticeTestingFrameWork\\src\\test\\java\\Data\\data.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};
	}

	public void gitDemo(){
		system.out.println("Code Added to git")
	}

}
