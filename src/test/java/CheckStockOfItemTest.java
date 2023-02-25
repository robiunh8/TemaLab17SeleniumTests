import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CheckStockOfItemTest {

    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void AddtocartCheckStock() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("dani.ban112@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("1ParolaPtTest1");
        driver.findElement(By.cssSelector("#send2")).click();

        driver.findElement(By.cssSelector(".level0.nav-5.parent > .has-children.level0")).click();
        driver.findElement(By.cssSelector("h2 [title]")).click();
        driver.findElement(By.cssSelector("img[alt='Blue']")).click();
        driver.findElement(By.cssSelector("a[name='xs'] > .swatch-label")).click();
        driver.findElement(By.cssSelector("#qty")).sendKeys("999");
        driver.findElement(By.cssSelector(".add-to-cart-buttons span:nth-of-type(1) span")).click();


        WebElement errorMsg = driver.findElement(By.cssSelector(".error-msg span"));

        String expectedText = "The requested quantity for \"Slim fit Dobby Oxford Shirt\" is not available.";
        String actualText = errorMsg.getText();

        Assert.assertEquals(expectedText, actualText);
    }


    @After
    public void quit() {
        driver.close();
    }
}




