# Aplicação para consumir e produzir mensagem em uma fila IBM MQ usando JMS


## Passo a passo para criar um container com o IBM MQ

##### 1. Extraia a imagem do hub Docker que contém a versão mais recente do servidor MQ
``` 
docker pull ibmcom/mq:latest
``` 
##### 2. Crie um volume
``` 
docker volume create qm1data
``` 
##### 3. Execute o container do servidor MQ
``` 
docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --volume qm1data:/mnt/mqm --publish 1414:1414 --publish 9443:9443 --detach --env MQ_APP_PASSWORD=passw0rd ibmcom/mq:latest
```
##### 4. URL para acessar o console do IBM MQ 
```
 https://localhost:9443/ibmmq/console/
```  

## Testando a aplicação

- Depois de startar o projeto execute  
  http://localhost:8080/send para enviar a mensagem
  http://localhost:8080/recv para receber a mensagem
  



  
