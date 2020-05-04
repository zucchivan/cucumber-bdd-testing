package br.com.assesso.datacaretest.pages;

import br.com.assesso.datacaretest.annotations.CucumberPageObject;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@CucumberPageObject
public class LoginPage {

    @Autowired
    private WebDriver webDriver;
    @Value("${assesso.datacare.root}")
    private String address;

    @Getter
    @FindBy(name = "ID")
    private WebElement userFieldElement;

    @Getter
    @FindBy(name = "PSW")
    private WebElement passwordElement;

    @Getter
    @FindBy(className = "btn_submit")
    private WebElement btnElement;

    @Getter
    @FindBy(className = "error")
    private WebElement errorText;

    public void access() {
        webDriver.get(address);
    }

}