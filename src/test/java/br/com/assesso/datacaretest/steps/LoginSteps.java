package br.com.assesso.datacaretest.steps;

import br.com.assesso.datacaretest.pages.AboutPage;
import br.com.assesso.datacaretest.pages.LoginPage;
import br.com.assesso.datacaretest.utils.WebDriverAssertions;
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
            assertThat(webDriverAssertions.evaluatePageTitle(title -> title.equals("DataCare"))).isTrue());
  }

  @Quando("^preencher os campos de usuário e senha com as credenciais de admin$")
  public void b() {
    loginPage.getUserFieldElement().sendKeys("admin_dc");
    loginPage.getPasswordElement().sendKeys("Admin123");
    //infoGloboGitHub.clickOnPeopleCategory();
    //await().atMost(TEN_SECONDS).untilAsserted(() -> assertThat(peopleComponent.size()).isOne());
  }

  //@E("^procurar por \"([^\"]*)\"$")
  @E("^clicar no botão entrar$")
  public void c() {
    loginPage.getBtnElement().click();
  }

  @Entao("^o usuário deve ser logado com sucesso no Datacare$")
  public void d() {
    await().atMost(TEN_SECONDS).untilAsserted(() ->
            assertThat(webDriverAssertions.evaluatePageTitle(title -> title.equals("DataCare - Lista de Processos"))).isTrue());
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
            assertThat(webDriverAssertions.evaluatePageTitle(title -> title.equals("DataCare"))).isTrue());
  }

}