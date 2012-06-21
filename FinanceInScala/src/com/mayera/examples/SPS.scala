package com.mayera.examples

object SPS {
  def existsSumPair(a:Array[Int], s: Int) : Boolean = {
  var intSet = Set[Int](0); var i = 0; var b = false
  while (i < a.length && !b) {
  
    if (intSet.contains(s - a(i))) b = true 
        else {
          intSet += a(i);   i += 1; 
        }
    
  }
 b
}
  def main(args: Array[String]): Unit = {
   println(existsSumPair(Array(2,3,4,5), 9)); // false 
  }

}