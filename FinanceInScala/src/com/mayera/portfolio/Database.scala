package com.mayera.portfolio

abstract class Database extends CompanyCategories {
def allCompanys: List[Company]
def allportfolios: List[Portfolio]
def CompanyNamed(name: String) =
allCompanys.find(f => f.name == name)
}

object SimpleDatabase extends Database
with SimpleCompanys with Simpleportfolios