import scala.annotation.tailrec

@main
def main(): Unit =
   val result = for n <- 0 to 200 yield (n, collatz(n).reverse)

   result
      .sortBy(_._2.head.toString.last.toInt)
      .foreach(r => println(s"Step: ${r._2.length - 1} \npath: ${r._2.mkString(",")}\n"))

@tailrec
def collatz(n: Long, acc: List[Long] = Nil): List[Long] =
   if n <= 1 then n :: acc
   else
      n % 2 match
         case 0 => collatz(n / 2, n :: acc)
         case _ => collatz(3 * n + 1, n :: acc)
