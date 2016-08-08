// Flatten a nested list structure

object P07 {
    def flatten(l: List[Any]): List[Any] = l flatMap {
        case p: List[_] => flatten(p)
        case b => List(b)
    }
}
println(P07.flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
