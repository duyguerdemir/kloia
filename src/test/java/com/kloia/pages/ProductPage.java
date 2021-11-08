package com.kloia.pages;

import com.kloia.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    public ProductPage() {
        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(xpath = "//a[@id='getWishList']")
    public WebElement wishListButton;

    @FindBy (id = "addToFavouriteWishListBtn")
    public WebElement addToFavouriteWishListBtn;

    @FindBy (xpath = "//span[@class='btn btnBlack confirm']")
    public WebElement confirmButton;

   @FindBy (xpath = "//h1[@class='proName']")
    public WebElement selectedFavouriteProduct;
}
