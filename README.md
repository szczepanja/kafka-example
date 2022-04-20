# kafka-streams

How to run this

- zookeeper:

````
    C:\kafka\bin\windows>zookeeper-server-start.bat C:kafka\config\zookeeper.properties
````

- kafka server:

````
    C:\kafka\bin\windows>kafka-server-start.bat C:\kafka\config\server.properties
````

- read message:

 ````
  C:\kafka\bin\windows>kafka-console-consumer.bat --topic New-Topic --from-beginning --bootstrap-server localhost:9092
````