## Tecnologias / Arquitetura:

Java 23
Spring Boot 3.4.0-RC1
Spring Web 3.4.0-RC1
Spring Data JPA 3.4.0-RC1
Spring Docker Compose 3.4.0-RC1
Spring Test 3.4.0-RC1
Spring Security 3.4.0-RC1
Spring Security Test 3.4.0-RC1
Spring Validation 3.4.0-RC1
Spring DOC OpenAPI WebMVC 2.7.0
PostgreSQL 17.0
H2 Database
Java JWT 4.4.0
IText7-Core 7.2.6
Apache POI 5.2.3
JFreeChart 1.5.3
Lombok 1.18.30
Docker Desktop 4.36.0
JUnit 5.11.13
Mockito
MockAPI
API Exchange Rates

## Funcionalidades:


## Entities: 

Usuario - Representa um usuario do sistema
Conta - Representa uma conta de um usuário, que pode ter "n" contas
Transacao - Representa uma transação de uma conta de um usuário. Quando o campo idContaTransferencia é diferente de null, significa um registro de transferência entre contas.

## INSTRUÇÕES PARA EXECUÇÃO

- Executar Docker Desktop em máquina local - versão 4.36.0
- Executar o projeto a partir da classe NttbankApplication.java
- Criar um Usuario, uma Conta para este Usuario e uma Transacao para esta Conta