package com.TMA.stepdefinition;


import com.TMA.pageobjects.RequestTypesEndPointsPO;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class ValidateDifferentRequestTypesAndEnpoints {
    ChromeOptions options;
    JavascriptExecutor js;
    WebDriver driver;
    //RequestTypesEndPointsPO requestTypesEndPointsPO;
    RequestTypesEndPointsPO requestTypesEndPointsPO;


    @Given("Open Chrome and Launch Application")
    public void open_chrome_and_launch_application() {
        options= new ChromeOptions();
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://reqres.in/");

    }
    @When("I click on {string}")
    public void iClickOn(String requestType) throws InterruptedException {
        requestTypesEndPointsPO=new RequestTypesEndPointsPO(driver);
        requestTypesEndPointsPO.clickOnSingleUserEndpointList(requestType);
    }


    @Then("I validate different requesttypes and endpoints")
    public void i_validate_different_requesttypes_and_endpoints() throws InterruptedException {
        requestTypesEndPointsPO=new RequestTypesEndPointsPO(driver);
        List<String> reqpoint=requestTypesEndPointsPO.clickAndValidateTheEndpointList();
        String curl= driver.getCurrentUrl();
        for(int i=0;i<reqpoint.size();i++){
            String updatedurl=curl+reqpoint.get(i);
            System.out.println("Request URL is : " + updatedurl);
        }
    }

    @When("I click on Support Button")
    public void iClickOnSupportButton() {
        requestTypesEndPointsPO=new RequestTypesEndPointsPO(driver);
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-1000)","");
        requestTypesEndPointsPO.clickOnSupportButton();
    }

    @Then("I navigated To Support page")
    public void iNavigatedToSupportPage() {
        String supporturl=driver.getCurrentUrl();
        System.out.println("Support page URL is : " + supporturl);
    }

    @And("Two Options As OneTime and MonthlySupport Available")
    public void twoOptionsAsOneTimeAndMonthlySupportAvailable() {
        requestTypesEndPointsPO=new RequestTypesEndPointsPO(driver);
        requestTypesEndPointsPO.getSupportOptions();
    }
}
