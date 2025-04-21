package codenboxautomationlab.codenboxautomationlab;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class AppTest 
{
	WebDriver driver = new ChromeDriver();
    String URL = "https://codenboxautomationlab.com/practice/";
    Random rand = new Random();
	  @BeforeTest
	    public void mySetup() {
	        driver.get(URL);
	        driver.manage().window().maximize();
	    }
	  
	  @Test(priority = 1)
	    public void  RadioButton() {
		  List<WebElement> allRadioButton=driver.findElements(By.className("radioButton"));
		  int totalRadioBtn = driver.findElements(By.className("radioButton")).size();
		  System.out.println("Total Radio Btn ="+totalRadioBtn);
		  int randomRadioBtnIndex= rand.nextInt(totalRadioBtn);
		  WebElement randomRadioButton= allRadioButton.get(randomRadioBtnIndex);
		  randomRadioButton.click();
	  }
	  
	  @AfterTest
	  public void tearDown() {
	        driver.quit(); // Closes the browser after tests
	    }
}
