# 📅 Cronograma de Desenvolvimento - Sprint 1 (API Clyvo)

**Projeto:** Plataforma de Engajamento Veterinário Clyvo  
**Disciplina:** Java Advanced  
**Metodologia Aplicada:** Ciclo de Desenvolvimento Ágil (Sprint Intensiva de 4 Dias)  
**Período:** 17/05/2026 a 20/05/2026

## 👥 Equipe Técnica e Responsabilidades
* **Maicon Douglas da Silva Timoteo** (RM: 561279) - Desenvolvedor Backend / Arquitetura Spring
* **Henrique S.Maran** (RM: [RM 2]) - Modelagem de Dados / Banco de Dados
* **[Nome do Integrante 3]** (RM: [RM 3]) - Documentação, Swagger e Testes QA

---

## 🚀 Linha do Tempo e Distribuição de Atividades

| Data | Fase do Projeto | Atividade Realizada | Responsável(is)                        | Status |
| :--- | :--- | :--- |:---------------------------------------| :--- |
| **17/05**<br>*(Domingo)* | **Planejamento e Modelagem** | - Definição do escopo do problema.<br>- Desenho do Diagrama Entidade-Relacionamento (DER).<br>- Desenho do Diagrama de Classes UML. | [Henrique R.Maran]                     | ✅ Concluído |
| **18/05**<br>*(Segunda-feira)* | **Setup e Persistência** | - Configuração do Spring Boot e Gradle.<br>- Mapeamento das Entidades JPA (`Usuario`, `Tutor`, `Pet`, `Clinica`).<br>- Configuração dos bancos (H2 e Oracle) via Profiles.<br>- Criação dos Repositories (Spring Data). | Maicon Douglas                         | ✅ Concluído |
| **19/05**<br>*(Terça-feira)* | **Regras de Negócio e Validação** | - Construção da camada Service.<br>- Criação dos DTOs (Records).<br>- Implementação do *Bean Validation* (`@NotBlank`, `@CPF`).<br>- Criação do `GlobalExceptionHandler` (Erros 400, 404, 409). | Maicon Douglas                         | ✅ Concluído |
| **20/05**<br>*(Quarta-feira)* | **Exposição, Testes e Entrega** | - Criação dos Controllers RESTful e Paginação.<br>- Configuração do motor de Cache nativo.<br>- Geração da documentação interativa (Swagger).<br>- Testes de integração via Postman/Insomnia. | Toda a Equipe                          | ✅ Concluído |

---

## 📌 Observações da Entrega
* **Gestão de Prazos:** Todas as atividades foram executadas e validadas dentro da janela intensiva de 4 dias.
* **Gestão de Configuração:** O versionamento de código foi mantido rigorosamente em repositório público no GitHub, garantindo a integração contínua até o momento da entrega final.