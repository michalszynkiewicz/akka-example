// cool things 2. pattern matching
// you can match everything. If you want to match on the attributes of class you need to make it a case class
case class A(a: Int)

val someA = new A(12)
val otherA = new A(32)
def matcher1(a: A) = {
  a match {
    case A(1) => "one"
    case A(32) => "thirtytwo"
    case _ => "unmatched"
  }
}
val m1s = matcher1(someA)
val m1o = matcher1(otherA)
// you can also add a "guard" to case:
def matcher2(a: A) = {
  a match {
    case A(x) if x > 12 => "bigger than 12"
    case _ => "something else"
  }
}
val m2s = matcher2(someA)
val m2o = matcher2(otherA)

// matching with non-case classes:
class B(val p: Int)

/* for non-case classes following doesn't work:
def bMatcher(b : B) = {
  b match {
    case B(1) => "one"
    case _ => "other"
  }
}
*/
// you can do:
def bMatcher(b: B) = {
  b match {
    case x: B if x.p == 1 => "one"
    case _ => "other"
  }
}

bMatcher(new B(1))
bMatcher(new B(32))
// matching on lists:







