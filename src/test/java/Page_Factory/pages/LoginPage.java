package Page_Factory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    //Webelements
    @FindBy(how = How.ID, using = "txt-username")
    @CacheLookup
    WebElement usrId;

    @FindBy(how = How.ID, using = "txt-password")
    @CacheLookup
    WebElement userPwd;


    @FindBy(how = How.ID, using = "btn-login")
    @CacheLookup
    WebElement btnLogin;

    public void loginAction(String uId, String usrPwd) {
        try {

            usrId.sendKeys( uId );
            userPwd.sendKeys( usrPwd );
            btnLogin.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
