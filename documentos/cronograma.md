# 📅 Cronograma de Desenvolvimento - Sprint 1 (API Clyvo)

**Projeto:** Plataforma de Engajamento Veterinário Clyvo  
**Disciplina:** Java Advanced  
**Metodologia Aplicada:** Ciclo de Desenvolvimento Ágil (Sprint Intensiva de 4 Dias)  
**Período:** 17/05/2026 a 20/05/2026

---

## 👥 Equipe Técnica e Responsabilidades
* **Maicon Douglas da Silva Timoteo** (RM: 561279) - Desenvolvimento Backend / Arquitetura Spring
* **Henrique Sinkevicius Maran** (RM: 562977) - Modelagem de Dados / Banco de Dados
* **Evellyn Ferreira** (RM: 562744) - Documentação, Swagger e Testes QA

---

## 🚀 Linha do Tempo e Distribuição de Atividades

| Data | Fase do Projeto | Atividade Realizada | Responsáveis | Status |
| :--- | :--- | :--- | :--- | :--- |
| **17/05** *(Domingo)* | **Planejamento e Modelagem** | Definição do escopo do problema; elaboração do **MER/DER** e diagrama de classes para coerência entre relacionamentos e constraints. | Henrique Sinkevicius Maran | ✅ Concluído |
| **18/05** *(Segunda-feira)* | **Setup e Persistência** | Configuração Spring Boot + Gradle; mapeamento das entidades JPA (**Usuario**, **Tutor**, **Pet**); configuração H2 (dev) e Oracle (profiles); criação de repositories (Spring Data). | Maicon Douglas da Silva Timoteo | ✅ Concluído |
| **19/05** *(Terça-feira)* | **Regras de Negócio e Validação** | Implementação da camada Service; criação de DTOs; validação com Bean Validation; implementação do `GlobalExceptionHandler` (400/404/409). | Maicon Douglas da Silva Timoteo | ✅ Concluído |
| **20/05** *(Quarta-feira)* | **Exposição, Testes e Entrega** | Controllers REST; paginação/ordenação/busca com parâmetros; configuração de cache; Swagger/OpenAPI; exportação e organização da collection do Insomnia e documentação final em `/documentos`. | Toda a equipe | ✅ Concluído |

---

## 📌 Observações da Entrega
* **Gestão de Prazos:** atividades executadas dentro da janela planejada da sprint.
* **Gestão de Configuração:** artefatos versionados em repositório público no GitHub, com documentação e evidências de teste.