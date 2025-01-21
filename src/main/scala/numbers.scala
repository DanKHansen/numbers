import scala.annotation.tailrec

@main
def main(): Unit =
   val result = for n <- primes.takeWhile(_ <= 2000).toList yield (n, collatz(n).reverse)

   result
      //.filter(_._2.head.toString.endsWith("17"))
      .sortBy(_._2.length-1)
      //.foreach(r => println(s"${r._2}"))
      //.foreach(r => println(s"Step: ${r._2.length - 1}"))
      .foreach(r => println(s"Step: ${r._2.length - 1} \npath: ${r._2.mkString(",")}\n"))

@tailrec
def collatz(n: Long, acc: List[Long] = Nil): List[Long] =
   if n <= 1 then n :: acc
   else
      n % 2 match
         case 0 => collatz(n / 2, n :: acc)
         case _ => collatz(3 * n + 1, n :: acc)

val primes: LazyList[Int] = 2 #:: LazyList.from(3,2).filter(isPrime)
   def isPrime(n: Int): Boolean =
      primes.takeWhile(p => p*p <= n).forall(n % _ != 0)

