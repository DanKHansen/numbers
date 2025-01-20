import scala.annotation.tailrec

@main
def main(): Unit =
   val res = collatz(5923).reverse
   println(res)
   println(s"Steps: ${res.length - 1}")
   println

@tailrec
def collatz(n: Long, acc: List[Long] = Nil): List[Long] =
   if n <= 1 then n :: acc
   else
      n % 2 match
         case 0 => collatz(n / 2, n :: acc)
         case _ => collatz(3 * n + 1, n :: acc)
