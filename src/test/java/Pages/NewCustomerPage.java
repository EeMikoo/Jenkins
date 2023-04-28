package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
    WebDriver driver;
    @FindBy(linkText = "Deposit")
    WebElement DepositLink;
    @FindBy(linkText = "New Account")
    WebElement newAccountLink;
    @FindBy(name = "name")
    WebElement CusName;

    @FindBy(name = "rad1")
    WebElement radio1Btn;

    @FindBy(name = "addr")
    WebElement addressfld;
    @FindBy(name = "dob")
    WebElement DateBirth;

    @FindBy(name = "telephoneno")
    WebElement Tel;
    @FindBy(name = "city")
    WebElement City;
    @FindBy(name = "state")
    WebElement State;
    @FindBy(name = "pinno")
    WebElement PIN;
    @FindBy(name = "emailid")
    WebElement Email;
    @FindBy(name = "password")
    WebElement Password;
    @FindBy(name = "sub")
    WebElement Submitting;

    /////////////////////// New Account Page

    @FindBy(name = "cusid")
    WebElement CustomerID;

    @FindBy(name = "button2")
    WebElement SubmittingBtn2;

    public void fillCusID(String cusid){
        CustomerID.sendKeys(cusid);
    }
    //////////////////////////Deposit
    @FindBy(name = "inideposit")
    WebElement AddDeposit;

    public void fillCusDepo(String depo){
        AddDeposit.sendKeys(depo);
    }
    @FindBy(name = "accountno")
    WebElement DepositAcc;

    public void fillAccDepo(String depoAcc){
        DepositAcc.sendKeys(depoAcc);
    }

    @FindBy(name = "ammount")
    WebElement DepositAmmount;

    public void fillDepoAmmount(String depoAmmount){
        DepositAmmount.sendKeys(depoAmmount);
    }

    @FindBy(name = "desc")
    WebElement DepositDesc;

    public void fillAccDesc(String depoDesc){
        DepositDesc.sendKeys(depoDesc);
    }

    @FindBy(name = "AccSubmit")
    WebElement SubmittingBtn3;

    ///////////////////////////// Customer
    public NewCustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public NewCustomerPage() {

    }
    public void fillCusName(String cusNAME){
        CusName.sendKeys(cusNAME);
    }
//    public void fillGender(){
//        radio1Btn.click();
//    }
    public void fillDateBirth(String birthDay){
        DateBirth.sendKeys(birthDay);
    }
    public void fillAddress(String address){
        addressfld.sendKeys(address);
    }
    public void fillCity(String city){
        City.sendKeys(city);
    }
    public void fillState(String state){
        State.sendKeys(state);
    }
    public void fillPIN(String pin){
        PIN.sendKeys(pin);
    }
    public void fillTelephone(String telephone){
        Tel.sendKeys(telephone);
    }
    public void fillMail(String mail){
        Email.sendKeys(mail);
    }
    public void fillPswd(String pswd){
        Password.sendKeys(pswd);
    }
    public void clickonsubmit(){
        Submitting.click();

    }
    public void ClickOnNewAccPage(){
        newAccountLink.click();
    }
    public void ClickOnDepositPage(){
        DepositLink.click();
    }

    @FindBy(className = "heading3")
    WebElement welcomeText;
    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public void clickonsubmit2(){
        SubmittingBtn2.click();

    }
    public void clickonsubmit3(){
        SubmittingBtn3.click();

    }











}