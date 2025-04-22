# Rest Assured API Testing Framework

A robust API testing framework built with **Rest Assured**, **TestNG**, and **Gradle**, designed to validate RESTful APIs with comprehensive test coverage and seamless CI/CD integration using **GitHub Actions**. This project automates testing of the JSONPlaceholder API, generates detailed **Allure reports**, and publishes them to **GitHub Pages** for easy access.

## Table of Contents

- Features
- Prerequisites
- Setup
- Running Tests
- Viewing Allure Reports
- CI/CD Pipeline
- Project Structure
- Contributing
- License

## Features

- **Comprehensive API Testing**: Tests for GET, POST, PUT, DELETE endpoints with positive and negative scenarios.
- **Rest Assured**: Fluent API testing with JSON validation and response time checks.
- **TestNG**: Organized test suites with parallel execution support.
- **Allure Reporting**: Detailed, visual test reports with request/response logs.
- **GitHub Actions**: Automated CI/CD pipeline for test execution and report publishing.
- **Gradle Build**: Dependency management and build automation.

## Prerequisites

- **Java**: JDK 17 or higher
- **Gradle**: 8.10.2 or compatible
- **Git**: For cloning the repository
- **Allure CLI**: For local report viewing (optional)
- **GitHub Account**: For accessing published reports

## Setup

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/deepakkc014/rest-assured-demo.git
   cd rest-assured-demo
   ```

2. **Install Dependencies**:

   ```bash
   ./gradlew build
   ```

3. **Install Allure CLI (Optional)**:

    - For macOS:

      ```bash
      brew install allure
      ```
    - For Ubuntu:

      ```bash
      sudo apt-get install allure
      ```

## Running Tests

Run all tests locally using Gradle:

```bash
./gradlew clean test
```

Generate Allure report after tests:

```bash
./gradlew allureReport
```

View Allure report locally:

```bash
./gradlew allureServe
```

## Viewing Allure Reports

Allure reports are generated and published automatically via GitHub Actions.

- **GitHub Pages**: Access the latest report at:

  ```
  https://deepakkc014.github.io/rest-assured-demo/allure-report
  ```

- **Artifacts**:

    1. Go to the Actions tab.
    2. Select the latest `Rest Assured CI` workflow run.
    3. Download the `allure-report` artifact.
    4. Extract the ZIP and serve locally:

       ```bash
       unzip allure-report.zip -d allure-report
       allure serve allure-report
       ```

## CI/CD Pipeline

The project uses **GitHub Actions** for continuous integration:

- **Trigger**: Runs on `push` or `pull_request` to `main` branch, or manually via `workflow_dispatch`.
- **Steps**:
    - Checks out code.
    - Sets up JDK 17.
    - Caches Gradle dependencies.
    - Runs tests with `./gradlew test`.
    - Generates Allure report with `./gradlew allureReport`.
    - Uploads report as an artifact.
    - Publishes report to GitHub Pages (`gh-pages` branch).
- **Workflow File**: .github/workflows/ci.yml
- **Status**: Check the workflow status in the Actions tab.

## Project Structure

```
rest-assured-demo/
├── src
│   ├── main
│   │   └── java
│   │       └── com/example/App.java
│   └── test
│       └── java
│           └── com/example/api
│               └── PostsTests.java
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
└── .github/workflows/ci.yml
```

- `PostsTests.java`: Test cases for JSONPlaceholder API endpoints.
- `build.gradle`: Gradle configuration for dependencies and Allure.
- `ci.yml`: GitHub Actions workflow for CI/CD.

## Contributing

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/xyz`).
3. Commit changes (`git commit -m "Add xyz feature"`).
4. Push to the branch (`git push origin feature/xyz`).
5. Create a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
