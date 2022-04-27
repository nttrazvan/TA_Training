Demo project using Junit5

Please make sure you have the following installed and set up:
 - Java and JAVA_HOME environment variable
 - Maven and MAVEN_HOME environment variable
 - To execute the tests:
   - Right-click on the test and choose either Run or Debug
   - Right-click on the test suite and choose either Run or Debug
   - Execute through Maven, Terminal using the command by specifying the profile as well:
 *NOTE: There are two available profiles: "suites" and "tests" and you need the call the correct profile in order to run either suites or tests
mvn clean verify -Pprofile -Dtests=tag1 (for multiple tags, separate them with commas, EX: tag1,tag2)
Example of directly working commands:
   - mvn clean verify -Psuites -Dtests=testSuite1 (For suites, you need to pass the class name)
   - mvn clean verify -Ptests -Dtests=test3
