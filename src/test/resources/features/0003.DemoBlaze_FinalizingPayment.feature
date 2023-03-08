
Feature: Customer Finalizing payment
  @finalizepayment @smoke @regression
  Scenario Outline: Customer Finalizing payment
    Given i have selected placed order
    And i have captured "<name>","<country>","<city>","<creditCard>","<month>","<year>"
    When i click on purchase
    Then i should see order id getting displayed successfully


    Examples:
      |name|country|city|creditCard|month|year|
      |sneha|southafrica|jhb|569874521365884|03|2023|