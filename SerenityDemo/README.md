## Serenity Automation

This document is written to give a helping hand over setting up and running the Serenity Web Automation

1. At first run, please run the command "mvn clean install" to fetch all dependencies.

2. Clear the Target Folder by running the command "mvn clean"

3. The options for the environment: prod
    - By setting the Env parameter, Serenity reads the property file for each environment
    - By setting the Env parameter, the default URL for each environment is read
    - By setting the Env parameter, the parametrization required for several URLs and Elements is accessed
        - The parameter for setting the environment looks as follows: -DtestEnv={environment name} Ex: -DtestEnv=prod

4. To run the tests use the command: mvn clean verify -P charity-tests -DtestEnv=prod -Dwebdriver.driver=chrome

5. You can also run or debug the tests by right clicking the story files and click the Run option, but for that, you will need to set the -DtestEnv = "{parameter}" in the Run / Debug configurations for Junit.
    - You can also run or debug each test by accessing the desired Story File and clicking the arrow next to each test, the same configuration as above needs to be performed for this option to work.

6. For running only one story, the following command must be used: mvn clean verify -DtestEnv=prod -P web-demo -Dwebdriver.driver=chrome -Dit.test={StoryFileName} Ex: -Dit.test=EmptyTemplateStory

7. To run only one or several Tests, a "Tag" separation is needed
    - You can achieve this by adding the "@WithTag("{tagName}")" at test level
    - You can run the tests that have the specific tag with the command: mvn clean verify -DtestEnv=prod -P web-demo -Dtags={tagName} Ex: -Dtags=debug
        - This will collect all the Tests that have the specific tag set throughout the whole project and run them
    - You can add another separation on testClass and tag level and run the desired tests with the command: -DtestEnv=prod -P web-demo -Dtags={tagName} -Dit.test={StoryFileName}

8. To run the Smoke tests, run the following command: mvn clean verify -DtestEnv=prod -P web-demo -Dtags=Smoke -Dwebdriver.driver=chrome
