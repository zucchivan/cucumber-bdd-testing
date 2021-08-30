package com.zucchivan.bdd.pages;

import com.zucchivan.bdd.annotations.CucumberPageObject;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@CucumberPageObject
public class ProcessoPage {

    @Autowired
    private WebDriver webDriver;

    @Getter
    @FindBy(id = "edit1")
    private WebElement editTextProcesso;

    @Getter
    @FindBy(id = "idSingleButton$")
    private WebElement btCriarProcesso;

}