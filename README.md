# kafka-poc
JAVA 11 and Spring Boot kafka Consumer/Producer

## DOCKER INSTRUCTIONS

Acrescente no seu /etc/hosts (para Windows o caminho é C:\Windows\system32\drivers\etc\hosts):
```
127.0.0.1 localhost kafka
127.0.0.1 host.docker.internal
```

## Build
```
./mvnw clean install
```

## Generate Docker Application Image:
```
docker build -t kafkapoc .
```

## Now start all enviroment:
```
**docker-compose rm (case exists old builds, you need remove)
docker-compose up
```

## Send new transaction to topic

```
curl --location --request POST 'localhost:8080/transactions' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": "1",
    "account_id": "1",
    "credit_card_number": "1234567890000000",
    "credit_card_name": "LUIZ SILVA",
    "amount": 500.60
}'
```

### Para entrar no container do kafka

```
docker exec -it kafka_kafka_1 bash
```

### Para produzir uma mensagem

```
kafka-console-producer --bootstrap-server=localhost:9092 --topic=transactions
```
*Mesmo que o tópico não exista nesse momento ele será criado


### Para consumir uma mensagem

```
kafka-console-consumer --bootstrap-server=localhost:9092 --topic=transactions
```

### Exemplo de mensagem

```
{"id": "1235", "account_id": "1", "credit_card_number": "1111111111111111", "credit_card_name": "LUIZ SILVA", "amount": 400.50}
```