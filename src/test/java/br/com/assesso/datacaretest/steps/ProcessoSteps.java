package br.com.assesso.datacaretest.steps;

import br.com.assesso.datacaretest.pages.ProcessoPage;
import br.com.assesso.datacaretest.utils.WebDriverAssertions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;

import static org.awaitility.Awaitility.await;
import static org.awaitility.Duration.TEN_SECONDS;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessoSteps {

  @Autowired
  private WebDriverAssertions webDriverAssertions;
  @Autowired
  private ProcessoPage processoPage;

  @Dado("^que o usuário esteja na página de processos$")
  public void a() {
    await().atMost(TEN_SECONDS).untilAsserted(() ->
            assertTrue(webDriverAssertions.evaluatePageTitle(title -> title.equals("DataCare - Lista de Processos"))));
  }

  @Quando("^preencher o campo de texto com o nome \\\"([^\\\"]*)\\\"$")
  public void b(String nomeProcesso) {
    processoPage.getEditTextProcesso().sendKeys(nomeProcesso);
  }

  @E("^clicar no link de novo processo$")
  public void c() {
    processoPage.getBtCriarProcesso().click();
  }

  @Entao("^um novo processo deve aparecer na tabela com o nome de \\\"([^\\\"]*)\\\"$")
  public void f(String nomeProcesso) {
    await().atMost(TEN_SECONDS).untilAsserted(() ->
          assertTrue(webDriverAssertions.hasWebElementWithText(nomeProcesso)));
  }

}