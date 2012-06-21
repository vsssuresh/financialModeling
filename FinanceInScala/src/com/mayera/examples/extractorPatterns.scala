package com.mayera.examples

object extractorPatterns {
/** We need an abstract base class for trees. Subclasses with 
   *  the 'case' modifier can be used in pattern matching expressions 
   *  to deconstruct trees. 
   * 
   *  Here, we replaced case classes of patterns.scala with objects 
   *  that hide the actual implementation of Branch and Leaf. Note 
   *  that the remaining code does not change. In this way, we 
   *  can change the implementation later without affecting clients, 
   *  which is called representation independence. 
   */
  abstract class Tree

  object Branch {
    /* method to contruct branches @see extractorPatterns.tree1 */
    def apply(left: Tree, right: Tree): Tree = new BranchImpl(left, right)
    /* extractor method referenced in match expressions @see extractorPatterns.sumLeaves */
    def unapply(x:Tree): Option[(Tree,Tree)] = x match {
      case y:BranchImpl => Some(y.left, y.right)
      case _            => None
    }
    private class BranchImpl(val left:Tree, val right:Tree) extends Tree
  }
  
  object Leaf {
    /* method to construct leaves @see tree1 */
    def apply(x:Int): Tree = new LeafImpl(x);
    /* extractor method referenced in match expressions @see extractorPatterns.sumLeaves */
    def unapply(x:Tree): Option[Int] = x match {
      case y:LeafImpl => Some(y.x)
      case _          => None
    }
    private class LeafImpl(val x: Int) extends Tree
  }


  /** Case classes have an implicit constructor methods which allows 
   *  to create objects withouth the 'new' keyword. It saves some typing 
   *  and makes code clearer. 
   * 
   *  Here, the task of the case class constructor is performed by the 
   *  method Branch.apply - the singleton Branch is treated as if it 
   *  were a function value. This trick works with any value that has 
   *  an apply method. 
   */
  val tree1 = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))

  /** Return the sum of numbers found in leaves. 
   *  'match' is a generalization of 'switch' in C-like languages 
   * 
   *  Patterns consist of case class constructors (which can 
   *  be nested), and lower case variables which are 
   *  bound to the values with which the class has been constructed. 
   * 
   *  For extractors, it is not the name of a case class, but the name of 
   *  the singleton object Branch which is used to refer to its extractor method 
   *  Branch.unapply - the pattern is the 'reverse' of a method 
   *  call, with the result being matched in the subpatterns. This works 
   *  for any value that has an appropriate extractor method. 
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
  def find[A, B](it: Iterator[Pair[A, B]], x: A): Option[B] = {
    var result: Option[B] = None
    while (it.hasNext && result == None) {
      val Pair(x1, y) = it.next;
      if (x == x1) result = Some(y)
    }
    result
  }

  def printFinds[A](xs: List[Pair[A, String]], x: A) =
    find(xs.elements, x) match {
      case Some(y) => println(y)
      case None => println("no match")
    }

  def main(args: Array[String]) {
    println("sum of leafs  =" + sumLeaves(tree1));
    printFinds(List(Pair(3, "three"), Pair(4, "four")), 4)
  }

}