package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class ProductPage extends AbstractComponent{

	WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	 @FindBy(css=".ng-animating")
	 WebElement spinner;
	 
	 By productList = By.cssSelector(".mb-3");
	 By addToCart = By.cssSelector(".card-body button:last-of-type");
	 By toastMessage = By.id("toast-container");
	 
	 public List<WebElement> waitforListtoAppear() {
		 waitforElementtoAppear(productList);
		 return products;
	 }
	 
	 public WebElement getProduct(String product) {
		 WebElement item = products.stream().filter(s->s.findElement(By.tagName("b")).getText().equalsIgnoreCase(product)).findFirst().orElse(null);
		 return item;
	 }
	 
	 public void addToCart(String prod) throws InterruptedException {
		 WebElement pro = getProduct(prod);
		 pro.findElement(addToCart).click();
		 waitforElementtoAppear(toastMessage);
		 waitforElementtoDisAppear(spinner);
	 }
}
