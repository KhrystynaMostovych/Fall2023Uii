Feature: Basic Validation

  Background:
    Given user on meetup homepage

  Scenario: To validate the title
    Then usen should see titile page contains "Meetup"

    Scenario:to validate the url
      Then User should verify the url contains "https://www.meetup.com/"



