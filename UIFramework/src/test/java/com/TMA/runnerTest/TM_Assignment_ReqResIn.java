package com.TMA.runnerTest;



import Util.FileReaderManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "classpath:featurefile/001UISpec_001A.feature"
        },
        glue = {
                "classpath:com.TMA.stepdefinition",
        },
        plugin = { "pretty",
                "html:target/cucumber_reports/cucumberreport.html"
            }
        )

public class TM_Assignment_ReqResIn {

    @AfterClass
    public static void writeExtentReport() throws IOException {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.5.2");
        Reporter.setSystemInfo("Java Version", "1.8.0_151");
    }
}
