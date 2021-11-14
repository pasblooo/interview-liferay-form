Feature: Launch Liferay form
  As a user
  I want to launch the Liferay form in browser

  Scenario Outline: Launch the liferay form application with different browsers
    Given Open "<browser>" browser
    When Load liferay form aplication
    Then The form has been loaded correctly

    Examples: Launch in <browser>
      | browser          |
      | Chrome           |
      | Safari           |
      | Edge             |
      | Firefox          |
      | InternetExplorer |
      | Opera            |