package Tests;

import Pages.NewAccountPage;
import Pages.NewCustomerPage;
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
import Pages.HomePage;
import Pages.LoginPage;
import javax.xml.xpath.XPath;
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
    public void loginTest(){
        driver.get("https://demo.guru99.com/v4/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserID("mngr481329");
        loginPage.fillPassword("dutuhAb");
        HomePage homePage = loginPage.clickLoginBtn();

//        Assert.assertEquals( homePage.getWelcomeText(), "Welcome To Manager's Page of Guru99 Bank");
    }


    @Test
    public void onHomePage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        NewCustomerPage newCustomerPage = homePage.clickonNewCustomerBtn();
        NewCustomerPage newCustomerPage1 = new NewCustomerPage(driver);
        newCustomerPage1.fillCusName("Merey");
        newCustomerPage1.fillDateBirth("06082002");
        newCustomerPage1.fillAddress("Asa");
        newCustomerPage1.fillCity("Taraz");
        newCustomerPage1.fillState("Zhambyl");
        newCustomerPage1.fillPIN("080200");
        newCustomerPage1.fillTelephone("87006862356");
        newCustomerPage1.fillMail("miko5@gmail.com");
        newCustomerPage1.fillPswd("QCkrQMD98");
        newCustomerPage1.clickonsubmit();
        Thread.sleep(1000);

        WebElement xp = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]"));

        newCustomerPage1.ClickOnNewAccPage();
        newCustomerPage1.fillCusID(xp.getText());
        newCustomerPage1.fillCusDepo("1000");
        newCustomerPage1.clickonsubmit2();

        newCustomerPage1.ClickOnDepositPage();
        Assert.assertEquals( homePage.getWelcomeText(), "Amount Deposit Form");
        newCustomerPage1.fillAccDepo("120175");
        newCustomerPage1.fillDepoAmmount("1000");
        newCustomerPage1.fillAccDesc("500");
        newCustomerPage1.clickonsubmit3();

    }

    @Test
    public void deposit(){

    }
    @AfterSuite()
    public void close(){
        driver.close();
    }
}