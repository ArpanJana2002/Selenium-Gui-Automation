
# Selenium GUI Automation Framework
[![Selenium GUI Automation](https://github.com/ArpanJana2002/Selenium-Gui-Automation/actions/workflows/seleniumGui.yml/badge.svg)](https://github.com/ArpanJana2002/Selenium-Gui-Automation/actions/workflows/seleniumGui.yml)

## Overview

A Selenium WebDriver Automation Framework built using Java, TestNG, Maven, and the Page Object Model (POM) design pattern.

This project automates various UI components available on the Test Automation Practice website and demonstrates real-world Selenium automation concepts such as:

* Form Handling
* Date Pickers
* File Uploads
* Alerts
* Popup Windows
* Mouse Actions
* Pagination Web Tables
* Broken Link Validation
* Wikipedia Search Widget
* TestNG Reporting
* Extent Reports

---

## Tech Stack

| Technology         | Purpose                  |
| ------------------ | ------------------------ |
| Java               | Programming Language     |
| Selenium WebDriver | Browser Automation       |
| TestNG             | Test Execution Framework |
| Maven              | Dependency Management    |
| WebDriverManager   | Driver Management        |
| Extent Reports     | Test Reporting           |
| Git & GitHub       | Version Control          |
| Eclipse IDE        | Development Environment  |

---

## Framework Architecture

```
selenium-gui-automation
│
├── Jenkinsfile
│
└── src
    └── test
        └── java
            │
            ├── base
            │   ├── BasePage.java
            │   └── BaseTest.java
            │
            ├── pages
            │   ├── FormPage.java
            │   ├── DatePickerPage.java
            │   ├── FileUploadPage.java
            │   ├── AlertPage.java
            │   ├── PopupPage.java
            │   ├── MouseActionPage.java
            │   ├── TablePage.java
            │   ├── BrokenLinkPage.java
            │   └── WikiSearchPage.java
            │
            ├── listeners
            │   └── TestListener.java
            │
            └── tests
                └── GuiElementsTest.java
```

---

## Features Automated

### Form Elements

* Text Fields
* Radio Buttons
* Checkboxes
* Dropdowns
* Scrolling Dropdown

### Date Pickers

* Standard Date Picker
* Date Range Selection

### File Upload

* Single File Upload
* Multiple File Upload

### Alerts

* Simple Alert
* Confirmation Alert
* Prompt Alert

### Mouse Actions

* Mouse Hover
* Double Click
* Drag and Drop
* Slider Movement

### Tables

* Pagination Handling
* Product Search
* Checkbox Selection

### Other Components

* Popup Window Handling
* Broken Link Validation
* Wikipedia Search
* Dynamic Section Submission

---

## Reports

### TestNG Emailable Report

Generated automatically after execution.

Location:

```
test-output/emailable-report.html
```

### Extent Report

Generated automatically after execution.

Location:

```
reports/ExtentReport.html
```

## Screenshots

```text
screenshot
│
├── console-output1
│   ├── CO1.png
│   ├── CO2.png
│   └── CO3.png
│
├── extent-report1
│   ├── ETR1.png
│   ├── ETR2.png
│   
│
└── emailable-report1
    ├── ER1.png
   
```

## Running The Project

Clone Repository

```bash
git clone https://github.com/ArpanJana2002/Selenium-Gui-Automation.git
```

Navigate To Project

```bash
cd Selenium-Gui-Automation
```

Execute Tests

```bash
mvn clean test
```

---

## TestNG Suite Execution

Run using:

```bash
testng.xml
```

or

```bash
mvn clean test
```

---

## CI/CD Integration

### Jenkins Pipeline

Features:

- GitHub Integration
- Automated Build Trigger
- Maven Build Execution
- TestNG Suite Execution
- Extent Report Publishing
- TestNG Report Publishing

Pipeline Flow:

GitHub → Jenkins → Maven → TestNG → Extent Report

## Sample Automated Scenarios

* Fill complete user form
* Upload files
* Handle alerts
* Handle popup windows
* Validate broken links
* Perform drag and drop
* Move slider
* Search Wikipedia widget
* Traverse pagination tables
* Select products dynamically

---

## Future Enhancements

* Jenkins CI/CD Integration
* Selenium Grid Execution
* Docker Integration
* Cross Browser Testing
* Parallel Execution
* Data Driven Framework
* API Automation Integration
* Allure Reporting

---

## 🎥 Live Automation Demo

<a href="https://youtu.be/NTak-vZ2VsA">
    <img src="https://img.youtube.com/vi/NTak-vZ2VsA/maxresdefault.jpg" width="800">
</a>

[Watch on YouTube](https://youtu.be/NTak-vZ2VsA)

## Author

**Arpan Jana**

GitHub:
https://github.com/ArpanJana2002
