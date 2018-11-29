package com.tdtk.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/**
 * 使用java开发sprak应用程序
 */
public class WordCountApp {

public static void main (String[] args){
//    [1] 创建上下文对象

//    SparkContext的初始化需要一个SparkConf对象，SparkConf包含了Spark集群配置的各种参数。
//    初始化后，就可以使用SparkContext对象所包含的各种方法来创建和操作RDD和共享变量。
//    SparkConf conf = new SparkConf().setMaster("master").setAppName("appName");
//    SparkContext sc = new SparkContext(conf);

//    SparkSession是Spark 2.0引入的新概念。SparkSession为用户提供了统一的切入点，来让用户学习spark的各项功能。
//    随着DataSet和DataFrame的API逐渐成为标准的API，就需要为他们建立接入点。所以在spark2.0中，引入SparkSession作为DataSet和DataFrame API的切入点，SparkSession封装了SparkConf、SparkContext和SQLContext。
//    在每一个JVM中只能有一个SparkContext，但是在一个Spark程序中可以有多个SparkSession。
    SparkSession spark = SparkSession.builder()
            .master("local[2]")
            .appName("WordCountApp")
            .getOrCreate();

    //JavaSparkContext sc = new JavaSparkContext(spark.sparkContext());
    //处理业务逻辑
    Dataset<String> textFile = spark.read().textFile("D:/hello.txt");
    JavaRDD<String> lines = textFile.javaRDD();

    JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split("\t")).iterator());

    JavaPairRDD<String, Integer> reduce = words.mapToPair(word -> new Tuple2<String, Integer>(word, 1))
            .reduceByKey((x, y) -> x + y);

    List<Tuple2<String, Integer>> list = reduce.collect();

    for (Tuple2<String, Integer> tuple:list) {
        System.out.println(tuple._1 +" : "+tuple._2);
    }


//    Dataset<Row> df = spark.read().json("examples/src/main/resources/people.json");



    spark.stop();
}
}
