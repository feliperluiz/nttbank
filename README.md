## Tecnologias / Arquitetura:

Java 23: Última versão estável do Java, com melhorias de performance e novos recursos.
Spring Boot 3.4.0-RC1: Framework para construção de aplicações Java com configurações automáticas e simplificadas.
Spring Web 3.4.0-RC1: Módulo do Spring Boot para desenvolvimento de aplicações web, incluindo RESTful APIs.
Spring Data JPA 3.4.0-RC1: Facilita o acesso a bancos de dados relacionais usando JPA (Java Persistence API).
Spring Docker Compose 3.4.0-RC1: Integração com Docker Compose para facilitar a execução de aplicações Spring Boot em containers.
Spring Test 3.4.0-RC1: Ferramentas para realizar testes de integração e unitários com Spring.
Spring Security 3.4.0-RC1: Framework de segurança para autenticação, autorização e proteção contra ataques.
Spring Security Test 3.4.0-RC1: Suporte para testar funcionalidades de segurança em aplicações Spring.
Spring Validation 3.4.0-RC1: Ferramentas para validação de dados e objetos em Spring.
Spring DOC OpenAPI WebMVC 2.7.0: Geração automática de documentação OpenAPI para APIs Spring com integração Swagger.
PostgreSQL 17.0: Banco de dados relacional de código aberto, altamente escalável e robusto.
H2 Database: Banco de dados em memória, ideal para testes e desenvolvimento rápido.
Java JWT 4.4.0: Biblioteca para gerar e validar tokens JWT em aplicações Java.
IText7-Core 7.2.6: Biblioteca para criação e manipulação de documentos PDF em Java.
Apache POI 5.2.3: API para leitura e escrita de arquivos do Microsoft Office (Excel, Word, etc.) em Java.
JFreeChart 1.5.3: Biblioteca para criar gráficos e visualizações de dados em Java.
Lombok 1.18.30: Biblioteca que reduz o código boilerplate com anotações como @Getter, @Setter e @AllArgsConstructor.
Docker Desktop 4.36.0: Aplicativo para gerenciar containers Docker localmente em ambientes de desenvolvimento.
JUnit 5.11.3: Framework para escrita e execução de testes unitários em Java.
Mockito 5.14.2: Framework de mocking para criar objetos simulados em testes unitários.
MockAPI: Ferramenta para simular APIs RESTful para testes e desenvolvimento.
API Exchange Rates v4: API para obter taxas de câmbio de várias moedas em tempo real.

## Funcionalidades:


## Entities: 

Usuario - Representa um usuario do sistema
Conta - Representa uma conta de um usuário, que pode ter "n" contas
Transacao - Representa uma transação de uma conta de um usuário. Quando o campo idContaTransferencia é diferente de null, significa um registro de transferência entre contas.
RelatorioTransacao - Representa os dados para retorno do resumo das despesas (filtrado por cpf) e para o gráfico de transações que é agrupado por tipo da despesa (também filtrado por cpf).

## INSTRUÇÕES PARA EXECUÇÃO

- Instalar e executar o Docker Desktop em máquina local - https://www.docker.com/products/docker-desktop/ - versão 4.36.0
- Download do projeto: https://github.com/feliperluiz/nttbank/archive/refs/heads/feature/hello-world.zip
- Na raiz do projeto, executar o seguinte comando:
a) docker-compose up --build
- Criar um Usuario, uma Conta para este Usuario e uma Transacao para esta Conta