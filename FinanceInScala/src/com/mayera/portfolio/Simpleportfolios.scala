package com.mayera.portfolio

trait Simpleportfolios {
this: SimpleCompanys =>
object InternetDadas extends Portfolio(
"internet Dadas",
List(Apple, Tailon), // Now Tailon is in scope
List(50, 50)
)
def allportfolios = List(InternetDadas)
}
