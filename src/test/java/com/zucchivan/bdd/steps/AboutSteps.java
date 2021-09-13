package com.zucchivan.bdd.steps;

import com.zucchivan.bdd.pages.AboutPage;
import com.zucchivan.bdd.utils.WebDriverAssertions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Duration.TEN_SECONDS;

public class AboutSteps {

  @Autowired
  private WebDriverAssertions webDriverAssertions;
  @Autowired
  private AboutPage aboutPage;

  @Dado("^que o usuário esteja na página de about$")
  public void a() {
    aboutPage.access();
    await().atMost(TEN_SECONDS).untilAsserted(() ->
            assertThat(webDriverAssertions.evaluatePageTitle(title -> title.equals("Portal - About"))).isTrue());
  }

  @Quando("^procurar por exceção$")
  public void b() {
    aboutPage.getBody().getText().contains("ERRO");
  }

  @Entao("^não deve encontrar nenhuma$")
  public void d() {
    assertThat(aboutPage.getBody().getText().contains("ERRO")).isFalse();
  }
}