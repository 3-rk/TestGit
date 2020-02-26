package Page_Factory.TestCases;

import Page_Factory.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tests_Suite {
    WebDriver driver;
//    static ExtentTest test;
//    static ExtentReports report;
//
//    @BeforeTest
//    public static void startTest() {
//        report = new ExtentReports( System.getProperty( "user.dir" ) + "\\ExtentReportResults.html" );
//        test = report.startTest( "Cura Healthcare site Test" );
//    }

    @BeforeTest
    public void initialize() {
        ChromeOptions options;
        try {
            String dirpath = System.getProperty( "user.dir" );
            System.setProperty( "webdriver.chrome.driver", dirpath + "\\src\\main\\Drivers\\chromedriver.exe" );
            options = new ChromeOptions();
            options.addArguments( "disable-infobars" );
            driver = new ChromeDriver( options );
            driver.get( "https://katalon-demo-cura.herokuapp.com/" );

            //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
            driver.manage().timeouts().implicitlyWait( 15, TimeUnit.SECONDS );
            driver.manage().window().fullscreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test() {
        LoginPage login = PageFactory.initElements( driver, LoginPage.class );
        //      test.log( LogStatus.PASS, "Navigated to the specified URL" );
        driver.findElement( By.id( "btn-make-appointment" ) ).click();
        login.loginAction( "John doe", "ThisIsNotAPassword" );
//        test.log( LogStatus.PASS, "Logged into the application successfully" );
        driver.close();
    }

//    @AfterClass
//    public static void endTest() {
//        report.endTest( test );
//        report.flush();
//    }
}
