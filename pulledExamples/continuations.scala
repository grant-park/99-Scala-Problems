import scala.continuations.cps
import scala.continuations.ControlContext.{shift,reset}

def trampolineK[A,B1<:C,C1<:C,C](body: => B1 @cps[B1,Bounce[C1]]): C =
  trampoline(reset(Done(body)))

case class Label[A](k: Label[A] => Bounce[A])

def label[A]: Label[A] @cps[Bounce[A],Bounce[A]] =
  shift((k: Label[A] => Bounce[A]) => k(Label(k)))

def goto[A](l: Label[A]): Unit @cps[Bounce[A],Bounce[A]] =
  shift((k: Nothing => Bounce[A]) => Call(() => l.k(l)))

trampolineK {
  var sum = 0
  var i = 0
  val beforeLoop = label
  if (i < 10000) {
    println(i)
    sum += i
    i += 1
    goto(beforeLoop)
  
}
  println(sum)

}
