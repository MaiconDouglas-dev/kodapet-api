# 🐾 Clyvo API - Plataforma de Engajamento Veterinário

> **Entrega Oficial - 1ª Sprint - Módulo: Java Advanced**  
> Este repositório contém o backend para a plataforma Clyvo, com foco no engajamento entre tutores, pets e clínicas veterinárias, indo além de um simples CRUD por incluir validações, regras de consistência, paginação/ordenação, busca parametrizada, cache e tratamento centralizado de exceções.

---

## 📌 Sobre o Projeto
A solução foi arquitetada com **POO**, entidades relacionadas e mapeadas com **JPA**, seguindo uma **arquitetura em camadas**:
- **Controller** (API REST)
- **Service** (regras de negócio)
- **Repository** (persistência)
- **Domain** (entidades)

O sistema gerencia **Usuários**, **Tutores** e **Pets**, respeitando a modelagem relacional e integridade referencial (ex.: vínculos entre entidades e constraints).

---

## 🚀 Tecnologias e Arquitetura
- **Linguagem:** Java 21
- **Framework:** Spring Boot (ecossistema Spring)
- **Build Tool:** Gradle (Groovy DSL)
- **Banco de Dados (Dev):** H2 (in-memory)
- **Banco de Dados (Prod):** Oracle (configurado via profiles)
- **Design Patterns (uso prudente):** DTO, Controller-Service-Repository, IoC/DI via Spring

---

## 🎯 Requisitos Técnicos Atendidos (Checklist)
- [x] **DTOs** (requests/responses) para isolamento da camada de domínio
- [x] **Bean Validation** nos DTOs de entrada (`@NotBlank`, `@NotNull`, `@Email`, `@Size`, etc.)
- [x] **Paginação** via `Pageable` e retorno `Page<T>`
- [x] **Ordenação** via `sort` / `@PageableDefault`
- [x] **Busca com parâmetros** (ex.: filtro por nome) via Spring Data JPA Query Methods
- [x] **Cache** com `@EnableCaching`, `@Cacheable` e `@CacheEvict` (Caffeine)
- [x] **Tratamento de exceções** centralizado com `@RestControllerAdvice`
- [x] **Swagger / OpenAPI** com `springdoc-openapi`

---

## 🛠️ Como Executar (Perfil de Desenvolvimento)
O perfil `dev` está ativo por padrão, utilizando **H2 em memória**. O banco e as tabelas são criados automaticamente a cada execução.

### Subir a aplicação (Gradle Wrapper)
**Windows:**
```bash
gradlew bootRun
```

**Mac/Linux:**
```bash
./gradlew bootRun
```

---

## ✅ Roteiro de Validação (Passo a Passo)
> Você pode executar este roteiro manualmente pelo Swagger ou importar a collection do Insomnia em: `documentos/Insomnia_2026-05-20.yaml`.

1. **Criar Usuário** (POST `/api/v1/usuarios`)
2. **Criar Tutor vinculado ao Usuário** (POST `/api/v1/tutores`) informando `idUsuario`
3. **Criar Pet vinculado ao Tutor** (POST `/api/v1/pets`) informando `idTutor`
4. **Listar Pets com paginação e ordenação**  
   GET `/api/v1/pets?page=0&size=10&sort=nome,asc`
5. **Buscar com parâmetro (filtro por nome) + paginação**  
   GET `/api/v1/pets?nome=Luna&page=0&size=10&sort=nome,asc`

---

## 🧪 Teste rápido (copy/paste) — cURL
> Base URL (dev): `http://localhost:8081`

### 1) Criar Usuário (deve retornar **201**)
```bash
curl -i -X POST http://localhost:8081/api/v1/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Usuario Teste",
    "email": "usuario.teste@clyvo.com",
    "senha": "12345678",
    "perfil": "ADMIN"
  }'
```

### 2) Listar Usuários (paginação + ordenação)
```bash
curl -i "http://localhost:8081/api/v1/usuarios?page=0&size=10&sort=nome,asc"
```

> Pegue o `id` retornado na listagem acima e use como `idUsuario` no próximo passo.

### 3) Criar Tutor (deve retornar **201**)
```bash
curl -i -X POST http://localhost:8081/api/v1/tutores \
  -H "Content-Type: application/json" \
  -d '{
    "idUsuario": 1,
    "nome": "Tutor Teste",
    "cpf": "123.456.789-00",
    "telefone": "11999999999",
    "endereco": "Rua A, 123",
    "dataNascimento": "1990-01-01"
  }'
```

### 4) Listar Tutores (busca por parâmetro + paginação)
```bash
curl -i "http://localhost:8081/api/v1/tutores?nome=Tutor&page=0&size=10&sort=nome,asc"
```

> Pegue o `id` do tutor retornado na listagem acima e use como `idTutor` no próximo passo.

### 5) Criar Pet (deve retornar **201**)
```bash
curl -i -X POST http://localhost:8081/api/v1/pets \
  -H "Content-Type: application/json" \
  -d '{
    "idTutor": 1,
    "nome": "Rex",
    "especie": "Cachorro",
    "raca": "Vira-lata",
    "sexo": "M",
    "dataNascimento": "2020-01-01",
    "pesoKg": 12.5
  }'
```

### 6) Listar Pets (paginação + ordenação)
```bash
curl -i "http://localhost:8081/api/v1/pets?page=0&size=10&sort=nome,asc"
```

---

## ✅ Provas de validação / regras de negócio (retornos esperados)

### Regra: senha deve ter **mínimo 8 caracteres** (deve retornar **400** ou **422**)
```bash
curl -i -X POST http://localhost:8081/api/v1/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Usuario Invalido",
    "email": "invalido@clyvo.com",
    "senha": "1234567",
    "perfil": "ADMIN"
  }'
```

### Regra: tutor não pode ter CPF duplicado (deve retornar **422** ou **409**)
> Execute o POST de Tutor duas vezes com o mesmo CPF.

## 🔗 URLs úteis
- **Swagger UI:** `http://localhost:8081/swagger-ui.html`
- **H2 Console:** `http://localhost:8081/h2-console`
    - JDBC: `jdbc:h2:mem:clyvodb`
    - User: `sa`
    - Senha: *(vazia)*

---

## 🗂️ Artefatos da Sprint (pasta `/documentos`)
Para validação estrutural e evidências de testes, consulte a pasta `/documentos`:

- **MER (Modelo Entidade-Relacionamento):** `documentos/MER.jpeg`
- **DER (Diagrama Entidade-Relacionamento / constraints e chaves):** `documentos/DER.jpeg`
- **Cronograma de Desenvolvimento:** `documentos/cronograma.md`
- **Collection de testes (Insomnia):** `documentos/Insomnia_2026-05-20.yaml`

> **Como validar os diagramas:** confira cardinalidades (1:N / N:1), chaves estrangeiras e constraints (ex.: unicidade e obrigatoriedades) e compare com os relacionamentos nas entidades JPA.

---

## 👥 Equipe de Desenvolvimento
- **Maicon Douglas da Silva Timoteo** — RM: 561279
- **Henrique Sinkevicius Maran** — RM: 562977
- **Evellyn Ferreira** — RM: 562744  