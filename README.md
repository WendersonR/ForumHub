#**ForumHub 🧠**
Um sistema de fórum de discussão criado com Spring Boot, que permite o cadastro, listagem, detalhamento, atualização e exclusão de tópicos. Inclui autenticação via login e geração de token JWT.

##**🛠 Tecnologias**
Java 17

Spring Boot

Spring Data JPA

Spring Security

MySQL

JWT (JSON Web Token)

Hibernate

Lombok

Swagger (documentação da API)

##**⚙️ Funcionalidades**
Cadastro de usuários

Login com autenticação JWT

Cadastro de tópicos

Listagem de tópicos

Detalhamento de tópicos

Atualização de tópicos

Exclusão de tópicos

Integração com Swagger para documentação da API

##**📦 Endpoints da API**
##**🔐 Login**
POST /login

Request:
{ "login": "usuario1", "senha": "123456" }

Resposta:
{ "token": "eyJhbGciOiJIUzI1NiIsIn..." }

##***📄 Listar Tópicos***
GET /topicos

Resposta:
[ { "id": 1, "titulo": "Dúvida sobre Spring", "mensagem": "Como funciona o contexto do Spring?", "dataCriacao": "2025-08-01T12:00:00", "status": "NAO_RESPONDIDO" } ]

##***➕ Cadastrar Tópico***
POST /topicos

Request:
{ "titulo": "Erro 403 ao autenticar", "mensagem": "Não consigo acessar a rota protegida", "dataCriacao": "2025-08-01T15:30:00", "status": "NAO_RESPONDIDO", "autor": { "id": 1 }, "curso": { "id": 1 } }

##***🔍 Detalhar Tópico***
GET /topicos/{id}

##***✏️ Atualizar Tópico***
PUT /topicos/{id}

Request:
{ "titulo": "Erro 403 corrigido", "mensagem": "Atualizei a autenticação e funcionou" }

##***❌ Deletar Tópico***
DELETE /topicos/{id}

##***🚀 Como rodar o projeto***
Clone o projeto:
git clone https://github.com/WendersonR/ForumHub

Configure o arquivo src/main/resources/application.properties com os dados do seu banco MySQL:
spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=root
spring.datasource.password=suasenha

Rode o projeto:

Via IDE: Run Application

***Via terminal:***
./mvnw spring-boot:run (Linux/Mac)
mvnw.cmd spring-boot:run (Windows)

***🧪 Exemplos de Teste no Insomnia***
Login: POST /login com JSON {"login":"usuario1","senha":"123456"} e Header Content-Type: application/json

Rotas protegidas: adicionar no Header Authorization: Bearer <TOKEN_RECEBIDO_DO_LOGIN>

***✅ Requisitos***
Java 17+, MySQL 8+, Maven 3+

***📄 Licença***
Este projeto é livre para fins educacionais.

**📖 Documentação da API**
http://localhost:8080/swagger-ui.html

***Contato***
Desenvolvido por Wenderson Ribeiro Lopes
GitHub: https://github.com/WendersonR
