/**
 * Author: Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * Date: 3/4/14
 * Time: 11:52 PM
 */

trait Friend {
  def hug() = {
    println("I give you a hug")
  }
}

class Dog {
  def how() {
    println("how")
  }
}

val d = new Dog()
//d.hug() // does not compile
val dogFriend = new Dog() with Friend
dogFriend.hug()


// as in Java - class can implement/extend a trait as well:
class Woman extends Friend {
  def yellWithoutReason() = {
    println("foiajsofia")
  }

  def answer() = {
    println("No")
  }
}

val w = new Woman()
w.hug()


w.answer()




