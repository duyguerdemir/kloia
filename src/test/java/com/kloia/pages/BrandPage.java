package com.kloia.pages;

import com.kloia.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandPage extends BasePage {

    public BrandPage() {

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath ="//a[@title='Markalar']" )
    public WebElement brandHeader;
}
