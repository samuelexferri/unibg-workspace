object SumGreaterThan0 {

  def isPos(n: Int): Int = if (n > 0) n else 0

  def isPosBoolean(n: Int): Boolean = if (n > 0) true else false

  def sumGreaterThan0For(list: List[Int]): Int = {
    var sum = 0
    for (i <- list) {
      sum += isPos(i)
    }
    sum
  }

  def sumGreaterThan0Foreach(list: List[Int]): Int = {
    var sum = 0
    list.foreach(sum += isPos(_))
    sum
  }

  def sumGreaterThan0Ric(list: List[Int]): Int = {
    if (list.isEmpty)
      return 0

    if (list.head > 0)
      list.head + sumGreaterThan0Ric(list.tail)
    else
      sumGreaterThan0Ric(list.tail)
  }

  def sumGreaterThan0RicTail(list: List[Int], sum: Int): Int = {
    if (list.isEmpty)
      return sum

    if (list.head > 0)
      sumGreaterThan0RicTail(list.tail, sum + list.head)
    else
      sumGreaterThan0RicTail(list.tail, sum)
  }

  def sumGreaterThan0RicTailInit(list: List[Int]): Int = {
    sumGreaterThan0RicTail(list, 0)
  }

  def sumGreaterThan0Filter(list: List[Int]): Int = list.filter(isPos(_) > 0).sum

  def sumGreaterThan0Foldleft(list: List[Int]): Int = list.foldLeft(0)((x, y) => x + isPos(y))

  def sumGreaterThan0Map(list: List[Int]): Int = list.map(num => if (num > 0) num else 0).sum

  def sumGreaterThan0HOF(f: (Int => Boolean)): List[Int] => Int = {
    def inner(list: List[Int]): Int = {
      list.filter(f(_)).sum
    }
    inner
  }

  def countPosElem(list: List[Int]): Int = {
    list.filter(x => x > 0).map(x => 1).sum
  }

  def main(args: Array[String]) {
    var lista = List.range(-5, 5)

    println(lista)

    println(sumGreaterThan0For(lista))
    println(sumGreaterThan0Foreach(lista))
    println(sumGreaterThan0Ric(lista))
    println(sumGreaterThan0RicTailInit(lista))

    println

    println(sumGreaterThan0Filter(lista))
    println(sumGreaterThan0Foldleft(lista))
    println(sumGreaterThan0Map(lista))

    println

    println(sumGreaterThan0HOF(isPosBoolean)(lista))
    println(countPosElem(lista))
  }
}