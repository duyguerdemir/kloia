Feature: Login

@login
Scenario: Login with Facebook account
  Given the user is on home page
  When the user clicks Giris Yap
  Then the user clicks Facebook ile Giris Yap
  #Then the user enters email and password and clicks login in login page
  And the user enters email and password and clicks login
  Then the user should be able to login successfully



