# whistle-qa-automation

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>


<!-- ABOUT THE PROJECT -->
## About The Project
The framework is designed to support web, mobile (Android and iOS) and API automation of Kinship entities/modules. Currently, it supports Whistle Mobile Apps (Android and iOS) following Page Object Model approach, TestNG and Maven configurations, Appium for Mobile (uiautomator2 for Android, XCUITest for iOS) and Java as programming language. It has following features:

* Allure Reporting
* Email Integration
* Mobile Android and iOS execution on [Browser Stack](https://app-automate.browserstack.com/dashboard/v2)
* [Test Rail Integration](https://whistle.testrail.com/index.php?/runs/overview/14)
* [Slack integration](https://whistle.slack.com/archives/C02LFTYU1LG)
* Logger using Log4j
* CI using GitHub Actions


<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

Below is the list of frameworks/libraries used in the project.

* [Java](https://www.java.com/en/)
* [Build management using Maven](https://maven.apache.org/)
* [TestNG Configurations](https://testng.org/doc/download.html)
* [Selenium for Web](https://www.selenium.dev/)
* [Appium for Mobile](https://appium.io/)
* [Rest Assured for API](https://rest-assured.io/)
* [Page Object Model Framework](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)
* [Allure Reports for Reporting](https://docs.qameta.io/allure/)
* [Log4j2 for Logging](https://logging.apache.org/log4j/2.x/)


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started
Below are the instructions on setting up your project.
To run your platform specific project, run below commands in terminal for local and remote execution.

<br>**Mobile**: 
   <br> **Android**: Run command in terminal for Android Mobile Execution in local and remote (Browser Stack)
   <br>$mvn install -Dtestsuite=src/test/resources/suitexml/WhistleMobileBATTest.xml -Dplatform=android -DrunType=local
   <br>$mvn install -Dtestsuite=src/test/resources/suitexml/WhistleMobileBATTest.xml -Dplatform=android -DrunType=remote
   
   <br> **iOS**: Run command in terminal for iOS Mobile Execution in local and remote (Browser Stack)
   <br>$mvn install -Dtestsuite=src/test/resources/suitexml/WhistleMobileTest.xml -Dplatform=ios -DrunType=local
   <br>$mvn install -Dtestsuite=src/test/resources/suitexml/WhistleMobileTest.xml -Dplatform=ios -DrunType=remote
<br>**Note**: While running iOS automation in local "udid" and "app" path values needs to be provided in capabilities defined in LocalMobileFactory.

# Log4j Logging
<br>After running test cases, Log4j logs can be found at logs folder under base directory with following names:
<br>1. Logs will be appended logs folder with name **"application-[date and time stamp].log"** 
<br>2. When application.log file size increases above 500 KB, zipped logs will be generated in format: "logs/$${date:yyyy-MM}Logs/app-%d{MM-dd-yyyy}-%i.log.gz"

# GitHub Actions
<br>Two pipelines are scheduled in Actions workflow to trigger scheduler for execution of mobile test cases in Android and iOS daily at a specific time.
<br>1. Auto-triggered Cron for Android and 
<br>2. Auto-triggered Cron for iOS
<br>Mobile manual trigger workflow is created to test mobile suite files manually.
<br>Refer pipelines in [Actions](https://github.com/WhistleLabs/whistle-qa-automation/actions)

### Prerequisites

List of softwares that needs to be installed in the system to run project locally.
* Java version 1.8 or Above  
* Appium desktop server
* Apache maven
* IDE(Eclipse or IntelliJ IDEA)
* Download TestNG for Eclipse from Marketplace if using Eclipse
* Android Studio/ SDK
* XCode
* GitHub Desktop app
* Download Xcode from Developer apple website
* iPhone latest version - iOS 15 or above 
* Require Node v13.11.0 or above
* Set environment and system variables path in Edit Environment variables (Windows) or bash profile (MAC).

  
  ### Installation

1. Sign In to [https://github.com/](https://github.com/)
2. Clone the repo
   ```sh
   git clone https://github.com/WhistleLabs/whistle-qa-automation.git
   ```
3. Install all Prerequisites mentioned above in the prerequisites section
4. Set path for java, maven home, android home and apache maven-3.8.3 or above
5. Set path for Mobile automation for node modules, android sdk, tools, platform-tools, bin, emulator, build tools and above
6. Install Appium Desktop v1.20.0 or above for Mobile [https://github.com/appium/appium-desktop/releases/tag/v1.20.0]
7. Run suite.xml files from src/test/resources/suitexml folder under project structure
<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Contributors 

Project Link: [https://github.com/WhistleLabs/whistle-qa-automation](https://github.com/WhistleLabs/whistle-qa-automation)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Below is the list of helpful resources and links.
* [Malven's Repository](https://mvnrepository.com/)
* [GitHub Pages](https://pages.github.com)
* [Postman](https://www.postman.com/)

<p align="right">(<a href="#top">back to top</a>)</p>
