# language: pt
  Funcionalidade: Tela de administração de processos e funcionalidade de criação
  Cenário de Fundo: Login já realizado
    Dado que o usuário esteja logado no Portal

    Cenário: Criação de um processo
      Dado que o usuário esteja na página de processos
      Quando preencher o campo de texto com o nome "CUCUMBER_TEST"
      E clicar no link de novo processo
      Então um novo processo deve aparecer na tabela com o nome de "CUCUMBER_TEST"
