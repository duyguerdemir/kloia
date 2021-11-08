package com.kloia.step_definitions;

import com.kloia.pages.BrandPage;
import com.kloia.pages.HomePage;
import com.kloia.utilities.BrowserUtils;
import com.kloia.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FooterLinkStepDefinitions {

    HomePage homePage = new HomePage();
    String textFile = "C:\\Users\\duygu\\IdeaProjects\\KloiaTask\\src\\test\\resources\\FooterLinks.txt";

    @Given("the user gets all the links at the footer")
    public void the_user_gets_all_the_links_at_the_footer() throws IOException {

        BrowserUtils.scrollToElement(homePage.footerPart);

        List<String> footerLinkText = BrowserUtils.getElementsText(homePage.footerLinks);

        File file = new File(textFile);
        FileWriter fileWriter = new FileWriter(file);

        for (int i = 0; i < footerLinkText.size(); i++) {
            String link = footerLinkText.get(i);
            System.out.println("link = " + link);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(link);
            writer.newLine();
            writer.flush();
        }

    }
    @Then("click brands at the footer")
    public void clickBrandsAtTheFooter() {

        homePage.brandFooter.click();
        BrowserUtils.waitFor(5);
    }

    @Then("the footer links should be same with the text file")
    public void the_footer_links_should_be_same_with_the_text_file() throws IOException {

        String expectedTitle = new BrandPage().brandHeader.getText();
        System.out.println("expectedTitle = " + expectedTitle);

        File file = new File(textFile);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        ArrayList <String> listOfLines = new ArrayList<>();

        String line = reader.readLine();
        while (line !=null) {
            listOfLines.add(line);
            line = reader.readLine();
        }
        System.out.println("listOfLines = " + listOfLines);
        System.out.println("Is actual title equals expected title? = " + listOfLines.contains(expectedTitle));
        Assert.assertTrue(listOfLines.contains(expectedTitle));

    }


}
