/**
 * Main differences:
 * 1. In many cases Scala is able to figure out the type, so you don't have to repeat the type of var/param everywhere
 * 2. you don't need semi-colons at the end of the line (only if you have multiple statements in one line)
 * 3. you don't need "return" word to return sth from a function
 * 4. lambdas
 * 5. you can use imports where you need it (not only on top of the class)
 */

// defining constants:
val a = 2

// defining functions:
def foo(param1: String): Unit = {
  // equiv. to Java void foo(String param1) {}
  println(param1)
}
// equivalent definition without specifying return type
def foo2(param1: String) {
  // equiv. to Java void foo(String param1) {}
  println(param1)
}
// calling functions:
foo("some text")

foo2(s"some text with var: $a")

// function returning a value
def multiply(a: Int, b: Int): Int = {
  a * b // return keyword is not needed
}
// type declaration is needed if you write a recursive function
def sumUpTo(n: Int): Int = {
  if (n == 0) 0 else n + sumUpTo(n - 1)
}


// Exercises

//println(sumUpTo(6))
// exercise 1. write a fibonacci function (a0 = 1, a1 = 1, a_{n+1} = a_n + a_{n-1}
def fib(n: Int): Int = {
  def fibRec(cnt: Int, prev: Int, prevPrev: Int): Int = {
    if (cnt == 0) prev else fibRec(cnt - 1, prev + prevPrev, prev)
  }
  fibRec(n, 1, 1)
}
val c = fib(2)


// if you really, really need it, you can also define a variable ;)
var v = 1

// scala guesses it's an int


// CLASSES
class MyClass(val constant: String, var variable: Int) {
  def this(constValue: Int) = this(String.valueOf(constValue), constValue)
}