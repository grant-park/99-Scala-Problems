import scala.annotation.tailrec

// Find the number of elements in a list
object P04 {
    def easyGetNumberOfElementsInList[A](l:List[A]):Int = l.length
    def getNumberOfElementsInList[A](l:List[A]):Int = {
       @tailrec def aux[A](l:List[A],tot:Int):Int = l match {
            case _ :: tail => aux(tail,tot+1)
            case _ => tot
        }
        aux(l,0)
    }
    def pureMatchGetLength(l:List[_]):Int = l match {
        case Nil => 0
        case _ :: tail => 1 + pureMatchGetLength(tail)
    }
    def pureFx[A](l:List[A]):Int = l.foldLeft(0) { (e,_) => e + 1 }
}

println(P04.getNumberOfElementsInList(List(1,2,3,4)))
println(P04.pureMatchGetLength(List(1,2,3,4)))
println(P04.pureFx(List(1,2,3,4)))
