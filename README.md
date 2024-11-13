## Tecnologias:

Spring Boot, Docker, PostgreSQL, Spring Data JPA, Spring Security, Apache POI, Swagger, JUnit com Mockito, MockAPI e Exchange Rates.

## Escopo:

1) Configurar o ambiente de desenvolvimento com Docker, incluindo um banco de dados PostgreSQL e a aplicação Spring Boot;


2) CRUDS:
- Operações para gerenciar perfis de usuário;
- Operações para gerenciar transações financeiras (depósitos, retiradas, transferências);


3) Cadastro em massa por Upload: Funcionalidade para importar dados de usuários a partir de uma planilha Excel e salvar no banco de dados;


4) Análise de Despesas: Funcionalidade que permite aos usuários visualizar um resumo e análise de suas despesas, categorizando as transações e exibindo gráficos;


5) Integrar uma API pública de taxas de câmbio para converter valores de transações em diferentes moedas;


6) Criar uma API Mock: no MockAPI para simular dados de saldo de conta bancária dos usuários;


7) Mostrar a taxa de câmbio atual em cada transação. Exibir o saldo de conta bancária dos usuários usando Mock API


8) Implementar validações robustas para todas as entradas de dados, incluindo formulários de usuário e transações.


9) Implementar autenticação e autorização utilizando Spring Security, garantindo que somente usuários autenticados possam acessar certas funcionalidades.


10) Utilizar OpenAPI para documentar todos os endpoints da API. Criar uma documentação técnica detalhada descrevendo a arquitetura, principais funcionalidades e instruções pasra configurar e rodar o projeto.


11) Escrever testes unitários abrangentes para todas as funcionalidades críticas da aplicação.


12) Implementar uma rota que permite baixar um relatório em formato PDF ou Excel contendo um resumo das transações financeiras dos usuários.


## Entities: 

* Usuario: id(PK), login, nome, cpf, email


* Conta: id(PK), idUsuario(FK), agencia, conta, dac, saldo, idTipoConta(FK)


* Transacao: id(PK), idConta(FK), valor, descricao, idTipoOperacao(FK), idTipoDespesa(FK)


* TipoConta: id(PK), descricao (Corrente, Investimento)


* TipoDespesa: id(PK), descricao (Alimentação, Saúde, Moradia, Educação, Vestuário, Lazer)


* TipoOperacao: id(PK), descricao (Débito, Crédito), transferencia(bool)


* View: idTransacao, valorTransacao, saldoReal, saldoDolar, saldoEuro, txCambioDolar, txCambioEuro


* Requisito funcional: Somente usuários autenticados do Banco podem ver informações/relatórios de várias contas


