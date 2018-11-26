package com.tdtk.spark

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Spark Streaming处理Socket数据
  *
  * 测试： nc
  *
  *异常：
  * 启动报错：
  * java.io.IOException:
  *      Could not locate executable null\bin\winutils.exe in the Hadoop binaries.
  *
  * 提示的信息是缺少winutils.exe这个文件，至于为什么缺少这个文件，后面文章再分析。
  * 解决方案是https://github.com/srccodes/hadoop-common-2.2.0-bin，下载整个git工程的zip，解压后。
  * 方式一：
  *    配置环境变量增加用户变量HADOOP_HOME，值是下载的zip包解压的目录，然后在系统变量path里增加$HADOOP_HOME\bin 即可。再次运行程序，正常执行。
  *
  * 方式二：
  *   或者在具体应用程序代码中加入
  *   System.setProperty("hadoop.home.dir","D:/hadoop-common-2.2.0-bin-master" )
  *
  *  其中winutils.exe相关文件放在D:/hadoop-common-2.2.0-bin-master/的bin/目录下
  */


object NetworkWordCount {


  def main(args: Array[String]) {

    //日志级别
    LoggerLevels.setStreamingLogLevels()

    System.setProperty("hadoop.home.dir","D:/hadoop-common-2.2.0-bin-master" )
     // 在本地运行Spark Streaming程序时，请勿使用“local”或“local [1]”作为主URL。
     // 在本地运行时，始终使用“local [ n ]”作为主URL，其中n >要运行的接收器数量
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")

    /**
      * 创建StreamingContext需要两个参数：SparkConf和batch interval
      */
    val ssc = new StreamingContext(sparkConf, Seconds(5))

    val lines = ssc.socketTextStream("localhost", 6789)

    val result = lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)

    result.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
