object HelloScala {

  def main(args: Array[String]): Unit = {
     //变量 分为 val 、var、lazy val
    //for(i <- 表达式),表达式1 to 10返回一个Range（区间）
    //每次循环将区间中的一个值赋给i
    for (i <- 1 to 10)
      print(i + " ")
    println()

    //for(i <- 数组)
    val arr = Array("a", "b", "c")
    for (i <- arr)
      print(i + " ")
    println()
    //高级for循环
    //每个生成器都可以带一个条件，注意：if前面没有分号
    for (i <- 1 to 3; j <- 1 to 3 if i != j)
      print((10 * i + j) + " ")
    println()

    //for推导式：如果for循环的循环体以yield开始，则该循环会构建出一个集合
    //每次迭代生成集合中的一个值
    val v = for (i <- 1 to 10) yield i * 10
    print(v)
    println()

    val k = 1.to(10).map(_ * 10)
    print(k)
    println()

    // until 用法
    val arr1 = 1.to(6)
    val m = for (i <- 0 until arr1.length) {
      print(i + "==>" + arr1(i) + " ")
    }
    println()

    // for循环遍历字符串
    val n = for (i <- "pwefjpwfpwkf[w") {
      // println(i)
      print(i + ",")
    }
    println()

    //    多重for循环遍历  九九乘法表

    for (x <- 1 to 9; y <- 1 to 9) {
      // y ==9 就换行
      if (y == 9) {
        println(x + "*" + y + "=" + x * y)
      } else
        print(x + "*" + y + "=" + x * y + "\t")
    }

  }


  //第一次调用时求值
//  lazy val p = 9
//  println(p)

}
