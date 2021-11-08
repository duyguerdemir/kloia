Feature: Favourites
@wip
  Scenario: Add product to the ‘Favorites’ (Favorilerim)

    Given the user is on home page
    When the user clicks Giris Yap
    Then the user clicks Facebook ile Giris Yap
    And the user enters email and password and clicks login

    And user navigates to Perfume & Deodorant under the Cosmetic & Personal Care tab
    When Search for "Lacoste" in Brand filter
    And Select "Lacoste"
    And Click 7th product on the search result page
    When Add product to the Favourites
    And Navigate to Favourites
    Then the product title should be same as with the product details page