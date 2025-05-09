package codenboxautomationlab.codenboxautomationlab;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AppTest {
	WebDriver driver = new ChromeDriver();
	String URL = "https://codenboxautomationlab.com/practice/";
	Random rand = new Random();

	@BeforeTest
	public void mySetup() {
		driver.get(URL);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void radioButton() {
		List<WebElement> allRadioButton = driver.findElements(By.className("radioButton"));
		int totalRadioBtn = driver.findElements(By.className("radioButton")).size();
		System.out.println("Total Radio Btn =" + totalRadioBtn);
		int randomRadioBtnIndex = rand.nextInt(totalRadioBtn);
		WebElement randomRadioButton = allRadioButton.get(randomRadioBtnIndex);
		randomRadioButton.click();
	}

	@Test(priority = 2)
	public void dynamicDropdownList() throws InterruptedException {
		String[] countryPrefixes = { "Un", "Ca", "In", "Ch", "Br", "Ge", "Fr", "It", "Au", "Ja" };//staticArray
        WebElement inputField= driver.findElement(By.id("autocomplete"));
        int randomCountryPrefiexIndex=rand.nextInt(countryPrefixes.length);
        inputField.sendKeys(countryPrefixes[randomCountryPrefiexIndex]);
        Thread.sleep(1000);
        inputField.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
	}
	
	@Test(priority = 3)
	public void staticDropdownList() throws InterruptedException {
		Thread.sleep(1000);
		 Select staticDropdownList = new Select(driver.findElement(By.id("dropdown-class-example")));
		 int randomOptionIndex=rand.nextInt(3);
		 Thread.sleep(1000);
		 staticDropdownList.selectByValue("option"+randomOptionIndex);
	}

	@AfterTest
	public void tearDown() {
		driver.quit(); // Closes the browser after tests
	}
}
