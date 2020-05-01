package br.com.assesso.datacaretest.utils;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
@Scope("cucumber-glue")
public class WebDriverAssertions {

    @Qualifier("webDriver")
    @Autowired
    private WebDriver browser;

    public boolean evaluatePageTitle(Predicate<String> evaluation) {
        return evaluation.test(browser.getTitle());
    }
}