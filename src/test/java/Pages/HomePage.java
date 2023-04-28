package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(className = "heading3")
    WebElement welcomeText;

    @FindBy(linkText = "New Customer")
    WebElement newCustomerLink;

    @FindBy(linkText = "New Account")
    WebElement newAccountLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public NewCustomerPage clickonNewCustomerBtn() {
        newCustomerLink.click();
        return new NewCustomerPage();


    }
}