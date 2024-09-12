
# Medal Manager Server

O projeto trata-se de um servidor destinado a uma aplicação de gerenciamento de medalhas das olimpíadas. Com ele é possível listar o ranking de medalhas por país, além de filtrar os esportes nos quais cada país mais recebeu medalhas. Além disso possui um sistema publisher/subscriber que permite os usuários do sistema seguir os países os quais ele tem interesse de acompanhar, de forma com que a cada medalha ganha de um país em específico, todos os seguidores desse país serão notificados por email.

Para isso foi utilizado uma arquitetura de microserviços utilizando API's REST garantindo a modularização do sistema, com o auxílio de um concentrador de rotas para possibilitar um fácil roteamento da API-Gateway. 

Para o envio assíncrono das notificações de usuários foi utilizado um serviço de mensageria através do RabbitMQ.




## Stack utilizada

**Back-end:** JAVA, SpringBoot, JPA

**Autenticação:** JWT, OAuth

**Mensageria:** RabitMQ

