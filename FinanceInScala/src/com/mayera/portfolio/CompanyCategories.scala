package com.mayera.portfolio

trait CompanyCategories {
case class CompanyCategory(name: String, Companys: List[Company])
def allCategories: List[CompanyCategory]
}