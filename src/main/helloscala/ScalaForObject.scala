
// 面向对象
// 1、private[helloscala] 包访问权限

// 2、ScalaForObject private 私有构造器
class ScalaForObject {

  val id = "5678"

  var name = "张三"

  // 只能在伴生对象中被访问使用
  private var gender: String = "nan"

  //只能在当前class类中使用
  private[this] var pop:String = _

  def printPop: Unit ={
    println(pop)
  }

  // 只能在伴生对象中被访问使用
  private def testP: Unit ={
    println(pop)
  }
}


// 伴生对象
object ScalaForObject {
  def main(args: Array[String]): Unit = {
    val sc = new ScalaForObject
    println(sc.id + ":" + sc.name)

    // sc.id="2345"

    sc.name = "李四"

    println(sc.id + ":" + sc.name)

    println(sc.gender)
    sc.gender = "男"
    println(sc.gender)


    println(sc.printPop)

    println(sc.testP)
  }
}


