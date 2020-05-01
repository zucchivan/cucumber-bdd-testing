package br.com.assesso.datacaretest.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class AboutPage {

    @Autowired
    private WebDriver webDriver;
    @Value("${assesso.datacare.about}")
    private String address;

    @Getter
    @FindBy(tagName = "body")
    private WebElement body;

    public void access() {
        webDriver.get(address);
    }

}