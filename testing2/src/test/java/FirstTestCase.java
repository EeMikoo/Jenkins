import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

public class FirstTestCase {
    WebDriver driver;

    @BeforeSuite
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/V4");

    }
    @Test(dataProvider = "loginData", priority = 0)
    public void loginTest(String userId, String password, String expectedUrl){
        WebElement userIDFld = driver.findElement(By.name("uid"));
        WebElement passwordFld = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.name("btnlogin"));

        userIDFld.sendKeys(userId);
        passwordFld.sendKeys(password);
        loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @AfterSuite
    public void tearDown(){
        driver.close();

    }
    @DataProvider(name = "loginData")
    public Object[][] loginData(){
        return new Object[][] {
                {"mngr481329", "dutuhAb"}
        };
    }
}
