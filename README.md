# Projeto de Gerenciamento de Tarefas



## O Projeto

Este projeto é uma aplicação de gerenciamento de tarefas e projetos, desenvolvida utilizando o Spring Framework do zero, com Hibernate para ORM, JUnit para testes, e XAMPP para o gerenciamento do banco de dados MySQL. A aplicação segue o padrão MVC (Model-View-Controller) e utiliza Maven para gerenciamento de dependências e build. O IDE utilizado para o desenvolvimento é o Spring Tool Suite (STS).

## Tecnologias Utilizadas

- Spring Framework: Utilizado para a estruturação da aplicação e injeção manual de dependências. A aplicação foi construída do zero com Spring, sem utilizar Spring Boot.
- Hibernate: Utilizado para o mapeamento objeto-relacional (ORM) e acesso ao banco de dados.
- JUnit: Utilizado para a realização de testes unitários.
- XAMPP: Utilizado para o gerenciamento do banco de dados MySQL.
- Maven: Utilizado como gerenciador de build e dependências.
- MySQL: Banco de dados utilizado, criado de forma escalável para armazenar as informações de projetos e tarefas.
- Spring Tool Suite (STS): IDE utilizada para o desenvolvimento da aplicação.
- MVC (Model-View-Controller): Estrutura de design utilizada para separar as responsabilidades da aplicação.

## Estrutura do Projeto

- Model: Contém as entidades JPA que representam as tabelas do banco de dados.
- Repository: Contém as classes DAO para acesso e manipulação dos dados no banco de dados.
- Service: Contém a lógica de negócio da aplicação.
- Controller: Contém os controladores que gerenciam as requisições HTTP e a interação com a camada de serviço.
- Resources: Contém os arquivos de configuração e as páginas XHTML.

## Configuração do Ambiente

- Configuração do Banco de Dados:
- Importe a base de dados em SQL q se encontra na pasta SQL e altere no application.properties com usuario, senha e base de dados.


## Configuração do Maven:

O projeto utiliza Maven para gerenciar suas dependências e build. Certifique-se de que o arquivo pom.xml está corretamente configurado com as dependências necessárias.



# Configuração do Spring Framework:

A aplicação foi construída utilizando o Spring Framework, com a injeção manual de dependências. Mesmo utilizando o Spring Tool Suite, a aplicação não utiliza o Spring Boot.

## Configuração do Hibernate:

O Hibernate é utilizado para realizar o mapeamento objeto-relacional e facilitar o acesso ao banco de dados.

## Como Executar
Clone o Repositório:

## Acesse a Aplicação:
Abra seu navegador e acesse http://localhost:8080/home.xhtml


## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
