# 💻 Sobre o projeto
O objetivo deste estudo é usar o Spring Boot para desenvolver uma API Rest, com algumas funcionalidades. A ideia é desenvolver um CRUD, sendo as quatro operações fundamentais das aplicações: cadastro, listagem, atualização e exclusão de informações.

## 🎯 Objetivos
* Desenvolvimento de uma API Rest
* CRUD (Create, Read, Update e Delete)
* Validações
* Paginação e ordenação

## ⚙️ Funcionalidades

- [ ] Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail.
- [ ] Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários.
- [ ] Lojistas só recebem transferências, não enviam dinheiro para ninguém.
- [ ] Validar se o usuário tem saldo antes da transferência.
- [ ] Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este mock para simular (https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6).
- [ ] A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia.
- [ ] No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este mock para simular o envio (http://o4d9z.mocklab.io/notify).
- [ ] Este serviço deve ser RESTFul.

## ⛔ O que NÃO será implementado

- Fluxo de cadastro de usuários e lojistas
- Frontend (só implementaremos a [API Restful](https://www.devmedia.com.br/rest-tutorial/28912))
- Autenticação

## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- *[Java 17](https://www.oracle.com/java)*
- *[Spring Boot 3](https://spring.io/projects/spring-boot)*
- *[Maven](https://maven.apache.org)*
- *[MySQL](https://www.mysql.com)*
- *[Hibernate](https://hibernate.org)*
- *[Flyway](https://flywaydb.org)*
- *[Lombok](https://projectlombok.org)*
- *[PostgreSQL](https://www.postgresql.org/)*
- *[Insomnia](https://insomnia.rest/)*
- *[Docker](https://www.docker.com/)*


## 📝 Materiais úteis
- https://hub.packtpub.com/why-we-need-design-patterns/
- https://refactoring.guru/
- http://br.phptherightway.com/
- https://www.php-fig.org/psr/psr-12/
- https://www.atlassian.com/continuous-delivery/software-testing/types-of-software-testing
- https://github.com/exakat/php-static-analysis-tools
- https://martinfowler.com/articles/microservices.htm
- https://docs.guzzlephp.org/en/stable/request-options.html
- https://www.devmedia.com.br/rest-tutorial/28912