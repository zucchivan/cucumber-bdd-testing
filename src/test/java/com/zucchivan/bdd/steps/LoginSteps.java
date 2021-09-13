package com.zucchivan.bdd.steps;

import com.zucchivan.bdd.pages.LoginPage;
import com.zucchivan.bdd.utils.WebDriverAssertions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Duration.TEN_SECONDS;

public class LoginSteps {

  @Autowired
  private WebDriverAssertions webDriverAssertions;

  @Autowired
  private LoginPage loginPage;

  @Dado("^que o usuário esteja na página de login$")
  public void a() {
    loginPage.access();
    await().atMost(TEN_SECONDS).untilAsserted(() ->
            assertThat(webDriverAssertions.evaluatePageTitle(title -> title.equals("Portal"))).isTrue());
  }

  @Quando("^preencher os campos de usuário e senha com as credenciais de admin$")
  public void b() {
    loginPage.getUserFieldElement().sendKeys("admin_dc");
    loginPage.getPasswordElement().sendKeys("Admin123");
  }

  @E("^clicar no botão entrar$")
  public void c() {
    loginPage.getBtnElement().click();
  }

  @Entao("^o usuário deve ser logado com sucesso no portal$")
  public void d() {
    await().atMost(TEN_SECONDS).untilAsserted(() ->
            assertThat(webDriverAssertions.evaluatePageTitle(title -> title.equals("Portal - Lista de Processos"))).isTrue());
  }

  @Quando("^preencher os campos de usuário e senha com as credenciais inválidas$")
  public void e() {
    loginPage.getUserFieldElement().sendKeys("abc");
    loginPage.getPasswordElement().sendKeys("123");
  }

  @Entao("^um erro deve ser mostrado$")
  public void f() {
    await().atMost(TEN_SECONDS).untilAsserted(() ->
          assertThat(loginPage.getErrorText().isDisplayed()).isTrue());
  }

  @E("^o usuário não deve ser redirecionado para outra página$")
  public void g() {
    await().atMost(TEN_SECONDS).untilAsserted(() ->
            assertThat(webDriverAssertions.evaluatePageTitle(title -> title.equals("Portal"))).isTrue());
  }

  @Dado("^que o usuário esteja logado no portal$")
  public void usuarioLogado() {
    loginPage.access();
    await().atMost(TEN_SECONDS);
    loginPage.getUserFieldElement().sendKeys("admin_dc");
    loginPage.getPasswordElement().sendKeys("Admin123");
    loginPage.getBtnElement().click();
    await().atMost(TEN_SECONDS);
    await().atMost(TEN_SECONDS).untilAsserted(() ->
            assertThat(webDriverAssertions.
                    evaluatePageTitle(title -> title.equals("Portal - Lista de Processos"))).isTrue());
  }

}