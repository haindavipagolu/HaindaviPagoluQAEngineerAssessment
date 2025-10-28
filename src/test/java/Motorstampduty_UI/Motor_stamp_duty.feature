@MotorstampdutyFeature
Feature: Check motor stamp duty.
  Scenario Outline:: Calculation of Motor vehicle registration duty.
    Given User clicks onto motor stamp duty URL "<url>"
    When User clicked on Check online button
    Then Validate if Motor vehicle registration duty calculator page appears
    When User clicked on Radio button Yes for the question Is this registration for a passenger vehicle?
    And User entered the Purchase price or value as "<Price>"
    And User clicked on Calculate button
    Then Validate the "<isPassengerVehicle>" and <Price> in the calculation page
    Then User clicked on Close button

    Examples:
      | url        | isPassengerVehicle | Price |
      | https://www.service.nsw.gov.au/transaction/check-motor-vehicle-stamp-duty | Yes | 45000 |