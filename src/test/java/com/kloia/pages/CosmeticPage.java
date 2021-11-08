package com.kloia.pages;

import com.kloia.utilities.ConfigurationReader;
import com.kloia.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CosmeticPage extends BasePage {
    public CosmeticPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@class='mainCat']/a")
    public WebElement perfumeDeodorant;

    @FindBy(xpath = "//i[@class='icon iconSearchDark']")
    public WebElement searchIcon;

    @FindBy(xpath = "//*[@class='openSearchBtn btnGrey open']/following-sibling::div/input")
    //@FindBy (xpath ="//input[@placeholder='Aranacak kelime'][@class='attributeSearch']")
    public WebElement searchBoxforBrand;

    @FindBy(id = "brand-m-Lacoste")
    public WebElement checkBoxLacoste;

    @FindBy(xpath = "//div[@data-position='7']")
    public WebElement productNumber7;

    @FindBy(xpath = "//div[@data-position='7']/div/a/h3")
    public WebElement getProductNumber7;




}
