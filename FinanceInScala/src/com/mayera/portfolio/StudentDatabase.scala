package com.mayera.portfolio

object StudentDatabase extends Database {
object FrozenCompany extends Company("FrozenCompany")
object HeatItUp extends  Portfolio(
"heat it up",
List(FrozenCompany),
List(100))
def allCompanys = List(FrozenCompany)
def allportfolios = List(HeatItUp)
def allCategories = List(
CompanyCategory("edible", List(FrozenCompany)))
}
object StudentBrowser extends Browser {
val database = StudentDatabase
}