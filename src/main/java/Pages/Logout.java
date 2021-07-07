package Pages;

import com.facebook.test.BaseProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Logout extends BaseProgram {

        @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/span[1]/div[1]/div[1]/i[1]")
        WebElement Logout;

        public Logout(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public void logout() throws InterruptedException {
        //    Account.click();

            Logout.click();
            Thread.sleep(1000);
            // System.out.println("Logout Successfully!");

            String actualurl = "https://www.facebook.com/";
            String expectedurl = driver.getCurrentUrl();
            Assert.assertEquals(expectedurl,actualurl);

        }

    }

