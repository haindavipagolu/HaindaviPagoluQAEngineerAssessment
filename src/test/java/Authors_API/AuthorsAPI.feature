@RunAuthorsAPI
Feature: Creating my first API feature

  @authorsAPIfeature
  Scenario Outline: Creating Feature with Get Authors
    Given Invoked Get Authors operation from "<uri>"
    When Deserialise the API response to a pojo
    Then Validate api content
    Examples:
      | uri        |
      | https://openlibrary.org/authors/OL1A.json |


