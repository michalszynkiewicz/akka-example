// cool things part 1. collection api:
val list = List(1, 2, 3)
val reversed = list.reverse

list.foreach {
  i => print(i + " ")
}
// shorter version:
list.foreach {
  println(_)
}




// map
val r = reversed.map {
  t => List(2 * t)
}
val rfm = r.flatMap {
  i => i
}
