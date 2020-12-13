
object lab2 {
  // 7. Объяснить работу.
  class Cat(par: Int) {
    val dangerous = false
    var age = par;

    def increase = {
      age += 1
    }
  }
  class Tiger(par: Int, par1: Boolean) extends Cat(par) {
    override val dangerous = par1
    val colour = "yellow"
  }
  // тигр наследует кошку, переопределяется иницилизация поля dangerous, добавляется поле цвет
  // остальные поля и методы класса кошка полностью включаеются в класс тигр

  var Tig1 = new Tiger(5, true)
  Tig1.increase

  println("7. Объяснить работу.")
  println("возраст тигра: " + Tig1.age)
  // 8. Создать два класса: Person и Student. Определить несколько полей и методов для этих классов,
  // провести с объектами этих классов несколько операций.
  class Person(n: String, a: Int){
    val name: String = n
    var age: Int = a
    def birthday = {
      age += 1
    }
    def this(n: String) = this(n, 0)

    override def toString: String = name + " " + age

  }

  class Student(n: String, a: Int, rb: String, c: Int) extends Person(n, a){
    val recordBook: String = rb
    var course: Int = c
    def increase = {
      course += 1
    }
    def this(n: String, a: Int, rb: String) = this(n, a, rb,  1)

    override def toString: String = super.toString + " " + recordBook + " " + course
  }

  var p1: Person = new Person("Maria", 22)
  var p2: Person = new Person("Mark")
  println("8. Создать два класса: Person и Student. Определить несколько полей и методов для этих классов,провести с объектами этих классов несколько операций.task 8:")
  println(p2.toString)
  p2.birthday
  println(p2.toString)

  var s1: Student = new Student("Peter", 20, "b20713")
  println(s1.toString)
  s1.increase
  s1.birthday
  println(s1.toString)

  // 9. Объекты-спутники. Объяснить работу.
  // в lab1 -- 7

  // 10. Продемонстрировать два альтернативных способа запуска приложения с помощью функции main и трейта App.
  // lab2 -- через main, lab1 -- трейт App.

  // 11. Продемонстрировать, как передать функции фрагмент произвольного исполняемого кода и выполнить его.

  def withCode (x:Int, code: => Unit): Int = {
    for (i <- 0 to 3) {
      code
    }
    x
  }

  // 12. Использовать как базовое объявление функции с 4 параметрами.
  // С помощью каррирования создать на основе базовой несколько других функций.
  def num (a:Int, b:Int, c:Int, d:Int):Int = 1000 * a + 100 * b + 10 * c + d
  def curNum:((Int, Int) => Int) = num(1,_,2,_)

  trait Auto {
    val c:Int
    println ("это исполняемая часть трейта")
    def log:Unit= println("это метод трейта")
  }
  class Rad extends Auto {
    val c=5
    var b=0
  }





  def main(args: Array[String]): Unit = {
    println("11. Продемонстрировать, как передать функции фрагмент произвольного исполняемого кода и выполнить его.")
    println(withCode(10, println("фрагмент произвольного исполняемого кода")))
    println("12. Использовать как базовое объявление функции с 4 параметрами. С помощью каррирования\nсоздать на основе базовой несколько других функций.")
    println(num(4,5,6,7))
    println(curNum(4,5))
    println("13 Трейты. Подмешивание трейтов. Объяснить работу.")
    var user = new Rad
    var cus: Auto = user
    // println (user.с) -- не будет работать, т.к. Auto не имеет поля с
    cus.log // отработает, т.к. произошло подмешивание трейта
    println (cus.c)

  }
}