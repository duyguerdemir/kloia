package com.kloia.pages;

import com.kloia.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy (xpath = "//nav[@class='catMenu']/ul/li[5]")
    public WebElement cosmeticTab;

    @FindBy (xpath = "//a[@title='Hesabım'][1]")
    public WebElement myAccountMenu;

    @FindBy (xpath = "//a[@title='Favorilerim / Listelerim']")
    public WebElement favourites;

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