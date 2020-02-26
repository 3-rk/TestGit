package stepDefinition;

//import Page_Factory.pages.AppointmentsPage;

import Page_Factory.pages.AppointmentPage;
import Page_Factory.pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Stepdefs {
    public WebDriver driver;

    public String apptID;
    //initialize page factory classes
    LoginPage login;
    AppointmentPage apptmentPage;

    static ExtentTest test;
    static ExtentHtmlReporter reporter;
    static ExtentReports extent;

    @Before
    public void before() {
        try {
            String dirpath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", dirpath + "\\src\\main\\Drivers\\chromedriver.exe");
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
            apptmentPage = PageFactory.initElements(driver, AppointmentPage.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Before
    public static void startTest() {
        String curDir = System.getProperty("user.dir");
        System.out.println(curDir + "\\Reports\\learn_automation1.html");
        reporter = new ExtentHtmlReporter(curDir + "\\Reports\\learn_automation1.html");

        // Create object of ExtentReports class- This is main class which will create report
        extent = new ExtentReports();

        // attach the reporter which we created in Step 1
        extent.attachReporter(reporter);


        // call createTest method and pass the name of TestCase- Based on your requirement
        test = extent.createTest("LoginTest");
    }

    @Given("^url is launched$")
    public void url_is_launched() throws Exception {
        // Write code here that turns the phrase above into
        //concrete actions
        try {
            driver.get("https://katalon-demo-cura.herokuapp.com/");
            driver.wait(300);
            test.log(Status.PASS, "Navigated to the specified URL");
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

//    @When("^user logs in with valid uid and pwd$")
//    public void user_logs_in_with_valid_uid_and_pwd() throws Exception {
//        try {
//            login.loginAction( "John Doe", "ThisIsNotAPassword" );
//            driver.wait(200);
//            test.log(LogStatus.PASS, "Logged into the application successfully");
//        }catch (Exception e){
//            System.out.println(e); }
//    }

//    @Then("^user books appointments$")
//    public void user_books_appointments() throws Exception {
//       apptmentPage.bookAppointment("Hongkong CURA Healthcare Center", "12/05/2019", "Test Automation appointment");
//       test.log(LogStatus.PASS, "appointment booked successfully");
//    }


    @And("^user logs in with valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userLogsInWithValidAnd(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            login.loginAction(arg0, arg1);
            test.log(Status.PASS, "Logged into the application successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Then("^user books appointments with data$")
    public void user_books_appointments_with_data(DataTable arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        List<List<String>> list = arg1.asLists(String.class);
        for (int i = 1; i < list.size(); i++) {
            String fname = list.get(i).get(0);
            String dtofappt = list.get(i).get(1);
            String txtcomment = list.get(i).get(2);
            apptID = "1000" + i;
            System.out.println(fname);
            apptmentPage.bookAppointment(fname, dtofappt, txtcomment + apptID);
            test.log(Status.PASS, "appointment booked " + i + "successfully");
            //reinit elements to re initialize dom
            apptmentPage = PageFactory.initElements(driver, AppointmentPage.class);
            driver.navigate().refresh();
        }
        //driver.close();
        driver.findElement(By.xpath("//*[@id='menu-toggle']")).click();
        driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[3]/a")).click();
        String aptid = driver.findElement(By.xpath("//*[@id='comment']")).getText();
        System.out.println(aptid + aptid.length());
        String id = aptid.substring(aptid.length() - 5);
        System.out.println(id);
    }


    @AfterClass
    public static void endTest() {

        extent.flush();

    }


}

