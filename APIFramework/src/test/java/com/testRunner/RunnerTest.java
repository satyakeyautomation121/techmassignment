package com.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="classpath:features",
        glue="stepdefs",
        plugin = {"pretty",
                "html:test-output/cucumber-Report/cucumberreport.html"

        }
)
public class RunnerTest {

}
