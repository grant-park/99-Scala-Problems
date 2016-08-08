// Find the second to last element of a list.

object P02 {
   //def penultimate[A](l:List[A]):A = l match {
   //    case h :: _ :: Nil => h
   //    case _ :: tail => penultimate(tail)
   //    case _ => throw new NoSuchElementException
   //}

    def penultimate[A](l:List[A]):A = 
        if (l.isEmpty) throw new NoSuchElementException else l.init.last
    
   //def lastNth[A](n:Int,l:List[A]):A = {
   //    if (n <= 0) throw new IllegalArgumentException
   //    if (l.length < n) throw new NoSuchElementException
   //    l.takeRight(n).head
   //}

    //def getNth[A](n:Int,l:List[A]):A = {
    //    if (n <= 0) throw new IllegalArgumentException
    //    if (l.length < n) throw new NoSuchElementException
    //    def aux[A](auxl:List[A],counter:Int):A =
    //        if (counter == 0) return auxl.head else 
    //            auxl match {
    //                case _ :: tail => aux(tail,counter-1)
    //                case _ => throw new NoSuchElementException
    //            }
    //    aux(l,n-1)
    //}

    def getNth[A](n:Int, l:List[A]):A = (n, l) match {
        case (0, h :: _) => h
        case (n, _ :: tail) => getNth(n-1,tail)
        case (_,Nil) => throw new NoSuchElementException
    }

    def getLastNth[A](n:Int,l:List[A]):A = {
        if (n <= 0) throw new IllegalArgumentException
        if (l.length < n) throw new NoSuchElementException
        getNth(l.length-n,l)
    }

}
println(P02.penultimate(List(1,2,3)))
println(P02.getNth(2,List(1,2,3)))
println(P02.getLastNth(2,List(1,2,3)))
