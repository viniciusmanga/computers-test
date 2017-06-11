# computers-test
Manual Test Cases and Automation Tests for the Computers Web Application

This project is intended to run a series of automated test cases using the following a set of technologies and best practices in the Quality Assurance area.

1. Java
2. Spring
3. JUnit
4. JBehave
5. Selenium
6. Maven
7. Log4j

In order to execute this set of automated test cases, you need to have maven installed on your local machine and the firefox browser.
<br/><br/>
To run the test cases simply using the following command: <b>mvn clean install</b>.
<br/>
<b>If you want to</b>, this project has the capability of running the test cases on MacOSX machines as well! To do that, simply add the parameter <b>-DsystemType=OSX</b> on the maven command line.<br/><br/> 
During the executin you will see the Firefox browser opening and the test cases being run right in front of you. 
<br/>
At the end of the execution, you have the option of checking the JBehave reports in HTML, XML and TXT formats, for you convinience! 
<br/><br/>
The reports can be accessed on the project's target folder: <b>/computers-test/target/jbehave/view/index.html</b>
