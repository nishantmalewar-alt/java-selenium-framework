# SauceDemo Selenium Framework (Java)

### 🌟 Overview
UI automation for SauceDemo (login + add to cart) using Java, Selenium, TestNG, Cucumber, Maven, and Chrome incognito mode.

### 🛠️ Tech Stack
* **Language:** Java
* **Tool:** Selenium WebDriver
* **Framework:** TestNG,Cucumber, Maven
* **Pattern:** Page Object Model (POM)

### 🚀 Features
* Valid and Invalid Login tests.
* Add product to cart and verification logic.
* BaseTest setup with Chrome Incognito mode.
* Reusuable Page Object classes and utility methods for waits and browser actions.
* Cucumber BDD scenarios with readable Given-When-Then steps and TestNG runner integration.

### 🏃 How to Run
1. Make sure you have **Chrome Browser** installed.
2. Open terminal in the project root.
3. Run: `mvn test`

### Folder Structure
* src/test/java – test classes and step definitions
* src/main/java – page objects and utilities
* resources – feature files, config, test data
