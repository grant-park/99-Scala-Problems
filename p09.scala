// Pack consecutive duplicates of list elements into sublists
object P09 {
    def organizeLists[A](l:List[A]):List[List[A]] = {
        if (l.isEmpty) List(List())
        else {
            val (packed, next) = l span { _ == l.head }
            if (next == Nil) List(packed) else packed :: organizeLists(next)
        }
    }
}
println(P09.organizeLists(List(1,1,1,2,3,4,4)))
