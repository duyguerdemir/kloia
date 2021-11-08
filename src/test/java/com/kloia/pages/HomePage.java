package com.kloia.pages;

import com.kloia.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@class='menuLink user']")
    public WebElement userName;

    @FindBy(xpath = "//a[@title='Favorilerim / Listelerim']")
    public WebElement favouritesList;

   @FindBy (xpath = "//div[@class='columnContent p10']")
   public WebElement footerPart;

    @FindBy (xpath = "//div[@class='columnContent p10']/ul/li")
   public List<WebElement> footerLinks;

    @FindBy (xpath = "(//div[@class='columnContent p10']/ul/li)[4]")
    public WebElement brandFooter;




}
