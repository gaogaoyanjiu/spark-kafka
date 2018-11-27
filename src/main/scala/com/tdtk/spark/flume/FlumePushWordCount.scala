package com.tdtk.spark.flume

import org.apache.spark.SparkConf
import org.apache.spark.streaming.flume.FlumeUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Spark Streaming整合Flume的第一种方式
  */
object FlumePushWordCount {

  def main(args: Array[String]): Unit = {

    //System.setProperty("hadoop.home.dir","D:/hadoop-common-2.2.0-bin-master" )

//    if(args.length != 2) {
//      //提示
//      System.err.println("Usage: FlumePushWordCount <hostname> <port>")
//      System.exit(1)
//    }

    val Array(hostname, port) = args

    //部署时注释掉本地启动
    val sparkConf = new SparkConf()//.setMaster("local[2]").setAppName("FlumePushWordCount")
    val ssc = new StreamingContext(sparkConf, Seconds(5))

    //TODO... 如何使用SparkStreaming整合Flume
    val flumeStream = FlumeUtils.createStream(ssc, "hadoop000", 41414)
//    val flumeStream = FlumeUtils.createStream(ssc, hostname, port.toInt)

    flumeStream.map(x=> new String(x.event.getBody.array()).trim)
      .flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).print()

    ssc.start()
    ssc.awaitTermination()
  }
}
