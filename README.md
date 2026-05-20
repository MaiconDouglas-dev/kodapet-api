# 🐾 Clyvo API - Plataforma de Engajamento Veterinário

> **Entrega Oficial - 1ª Sprint - Módulo: Java Advanced**
> Este repositório contém o ecossistema backend para a plataforma Clyvo, um sistema focado no engajamento entre tutores, pets e clínicas veterinárias, indo muito além de um simples CRUD.

## 📌 Sobre o Projeto
A solução foi arquitetada utilizando os conceitos de **Domain-Driven Design (DDD)** simplificado e **Arquitetura em Camadas** (Controller, Service, Repository, Domain). O sistema gerencia usuários, tutores e pets, aplicando rigorosamente as regras de chaves estrangeiras (1:N e N:1) definidas na modelagem relacional na 3ª Forma Normal (3FN).

## 🚀 Tecnologias e Arquitetura
Para demonstrar domínio pleno da linguagem e do framework, este projeto foi construído em **Java Puro (Sem Lombok)**, garantindo total transparência no encapsulamento e injeção de dependências.

* **Linguagem:** Java 17/21
* **Framework:** Spring Boot 3.x
* **Build Tool:** Gradle (Groovy DSL)
* **Banco de Dados (Dev):** H2 Database (In-Memory)
* **Banco de Dados (Prod):** Oracle Database (Mapeado nos perfis do Spring)
* **Design Patterns:** Data Transfer Object (DTO), Singleton (via Spring IoC), Controller-Service-Repository.

---

## 🎯 Requisitos Técnicos Atendidos (Checklist de Avaliação)
A API foi desenvolvida visando o mais alto nível de maturidade RESTful, cumprindo integralmente os 8 requisitos técnicos da Sprint:

- [x] **Utilização de DTOs:** Padrão `Record` do Java moderno para isolar a camada de domínio.
- [x] **Validação com Bean Validation:** Anotações `@NotBlank`, `@NotNull`, `@Email`, `@Size` implementadas nos Requests.
- [x] **Paginação e Ordenação:** Implementação nativa via `Pageable` e `@PageableDefault` nas listagens.
- [x] **Busca com Parâmetros:** Consultas dinâmicas utilizando *Spring Data JPA Query Methods* (ex: `findByNomeContainingIgnoreCase`).
- [x] **Uso de Cache:** Otimização de performance com anotações `@Cacheable` nos GETs e `@CacheEvict` nos POSTs.
- [x] **Tratamento de Exceções:** Classe `GlobalExceptionHandler` (`@RestControllerAdvice`) para mapear erros 400, 404 e 409 (Data Integrity).
- [x] **Documentação Swagger:** Interface interativa e documentada gerada com `Springdoc OpenAPI`.
- [x] **Gestão e Testes:** Exportação das requisições via Postman e artefatos de modelagem armazenados na pasta `/documentos`.

---

## 🛠️ Como Executar o Projeto (Perfil de Desenvolvimento)

A aplicação utiliza **Spring Profiles**. O perfil `dev` está ativo por padrão, configurado para utilizar o banco **H2 em memória**. O banco e as tabelas são criados automaticamente a cada execução, facilitando a correção e os testes da banca examinadora.

**1. Clone o repositório e acesse a pasta:**
```bash
git clone [https://github.com/SeuUsuario/clyvo-api.git](https://github.com/SeuUsuario/clyvo-api.git)
cd clyvo-api

2. Suba a aplicação via Gradle Wrapper:

No Windows: gradlew bootRun

No Mac/Linux: ./gradlew bootRun

3. Acesse a Documentação Interativa (Swagger):

URL: http://localhost:8080/swagger-ui.html

Por aqui é possível testar todas as rotas (POST, GET, DELETE).

4. Acesse o Console do Banco de Dados (H2):

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:clyvodb

User: sa (Senha em branco).

🗂️ Artefatos da Sprint (Pasta /documentos)
Para validação estrutural e evidência de testes, verifique a pasta documentos na raiz deste repositório. Ela contém:

DER & Diagrama de Classes UML: Evidenciando as cardinalidades e restrições.

Cronograma de Desenvolvimento: Detalhamento da distribuição de tarefas da equipe.

Collection do Postman/Insomnia: Arquivo .json contendo todas as requisições (POST e GET paginados) já configuradas para validação do funcionamento da persistência.

👥 Equipe de Desenvolvimento
Maicon Douglas da Silva Timoteo - RM: [Seu RM]

[Nome do Integrante 2] - RM: [RM]

[Nome do Integrante 3] - RM: [RM]
