# API-Spring

API de ordem de pedidos (inspirado no IFood) desenvolvida em Minicurso de Java 8 e Spring Booot na UDESC.

## Descrição entidades

#### Order
Representa um pedido na aplicação. Contém uma lista de itens (OrdemItem); um usuário (User) e um restaurant (Restaurant) associados; existe um status (OrderStatusEnum) para representar o status da ordem (aberto, confirmado, em entrega, entregue).

#### OrdemItem
Representa um item escolhido de um pedido. Contém um produto (Product) associado e a quantidade desejada.

#### Product
Representa um produto dentro da aplicação. Possui nome, valor e restaurante (Restaurant) associado.

#### Restaurant
Representa um restaurante cadastrado no sistema. É composto por nome, telefone e email.

#### User
Representa um usuário que ordena um pedido. É composto por nome, telefone, email, senha e endereço.


## Padrões utilizados

* Foi  adotado o modelo em camadadas (Controller, Service, Domain, Repository).
* É utilizado objetos de transferência de dados (DTO) para recebimento e envio de objetos da API.

## Tecnologias utilizadas

* Banco de dados em memória (H2)
* Documentação com Swagger
* ModelMapper para mapeamento de entidades  para DTO.
