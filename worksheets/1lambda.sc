//using lambda to sort:
val input: List[Int] = List(2, 3, 1, 45, 3, 1, 4)
// decreasing
val l11 = input.sortWith {
  (a, b) => a > b
}
val l12 = input.sortWith(_ > _) // shorter version
// increasing
val l2 = input.sortWith(_ < _)
def generate(contentGenerator: () => String) = {
  s"<html>${contentGenerator()}</html>"
}

val firstPage = generate {
  () => "<h1>this is the first page</h1>"
}
val secondPage = generate {
  () => "<h1>this is the second page</h1>"
}