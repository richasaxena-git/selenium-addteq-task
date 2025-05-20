# selenium-addteq-task

This is a complete Java-based Selenium automation framework for testing the (https://www.saucedemo.com/) using Page Object Model (POM), TestNG, Maven, and JSON-based test data.

---

### Prerequisites

- Java 17 or higher
- Maven installed and configured (`mvn -version`)
- Google Chrome browser installed
- IntelliJ IDEA (recommended) or any Java IDE

Test Cases Included :

1. loginWithValidCredentials	Logs in using valid credentials from JSON file
2. loginWithInvalidCredentials	Tests error message for a locked-out user
3. addToCart	Adds the first product to cart and checks cart count
4. checkoutFlow	Proceeds through checkout and verifies success

Dependencies Used :

1. Selenium WebDriver 4.20.0
2. TestNG 7.9.0
3. WebDriverManager 5.8.0

Framework Design as per guidelines :

1. Page Object Model (POM): Each page (Login, Products, Checkout) has a dedicated class.
2. TestNG: Used for test execution with before/after setup.
3. WebDriverManager: Automatically handles driver binaries.
4. Jackson: Reads login credentials from a JSON file.
5. Maven: Manages dependencies and test execution.


