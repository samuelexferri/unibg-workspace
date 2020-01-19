object C7 {

  def contieni7(a: Int): Int = {
    var x = a.toString()

    if (x.contains("7")) 1
    else 0
  }

  def countC7For(a: Int, b: Int): Int = {
    var list = List.range(a, b)
    var count = 0

    for (i <- list)
      if (contieni7(i) == 1)
        count += 1

    return count
  }

  def countC7Foreach(a: Int, b: Int): Int = {
    var list = List.range(a, b)
    var count = 0

    list.foreach(count += contieni7(_))

    return count
  }

  def countC7Ric(a: Int, b: Int): Int = {
    var list = List.range(a, b)

    if (list.isEmpty)
      return 0;

    if (contieni7(list.head) == 1)
      return 1 + countC7Ric(a + 1, b)
    else
      return countC7Ric(a + 1, b)
  }

  def countC7Map(a: Int, b: Int): Int = {
    var list = List.range(a, b)

    return list.map(contieni7(_)).sum
  }

  def countC7Foldleft(a: Int, b: Int): Int = {
    var list = List.range(a, b)

    return list.foldLeft(0)((x, y) => x + contieni7(y))
  }

  def countC7Filter(a: Int, b: Int): Int = {
    var list = List.range(a, b)

    return list.filter(contieni7(_) == 1).size
  }

  def contieniN(a: Int, n: Int): Int = {
    var x = a.toString()

    if (x.contains(n.toString())) 1
    else 0
  }

  def countC7(f: (Int, Int) => Int): (Int, Int, Int) => Int = {
    def inner(a: Int, b: Int, n: Int): Int = {
      var list = List.range(a, b)

      return list.filter(f(_, n) == 1).size
    }
    inner
  }

  def main(args: Array[String]) {
    println(contieni7(878))

    println

    println(countC7For(0, 30))
    println(countC7Foreach(0, 30))
    println(countC7Ric(0, 30))

    println

    println(countC7Map(0, 30))
    println(countC7Foldleft(0, 30))
    println(countC7Filter(0, 30))

    println

    println(countC7(contieniN)(0, 30, 7))
  }
}