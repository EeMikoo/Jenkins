package Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.LoginPage;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeSuite
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://moodle.sdu.edu.kz/login/index.php");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserID("200103080");
        loginPage.fillPassword("17036889");
        loginPage.clickLoginBtn();
        Thread.sleep(1000);
    }

    @AfterSuite()
    public void close(){
        driver.close();
    }
}