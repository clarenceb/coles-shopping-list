package colestw.demo.shoppinglist;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;


import cucumber.runtime.converters.ListConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

//import static junit.framework.Assert.assertEquals;

public class ShoppingListStepdefs {

	WebDriver driver;
    private ShoppingList shoppingList;


	@Given("^I visit the Coles Shopping List site$")
	public void I_visit_the_Coles_Shopping_List_site() throws Throwable {
		driver.get("http://localhost:9000");
	}

	@When("^I log in$")
	public void I_create_a_new_shopping_list() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("guillaume@sample.com");
		driver.findElement(By.name("password")).sendKeys("secret");
        driver.findElement(By.name("password")).submit();
	}

    @Then("^I should see my dashboard$")
    public void I_should_see_my_dashboard() throws Throwable {
        driver.findElement(By.className("loader"));
    }

    @Given("^an empty shopping list$")
    public void a_empty_shopping_list() throws Throwable {
        shoppingList = new ShoppingList();
    }

    @When("^I add a shopping item to the list$")
    public void I_add_an_item_to_the_list(List<ShoppingItem> items) throws Throwable {
        for (ShoppingItem item : items) {
            shoppingList.addItem(item.name, item.count);
        }
    }

    @Then("^the shopping list should look like:$")
    public void it_should_look_like(String expected) throws Throwable {
//        String shoppingItemList;
//        for (ShoppingItem item : shoppingList) {
//            shoppingItemList = item.count.toString() + " " + item.name;
//        }
//        assertEquals(expected, shoppingItemList);
        //throw new PendingException();
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

    public static class ShoppingItem {
        private String name;
        private Integer count;
    }
}
