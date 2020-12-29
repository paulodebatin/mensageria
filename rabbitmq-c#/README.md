# rabbirmq-c#

Projeto C# (aplicação console, criada a partir: dotnet new console) que demonstra enviar e receber mensagens do RabbitMQ.

### Para testar
Inicie um servidor RabbitMQ. Recomendo um docker.
cd rabbirmq-c#

Enviar: 
dotnet build -p:StartupObject=rabbitmq_c_.Send -t:Rebuild
dotnet run

Consumir:
dotnet build -p:StartupObject=rabbitmq_c_.Consumer -t:Rebuild
dotnet run

### Tecnologias utilizadas:
* C#
* RabbitMQ


