package br.com.assesso.datacaretest.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
public class WebDriverConfiguration {

    @Bean
    @Scope("cucumber-glue")
    public WebDriver webDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    @Scope("cucumber-glue")
    public WebDriver webDriverHeadless() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }

}