import java.io.{File, PrintWriter}

import scala.io.Source

object FileScala {

  def main(args: Array[String]): Unit = {


    // [1] 写入文件
    val writer = new PrintWriter(new File("test.txt" ))

    writer.write("这是一个文件写入测试")
    writer.close()


    // [2] 读取文件
    println("文件内容为:" )

    Source.fromFile("test.txt" ).foreach{
      print
    }
  }
}
