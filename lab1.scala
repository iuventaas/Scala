import scala.collection.mutable._

object lab1 extends App {
  // 1. Определение переменных с атрибутами val и var
  val testVal = 1
  var testVar = 2
  // testVal = 6
  // нельзя присвоить val новое значение
  testVar = 0

  // 2. Определение функций
  // тип Unit является аналогом void в Java, с его помощью реализуются процедуры

  // 3. Вычисление суммы всех целых в интервале a..b
  def sum(a: Int, b: Int): Int = {
    var result = 0
    for (i <- a to b) result += i
    result
  }

  println("3. Вычисление суммы всех целых в интервале a..b")
  println(sum(5, 2))
  println(sum(2, 5))

  def sum2(a: Int, b: Int): Int =
    if (a > b) 0 else a + sum2(a + 1, b)

  println(sum2(5, 2))
  println(sum2(2, 5))

  // 4. Определение функций высших порядков
  // 4.а Функция-параметр
  def sum3(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum3(f, a + 1, b)

  println("4.а Функция-параметр")
  print("сумма от 1 до 3: ")
  println(sum3(a => a, 1, 3))

  def square(x: Int): Int = x * x
  print("сумма квадратов от 1 до 3: ")
  println(sum3(square, 1, 3))

  // 4.b Возвращение в качестве результата функции
  def mul(j: Int) = (x: Char) => x + j

  println("4.b Возвращение в качестве результата функции")
  // переводит второй аругмент char в int (ASCII) и суммирует 2 int
  println(mul(1)('1'))

  //  5. Моделирование свойств.
  class Rad {
    private val numer: Int = 1
    private var denom: Int = 0

    def num = numer

    private def den = denom

    //  private def den_=(Newv:Int) {if (Newv >=3) denom=Newv}
    // не будет работать извне с модификатором private
    def den_=(Newv: Int) {
      if (Newv >= 3) denom = Newv
    }

    def con(): Unit = {
      den = 2;
      println(den)
    }
  }

  println("5. Моделирование свойств.")
  var user = new Rad
  println(user.num)
  user.con
  user.den_=(5)
  user.con


  //  6. Конструкторы.
  class Rational(n: Int, d: Int) {
    val numer: Int = n
    val denom: Int = d

    def this(n: Int) = this(n, 1)

  }

  println("6. Конструкторы.")
  var r1 = new Rational(3)
  var r2 = new Rational(3, 5)
  println(r1.denom, r1.numer)
  println(r2.denom, r2.numer)


  //  7. Объекты-спутники.
  class Account(n: Double) {
    var num1 = 1

    def M = num1 + n
  }

  object Account {
    var number = 5
    def apply(Ib: Double) = new Account(Ib)

  }

  println("7. Объекты-спутники.")
  val Acc1 = Account(20.0)
  val Acc3 = new Account(40)
  // объект спутник позволяет создавать объекты класса без ключевого слова new,
  // в спутниках можно реализовать статические поля
  println(Acc1.num1 + " " + Acc1.M + " " + Account.number)

}