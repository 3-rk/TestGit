
package cucumberTest.stepDefinition;

import Page_Factory.pages.AppointmentsPage;
import Page_Factory.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
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
    AppointmentsPage apptmentPage;

    static ExtentTest test;
    static ExtentReports report;

    @Before
    public void before() {

//        String currentDir = System.getProperty("user.dir");
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
        apptmentPage = PageFactory.initElements(driver, AppointmentsPage.class);
    }

    public static void startTest() {
        report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");

        test = report.startTest("Cura Healthcare site Test");

    }
    @Given("^url is launched$")
    public void url_is_launched() throws Exception {
        // Write code here that turns the phrase above into
        //concrete actions
        try {
            driver.get("https://katalon-demo-cura.herokuapp.com/");
            driver.wait(200);
            test.log(LogStatus.PASS, "Navigated to the specified URL");
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
        login.loginAction("John Doe", "ThisIsNotAPassword");
        //test.log(LogStatus.PASS, "Logged into the application successfully");
    }

    @Then("^user books appointments$")
    public void user_books_appointments() throws Exception {
        apptmentPage.bookAppointment("Hongkong CURA Healthcare Center", "12/05/2019", "Test Automation appointment");
        test.log(LogStatus.PASS, "appointment booked successfully");
    }

    @AfterClass
    public static void endTest() {
        report.endTest(test);
        report.flush();
    }

}
