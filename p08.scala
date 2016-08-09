// Eliminate consecutive duplicates of list elements

object P08 {
    def eliminateDups[A](l:List[A]):List[A] = {
        def aux[A](l:List[A],newL:List[A]):List[A] = newL match {
            case h :: tail => aux(h :: l,tail.dropWhile(_ == h))
            case Nil => l.reverse
        }
        aux(Nil,l)
    }

    def fxDups[A](l:List[A]):List[A] = l.foldRight(List[A]()) { (a,b) =>
        if (b.isEmpty || b.head != a)  a :: b else b
    }
}

println(P08.eliminateDups(List(1,1,2,2,3,3,4,4,4)))
println(P08.fxDups(List(1,1,2,2,3,3,4,4,4,5)))
