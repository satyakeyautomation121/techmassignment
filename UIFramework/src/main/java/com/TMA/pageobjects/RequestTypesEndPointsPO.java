package com.TMA.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RequestTypesEndPointsPO {
    public RequestTypesEndPointsPO(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='endpoints']//li")
    private List<WebElement> endpointlist;

    @FindBy(xpath = "//div[@class='endpoints']/../div[@class='output']//a//span")
    private WebElement reqpoint;

    @FindBy(xpath = "//div[@class='response']//span")
    private WebElement responsecode;

    @FindBy(xpath = "//a[text()='Support ReqRes']")
    private WebElement supportbutton;

    @FindBy(xpath = "//form[@id='supportForm']//label")
    private List<WebElement> supportoptions;

    public List<String> clickAndValidateTheEndpointList() throws InterruptedException {
        String reqpointetxt=null;
        ArrayList<String> ls= new ArrayList<>();
        for(int i=0;i<endpointlist.size();i++){
            Thread.sleep(2000);
            endpointlist.get(i).click();
            reqpointetxt=reqpoint.getText();
            ls.add(reqpointetxt);
        }
        return ls;
    }
    public String clickOnSingleUserEndpointList(String expvalue) throws InterruptedException {
        String reqpointetxt=null;

        for(int i=0;i<endpointlist.size();i++){
            Thread.sleep(2000);
            endpointlist.get(i).click();
            reqpointetxt=endpointlist.get(i).getText();
            if(reqpointetxt.equalsIgnoreCase(expvalue)){
                String responsecodetext=responsecode.getText();
                System.out.println("Request resource is " + reqpointetxt +" And Response Code Is "+ responsecodetext);
                break;
            }
        }
        return reqpointetxt;
    }
    public void clickOnSupportButton(){
        supportbutton.click();
    }

    public void getSupportOptions(){
        for(int i=0;i<supportoptions.size();i++){
            String supportsoptionstext=supportoptions.get(i).getText();
            System.out.println("Support Options Text are : " + supportsoptionstext);
        }
    }

}
