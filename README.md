# inventory-app

Before starting the app, startup postgres db and kafka by running:
docker-compose up

Build and run the application using the following commands:
mvn clean package
java -jar target/inventory-app-1.0.0-SNAPSHOT.jar

Once the application is started, you can populate the DB with initial data by running:
curl -X GET "http://localhost:7070/inventory/api/setup-db"

You can test order and product decrement by running:
curl -X POST "http://localhost:7070/inventory/api/order/add" -H "accept: */*" -H "Content-Type: application/json" -d "{\"listOfOrderedItems\":[{\"productId\":1,\"quantity\":1,\"soldPrice\":2300000},{\"productId\":3,\"quantity\":7,\"soldPrice\":200000}],\"processingAdminId\":1,\"customer\":{\"names\":\"Frodo Baggins\",\"phoneNo\":\"08012345678\"}}"

You can also find other useful endpoint using the swagger doc:
http://localhost:7070/inventory/api/swagger-ui/index.html?configUrl=/inventory/api/v3/api-docs/swagger-config

