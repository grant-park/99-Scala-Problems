// Reverse a list

object P05 {
    def reverseList[A](l:List[A]):List[A] = {
        def aux[A](l:List[A],tot:List[A]):List[A] = l match {
            case h :: Nil => h +: tot
            case h :: tail => aux(tail,h+:tot)
            case _ => throw new NoSuchElementException
        }
        aux(l, List())
    }
    def easyReverse[A](l:List[A]):List[A] = l.reverse
    
    // Non-tail soln
    def reverseListNT[A](l:List[A]):List[A] = l match {
        case Nil => Nil
        case h :: tail => reverseListNT(tail) ::: List(h)
    }
    
    // fx 
    def reverseFx[A](l:List[A]):List[A] = l.foldLeft(List[A]()) {
        (e,n) => n :: e
    }

}
println(P05.reverseList(List(1,2,3,4,5)))
println(P05.easyReverse(List(1,2,3,4)))
println(P05.reverseListNT(List(1,2,3)))
println(P05.reverseFx(List(1,2,3,4,5,6,7)))
