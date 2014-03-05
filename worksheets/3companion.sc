/**
 * Scala has no static methods. If you want static-like things you have to use "companion objects"
 *
 * A companion object is simply a singleton.
 *
 */

// apply() function in companion object can be use as a short-hand for constructing object
class Foo(val attr1: Int, val attr2: Int) {

}

object Foo {
  def apply(initializer: Int): Foo = {
    new Foo(initializer, initializer * 2)
  }
}

val f = Foo(2)

// object defines a "normal" singleton object. It can extend some class:
class A {
  def doAStuff() {
    println("doing what A does")
  }
}

object ASingleton extends A {}

ASingleton.doAStuff()



//unapply
