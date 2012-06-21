package com.mayera.portfolio

class Portfolio(
val name: String,
val composition: List[Company],
val proportions: List[Int]

) {
  require(proportions  forall (_ > 0))
  require((0 /: proportions) (_ + _) == 100)
  override def toString = name

}