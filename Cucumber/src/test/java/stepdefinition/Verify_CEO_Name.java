package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_CEO_Name {
	@Given("The user is logged in successfully and is on Home Page.")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() {
	    System.out.println("user_is_logged_in_successfully_and_is_on_home_page");
	}

	@When("the user clicks on the directory option from the Home Page")
	public void the_user_clicks_on_the_directory_option_from_the_home_page() {
		System.out.println("user_clicks_on_the_directory_option_from_the_home_page");
	}

	@When("the user select the job title as {string} from the drop down")
	public void the_user_select_the_job_title_as_from_the_drop_down(String string) {
	    System.out.println("user select the job title as {string} from the drop down");

	}

	@When("clicks search button")
	public void clicks_search_button() {
	    System.out.println("clicks search button");

	}

	@Then("the user should see the CEO Name as {string}")
	public void the_user_should_see_the_ceo_name_as(String string) {
		 System.out.println("user should see the CEO Name as {string}");
	}
		
}
