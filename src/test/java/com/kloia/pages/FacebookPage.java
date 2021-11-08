package com.kloia.pages;

import com.kloia.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage extends BasePage{

    public FacebookPage(){
        PageFactory.initElements(Driver.get(), this);

    }
    @FindBy(xpath = "//input[@class='inputtext _55r1 inputtext inputtext']")
    public WebElement emailAddressBox;

    @FindBy (id = "pass")
    public WebElement passwordBox;

    @FindBy (xpath ="//input[@name='login']")
    public WebElement logInButton;
}
