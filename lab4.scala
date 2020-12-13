object lab4 extends App {
  println("26 Cформировать список из произвольного списка, удалив первый и последний элементы. Применить оператор сопоставления с образцом match.")

  def flat[T](list: List[T]): List[T] = list match {
    case list: List[T] if list.length <= 2 => List()
    case list: List[T] => list.tail.reverse.tail.reverse
  }

  println(flat(List(List(List(1, 2)), List(3, 4), 5, 6)))

  println("27 Используя оператор сопоставления с образцом match, определить сумму элементов List[Int].")

  def sum(list: List[Int]): Int = {
    list match {
      case x :: tail => x + sum(tail)
      case Nil => 0
    }
  }

  println(sum(List(1, 2, 3)))

  println("28 Определить, содержит ли многомерный массив ненулевые элементы, используя match.")

  def notNul[T](ar: Array[T]): Boolean = {
    var result = false
    for (x <- ar) {
      x match {
        case array: Array[_] => notNul(array)
        case x if x != 0 => result = true
        case _ =>
      }
    }
    result
  }

  println(notNul(Array(0, 0, 1)))

  println("29 Объяснить работу приложения, обратив внимание на процедуры сопоставления с образцом.")

  case class Person(name: String, age: Int)

  class Employee

  case class Engineer(id: Person) extends Employee

  case class Manager(id: Person, subordinates: List[Employee]) extends Employee

  val us = List(Engineer(Person("Maxim", 24)), Engineer(Person("Mark", 55)), Manager(Person("Ivan", 40),
    List(new Employee)), Manager(Person("Vlad", 30), List(new Employee, new Employee)))

  def isManagerOver40(p: Employee): Unit = p match {
    case Manager(Person(_, age), _) if age > 40 => println(true) // если manаger, то проверяем возраст
    case _ => println(false)
  }

  def numOfsub(employee: Employee): Unit =
    employee match {
      case Manager(_, subordinates) => println(subordinates.length) // если manаger, то выводим количество подчиненных
      case _ => println("0") // иначе 0
    }

  us.foreach(numOfsub)
  us.foreach(isManagerOver40)

  println("30 Изменить работу оператора match, используя переменные шаблона Email (user, domain):")

  object EMail {
    def unapply(str: String): Option[(String, String)] = {
      val parts: Array[String] = str.split("@")
      if (parts.length == 2) Some(parts(0), parts(1))
      else None
    }
  }

  var selString: String = "aaa@bbb.ru"
  selString match {
    case EMail(user, domain) => println("адрес: " + user + domain)
    case _ => println("не адрес")
  }

  println("31 Записи журнала логирования (строки) имеют следующую структуру: дата, время, тип" +
    "операции, субъект. Сформировать экстрактор, помогающий извлекать эту информацию.")

  object Log {
    def unapply(str: String): Option[(String, String, String, String)] = {
      val parts: Array[String] = str.split("; ")
      if (parts.length == 4) Some(parts(0), parts(1), parts(2), parts(3))
      else None
    }
  }

  var getLog: String = "12.12.2020; 12:00; add; a1"

  getLog match {
    case Log(date, _, _, _) if date.equals("12.12.2020") => println("лог произошел сегодня")
    case Log(_, _, _, _) => println("лог произошел не сегодня")
    case _ => println("не лог")
  }
}
