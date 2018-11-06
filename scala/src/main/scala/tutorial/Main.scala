package tutorial

object Main {
  def main(args: Array[String]): Unit = {
    //variablesAndExpressions()
    //conditionals()
    //loops()
    //classes()
    traits()
    // generics()
    // operator overloading()
    // concurrency()
  }

  def variablesAndExpressions(): Unit = {
    // This is a single line comment
    /* This is a multi-line comment
    *  The primitive data types in the language that we care about are:
    *  Boolean
    *  Char
    *  Int
    *  Double
    * */

    // Variables
    /// This is a constant
    val constantInt: Int = 3
    println(constantInt)

    // Example of type inference
    val constantIntInferred = 1
    println(constantIntInferred)

    // This is a mutable value
    var mutableInt = 0
    mutableInt += 3
    println(mutableInt)

    // Blocks: allows expressions to be combined together
    // The result of the last expression is the result of the block
    println({
      val x = 1 + 2
      x * 3
    })
  }

  def conditionals(): Unit = {
    // Conditionals
    val age = 18
    // Example of string literal; canVote is of type String
    val canVote = if (age >= 18)  "yes" else "no"
    println(canVote)

    // Generic if statement
    if (age >= 5 && age <= 7) {
      println("Go to kindergarten")
    } else if (age > 6 && age <= 7) {
      println("Got to grade 1")
    } else {
      println("Go to grade 2 and above")
    }
  }

  def loops(): Unit = {
    // while loop
    var i = 0
    while (i < 10) {
      println(i)
      i += 1
    }

    // do while loop
    do {
      println(i)
      i -= 1
    } while (i >= 0)

    for (i <- 1 to 10) {
      println(i)
    }

    val randomLetters = "ABCDEFGHIJKLKMNOPQRSTUVWXYZ"
    for (i <- 0 until randomLetters.length) {
      // Strings are indexed using round brackets
      print(randomLetters(i))
    }
    println()

    val aList = List(1,2,3,4,5)
    for (num <- aList) {
      // String concatenated
      println("List item: " + num)
    }

    val myAge = 20
    // String templating
    println(s"Ethan's age is ${myAge}")
  }

  def classes(): Unit = {
    // Classes can contain: methods, variables, types, objects, traits, and other classes
    // All together, these items are called members
    class User
    // class User has a default constructor
    val user1 = new User
    println(user1)

    // No default constructor since constructor is defined
    // x and y are public and mutable member variables
    class Point(var x: Int, var y: Int) {
      def move(dx: Int, dy: Int): Unit = {
        x += dx
        y += dy
      }
      override def toString: String = s"($x, $y)"
    }

    val point1 = new Point(2, 3)
    println(point1.x)
    point1.move(0, -4)
    // toString method is invoked
    println(point1)

    class PointWithOptionalParams(var x: Int = 0, var y: Int = 0) {
      // The return type is inferred
      override def toString = s"($x $y)"
    }
    val origin = new PointWithOptionalParams
    val PointOnXAxis = new PointWithOptionalParams(4)
    println(origin)
    println(PointOnXAxis)
    // Example of named parameters
    val PointOnYAxis = new PointWithOptionalParams(y = 3)
    println(PointOnYAxis)

    // Private members and getter/setter syntax
    // Members are public by default so you need the private keyword
    // You need getters and setters
    class PrivatePoint {
      private var x = 0
      private var y = 0

      def getX: Int = x
      def getY: Int = y

      def setX(newVal: Int): Unit = {
        x = newVal
      }

      def setY(newVal: Int): Unit = {
        y = newVal
      }
    }

    // Parameters without val or var are private values
    class PrivatePointShortForm(x: Int, y: Int)
  }

  def traits(): Unit = {
    // Traits in Scala are like ABCs in C++ or Interfaces in Java
    // Classes and objects can extends traits but traits themselves can't be instantiated

    trait mostBasicTrait

    // Sneak preview of generics
    trait Iterator[A] {
      def hasNext: Boolean
      def next(): A
    }

    class IntIterator(to: Int) extends Iterator[Int] {
      private var current = 0
      override def hasNext: Boolean = current < to
      override def next(): Int = {
        if (hasNext) {
          val t = current
          current += 1
          t
        } else 0
      }
    }
    val iterator = new IntIterator(10)
    println(iterator.next())
    println(iterator.next())

    // Polymorphism fully supported

  }
}


