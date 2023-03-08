Feature: OnBoarding clients on Demoblaze application
  @accountcreation @smoke @regression
  Scenario Outline: Onboarding clients
    Given i have navaigated to stores site
    When i click on Signup menu and capture "<username>" and "<password>"
    Then i should see successful confirmation message sign up successful "<message>"
    And register user logins successfully with "<username>" and "<password>"



    Examples:
      |username|password|message|
      |demoblazeuserks114|windows123|Sign up successful.|