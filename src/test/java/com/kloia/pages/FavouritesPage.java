package com.kloia.pages;

import com.kloia.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavouritesPage extends BasePage {

    public FavouritesPage(){
        PageFactory.initElements(Driver.get(),this);

    }

    @FindBy (xpath = "//h4[@class='listItemTitle']")
    public WebElement myFavouritesList;

    @FindBy (xpath = "//h3[@itemprop='name']")
    public WebElement myFavouriteProduct;




}
