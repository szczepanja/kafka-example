import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

import java.util.Properties

object ConsumerAndProducer extends App {

  val props = new Properties()

  props.put("bootstrap.servers", "localhost:9092")
  props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
  props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")

  val output = "hello".toUpperCase
  val topic = "Consumer-Topic"

  val producer = new KafkaProducer[String, String](props)

  producer.send(new ProducerRecord[String, String](topic, output))
  producer.close()
}
