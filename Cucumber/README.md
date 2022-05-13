## Cucumber Training

This document is written to give a helping hand over setting up and running Cucumber BDD Web Automation Demo

1. At first run, please run the command "mvn clean install" to fetch all dependencies.

2. Clear the Target Folder by running the command "mvn clean"

3. The options for the environment: prod
    - By setting the Env parameter, Serenity reads the property file for each environment
    - By setting the Env parameter, the default URL for each environment is read
        - The parameter for setting the environment looks as follows: -DtestEnv={environment name} Ex: -DtestEnv=prod

4. To run the tests use the command: mvn clean verify -DtestEnv=prod -Dwebdriver.driver=chrome

5. To run only one or several Tests, a "Tag" separation is needed
    - You can achieve this by adding the "@WithTag("{tagName}")" at test level
    - You can run the tests that have the specific tag with the command: mvn clean verify -DtestEnv=prod -Dtags={tagName} Ex: -Dtags=debug
        - This will collect all the Tests that have the specific tag set throughout the whole project and run them

6. To run the Smoke tests, run the following command: mvn clean verify -DtestEnv=prod -Dtags=Smoke -Dwebdriver.driver=chrome

For differentiating between linux / mac / windows operating systems, please update the serenity.properties file for the chromeDriver filepath.
Note that for Windows OS, serenity requires the .exe driver and for Linux based OS, serenity requires the batch driver (without .exe). 
We highly recommend downloading the latest Drivers available from the Web as the drivers within the project might not run for specific machines.

7. For running or debugging the Features or Scenarios using jUnit, please do the following:

    - Click on Run from the Context Menu and then Edit Configurations
    - Delete the already created Configurations and click Apply
    - Expand the Templates menu from the left side
    - Click on Cucumber Java
        - For Main Class fill with the following: cucumber.api.cli.Main
        - For Glue fill with the following: Cucumber/Digital/stepdefinitions
        - For VM Options fill with the following: -ea -Dwebdriver.driver=chrome -Ddefault.url=https://www.virginmedia.com -Dwebdriver.chrome.driver=./src/test/resources/Drivers/chromedriver -Denvironment.settings=web -DtestEnv=prod

    - Click on JUnit from the left-side menu
        - For VM Options fill with the following: -ea -Dwebdriver.driver=chrome -Ddefault.url=https://www.virginmedia.com -Dwebdriver.chrome.driver=./src/test/resources/Drivers/chromedriver -Denvironment.settings=web -DtestEnv=prod
* Add the tag @Web for the scenarios that should run through a browser