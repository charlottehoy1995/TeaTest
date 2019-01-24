package maven.cucumber.testing.TeaTesting;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeaSteps {

	WebDriver driver;
	int i;
	ExtentReports report;
	ExtentTest test;

	@Before
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		report = new ExtentReports("C:\\Users\\Administrator\\Desktop\\TeaReport.html", true);
		test = report.startTest("Tea Test");

	}

	@After
	public void closeDown() {
		driver.quit();
	}

	@Given("^the correct web address$")
	public void the_correct_web_address() {
		// System.out.println("error here");
		driver.get("http://www.practiceselenium.com/welcome.html");

		test.log(LogStatus.INFO, "Browser started");

	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {

		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		homepage.clickButton();

		test.log(LogStatus.INFO, "Menu Page Navigation");
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {

		String title = driver.getTitle();

		if (title.equals("Menu")) {
			test.log(LogStatus.PASS, "Passed");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}

		assertEquals("Green Tea",
				driver.findElement(By
						.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong"))
						.getText());

	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {

		Menu menupage = PageFactory.initElements(driver, Menu.class);
		menupage.clickButton();

		test.log(LogStatus.INFO, "Checkout Page Navigation");
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {

		Checkout checkoutPage = PageFactory.initElements(driver, Checkout.class);
		checkoutPage.fillForm();

		test.log(LogStatus.INFO, "Form filled out correctly");

		report.endTest(test);
		report.flush();

	}

}
