package colestw.demo.shoppinglist;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class ShoppingListStepdefs {

	WebDriver driver;

	@Given("^I visit the Coles Shopping List site$")
	public void I_visit_the_Coles_Shopping_List_site() throws Throwable {
		// Express the Regexp above with the code you wish you had
		driver.get("http://localhost:9000");
	}

	@When("^I create a new shopping list$")
	public void I_create_a_new_shopping_list() throws Throwable {
		// Express the Regexp above with the code you wish you had
		driver.findElement(By.id("btnCreateShoppingList")).click();
	}

	@Then("^I should have a shopping list$")
	public void I_should_have_a_shopping_list() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Before
	public void before() {
		driver = new FirefoxDriver();
	}

	@After
	public void after() {
		if (driver != null) {
			driver.quit();
		}
	}
}