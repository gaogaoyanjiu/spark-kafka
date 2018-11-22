package com.tdtk.spark.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/******************************************************
 ****** @ClassName   : ProducerDemo.java 生产者
 ****** @author      : zl ^ ^
 ****** @date        : 2018 11 23 02:30
 ****** @version     : v1.0.x
 *******************************************************/
public class ProducerDemo {

    public static void main(String[] args){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", KafkaProperties.BROKER_LIST);//"localhost:9092"
        properties.put("acks", "1"); //all、 0、1、-1
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<String, String>(properties);
            for (int i = 0; i < 10000; i++) {
                String msg = "Message " + i;
                producer.send(new ProducerRecord<String, String>(KafkaProperties.TOPIC, msg));
                System.out.println("Sent:" + msg );
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            producer.close();
        }

    }
}