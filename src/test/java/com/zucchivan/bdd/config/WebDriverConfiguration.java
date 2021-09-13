package com.zucchivan.bdd.config;

import com.zucchivan.bdd.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
@EnableAspectJAutoProxy
public class WebDriverConfiguration {

    @Bean
    @Scope("cucumber-glue")
    @Conditional(EnableWhenHeadlessDeactivatedCondition.class)
    public WebDriver webDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    @Scope("cucumber-glue")
    @Profile(Constants.SPRING_PROFILES_HEADLESS)
    public WebDriver webDriverHeadless() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }

    public static class EnableWhenHeadlessDeactivatedCondition implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return !context.getEnvironment().acceptsProfiles(Constants.SPRING_PROFILES_HEADLESS);
        }

    }

}