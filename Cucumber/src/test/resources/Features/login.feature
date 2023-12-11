Feature: This feature is to get CEO name from OrangeHRM app

  Scenario Outline: This scenario is to test the CEO Name
    Given The user is logged in successfully and is on Home Page.
    When the user clicks on the directory option from the Home Page
    And the user select the job title as '<CEO>' from the drop down
    And clicks search button
    Then the user should see the CEO Name as '<CEO Name>'

    Examples: 
      | CEO Name | CEO|
      | Deva K   | Chief Executive Officer |
