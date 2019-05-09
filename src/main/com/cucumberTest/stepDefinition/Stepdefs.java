package cucumberTest.stepDefinition;

import Page_Factory.pages.LoginPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Stepdefs {
    public WebDriver driver;
    //initialize page factory classes
    LoginPage login;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vamankarve\\drivers_selenium\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        //Put a Implicit wait, this means that any search for
        //elements on the page could take the time the implicit wait is
        //set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //initialize pages
        login = PageFactory.initElements(driver, LoginPage.class);
    }

    @Given("^url is launched$")
    public void url_is_launched() throws Exception {
        // Write code here that turns the phrase above into
        //concrete actions
        try {
            driver.get("https://katalon-demo-cura.herokuapp.com/");
            driver.wait(200);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @When("^user clicks on book appointment$")
    public void user_clicks_on_book_appointment() throws Exception {
        // Write code here that turns the phrase above into
        //concrete actions
        driver.findElement(By.id("btn-make-appointment")).click();

    }

    @When("^user logs in with valid uid and pwd$")
    public void user_logs_in_with_valid_uid_and_pwd() throws Exception {
        // Write code here that turns the phrase above into
        //concrete actions
        login.loginAction("John doe", "ThisIsNotAPassword");
    }

    @Then("^user books appointments$")
    public void user_books_appointments() throws Exception {
        // Write code here that turns the phrase above into
        //concrete actions
        System.out.println("aapt");
    }
}
