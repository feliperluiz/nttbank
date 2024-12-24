# Projeto NTT Bank

## Tecnologias / Arquitetura

- **Java 23**: Última versão estável do Java, com melhorias de performance e novos recursos.
- **Spring Boot 3.4.0-RC1**: Framework para construção de aplicações Java com configurações automáticas e simplificadas.
- **Spring Web 3.4.0-RC1**: Módulo do Spring Boot para desenvolvimento de aplicações web, incluindo RESTful APIs.
- **Spring Data JPA 3.4.0-RC1**: Facilita o acesso a bancos de dados relacionais usando JPA (Java Persistence API).
- **Spring Docker Compose 3.4.0-RC1**: Integração com Docker Compose para facilitar a execução de aplicações Spring Boot em containers.
- **Spring Test 3.4.0-RC1**: Ferramentas para realizar testes de integração e unitários com Spring.
- **Spring Security 3.4.0-RC1**: Framework de segurança para autenticação, autorização e proteção contra ataques.
- **Spring Security Test 3.4.0-RC1**: Suporte para testar funcionalidades de segurança em aplicações Spring.
- **Spring Validation 3.4.0-RC1**: Ferramentas para validação de dados e objetos em Spring.
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

4. **Criar Usuário, Conta e Transação**:
    - Após subir o Docker, crie um usuário, uma conta para este usuário e uma transação para essa conta.

---

## Contribuição

- **Clone o repositório**:
  Clone este repositório usando o comando:
  ```bash
  git clone https://github.com/feliperluiz/nttbank.git
