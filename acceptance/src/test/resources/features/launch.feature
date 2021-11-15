Feature: Launch Liferay form
  As a user
  I want to launch the Liferay form in browser

  Scenario Outline: Launch the liferay form application with different browsers
    Given Open <browser> browser
    When Load liferay form application
    Then The form has been loaded correctly

    Examples: Launch in <browser>
      | browser |
      | Chrome  |
      | Safari  |
      | Edge    |
      | Firefox |
      | ie      |
      | Opera   |


  Scenario Outline: Launch the liferay form application with different resolutions
    Given Open "Chrome" browser
    When Set browser window size to "<width>" width by "<height>" height
    And Load liferay form application
    Then The form has been loaded correctly

    Examples: Load with <width> x <height> size
      | width | height |
      | 1920  | 1080   |
      | 1280  | 800    |
      | 1024  | 768    |
      | 640   | 360    |
      | 2560  | 1440   |
      | 962   | 601    |
      | 896   | 414    |