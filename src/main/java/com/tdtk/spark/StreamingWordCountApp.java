package com.tdtk.spark;


import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;

/**
 * java 操作 spark Streaming的API
 */
public class StreamingWordCountApp {


    public static void main(String[] args) throws InterruptedException {
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("StreamingWordCountApp");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));

        // 连接
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("192.168.199.150", 9999);
        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split("\t")).iterator());

        JavaPairDStream<String, Integer> pairs = words.mapToPair(word -> new Tuple2<>(word, 1));
        JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey((x, y) -> x + y);

        // 输出到控制台
        wordCounts.print();
        jssc.start();
        jssc.awaitTermination();
    }

}
