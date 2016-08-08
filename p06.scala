// Find out if a list is a palindrome.

object P06 {
    def isPalindrome[Any](l:List[Any]):Boolean = l match {
        case Nil => true
        case _ :: Nil => true
        case h :: tail => if (h == tail.last) isPalindrome(tail.init) else false
    }
    def easyIsPalindrome[A](l:List[A]):Boolean = l == l.reverse
}

println(P06.isPalindrome(List(1,5,3,3,5,1)))
println(P06.easyIsPalindrome(List(1,2,3,3,1)))
