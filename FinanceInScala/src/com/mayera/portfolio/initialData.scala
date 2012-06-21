package com.mayera.portfolio
object Apple extends Company("Apple")
object Google extends Company("Google")
object Facebook extends Company("Facebook")
object Tailon extends Company("Tailon")
object Groupon extends Company("Groupon")
object InternetDadas extends Portfolio(
   "internet Dadas",
   List(Apple, Google, Facebook, Groupon),
   List(25,25,25,25))
object InternetDuds extends Portfolio(
   "internet Duds",
   List( Facebook, Groupon),
   List(25,25))




object Test extends App{
  val apple = SimpleDatabase.CompanyNamed("Apple").get
  println(apple)
  println(SimpleBrowser.portfoliosUsing(apple))
  
 object SimpleDatabase {
def allCompanys = List(Apple, Google,Facebook,Groupon)

def CompanyNamed(name: String): Option[Company] =
allCompanys.find(_.name == name)
def allPortfolios: List[Portfolio] = List(InternetDadas, InternetDuds)
}
object SimpleBrowser {
def portfoliosUsing(company: Company) =
SimpleDatabase.allPortfolios.filter(portfolio =>
portfolio.composition.contains(company))
  
}}