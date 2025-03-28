# 📌 Pedidos API 🍔

API REST para gerenciamento de pedidos em um restaurante, desenvolvida com Spring Boot e PostgreSQL.

## 📌 Sobre o Projeto

Este projeto é uma API REST desenvolvida com Spring Boot, permitindo o gerenciamento de pedidos em um restaurante. Ele conta com:
- Controle de acesso com Spring Security (diferencia permissões entre USER e ADMIN)
- Banco de Dados PostgreSQL para persistência
- Spring Data JPA para interação com o banco
- DTOs para encapsular dados de requisição e resposta
- Validações de entrada com Bean Validation
- Tratamento de Exceções para requisições inválidas
- Uso de Docker para rodar o PostgreSQL
- Testes de API via Postman

## 🚀 Tecnologias Utilizadas
O projeto foi desenvolvido com as seguintes tecnologias:
| Tecnologia  | Descrição | 
|-----------|-----------|
| Java 21    | Linguagem principal    |
| Spring Boot  | Framework para desenvolvimento da API    | 
| Spring Security  | Controle de autenticação e autorização    |
| Spring Data JPA  | Camada de persistência    |
| PostgreSQL  | Banco de dados relacional    |
| pgAdmin 4	  | Interface gráfica para gerenciamento do PostgreSQL    |
| Docker  | 	Contêinerização do PostgreSQL    |
| Postman	  | Testes de requisições API    |

## 🏗 Arquitetura do Projeto
O código foi estruturado seguindo boas práticas de arquitetura em camadas:
- 📂 controller → Controladores que expõem os endpoints da API
- 📂 service → Regras de negócio e manipulação dos dados
- 📂 repository → Comunicação com o banco de dados via JPA
- 📂 model → Definição das entidades persistidas no banco
- 📂 dto → Objetos de transferência de dados entre requisição e resposta
- 📂 config → Configurações do Spring Security
- 📂 exception → Tratamento global de exceções

## 🛠 Instalação e Configuração
### 📌 Pré-requisitos
- JDK 17+
- Maven ou Gradle
- Docker
- Postman (para testes de API)

### 1️⃣ Clonar o repositório
```bash
git clone https://github.com/seu-usuario/pedidos-api.git
cd pedidos-api
```

### 📌 Configurar o Banco de Dados
#### 2️⃣  Rodando PostgreSQL com Docker
```bash
docker run --name pedidos-db -e POSTGRES_DB=pedidos -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -p 5432:5432 -d postgres
```
#### 3️⃣ Configurar ```application.properties``` para conectar ao PostgreSQL
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pedidos
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

#### 4️⃣  Rodar a aplicação
```bash
mvn spring-boot:run
```
#### 5️⃣ Acesse a API via Postman ou outro cliente HTTP

## 📌 Endpoints
#### 🔑 Autenticação 
| Método | Endpoint   | Acesso  |
|--------|-----------|---------|
| `POST` | `/usuarios` | **Público** (criação de usuários) |
| `POST` | `/login`    | **Público** (página de login) |

#### 📦 Pedidos  

| Método | Endpoint       | Acesso         |
|--------|---------------|----------------|
| `GET`  | `/pedidos`     | **USER, ADMIN** |
| `POST` | `/pedidos`     | **USER, ADMIN** |
| `PUT`  | `/pedidos/{id}` | **ADMIN**       |
| `DELETE` | `/pedidos/{id}` | **ADMIN**       |

#### 👥 Clientes  

| Método | Endpoint    | Acesso  |
|--------|------------|---------|
| `GET`  | `/clientes` | **ADMIN** |
| `POST` | `/clientes` | **ADMIN** |

## 📝 Considerações
Este projeto foi desenvolvido com foco na estruturação do código utilizando DTOs, Services, Controllers e Repositories, além de boas práticas no Spring Security para controle de usuários e permissões. 🚀🔥
