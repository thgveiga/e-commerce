# e-commerce
Cadastro de produtos e pedidos em um portal de e-commerce

**Nome Aplicação:** e-commerce

**Repositorio:** https://github.com/thgveiga/e-commerce.git

**Disciplina:** Presistence

**Professor:** Rafael Tsuji Matsuyama

**Turma:** 35SCJ 
**Curso:** MBA em FullStack Developer - Microservices, Cloud e IoT
 
**Desenvolvedores:**
     * Victor Hugo      RM
     * Carlos Zanchetta RM
     * Rodrigo Nonato   RM
     * Thiago Veiga     RM 336295

     
**Principais Funcionalidades:**
     * Cadastro de Clientes
     * Cadastro de Produtos
     * Cadastro de Pedidos
     * Controle de Estoque

**Tecnologias:**
    * Spring-Boot
    * Spring-REST
    * String Data
    * Mysql
    * Redis

**Principais Serviços da API:**
    * Clientes (CRUD e operações)
    * Produtos (CRUD e operações)
    * Pedidos  (CRUD e operações)

# Instalação

```bash
mvn clean install 
java -jar {user_home}/.m2/repository/org/projectlombok/lombok/1.18.12/lombok-1.18.12.jar
cd {app_home}
mvn clean spring-boot:run
```
## Pre Requisitos 

```
Java8
Maven3 
```

# Swagger

```
http://localhost:8080/swagger-ui.html

```

# Database
## Redis
```
url : http://localhost:6279
user : admin
password : ''
```

## PostgreSql
```
url: http://127.0.0.1:49878/browser/
username=postgres
password=admin

```