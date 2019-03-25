val a = Array("leo", 30)
val n = Array(1, 2, 3, 4, 5)
n.sum
n.mkString("--")


val n2 =Array(1, 2, 3, 4)
n++n2
n2.contains(4)

val n3 = for(p <- n2 if p%2 ==0) yield p
