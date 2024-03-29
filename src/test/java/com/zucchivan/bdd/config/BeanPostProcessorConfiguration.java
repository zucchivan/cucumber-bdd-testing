package com.zucchivan.bdd.config;

//import br.com.globo.annotations.CucumberPageObject;

import com.zucchivan.bdd.annotations.CucumberPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPostProcessorConfiguration {

  @Bean
  public BeanPostProcessor pageObjectBeanPostProcessor() {
    return new PageObjectBeanPostProcessor();
  }

  /**
   * Proxy para inicialização de todos os WebElements que serão usados por PageObjects.
   */
  public static class PageObjectBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
      if (bean.getClass().isAnnotationPresent(CucumberPageObject.class)) {
        PageFactory.initElements(applicationContext.getBean(WebDriver.class), bean);
      }
      return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
      return bean;
    }
  }
}