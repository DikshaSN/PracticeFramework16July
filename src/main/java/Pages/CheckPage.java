package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponent.AbstractComponent;

public class CheckPage extends AbstractComponent{

	WebDriver driver;
	public CheckPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement tbox;
	
	@FindBy(css=".list-group-item")
	List<WebElement> countries;
	
	@FindBy(css=".action__submit")
	WebElement submitButton;
	
	public void selectCountry(String country) {
		Actions a = new Actions(driver);
		a.sendKeys(tbox, country).build().perform();
		WebElement India= countries.stream().filter(s->s.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		India.click();
	}
	public void goToConfirmationPage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		submitButton.click();
	}

}
