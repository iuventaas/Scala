object lab6 extends App {
  println("1 Определить, что получится")
  println(List(0, 1, 0) zip Set(2.0, 3, 4))
  //List((0,2.0), (1,3.0), (0,4.0))

  println("2 Создать объект-итератор и провести с ним несколько операций с помощью соответствующих методов.")

  var iter = Iterator(0, 1, 2, 3)

  println(iter.next())
  println(iter.find(_ == 2))
  println(iter.next())
  println(iter.isEmpty)

  println("3 Разобраться с работой кода")
  println((1 to 10).map(println).take(5).toList)
  //Выводит числа от 1 до 10, println выводит список из 5 пустых кортежей
  println((1 to 10).iterator.map(println).take(5).toList)
  //Выводит числа от 1 до 5, println выводит список из 5 пустых кортежей
  (1 to 10).iterator.map(println)
  //пустой итератор

  println("4 Создать бесконечный итератор и привести примеры работы с ним.")

  var iterator = Iterator.from(0)
  iterator.dropWhile(_ >= Int.MinValue).next
}
