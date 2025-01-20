import scala.annotation.tailrec

@main
def main(): Unit =
   collatz(27)

@tailrec
def collatz(n: Long, i: Int = 0): Unit =
   if n <= 1 then
      println(n)
      println(s"Steps: $i")
   else
      print(s"$n, ")
      n % 2 match
         case 0 => collatz(n / 2, i + 1)
         case _ => collatz(3 * n + 1, i + 1)
