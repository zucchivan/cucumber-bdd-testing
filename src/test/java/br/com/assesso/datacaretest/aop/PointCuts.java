package br.com.assesso.datacaretest.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCuts {

  /**
   * Method is empty as this is just a Pointcut, the implementations are in the advices.
   */
  @Pointcut("within(br.com.assesso.datacaretest.steps..*)")
  public void stepDefinitionsPointcut() {

  }
}