<!-- INTRODUCTION -->
<h3 align="center">Trello Test Automation Project</h3>

  <p align="center">
    This project serves as an example of how to set up a test automation project using Java, Selenium WebDriver and Cucumber. <br/>
    Trello is chosen as the system under test.
    <br />
    <a href="https://github.com/jarends404/Java_Selenium_Cucumber/issues">Report Bug</a>
    ·
    <a href="https://github.com/jarends404/Java_Selenium_Cucumber/issues">Request Feature</a>
  </p>


<!-- GETTING STARTED -->
## Getting Started

This section contains instructions on ways to run the tests. This can be done either from IntelliJ or through the command line.

### Running test cases in IntelliJ IDEA

To run test cases in IntelliJ IDEA, clone the project and open it in IntelliJ IDEA.

Afterwards, the first step is to make sure you have Java version 17 installed. If not, this can be done in IntelliJ under: <br/>
`File > Project Structure... ` and then under `Project Settings > Project` select the `SDK` dropdown and choose `+ Add SDK > Download JDK`. <br/>
Once IntelliJ is finished downloading, select language level 17 in the `Language Level` dropdown.

The second step is to install the `Cucumber for Java` plugin to make sure IntelliJ recognizes the Gherkin format used in the feature files.
This plugin will add a run button next to every feature and scenario. You can search for this plugin in the marketplace under `Preferences > Plugins`.

The third step is to set the right run configurations. At the top of your screen, select the dropdown menu displaying `Current File` and choose `Edit Configurations...` <br/>
In the bottom-left corner, select `edit configuration templates...`. Next, select `Cucumber Java` from the list of templates and enter the following values:

| Field      | Value                               |
|------------|-------------------------------------|
| Main class | io.cucumber.core.cli.Main           |
| Glue       | nl.example                          |
| VM options | -Dbrowser=chrome -Denvironment=test |

You can also choose other browsers. Currently supported browsers are Chrome, Firefox and Safari. <br/>
Once you applied these settings, click Apply and then OK.

The last step is to click the run button next to a feature or scenario and choose run! <br/>
You can find the feature files under `src/test/resources/nl/example/features`.

### Running test cases through the command line using Maven

Another way to run the tests is by using Maven through the command line. To do so, use the `mvn test` command and pass the environment and browser as parameters. <br/>
For example, if you want to run your tests on the test environment using a Chrome browser, the command will be: <br/>
`mvn test -Denvironment=test -Dbrowser=chrome`

If you don't have Maven installed on your machine, you can use the Maven wrapper included in this project. <br/>
In that case, replace `mvn` with `./mvnw`

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- FURTHER IMPROVEMENTS -->
## Further Improvements

Some of the improvements that could be added:
- Being able to run the test suite in Docker and Selenium Grid
- Parallelize tests to run simultaneous on all browsers
- Format and upload test report to easy to find location

<!-- CONTACT -->
## Contact

Joost Arends - 404 Consultancy - https://404consultancy.nl - info@404consultancy.nl

Project Link: [https://github.com/jarends404/Knab_Assessment](https://github.com/jarends404/Knab_Assessment)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

