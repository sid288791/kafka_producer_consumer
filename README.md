# Spring Kafka Producer Consumer

### Start Zookeper Server
- > zookeeper-server-start.bat ../../config/zookeeper.properties

### Start kafka server
- > kafka-server-start.bat ../../config/server.properties

### Create a topic

- > Let's create a topic named "test" with a single partition and only one replica:
- >  kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
- > We can now see that topic if we run the list topic command:
- > kafka-topics.bat --list --zookeeper localhost:2181
test

### Send some messages

- > Run the producer and then type a few messages into the console to send to the server.
- > kafka-console-producer.bat --broker-list localhost:9092 --topic test
- > This is a message
- > This is another message

### Start a consumer

- > Kafka also has a command line consumer that will dump out messages to standard output.
- > kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning
- > This is a message
- > This is another message

## Create Kafka Producer

- > Create maven project and add the required dependencies such as spring-boot-starter-web, spring-kafka
- > Create application.properties and add server.port="give any value we are using 8075"
- > Add Rest Controller and autowire KafkaTemplate (bean creation of kafka template is not needed for String return type ) which used for interacting with kafka server
- > Initialize the TOPIC value
- > Now run the application and if want to check your application hit the url http://localhost:8075/kafka/publish/hello, it will return String
- > If you want response in JSON format 
   - > Add Kafka Configuration class and create bean of ProducerFactory, KafkaTemplate.
- > Now run the application and if want to check your application hit the url http://localhost:8075/kafka/publish/hello, it will return JSON
   
## Create Kafka Consumer

- > Create maven project and add the required dependencies such as spring-boot-starter-web, spring-kafka
- > Create application.properties and add server.port="give any value we are using 8076"
- > Create Service class and add KafkaListener
- > Add Kafka Configuration class and create bean of ConsumerFactory, Listner.
- > Now publish the message and you should be able to consume the message.
