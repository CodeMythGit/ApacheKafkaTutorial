# Step to Start Kafka and Zookeeper (CodeMyth Youtube Channel)

Open command promt by going to kafka directory

## Start Zookeeper
bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

## Start Kafka Server
bin\windows\kafka-server-start.bat .\config\server.properties

## Create Topic
bin\windows\kafka-topics.bat --create --topic **mytopicname** --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

## List the topic
bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
