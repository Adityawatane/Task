package stepdefinitions;

import static org.testng.Assert.assertTrue;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginModule {

	WebDriver driver;
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
	    System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://uat.bhanuembroideries.com/login");
	}

	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {
	    WebElement username=driver.findElement(By.xpath("//input[@name='email']"));
	    WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	    username.sendKeys("test@admin.com");
	    password.sendKeys("Admin@123");
	}

	@When("I click the login button")
	public void i_click_the_login_button() {
	    WebElement submit_button=driver.findElement(By.xpath("//button[@type='submit']"));
	    submit_button.click();
	}

	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() {
		String expTitile="Dashboard - Admin Panel";
		String actTitle=driver.getTitle();
		Assert.assertEquals(expTitile, actTitle);
		driver.quit();
	}

	@When("I enter invalid credentials")
	public void i_enter_invalid_credentials() {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("https://uat.bhanuembroideries.com/login");
	    WebElement username=driver.findElement(By.xpath("//input[@name='email']"));
	    WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	    username.sendKeys("test@gmail.com");
	    password.sendKeys("Adopu@123");
	    WebElement submit_button=driver.findElement(By.xpath("//button[@type='submit']"));
	    submit_button.click();
	}

	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
	    WebElement errormessage = driver.findElement(By.xpath("//div[text()='Invalid credentials.']"));
	    assertTrue(errormessage.isDisplayed());
	    driver.quit();
	}

	

}
