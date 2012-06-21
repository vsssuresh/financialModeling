package com.mayera.portfolio

trait SimpleCompanys {
object Pear extends Company("Pear")
def allCompanys = List(Apple, Pear)
def allCategories = Nil
}