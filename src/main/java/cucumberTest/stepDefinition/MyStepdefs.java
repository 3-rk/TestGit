package cucumberTest.stepDefinition;
import Page_Factory.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;

public class MyStepdefs {
    public WebDriver driver;

    //initialize page factory classes
    LoginPage login;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vamankarve\\drivers_selenium\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    //initialize pages
        login = PageFactory.initElements(driver,LoginPage.class);
    }

    @Given("^url is launched$")
    public void url_is_launched() {
        try {
            driver.get("https://katalon-demo-cura.herokuapp.com/");
            driver.wait(200);
        }catch(Exception e){
            System.out.println(e);
        }

    }


    @When("^user clicks on book appointment$")
    public void user_clicks_on_book_appointment() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("btn-make-appointment")).click();
    }

    @When("^user logs in with valid uid and pwd$")
    public void user_logs_in_with_valid_uid_and_pwd() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        login.loginAction("John doe","ThisIsNotAPassword");
    }

    @Then("^user books appointments$")
    public void user_books_appointments() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    /*@When("^searched for uft$")
    public void searched_for_uft() {
        List <WebElement> links;
        String str;
        int j=0;

        try {
            // Write code here that turns the phrase above into concrete actions
            driver.findElement(By.id("lst-ib")).sendKeys("uft");
            driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
           // driver.wait(200);
            System.out.println("inside link search uft");
            links = driver.findElements(By.tagName("a"));
            Iterator<WebElement> i = links.iterator();

            while(i.hasNext()) {
                WebElement anchor = i.next();
                if(anchor.getAttribute("href").contains("UFT")) {
                    anchor.click();
                    System.out.println("UFT clicked");
                    break;
                }
            }
            //throw new PendingException();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Then("^display message success$")
    public void display_message_success() {
        System.out.println("ok");
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }*/


}
