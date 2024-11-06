
# Desafio API 

## Descrição

Este projeto é uma API desenvolvida para gerenciar alunos e turmas. A aplicação fornece endpoints para criar, atualizar, excluir e consultar alunos e suas associações com turmas, usando validações e regras de negócio específicas.
## Tecnologias Utilizadas

## Java
- Linguagem principal utilizada para o desenvolvimento da API.
- Spring Boot: Framework que facilita a criação de aplicações Java robustas e escaláveis.
- Spring Data JPA: Módulo do Spring que simplifica o acesso a dados e abstrai as operações com o banco de dados.
## Swagger
- Ferramenta de documentação que permite testar os endpoints da API.
## Banco de Dados (PostgreSQL)
- Armazena as informações de alunos e turmas.
## Documentação
- Swagger UI: Interface interativa para visualização e teste dos endpoints da API, configurada para rodar na porta 8085.
## Pré-requisitos
 Antes de começar, certifique-se de ter os seguintes itens instalados:

- Java 17 ou superior
- Maven para gerenciar as dependências do projeto
- PostgreSQL para o banco de dados relacional
## Como Clonar o Repositório
### Para clonar o repositório, execute o comando abaixo:

- git clone <URL_DO_REPOSITORIO>
- cd desafioWebApi

## Configuração do Banco de Dados

### 1 - Crie um banco de dados no PostgreSQL com o nome: bd_apidesafio
#### No terminal do PostgreSQL, você pode rodar o comando:
- CREATE DATABASE bd_apidesafio;
### 2 - Configure as credenciais de acesso no arquivo application.properties ou application.yml, dependendo do projeto. Certifique-se de atualizar as propriedades de conexão conforme o seu ambiente.

#### Exemplo de configuração em application.properties:

- spring.datasource.url=jdbc:postgresql://localhost:5432/bd_apidesafio
- spring.datasource.username=<SEU_USUARIO>
- spring.datasource.password=<SUA_SENHA>
## Acessando a Documentação (Swagger)

#### O Swagger UI está configurado para a porta 8080. Após iniciar a aplicação, você pode acessar a documentação interativa dos endpoints através do link:

- http://localhost:8085/swagger-ui.html

### Endpoints Principais
#### A API oferece os seguintes endpoints principais para gerenciamento de alunos e turmas:

- GET /alunos: Lista todos os alunos.
- POST /alunos: Cria um novo aluno.
- PUT /alunos/{id}: Atualiza um aluno existente.
- DELETE /alunos/{id}: Exclui um aluno.
- GET /turmas: Lista todas as turmas.
- POST /turmas: Cria uma nova turma.
- PUT /turmas/{id}: Atualiza uma turma existente.
- DELETE /turmas/{id}: Exclui uma turma.
## Autor

- [Gilvan-Borges](https://www.linkedin.com/in/gilvan-borges-0b70582bb/)

