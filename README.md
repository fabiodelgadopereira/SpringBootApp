### Autor: Fábio Delgado

Olá! Seja bem vindo ;)


## Índice
1. [SpringBootApp](#SpringBootApp)
2. [Projeto e Conteúdo](#Projeto-e-Conteudo)
3. [Swagger](#Swagger)
4. [JWT](#JWT)
5. [SQL Server e JDBC](#SQL-Server-e-JDBC)
6. [Publicação](#Publicação)
7. [Suporte](#Suporte)

## FlaskApp

Este repositório contém um exemplo de APIs REST desenvolvida em JAVA utilizando o framework Spring Boot com SQL Server para armazenameto de dados

### Pre-requisitos

JDK 1.8 +
Maven 3.0 +

### Como executar essa aplicação?

 - Faça o download do zip ou clone o repositório Git.
 - Descompacte o arquivo zip (caso tenha baixado o .zip)
 - Abra o diretório Prompt de Comando e Altere (cd) para a pasta que contém pom.xml
 - Abra o visual code ou execute o comando via prompt `code .`
 - Pressione `F5` para executar a aplicação.

A aplicação deverá estar disponivel em seu navegador no endereço: http://localhost:8080/swagger-ui.html

![swagger](/img/swagger.png)

### Extensões recomendadas para desenvolvimento no VSCODE

 - Java Extension Pack from Microsoft
 - Spring Boot Extension Pack from Pivotal
 - Spring Boot Dashboard from Microsoft
 - Lombok Annotations Support for VS Code from Gabriel Basilio Brito
 - Java Code Generators from Sohibe

## Projeto e Conteúdo

O Spring Boot é um projeto da Spring que veio para facilitar o processo de configuração e publicação de nossas aplicações. A intenção é ter o seu projeto rodando o mais rápido possível e sem complicação. Ele consegue isso favorecendo a convenção sobre a configuração. Basta que você diga pra ele quais módulos deseja utilizar (WEB, Template, Persistência, Segurança, etc.) que ele vai reconhecer e configurar.

### Entedento a estrutura de projeto

![ini](/img/ini.png)

## Swagger

O Swagger é uma aplicação open source que auxilia os desenvolvedores a definir, criar, documentar e consumir APIs REST;
É composto de um arquivo de configuração, que pode ser definido em YAML ou JSON;
Fornece ferramentas para: auxiliar na definição do arquivo de configuração (Swagger Editor), interagir com API através das definições do arquivo de configuração (Swagger UI) e gerar templates de código a partir do arquivo de configuração (Swagger Codegen).

fonte: https://swagger.io/resources/webinars/getting-started-with-swagger/

> A maneira mais fácil de instalar é usar o Maven:

`pom.xml`
```xml
		<dependency>
		    <groupId>io.springfox</groupId>
		    <artifactId>springfox-swagger2</artifactId>
		    <version>2.9.2</version>
		</dependency>
		<dependency>
		    <groupId>io.springfox</groupId>
		    <artifactId>springfox-swagger-ui</artifactId>
		    <version>2.9.2</version>
		</dependency>
```
> Exemplo de implementação para testes


## JWT
O JWT (JSON Web Token) nada mais é que um padrão (RFC-7519) de mercado que define como transmitir e armazenar objetos JSON de forma simples, compacta e segura entre diferentes aplicações, muito utilizado para validar serviços em Web Services pois os dados contidos no token gerado pode ser validado a qualquer momento uma vez que ele é assinado digitalmente.

JSON Web Tokens (JWT) é um padrão stateless porque o servidor autorizador não precisa manter nenhum estado; o próprio token é sulficiente para verificar a autorização de um portador de token.

Os JWTs são assinados usando um algoritmo de assinatura digital (por exemplo, RSA) que não pode ser forjado. Por isso, qualquer pessoa que confie no certificado do assinante pode confiar com segurança que o JWT é autêntico. Não há necessidade de um servidor consultar o servidor emissor de token para confirmar sua autenticidade.

fonte: https://jwt.io/introduction/

> A maneira mais fácil de instalar é usar o Maven:


> Exemplo de implementação para testes


## SQL Server e JDBC

JDBC é semelhante ao ODBC, e no principio usava justamente ODBC para conectar-se com o banco de dados. A partir de um código nativo as aplicações Java podiam utilizar qualquer banco de dados que tivesse um driver ODBC disponível. Isso contribuiu bastante para a popularização do JDBC uma vez que existe um driver ODBC para praticamente qualquer banco de dados de mercado. Nesse repositório sera utilizado o JDBC para comunicação com o banco de dados e execução de comandos através de store procedures.

Stored Procedure, que traduzido significa Procedimento Armazenado, é uma conjunto de comandos em SQL que podem ser executados de uma só vez, como em uma função. Ele armazena tarefas repetitivas e aceita parâmetros de entrada para que a tarefa seja efetuada de acordo com a necessidade individual. Nesse projeto foram desenvolvidos. As Stored Procedures implementadas nesse projeto são: 

- sp_Clientes_InsertValue
- sp_Clientes_GetValueById
- sp_Clientes_GetAllValues
- sp_Clientes_DeleteValue

> A maneira mais fácil de instalar é usar o Maven:

> Exemplo de implementação para testes

## Suporte

Por favor entre em contato conosco via [Email]