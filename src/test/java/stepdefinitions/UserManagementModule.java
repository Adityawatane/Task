package stepdefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagementModule {
WebDriver driver;
	@Given("I am logged in and on the user management page")
	public void i_am_logged_in_and_on_the_user_management_page() {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://uat.bhanuembroideries.com/login");
	    WebElement username=driver.findElement(By.xpath("//input[@name='email']"));
	    WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	    username.sendKeys("test@admin.com");
	    password.sendKeys("Admin@123");
	    WebElement user_click = driver.findElement(By.xpath("(//a[contains(@href,'/users')])[2]"));
	    user_click.click();
	}

	@When("I add a new user with valid details")
	public void i_add_a_new_user_with_valid_details() {
	    WebElement add_user_button = driver.findElement(By.xpath("//button[@aria-label='Add user']"));
        add_user_button.click();
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        WebElement mobilenumber=driver.findElement(By.xpath("//input[@name='contact_number']"));
        WebElement selectrole=driver.findElement(By.xpath("//input[@id='input-622']"));
        name.sendKeys("Aditya");
        email.sendKeys("asd@gmail.com");
        password.sendKeys("Admin@123");
        mobilenumber.sendKeys("7852145695");
        selectrole.sendKeys("STOCK TALLY");
        WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
	    submit.click();
	}

	@Then("the new user should be listed in the users table")
	public void the_new_user_should_be_listed_in_the_users_table() {
		WebElement userRow=driver.findElement(By.xpath("//table//tbody//tr//td[text()='Aditya']"));
	    assertTrue(userRow.isDisplayed());
	}

	@When("I edit an existing user's details")
	public void i_edit_an_existing_user_s_details() {
	    WebElement edituser = driver.findElement(By.xpath("(//button[@aria-label='Edit user'])[2]"));
	    edituser.click();
	    WebElement nameedit = driver.findElement(By.xpath("//input[@name='name']"));
	    nameedit.sendKeys("Himesh");
	    WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
	    submit.click();
	}

	@Then("the changes should be reflected in the user details")
	public void the_changes_should_be_reflected_in_the_user_details() {
		WebElement userRow = driver.findElement(By.xpath("//table//tbody//tr//td[text()='Himesh']"));
        assertTrue(userRow.isDisplayed());
	}

	@When("I delete a user I previously added")
	public void i_delete_a_user_i_previously_added() {
		WebElement deleteButton = driver.findElement(By.xpath("(//button[@aria-label='Delete user'])[2]"));
        deleteButton.click();
        WebElement confirmButton = driver.findElement(By.xpath("//button[@class='btn btn-black m-b-10 m-t-10 v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default']"));
        confirmButton.click();
	}

	@Then("the user should no longer be listed in the users table")
	public void the_user_should_no_longer_be_listed_in_the_users_table() {
		WebElement userRow = driver.findElement(By.xpath("//table//tbody//tr//td[text()='Himesh']"));
        assertFalse(userRow.isDisplayed());
        
	}

	@When("I search for a specific user")
	public void i_search_for_a_specific_user() {
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='input-1319']"));
        searchBox.sendKeys("Aditya");
        
	}

	@Then("the search results should display the matching user")
	public void the_search_results_should_display_the_matching_user() {
		WebElement userRow = driver.findElement(By.xpath("//table//tr//td[text()='Aditya']"));
        assertTrue(userRow.isDisplayed());
	}

	@When("I filter users by role")
	public void i_filter_users_by_role() {
		WebElement roleFilter = driver.findElement(By.name("//button[@aria-label='Filter']"));
        roleFilter.click();
        WebElement filter = driver.findElement(By.xpath("//input[@aria-label='Role']"));
        filter.sendKeys("STOCK TALLY");
	}

	@Then("the results should only show users with the selected role")
	public void the_results_should_only_show_users_with_the_selected_role() {
		WebElement userRows = driver.findElement(By.xpath("//table//td//span[text()='STOCK TALLY']"));
        assertTrue(userRows.isDisplayed());
        driver.quit();
	}
}
