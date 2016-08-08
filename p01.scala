// Find the last element of a list.

object P01 {
    //def last(L:List[Any]):Any = L(L.length-1)
    //def last[A](l: List[A]):A = l.last
    def last[A](l: List[A]):A = l match {
        case h :: Nil => h
        case _ :: tail => last(tail)
        case _ => throw new NoSuchElementException
    }
}


println(P01.last(List(1)))
println(P01.last(List(1,2,3)))
println(P01.last(List('a','b','c')))
//println(P01.last(List()))

