package com.mayera.portfolio

abstract class Browser {
  val database: Database
  def portfoliosUsing(company: Company) =
    database.allportfolios.filter(portfolio =>
      portfolio.composition.contains(company))
  def displayCategory(category: database.CompanyCategory) {
    println(category)
  }
}