package com.mayera.examples

object patterns {
/** We need an abstract base class for trees. Subclasses with 
   *  the 'case' modifier can be used in pattern matching expressions 
   *  to deconstruct trees. 
   */
  abstract class Tree
  case class Branch(left: Tree, right: Tree) extends Tree
  case class Leaf(x: Int) extends Tree

  /** Case classes have an implicit constructor methods which allows 
   *  to create objects without the 'new' keyword. It saves some typing 
   *  and makes code clearer. 
   */
  val tree1 = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))

  /** Return the sum of numbers found in leaves. 
   *  'match' is a generalization of 'switch' in C-like languages 
   * 
   *  Patterns consist of case class constructors (which can 
   *  be nested), and lower case variables which are 
   *  bound to the values with which the class has been constructed. 
   */
  def sumLeaves(t: Tree): Int = t match {
    case Branch(l, r) => sumLeaves(l) + sumLeaves(r)
    case Leaf(x) => x
  }

  /** This illustrates the use of Option types. Since the 
   *  method is not known in advance to find 'x', the 
   *  return type is an Option. Options have two possible 
   *  values, either 'Some' or 'None'. It is a type-safe 
   *  way around 'null' values. 
   */
  def find[A, B](it: Iterator[(A, B)], x: A): Option[B] = {
    var result: Option[B] = None
    while (it.hasNext && result == None) {
      val Pair(x1, y) = it.next
      if (x == x1) result = Some(y)
    }
    result
  }

  def printFinds[A](xs: List[(A, String)], x: A) =
    find(xs.elements, x) match {
      case Some(y) => println(y)
      case None => println("no match")
    }

  def main(args: Array[String]) {
    println("sum of leafs=" + sumLeaves(tree1))
    printFinds(List((3, "three"), (4, "four")), 4)
  }
}