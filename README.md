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

## ✅ Roteiro de Validação (Passo a Passo)

> Você pode executar este roteiro manualmente pelo Swagger ou importar a collection do Insomnia em: `documentos/Insomnia_2026-05-20.yaml`.

1. **Criar Usuário** (POST `/api/v1/usuarios`)
2. **Criar Tutor vinculado ao Usuário** (POST `/api/v1/tutores`) informando `idUsuario`
3. **Criar Pet vinculado ao Tutor** (POST `/api/v1/pets`) informando `idTutor`
4. **Listar Pets com paginação e ordenação** (GET `/api/v1/pets?page=0&size=10&sort=nome,asc`)
5. **Buscar por parâmetro (filtro por nome)** (GET `/api/v1/pets?nome=Luna&page=0&size=10&sort=nome,asc`)

### URLs úteis
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- H2 Console: `http://localhost:8080/h2-console` (JDBC: `jdbc:h2:mem:clyvodb`, user `sa`, sem senha)

🗂️ Artefatos da Sprint (Pasta /documentos)
Para validação estrutural e evidência de testes, verifique a pasta documentos na raiz deste repositório. Ela contém:

- **MER (Modelo Entidade-Relacionamento):** `documentos/MER.jpeg`
- **DER (Diagrama Entidade-Relacionamento / constraints e chaves):** `documentos/DER.jpeg`

> **Como validar:** abra as imagens acima e confira as cardinalidades (1:N / N:1), chaves estrangeiras e constraints (ex.: unicidade de e-mail/CPF, obrigatoriedades) batendo com as entidades JPA do projeto.

DER & Diagrama de Classes UML: Evidenciando as cardinalidades e restrições.

Cronograma de Desenvolvimento: Detalhamento da distribuição de tarefas da equipe.

Collection do Postman/Insomnia: Arquivo .json contendo todas as requisições (POST e GET paginados) já configuradas para validação do funcionamento da persistência.

👥 Equipe de Desenvolvimento
Maicon Douglas da Silva Timoteo - RM: RM: 561279

Henrique Sinkevicius Maran - RM: 562977

Evellyn Ferreira - RM: 562744
