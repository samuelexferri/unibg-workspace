// Ho fatto la somma invece del prodotto!
object Stringhe {
  def inizia(s: String): Boolean = {
    if (s.startsWith("a"))
      return true
    else
      return false
  }

  // For
  def pls1(list: List[String]): Int = {
    var count = 0

    for (i <- list) {
      if (inizia(i))
        count += i.size
    }

    return count
  }

  // Foreach
  def pls2(list: List[String]): Int = {
    var somma = 0

    list.foreach(s => if (s.startsWith("a")) (somma += s.size))

    return somma
  }

  // Ric
  def pls3(list: List[String]): Int = {
    if (list.isEmpty)
      return 0;

    if (list.head.startsWith("a"))
      return list.head.size + pls3(list.tail)

    return pls3(list.tail);
  }

  // Foldleft
  def pls4(list: List[String]): Int = list.foldLeft(0)((x, y) => if (y.startsWith("a")) (x + y.size) else x)

  // Filter
  def pls5(list: List[String]): Int = {
    def loop(list: List[String]): Int = {
      if (list.isEmpty) 0
      else list.head.length + loop(list.tail)
    }

    loop(list.filter(_.startsWith("a")))
  }

  // Map
  def pls6(list: List[String]): Int = list.filter(_.startsWith("a")).map(_.size).sum

  def stp(f: (String => Boolean)): List[String] => Int = {
    def inner(l: List[String]): Int = l.filter(f).map(_.size).sum
    inner
  }

  def main(args: Array[String]) {
    val list = List("gino", "asino", "comodino", "aiuola")

    println(pls1(list))
    println(pls2(list))
    println(pls3(list))
    println(pls4(list))
    println(pls5(list))
    println(pls6(list))

    println

    println(stp(_.startsWith("a"))(list))
  }
}