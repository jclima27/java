# Aplicação Crud usando Spring boot persistindo dados em um banco MySQL em um container Docker

## Criando um container com MySQL

```
docker run -p 6033:3306 --name=docker-mysql env=MYSQL_ROOT_PASSWORD=root env=MYSQL_PASSWORD=root env=MYSQL_DATABASE=mydatabase mysql
```
O comando acima executa as seguintes funções
- Ininia um container com uma imagem mysql com o nome de docker-mysql 
- adiciona usuario e senha como root
- cria um banco de dados com o nome de mydatabase na porta 6033

## Testando a aplicação

Para testar aplicação eu adicionei uma coleção para ser inportada no Postman 


