package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> titles;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkButton;
	
	public Boolean verifyTitles(String product) {
		Boolean match = titles.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		return match;
	}
	
	public CheckPage goToCheckPage() {
		checkButton.click();
		CheckPage check = new CheckPage(driver);
		return check;
	}

}
