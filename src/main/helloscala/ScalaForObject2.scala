import scala.io.Source

// 面向对象  ==>  构造器
//主构造器会执行类定义中的所有语句
class ScalaForObject2 {

  var name = "张三"

  println(name)


  def sayHi: Unit = {
    name = "李四"
    println(name)
  }

  try {
    // 读取文件
    val cont=Source.fromFile("test.txt").mkString
    println(cont)
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {}
  println("finally")
}


// 伴生对象
object ScalaForObject2 {
  def main(args: Array[String]): Unit = {
    val sc = new ScalaForObject2

    sc.sayHi

  }
}


