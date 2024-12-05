package com.kafka.java;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    private static final String topic = "numbers";
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.29.112:9093, 192.168.29.112:9094, 192.168.29.112:9095");
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<>(properties);

        for (int i= 1; i<=100; i++) {
            System.out.println("message produced: " + i);
            producer.send(new ProducerRecord<String, String>(topic, String.valueOf(i), String.valueOf(i)));
        }

        producer.close();
    }
}
