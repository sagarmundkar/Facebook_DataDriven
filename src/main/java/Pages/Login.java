package Pages;

import com.facebook.test.BaseProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseProgram {
         //Login to the Facebook page using valid email
        @FindBy(id = "email")
        WebElement email;

        //Login to the Facebook page using valid password
        @FindBy(name = "pass")
        WebElement password;

        //Submit valid details
        @FindBy(xpath = "//button[@type='submit']")
        WebElement loginbutton;

        public Login(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public String Login(String Username, String Password) throws InterruptedException {
            email.sendKeys(Username);
            password.sendKeys(Password);
            loginbutton.click();
            Thread.sleep(1000);
            return driver.getTitle();
        }



    }




