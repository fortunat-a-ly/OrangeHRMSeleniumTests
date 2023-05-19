package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        glue = "org.example.stepdefs",
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "json:allure-results/cucumber-report.json"})
public class TestRunner {
}
