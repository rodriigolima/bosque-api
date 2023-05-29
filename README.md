# Spring Boot API Bosque Project

This is a sample Java / Maven / Spring Boot (version 3.0.1) application that can be used as a starter for creating a microservice rest.


## How to Run [🔝](#)

This application is packaged as a war which has Tomcat 10.1.4 embedded.

* Clone this repository
* Make sure you are using JDK 19.0.1 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these methods: ```mvn spring-boot:run```
  or can use any IDE.
* Check the stdout or boot_example.log file to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2023-05-28T15:49:57.113-03:00  INFO 16584 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-05-28T15:49:57.120-03:00  INFO 16584 --- [  restartedMain] b.c.h.bosque.BosqueApiApplication        : Started BosqueApiApplication in 4.999 seconds (process running for 5.492)
```

# Indice [🔝](#)

- [Spring Boot API Bosque Project](#)
    - [How to Run](#how-to-run-)
        - [About the Service](#about-the-service-)
            - [Get endpoints, documentation configurations, etc.](#get-endpoints-documentation-configurations-etc-)
            - [Create a user resource](#)
            - [list of users](#-)
            - [Update a user resource](#)
            - [Delete a user resource](#)
            - [Documentation Swagger](#-)
    - [About Spring Boot](#about-spring-boot-)
    - [Running the project with MySQL](#running-the-project-with-mysql-)

## About the Service [🔝](#s)

The service is just a simple products review REST service, 
also do with a relational database like MySQL or PostgreSQL. If your database connection properties work, you can call some
REST endpoints defined in ```br.com.hackthon.bosque.api.controller.UsuarioController``` on **port 8080**.



You can use this sample service to understand the conventions and configurations that allow you to create a DB-backed RESTful service. Once you understand and get comfortable with the sample app you can add your own services following the same patterns as the sample service.

Here is what this little application demonstrates:

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
* Packaging as a single war with embedded container (tomcat 9.0.34): No need to install a container separately on the host just run using the ``mvn spring-boot:run`` command
* Endpoints automatically on a configured port.
* Writing a REST service using annotation:  JSON request / response;
* Exception mapping from application exceptions to the right HTTP response with exception details in the body
* *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations.
* Automatic CRUD functionality against the data source using Spring *Repository* pattern
* Demonstrates MockMVC test framework with associated libraries
* All APIs are "self-documented" by Swagger2 using annotations


The service has structural applications most used in the development market such as MVC architecture, TDD concept
applications, clean Code.

It was also implementing a unit testing system with JUnit5, which provides a more robust application and less prone to bugs.
as you saw above there is a command to execute all tests that were successful.



Here are some endpoints you can call:

### Get endpoints, documentation configurations, etc. [🔝](#)

```
http://localhost:8080/usuarios
http://localhost:8080/usuarios/:id
```

### Create a product resource [🔝](#spring-boot--microservice--attornatus-project)

```
POST /products
Accept: application/json
Content-Type: application/json

{
    "cpf": "032.042.614-03",
    "nome": "Rodrigo Lima",
    "email": "rodrigolima@hotmail.com",
    "senha": "123",
    "dataNascimento": "1993-12-21",
    "genero": "MASCULINO",
    "telefone": "81992406566",
    "nomeEmpresa": "Bosque"
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8080/usuarios/1
```

### list of people [🔝](#)

```
GET http://localhost:8080/usuarios

Response: HTTP 200
Content: list of application/json

[]
```
### By ID  [🔝](#s) 
```
GET http://localhost:8080/usuarios/1

Response: HTTP 200
Content: application/json


{
    "id": 1,
    "cpf": "999.9999.999-99",
    "nome": "João da Silva",
    "email": "joao@bosque.com.br",
    "dataNascimento": "23/12/1993",
    "genero": "MASCULINO",
    "telefone": "95215648",
    "nomeEmpresa": "Bosque",
    "grupos": [
        {
            "id": 1,
            "nome": "ALUNO"
        }
    ]
}
```

### Update a user resource [🔝](#)

```
PUT /usuarios/1
Accept: application/json
Content-Type: application/json

{
    "cpf": "091.049.634-03",
    "nome": "Rodrigo Lima",
    "email": "rodrigolima@hotmail.com",
    "dataNascimento": "21/12/1933",
    "genero": "MASCULINO",
    "telefone": "81992406566",
    "nomeEmpresa": "Bosque",
    "grupos": []
}

RESPONSE: HTTP 204 
```

### Update a password user resource [🔝](#)

```
PUT /usuarios/1/senha
Accept: application/json
Content-Type: application/json

{
    {
    "senhaAtual": "abc",
    "novaSenha": "123"
}
}

RESPONSE: HTTP 204 
```
### Delete a user  resource [🔝](#)

```
DELETE /api/usuarios/1
Content-Type: No content

RESPONSE: HTTP 204 
Content: No Content
```

### Other endpoints of user is in production [🔝](#) 

- Grupo
- Permissão
- Cursos



Author                                                                                                                                                     |                                                                                                                                                                                                                                                                         |
| :-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
| [<img src="https://avatars.githubusercontent.com/u/23271567?v=4" width=115><br><sub>@rodrigoml21</sub>](https://github.com/rodriigolima) <br><br> | :computer: [About me](https://about.me/rmls)
