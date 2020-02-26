package Page_Factory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


public class AppointmentPage {

    //Webelements on appointment page
    @FindBy(how = How.XPATH, using = "//*[@id='combo_facility']")
    @CacheLookup
    WebElement facilityCombobx;
    @FindBy(how = How.XPATH, using = "//*[@id='txt_visit_date']")
    @CacheLookup
    WebElement aaptDate;
    @FindBy(how = How.XPATH, using = "//*[@id='txt_comment']")
    @CacheLookup
    WebElement txtAptcomment;

    //*[@id="radio_program_medicaid"]
    @FindBy(how = How.XPATH, using = "//*[@id='btn-book-appointment']")
    @CacheLookup
    WebElement btnBookAppointmt;

    @FindBy(how = How.XPATH, using = "//*[@id='btn-make-appointment']")
    @CacheLookup
    WebElement btnMakeAppointment;

    private WebDriver driver;
    Select sel;


    public AppointmentPage(WebDriver driver) {

        this.driver = driver;
    }

    public void bookAppointment(String facilityName, String strDate, String aptComment) throws Exception {

        facilityCombobx.sendKeys( facilityName );
        aaptDate.sendKeys( strDate );
        txtAptcomment.sendKeys( aptComment );
        btnBookAppointmt.click();
        clickOnMakeAppointmentPage();

    }

    public void clickOnMakeAppointmentPage() {

        btnMakeAppointment.click();
    }

}