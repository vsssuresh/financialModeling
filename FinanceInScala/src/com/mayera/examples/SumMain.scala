package com.mayera.examples

object SumMain {
  def main(args: Array[String]) {
    try {
      val elems = args map Integer.parseInt
      val evenElems = elems filter (_ % 2 == 0)
      elems foreach println
      evenElems foreach println
      //println("The sum of my arguments is: " + elems.foldLeft(0) (_ + _))
      println("The sum of my arguments is: " + (0 /: elems)(_ + _))
    } catch {
      case e: NumberFormatException =>
        println("Usage: scala SumMain <n1> <n2> ... ")
    }
  }
}