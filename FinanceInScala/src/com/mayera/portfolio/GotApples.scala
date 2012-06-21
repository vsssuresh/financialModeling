package com.mayera.portfolio

object GotApples {
  def main(args: Array[String]) {
    val db: Database =
      if (args(0) == "student")
        StudentDatabase
      else
        SimpleDatabase

    object browser extends Browser {
      val database: db.type = db
    }
    val apple = SimpleDatabase.CompanyNamed("Apple").get
    for (
      portfolio <- browser.portfoliosUsing(apple)
    ) println(portfolio)
  }
}