package com.kloia.pages;

import com.kloia.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".dn-slide-deny-btn:nth-of-type(1)")
    public WebElement dahaSonraButton;

    //@FindBy(xpath = "//a[@class='btnSignIn']")
    @FindBy(className = "btnSignIn")
    public WebElement girisYapButton;

    @FindBy(xpath = "//div[@class='facebook_large medium facebookBtn  btnLogin']")
    public WebElement facebookIleGirisYap;

    @FindBy (id = "email")
    public WebElement epostaAdresiBox;

    @FindBy (id = "password")
    public WebElement sifreBox;

    @FindBy (id = "loginButton")
    public WebElement girisButton;


    public void switchToWindow() {

        String window1 = Driver.get().getWindowHandle();
        for (String windowHandle : Driver.get().getWindowHandles()) {
            if (!windowHandle.equals(window1)) {
                Driver.get().switchTo().window(windowHandle);
                break;
            }
        }
    }
}