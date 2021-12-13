Acrescente no seu /etc/hosts (para Windows o caminho é C:\Windows\system32\drivers\etc\hosts):
```
127.0.0.1 localhost kafka
127.0.0.1 host.docker.internal
```

### Para subir os containers dentro do diretorio kafka-poc/docker/kafka
```
docker-compose up -d
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