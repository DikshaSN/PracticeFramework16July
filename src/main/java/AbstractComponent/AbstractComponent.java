package AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.CartPage;

public class AbstractComponent {
	
	public WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cartButton;
	
	public void waitforElementtoAppear(By ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	
	public void waitforElementtoDisAppear(WebElement ele) throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public CartPage goToCart() {
		cartButton.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}

}
