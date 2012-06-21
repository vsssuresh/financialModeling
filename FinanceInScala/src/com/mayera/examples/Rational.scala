package com.mayera.examples

class Rational(n: Int, d: Int) {
require(d != 0)
override def toString = n +"/"+ d
}