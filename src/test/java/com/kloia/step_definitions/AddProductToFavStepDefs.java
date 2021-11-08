package com.kloia.step_definitions;

import com.kloia.pages.*;
import com.kloia.utilities.BrowserUtils;
import com.kloia.utilities.ConfigurationReader;
import com.kloia.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class AddProductToFavStepDefs {

    HomePage homePage = new HomePage();
    CosmeticPage cosmeticPage = new CosmeticPage();
    FavouritesPage favouritesPage = new FavouritesPage();
    ProductPage productPage = new ProductPage();

    String actualProductName = "";
    String expectedProductName = "";

    @Then("user navigates to Perfume & Deodorant under the Cosmetic & Personal Care tab")
    public void user_navigates_to_Perfume_Deodorant_under_the_Cosmetic_Personal_Care_tab() {
        homePage.cosmeticTab.click();
        BrowserUtils.waitFor(5);
        cosmeticPage.perfumeDeodorant.click();

    }

    @When("Search for {string} in Brand filter")
    public void search_for_in_Brand_filter(String brand) {
        BrowserUtils.waitFor(5);
        cosmeticPage.searchIcon.click();
        BrowserUtils.waitFor(5);
        cosmeticPage.searchBoxforBrand.sendKeys(brand);

    }

    @When("Select {string}")
    public void select(String brand) {
        cosmeticPage.checkBoxLacoste.click();
        BrowserUtils.waitFor(5);

    }

    @When("Click 7th product on the search result page")
    public void click_product_on_the_search_result_page() {

        expectedProductName = cosmeticPage.getProductNumber7.getText();
        cosmeticPage.productNumber7.click();
        System.out.println("expectedProductName = " + expectedProductName);

    }

    @When("Add product to the Favourites")
    public void add_product_to_the_Favourites() {


        BrowserUtils.waitFor(5);
        productPage.wishListButton.click();

        productPage.switchToWindow();
        BrowserUtils.waitFor(7);

        productPage.addToFavouriteWishListBtn.click();
        BrowserUtils.waitFor(5);
        productPage.switchToWindow();
        productPage.confirmButton.click();

    }

    @When("Navigate to Favourites")
    public void navigate_to_Favourites() {

        BrowserUtils.hover(homePage.myAccountMenu);

        BrowserUtils.waitForClickablility(homePage.favouritesList, 10);
        homePage.favouritesList.click();

        BrowserUtils.waitForClickablility(favouritesPage.myFavouritesList, 10);
        favouritesPage.myFavouritesList.click();
        BrowserUtils.waitFor(10);
        actualProductName = favouritesPage.myFavouriteProduct.getText();

    }

    @Then("the product title should be same as with the product details page")
    public void the_product_title_should_be_same_as_with_the_product_details_page() {

        Assert.assertEquals(expectedProductName, actualProductName);


        /*String expectedProductName = productPage.selectedFavouriteProduct.getText();
       String actualProductName= favouritesPage.myFavouriteProduct.getText();

        System.out.println("expectedProductName = " + expectedProductName);
        System.out.println("actualProductName = " + actualProductName);

        BrowserUtils.waitFor(15);

        Assert.assertEquals(expectedProductName, actualProductName);*/

    }


}
