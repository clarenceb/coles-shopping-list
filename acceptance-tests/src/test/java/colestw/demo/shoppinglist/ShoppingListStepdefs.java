package colestw.demo.shoppinglist;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;


import cucumber.runtime.converters.ListConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.Console;
import java.util.List;

import static junit.framework.Assert.assertEquals;

//import static junit.framework.Assert.assertEquals;

public class ShoppingListStepdefs {

	WebDriver driver;
    private ShoppingList shoppingList;


	@Given("^I visit the Coles Shopping List site$")
	public void I_visit_the_Coles_Shopping_List_site() throws Throwable {
        String targetHost = System.getenv("TARGET_HOST");
        if (targetHost == null || targetHost == "") {
            targetHost = "http://localhost:9000";
		}

        driver.get(targetHost);
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

    @When("^my shopping list is empty$")
    public void my_shopping_list_is_empty() throws Throwable {
        shoppingList = new ShoppingList();
    }

    @When("^I add a shopping item to the list$")
    public void I_add_an_item_to_the_list(List<ShoppingItem> items) throws Throwable {
        for (ShoppingItem item : items) {
            shoppingList.addItem(item.name, item.count);
        }
    }

    @When("^I enter a new item$")
    public void I_enter_a_new_item() throws InterruptedException {
        driver.findElement(By.name("taskBody")).sendKeys("A NEW ITEM");
        Thread.sleep(2000);
        driver.findElement(By.name("taskBody")).submit();
        Thread.sleep(2000);
    }
//
//    @When("^I can see that the item has been added to the list$")
//    public void I_can_see_that_the_item_has_been_added_to_the_list() {
//        String someText = driver.findElement(By.tagName("h4")).getText();
//        assertEquals("A NEW ITEM", someText);
//    }



    @Then("^the shopping list should look like:$")
    public void it_should_look_like(String expected) throws Throwable {
        StringBuilder shoppingItemList = new StringBuilder();
        shoppingList.print(shoppingItemList);
        assertEquals(expected, shoppingItemList.toString());
    }

    @Given("^I select a project group$")
    public void I_select_a_project_group() {
        driver.findElement(By.id("foo")).click();
    }

    @Then("^I can see the list of items in the group$")
    public void I_can_see_the_list_of_items_in_the_group(){
        driver.findElement(By.className("folder"));
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
