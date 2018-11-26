package com.tdtk.spark

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * 使用Spark Streaming处理文件系统(local/hdfs)的数据
  */
object FileWordCount {

  def main(args: Array[String]): Unit = {

    LoggerLevels.setStreamingLogLevels()
    System.setProperty("hadoop.home.dir","D:/hadoop-common-2.2.0-bin-master" )

    val sparkConf = new SparkConf().setMaster("local").setAppName("FileWordCount")
    val ssc = new StreamingContext(sparkConf, Seconds(1))

    // 本地文件读取 sc.textFile("路径").在路径前面加上file:// 表示从本地文件系统读
    val lines = ssc.textFileStream("file:///D:\\data\\")

    val result = lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
    result.print()

    ssc.start()
    ssc.awaitTermination()


  }

}
