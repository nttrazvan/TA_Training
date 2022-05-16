Demo project using TestNG

Please make sure you have the following installed and set up:
- Java and JAVA_HOME environment variable
- Maven and MAVEN_HOME environment variable
- To execute the tests:
    - Right-click on the test and choose either Run or Debug
    - Right-click on the test suite and choose either Run or Debug
    - Execute through Maven, Terminal using the command by specifying test suite file or group:
      mvn clean verify -DsuiteXmlFile="pathToFileFromSrc/APISuite.xml"
      Example of directly working commands:
    - mvn clean verify -DsuiteXmlFile="src/test/java/suites/APISuite.xml"
