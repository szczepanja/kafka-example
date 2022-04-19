import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

import java.util.Properties

object KafkaProducerApp extends App {

  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
  props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")


  (0 to 1000).foreach { n =>
    val message = s"Countdown to: $n"
    val topic = "New-Topic"

    val producer = new KafkaProducer[String, String](props)
    producer.send(new ProducerRecord[String, String](topic, message))
    producer.close()

  }

}
