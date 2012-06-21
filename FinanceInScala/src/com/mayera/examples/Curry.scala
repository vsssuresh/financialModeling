package com.mayera.examples

object Curry {
  def add(a: Vector[Int])(b: Vector[Int]): Vector[Int] = a ++ b
  def cube(n: Int): Int = { def sq = n * n; sq * n }
  def div(a: Int, b: Int): Option[Int] =
    if (b == 0)
      None
    else
      Some(a / b)
  def main(args: Array[String]): Unit = {

    println(add(Vector(2))(Vector(3)))
    println(cube(2))
    val x = 1248.74589
    printf("%10.2f", x)
    println()
    div(25, 5) match {
      case Some(x) => println(x)
      case None => println("Problems")
    }
    val a = Array(2, 3)
    a foreach println
    a(0) = 3
    a foreach println
    import scala.math._
    println(sqrt(2))
    pow(2, 4)
    val r = new scala.util.Random
    val rnd = r.nextInt(_: Int)
    for (i <- 1 to 100) print(rnd(100) + "\t")
  }

}