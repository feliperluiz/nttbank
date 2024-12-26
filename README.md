# Projeto NTT Bank

## Tecnologias / Arquitetura

- **Java 23**: Última versão estável do Java, com melhorias de performance e novos recursos.
- **Spring Boot 3.4.0**: Framework para construção de aplicações Java com configurações automáticas e simplificadas.
- **Spring Web 3.4.0**: Módulo do Spring Boot para desenvolvimento de aplicações web, incluindo RESTful APIs.
- **Spring Data JPA 3.4.0**: Facilita o acesso a bancos de dados relacionais usando JPA (Java Persistence API).
- **Spring Docker Compose 3.4.0**: Integração com Docker Compose para facilitar a execução de aplicações Spring Boot em containers.
- **Spring Test 3.4.0**: Ferramentas para realizar testes de integração e unitários com Spring.
- **Spring Security 3.4.0**: Framework de segurança para autenticação, autorização e proteção contra ataques.
- **Spring Security Test 3.4.0**: Suporte para testar funcionalidades de segurança em aplicações Spring.
- **Spring Validation 3.4.0**: Ferramentas para validação de dados e objetos em Spring.
- **Spring DOC OpenAPI WebMVC 2.7.0**: Geração automática de documentação OpenAPI para APIs Spring com integração Swagger.
- **PostgreSQL 17.0**: Banco de dados relacional de código aberto, altamente escalável e robusto.
- **H2 Database**: Banco de dados em memória, ideal para testes e desenvolvimento rápido.
- **Java JWT 4.4.0**: Biblioteca para gerar e validar tokens JWT em aplicações Java.
- **IText7-Core 7.2.6**: Biblioteca para criação e manipulação de documentos PDF em Java.
- **Apache POI 5.2.3**: API para leitura e escrita de arquivos do Microsoft Office (Excel, Word, etc.) em Java.
- **JFreeChart 1.5.3**: Biblioteca para criar gráficos e visualizações de dados em Java.
- **Lombok 1.18.30**: Biblioteca que reduz o código boilerplate com anotações como `@Getter`, `@Setter` e `@AllArgsConstructor`.
- **Docker Desktop 4.36.0**: Aplicativo para gerenciar containers Docker localmente em ambientes de desenvolvimento.
- **JUnit 5.11.3**: Framework para escrita e execução de testes unitários em Java.
- **Mockito 5.14.2**: Framework de mocking para criar objetos simulados em testes unitários.
- **MockAPI**: Ferramenta para simular APIs RESTful para testes e desenvolvimento.
- **API Exchange Rates v4**: API para obter taxas de câmbio de várias moedas em tempo real.

---

## Funcionalidades

- **Autenticação**: Sistema de login com token JWT.
- **Gestão de Contas**: Criação e gerenciamento de contas de usuários.
- **Transações**: Realização de transações financeiras entre contas.
- **Relatórios**: Geração de relatórios de transações e gráficos de despesas.

---

## Entities

- **Usuario**: Representa um usuário do sistema.
- **Conta**: Representa uma conta de um usuário, podendo ter "n" contas associadas.
- **Transacao**: Representa uma transação de uma conta de um usuário. Quando o campo `idContaTransferencia` é diferente de `null`, significa que é uma transferência entre contas.
- **RelatorioTransacao**: Representa os dados para retorno do resumo das despesas (filtrado por CPF) e para o gráfico de transações agrupado por tipo de despesa (também filtrado por CPF).

---

## Instruções para Execução

1. **Instalar e executar o Docker Desktop**:
    - Baixe e instale a versão 4.36.0 do [Docker Desktop](https://www.docker.com/products/docker-desktop/).

2. **Download do projeto**:
    - Faça o download do projeto diretamente do [GitHub](https://github.com/feliperluiz/nttbank/archive/refs/heads/feature/hello-world.zip).

3. **Executar o Docker Compose**:
    - Na raiz do projeto, execute o seguinte comando para iniciar o ambiente de containers:
      ```bash
      docker-compose up --build
      ```

4. **Testar a aplicação**:
    - Após subir o Docker, veja a documentação gerada pelo OpenAPI:
   ```link
   http://localhost:8080/swagger-ui/index.html
   ```
    - Crie um Usuário, uma Conta para este Usuário e uma Transação para essa conta criada.
   

5. Funcionalidades da aplicação API REST:

- Cadastro, listagem, alteração e exclusão de usuários;
- Cadastro (Upload) de usuários através de planilha Excel;
- Cadastro, listagem, alteração e exclusão de contas de usuários;
- Cadastro, listagem, alteração e exclusão de transações de contas;
- Resumo de transações em formato PDF retornando identificador, nome do usuário, agência/conta/dac do responsável, agência/conta/dac da conta origem/destino (caso for transferência), valor, descrição, tipo da operação (crédito ou débito) e tipo da despesa (alimentação, saúde, lazer, educação, moradia, casa, vestuário);
- Resumo de despesas (transações do tipo débito) de um usuário (filtrado pro cpf), onde é retornado o nome do usuário, o identificador da conta bancária da despesa, o valor da transação, a descrição, o tipo de despesa e o tipo de operação (que será débito por se tratar de uma despesa).
- Gráfico de despesas, filtrado por cpf, onde retorna um gráfico de barras numa imagem em formato png. O gráfico soma os valores das transações para cada tipo de despesa (alimentação, saúde, lazer, educação, moradia, casa, vestuário), ou seja, é um gráfico soma despesas x tipo.

**Importante!**

- No cadastro de usuário, deve-se cadastrar um login, senha e a autorização "role", desse usuário, podendo ser USER ou ADMIN.
- Na aplicação o usuário com autorização do tipo USER pode realizar todas as chamadas da API REST, exceto as que são exclusivas do ADMIN, que são as chamadas onde se obtém informações de N usuários:
  - Upload de usuários via Excel
  - Listagem de usuários, contas e transações;
  - Resumo de transações em formato PDF; 
- Todas as rotas são autenticadas, ou seja, deve-se chamar o /login para obter um Token JWT e nas chamadas seguintes, passá-lo como Header no formato Bearer Authentication.


## Contribuição

- **Clone o repositório**:
  Clone este repositório usando o comando:
  ```bash
  git clone https://github.com/feliperluiz/nttbank.git
