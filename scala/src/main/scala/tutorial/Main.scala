package tutorial

object Main {
  def main(args: Array[String]): Unit = {
    // variablesAndExpressions()
    // conditionals()
    // loops()
    // classes()
    // traits()
    // tuples()
    // mixins()
    // higherOrderFunctions()
    // currying()
    caseClasses()
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
    trait Pet {
      val name: String
    }

    class Cat(val name: String) extends Pet
    class Dog(val name: String) extends Pet

    val animalList = List(new Cat("kitty"), new Dog("ebb"), new Dog("flow"))
    for (animal <- animalList) {
      println(animal.name)
    }
  }

  def tuples(): Unit = {
    // Usually, we prefer a case class over a tuple
    // Which one takes up more memory?
    // Tuples are immutable
    val ingredient = ("Sugar", 25)
    println(ingredient)
    println(ingredient._1)
    println(ingredient._2)

    // Destructuring tuple data
    val (name, quantity) = ingredient
    println(name)
    println(quantity)
  }

  def mixins(): Unit = {
    // What?? I thought traits were like ABCs in C++
    // but now we have abstract classes?

    // Mixins ARE traits that are used to compose a class
    abstract class A {
      val message: String
    }

    class B extends A {
      val message = "I'm an instance of class B"
    }

    // Nani
    trait C extends A {
      def loudMessage: String = message.toUpperCase()
    }

    // NANI
    class D extends B with C

    val d = new D
    println(d.message)
    println(d.loudMessage)

    // classes can only have one superclass but many mixins

    // Iterator example
    // Class has an abstract type T
    abstract class AbstractIterator {
      type T
      def hasNext: Boolean
      def next: T
    }

    class StringIterator(s: String) extends AbstractIterator {
      type T = Char
      private var i = 0
      def hasNext: Boolean = i < s.length
      def next: Char = {
        val ch = s charAt i
        i += 1
        ch
      }
    }

    trait RichIterator extends AbstractIterator {
      def foreach(f: T => Unit): Unit = while (hasNext) f(next)
    }

    class RichStringIter extends StringIterator("Scala") with RichIterator

    val richStringIter = new RichStringIter
    richStringIter foreach println
  }

  def higherOrderFunctions(): Unit = {
    // by definition, higher order functions either take in or return other functions
    def apply(f: Int => String, v: Int) = f(v)

    class Decorator(left: String, right: String) {
      def layout[A](x: A): String = left + x.toString() + right
    }

    val decorator = new Decorator("[", "]")
    println(apply(decorator.layout, 7))
  }

  def currying(): Unit = {
    // Methods can take multiple parameter lists
    // A method called with a fewer number of parameters will return a function
    // that takes the missing parameters as arguments
    def filter(xs: List[Int], p: Int => Boolean): List[Int] =
      if (xs.isEmpty) xs
      else if (p(xs.head)) xs.head :: filter(xs.tail, p)
      else filter(xs.tail, p)

    // In JS, this is equivalent to:
    // const modN = (n) => (x) => (x % n) == 0
    def modN(n: Int)(x: Int) = ((x % n) == 0)

    val nums = List(1,2,3,4,5,6,7,8)
    println(filter(nums, modN(2)))
    println(filter(nums, modN(3)))
  }

  def caseClasses(): Unit = {
    // the structs of Scala! Good for modelling immutable data
    // By default, parameters are public vals
    case class Book(isbn: String)
    val frankenstein = Book("12345678")

    // Case classes are compared by value
    case class Message(body: String)
    val myMessage = Message("Hello, world!")
    val hisMessage = Message("Hello, world!")
    println(myMessage == hisMessage)

    // shallow copying with optional changing of arguments
    val originalMessage = Message("Hello, world!")
    val copiedMessaged = originalMessage.copy()
    println(originalMessage)
    println(copiedMessaged)
  }
}

