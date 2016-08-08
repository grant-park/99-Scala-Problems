object P03 {
    def getNthEasy[A](n:Int,l:List[A]):A = l(n-1)

    def getNth[A](n:Int, l:List[A]):A = (n, l) match {
        case (0, h :: _) => h
        case (n, _ :: tail) => getNth(n-1,tail)
        case (_,Nil) => throw new NoSuchElementException
    }
}
println(P03.getNth(3,List(1,2,3)))
println(P03.getNthEasy(3,List(1,2,3)))
