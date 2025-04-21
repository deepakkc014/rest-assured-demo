plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"
}

group = "qa.deepakkc014"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allure {
    version = "2.17.0"
    adapter.autoconfigure = true
    adapter.aspectjWeaver = true
}

dependencies {
    // Rest Assured
    implementation("io.rest-assured:rest-assured:5.5.0")

    // TestNG
    testImplementation("org.testng:testng:7.7.1")

    // Allure TestNG
    testImplementation("io.qameta.allure:allure-testng:2.12.0")

    // Jackson
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
}

tasks.test {
    useTestNG()
    systemProperty("allure.results.directory", "build/allure-results")
}