# kafka-poc
JAVA 11 and Spring Boot kafka Consumer

## DOCKER INSTRUCTIONS

*** IMPORTANT: First of all run ```docker-compose up``` -d inside docker/kafka

Build
```
./mvnw clean install
```

Generate Docker Application Image:
```
docker build -t kafkapoc .
```

Now start all enviroment:
```
**docker-compose rm (case exists old builds, you need remove)
docker-compose up
```

Send new transaction to topic

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