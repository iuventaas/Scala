package packA {

  import packC._

  class C1(x: Int) {
    val num = x
  }

  package packC {

    class C2(x: Int) extends C1(x) {
      val newNum = n
    }

  }

  package object packC {
    val n = 100;

  }

}

package packB {


  import packA._
  import packA.packC._



  object Start extends App {

    val c1 = new C1(1)
    val c2 = new packC.C2(2)
    println("1. Создать два независимых пакета А и B, в пакет А вложить пакет С.")
    println(c2.newNum)
    println(c2.num)

    class GenCell[T](init: T)
    {
      private var value: T = init;
      def get: T = value;
      def set(x: T) : Unit = { value = x }
    }
    def swap[T](x: GenCell[T], y: GenCell[T]) : Unit =
    {
      val t = x.get;
      x.set(y.get);
      y.set(t)
    }
    val x = new GenCell[Int](1);
    val y = new GenCell[Int](2);
    swap[Int](x, y)

    println("2. Объяснить работу кода.")
    println(x.get, y.get)

    val x2 = new GenCell[Char]('a');
    val y2 = new GenCell[Char]('b');
    swap[Char](x2, y2)
    println(x2.get, y2.get)

    println("Параметризированные класс и функция позволяют выполнять действие для любых типов данных.")

  }

}

