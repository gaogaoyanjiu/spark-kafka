object ScalaFunction {

  def main(args: Array[String]): Unit = {

//    Scala 中使用 val 语句可以定义函数，def 语句定义方法。

    val arr=1 to 10

    // [1] 方法
    def m(x: Int) = x * 10
//    println(arr.map(m))

    //方法=>函数转换
    val p =print _
    println(p)
    println(m(2))

    // [2] 函数：和方法的最大区别是可以作为参数传入到方法里,方法也可以作为参数传到方法里（内部进行了：方法=>函数转换）
    val f = (x: Int) => x * 10
//    println(arr.map(f))
    println(f(2))




    //初始化一个数组
    val arr5 = Array(1,2,3,4,5,6,7,8)
    //增强for循环
    for(i <- arr5)
      print(i + " ")

    println()

    //好用的until会生成一个Range
    //reverse是将前面生成的Range反转
    for(i <- (0 until arr5.length).reverse)
      print(arr(i) + " ")


  }



}
