Feature: Footer Links

  @footer
  Scenario: Verify the footer links with the text file

    Given the user is on home page
    And the user gets all the links at the footer
    Then click brands at the footer
    Then the footer links should be same with the text file

