# ForumHub 🧠

Um sistema de fórum de discussão criado com Spring Boot, que permite o cadastro, listagem, detalhamento, atualização e exclusão de tópicos. Inclui autenticação via login e geração de token JWT.

---

## 🛠 Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- JWT (JSON Web Token)
- Hibernate
- Lombok

---

## ⚙️ Funcionalidades

- Cadastro de usuários
- Login com autenticação JWT
- Cadastro de tópicos
- Listagem de tópicos
- Detalhamento de tópicos
- Atualização de tópicos
- Exclusão de tópicos
- Integração com Swagger (documentação da API)

---

## 📦 Endpoints da API

### 🔐 Login

`POST /login`

```json
{
  "login": "usuario1",
  "senha": "123456"
}

Exemplo de Resposta:
{
  "token": "eyJhbGciOiJIUzI1NiIsIn..."
}

Resposta:

{
  "token": "eyJhbGciOiJIUzI1NiIsIn..."
}

**📄 Listar Tópicos**

GET /topicos
[
  {
    "id": 1,
    "titulo": "Dúvida sobre Spring",
    "mensagem": "Como funciona o contexto do Spring?",
    "dataCriacao": "2025-08-01T12:00:00",
    "status": "NAO_RESPONDIDO"
  }
]

**➕ Cadastrar Tópico**

POST /topicos

{
  "titulo": "Erro 403 ao autenticar",
  "mensagem": "Não consigo acessar a rota protegida",
  "dataCriacao": "2025-08-01T15:30:00",
  "status": "NAO_RESPONDIDO",
  "autor": {
    "id": 1
  },
  "curso": {
    "id": 1
  }
}

**🔍 Detalhar Tópico**

GET /topicos/{id}

**✏️ Atualizar Tópico**

PUT /topicos/{id}

{
  "titulo": "Erro 403 corrigido",
  "mensagem": "Atualizei a autenticação e funcionou"
}

**❌ Deletar Tópico**

DELETE /topicos/{id}

**🚀 Como rodar o projeto**

*Clone o projeto*
git clone https://github.com/WendersonR/ForumHub

Configure o application.properties com seu banco MySQL:

spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=root
spring.datasource.password=suasenha

*Rode o projeto:*

Via IDE: Run Application

Via terminal:
./mvnw spring-boot:run (Linux/Mac)
mvnw.cmd spring-boot:run (Windows)

**🧪 Exemplos de Teste no Insomnia**

*Login*
Rota: POST /login

Corpo: JSON (login/senha)

Header: Content-Type: application/json

Rotas protegidas
Adicione Header:
Authorization: Bearer <TOKEN_RECEBIDO_DO_LOGIN>

**✅ Requisitos**

Java 17+

MySQL 8+

Maven 3+

**📄 Licença**

Este projeto é livre para fins educacionais.
