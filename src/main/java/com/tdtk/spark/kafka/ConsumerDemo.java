//package com.tdtk.spark.kafka;
//
//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.Properties;
//
///******************************************************
// ****** @ClassName   : ConsumerDemo.java 消费者
// ****** @author      : zl ^ ^
// ****** @date        : 2018 11 23 02:30
// ****** @version     : v1.0.x
// *******************************************************/
//public class ConsumerDemo {
//    public static void main(String[] args) throws IOException {
//        Properties props = new Properties();
//        // 老版本
//        //props.put("zookeeper.connect", "localhost:2181");
//        //0.9 以后新版本
//        props.put("bootstrap.servers", KafkaProperties.BROKER_LIST);//"localhost:9092"
//        props.put("group.id",KafkaProperties.TOPIC);
//        // 自动确认设置
//        //0.9 以后新版本
//        props.put("enable.auto.commit", "true");
//       // props.put("enable.auto.commit", "false");
//        props.put("auto.commit.interval.ms", "1000");
//        props.put("session.timeout.ms", "30000"); //30000和不写都正常，改成40000就启动报错
//
//        //老版本
////        props.put("zookeeper.session.timeout.ms", "30000");
////        props.put("zookeeper.sync.time.ms", "200");
////        props.put("auto.commit.interval.ms", "1000");
//
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);
//        Collection<String> topics = Arrays.asList(KafkaProperties.TOPIC);
//        //消费者订阅topic
//        consumer.subscribe((List<String>) topics);
//        ConsumerRecords<String, String> consumerRecords = null;
//        while (true) {
//            //接下来就要从topic中拉取数据
//            consumerRecords = consumer.poll(1000);
//            //遍历每一条记录
//            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
//                long offset = consumerRecord.offset();
//                int partition = consumerRecord.partition();
//                Object key = consumerRecord.key();
//                Object value = consumerRecord.value();
//                System.out.println(offset + " " + partition + " " + key + " " + value);
//            }
//        }
//    }
//
//}
