object lab3 extends App {

  println("11 Создать двухмерный и трехмерный массивы и осуществить присваивание\nзначений ряду элементов.")

  var m2 = Array.ofDim[Int](2, 2)
  m2(0) = Array(1, 1)
  m2(1)(1) = 2
  println(m2.flatten.mkString("Array(", ", ", ")"))

  var m3 = Array.ofDim[Int](2, 2, 2)
  m3(0) = Array(Array(1, 1), Array(2, 2))
  m3(1)(1) = Array(3, 3)
  println(m3.flatten.flatten.mkString("Array(", ", ", ")"))

  println("12 Создать массив, состоящий из элементов разных типов.")

  var m = Array('a', "abc", 1)
  println(m.mkString(" "))

  println("13 Пояснить, что делается при выполнении строки")
  var mА = Array(-1, 2, 44, 0)
  // создается массив с заданными значениями и заданной длины

  println("14 Определить, содержит ли многомерный массив ненулевые элементы.")
  var a = Array.ofDim[Int](2, 3, 5)
  a(0)(1)(0) = 2
  println(!a.flatten.flatten.forall(_ == 0))

  println("15 Продемонстрировать на примере, чем отличаются неизменяемые коллекции от изменяемых.")

  var list = List(1, 1)
  var array = Array(1, 1)
  // list(0) = 2 -- ошибка, нельзя присвоить новое значение, т.к. неизменяемая коллекция
  array(0) = 2
  println(array.mkString(" "))

  println("16 Показать на примерах, как работает с коллекциями метод map.")

  array = Array(0, 1, 2, 3)
  println(array.map(_ * 2).mkString("Array(", ", ", ")")) // * 2 выполняется для каждого элемента array

  println("17 Создать отображение Map и провести с ним несколько операций.")
  var map = Map("a" -> "aa", "b" -> "bb")
  map += ("c" -> "cc")
  map -= ("a")
  println(map.toString())

  println("18*. Для произвольного многомерного массива написать процедуру, печатающую все его элементы.")

  def flat[T](array: Array[T]): Unit = {
    for (e <- array) {
      if (!e.isInstanceOf[Array[T]])
        print(e + " ")
      else {
        flat(e.asInstanceOf[Array[T]])
      }
    }
  }
  println(flat(Array(1, Array(Array(2, 2), 3), Array("a", "b"))))

  println("19*. Создать метод сортировки любых индексированных коллекций и убедиться в правильности его работы.")

  def sort[T <% Ordered[T]](l: Seq[T]): Seq[T] = l.sorted

  var list1 = List("aa", "cc", "bb")
  println(sort(list1))

  var array1 = Array("aa", "cc", "bb")
  println(sort(array1))

}
