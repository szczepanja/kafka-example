import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}

import java.util.Properties

object Consumer extends App {

  val props = new Properties()

  props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
  props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "test")
  props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
  props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")

  //REMEMBER
  val kafkaConsumer = new KafkaConsumer[String, String](props)

  import scala.jdk.CollectionConverters._

  kafkaConsumer.subscribe(Seq("adform").asJava)

  import java.time.Duration

  while (true) {
    val records = kafkaConsumer.poll(Duration.ofMillis(100)).asScala

    records.foreach { record =>
      println("offset = %d, key = %s, value = %s%n", record.offset, record.key, record.value)
    }
  }
}
