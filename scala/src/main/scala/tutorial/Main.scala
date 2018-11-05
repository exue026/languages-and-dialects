package tutorial

object Main extends App {
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


