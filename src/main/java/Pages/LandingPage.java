package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement email ;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	public void initUrl() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public ProductPage lauchApplication(String a, String b) {
		email.sendKeys(a);
		password.sendKeys(b);
		submit.click();
		ProductPage product = new ProductPage(driver);
		return product;
	}

}
