package TestComponent;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pages.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landing;
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public List<HashMap<String, String>> getJsonData(String file) throws IOException {
		String jsonData = FileUtils.readFileToString(new File (file), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonData, new TypeReference <List<HashMap<String,String>>>(){});
		return data;
	}
	
	public String getScreenshot(String test, WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file = new File("D:\\Selenium\\Scripts\\PracticeTestingFrameWork\\Reports\\"+test+".png");
		FileUtils.copyFile(src, file);
		return "D:\\Selenium\\Scripts\\PracticeTestingFrameWork\\Reports\\"+test+".png";
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage initBrowser() {
		openBrowser();
		landing = new LandingPage(driver);
		landing.initUrl();
		return landing;
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
}
