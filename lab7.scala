import java.time._

object lab7 extends App {
  println("Используя неявные параметры-функции определить текущее время.Импортировать необходимые классы.")

  implicit def lTime: ZonedDateTime = {
    ZonedDateTime.now.withZoneSameInstant(ZoneId.of("UTC"))
  }

  def printCurrentTime(implicit lT: ZonedDateTime): Unit =
    println(lT.toString)

  printCurrentTime

  println("2 Указать ограничения на класс параметра self в этом фрагменте:")

  implicit class ReachInt(self: Int) {
    def fib: Int =
      self match { // self -- только Int
        case 0 | 1 => 1
        case i => (i - 1).fib + (i - 2).fib
      }

    // 5 Дополнить функционал целых чисел методом вычисления факториала.
    def fact: Int =
      self match {
        case 0 | 1 => 1
        case n => n * (n - 1).fact
      }

  }

  println(7.fib)

  println("3 Что будет распечатано?") // -- 1

  implicit def d1(x: Int): Int = 10 + x

  def printCur(implicit d: (Int => Int)) = println(d(1))

  printCur

  println("4 Привести пример импортирования неявных параметров.")

  import scala.math._

  def num[T](t: T)(implicit numeric: Numeric[T]): Unit = {
    println(numeric)
  }

  num(1.0)
  num(1)

  println("5 Дополнить функционал целых чисел методом вычисления факториала.")
  println(3.fact)

}
