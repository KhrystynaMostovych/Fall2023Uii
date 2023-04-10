Feature: LoginFlow
  Background:
    Given user on meetup homepage

    Scenario: To validate Sing Up button is displayed
      Then user should be able to see "Sing up" button

      Scenario: To validate Login button is displayed
        Then user should be able to see "Log in" button

        Scenario: To validate Join Meetup button is displayed
          Then user should be able to see "Join Meetup" button

