# language: pt
  Funcionalidade: Tela de login e funcionalidade de autenticação do Datacare

    Cenário: Login com sucesso usando credenciais válidas
      Dado que o usuário esteja na página de login
      Quando preencher os campos de usuário e senha com as credenciais de admin
      E clicar no botão entrar
      Então o usuário deve ser logado com sucesso no Datacare

    Cenario: Login sem sucesso usando credenciais inválidas
      Dado que o usuário esteja na página de login
      Quando preencher os campos de usuário e senha com as credenciais inválidas
      E clicar no botão entrar
      Então um erro deve ser mostrado
      E o usuário não deve ser redirecionado para outra página