package com.kloia.step_definitions;

import com.kloia.pages.FacebookPage;
import com.kloia.pages.HomePage;
import com.kloia.pages.LoginPage;
import com.kloia.utilities.BrowserUtils;
import com.kloia.utilities.ConfigurationReader;
import com.kloia.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();
    FacebookPage facebookPage = new FacebookPage();
    HomePage homePage = new HomePage();

    @Given("the user is on home page")
    public void the_user_is_on_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        //BrowserUtils.waitForClickablility(loginPage.dahaSonraButton, 10);
        //loginPage.dahaSonraButton.click();
        //BrowserUtils.waitFor(2);
    }

    @When("the user clicks Giris Yap")
    public void the_user_clicks_Giris_Yap() {
        //BrowserUtils.waitForClickablility(loginPage.girisYapButton, 10);
        loginPage.girisYapButton.click();
        BrowserUtils.waitFor(5);

    }

   /*@Then("the user enters email and password and clicks login in login page")
    public void the_user_enters_email_and_password_and_clicks_login_in_login_page() {

        loginPage.epostaAdresiBox.sendKeys(ConfigurationReader.get("email"));
        loginPage.sifreBox.sendKeys(ConfigurationReader.get("password"));

    }*/


    @Then("the user clicks Facebook ile Giris Yap")
    public void the_user_clicks_Facebook_ile_Giris_Yap() {
        loginPage.facebookIleGirisYap.click();
        loginPage.switchToWindow();
        BrowserUtils.waitFor(10);

    }

   @Then("the user enters email and password and clicks login")
    public void the_user_enters_email_and_password_and_clicks_login() {
        facebookPage.emailAddressBox.sendKeys(ConfigurationReader.get("email"));
        facebookPage.passwordBox.sendKeys(ConfigurationReader.get("password"));

        facebookPage.logInButton.click();
        loginPage.switchToWindow();
        BrowserUtils.waitFor(10);

    }



    @Then("the user should be able to login successfully")
    public void the_user_should_be_able_to_login_successfully() {

        String actualUserName = "\""+homePage.userName.getText()+"\"" ;

        System.out.println(actualUserName);
        BrowserUtils.waitFor(10);
        Assert.assertTrue(homePage.userName.isDisplayed());
    }


}
