import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyAccountVerifyTest {

    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void VerifyLoginTextPage() {

        driver.findElement(By.cssSelector(".footer [title='My Account']")).click();

        WebElement loginMsg = driver.findElement(By.cssSelector(".page-title"));
        String expectedText = "LOGIN OR CREATE AN ACCOUNT";
        String actualText = loginMsg.getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @After
    public void quit() {
        driver.close();
    }
}

