#!/bin/bash

echo "Delete debezium connectors"

curl --location --request DELETE 'localhost:8083/connectors/order-payment-connector'
curl --location --request DELETE 'localhost:8083/connectors/order-restaurant-connector'
curl --location --request DELETE 'localhost:8083/connectors/payment-order-connector'
curl --location --request DELETE 'localhost:8083/connectors/restaurant-order-connector'

echo "Shutdown Zookeeper, Kafka cluster, and other services"

# Using a single docker-compose file to shutdown all services
docker-compose down

echo "Sleeping for 5 seconds to ensure all services are down"
sleep 5

echo "Deleting Kafka and Zookeeper volumes"

# Ensure the volumes directory exists and remove it
if [ -d "./volumes/kafka" ]; then
    rm -r ./volumes/kafka/*
fi

if [ -d "./volumes/zookeeper" ]; then
    rm -r ./volumes/zookeeper/*
fi

echo "All services are shut down and volumes deleted"

echo "Shutdown completed"
