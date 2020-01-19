object Currying {
  def addB1(x: Int): Int => Int =
    y => x + y

  def addB2(x: Int): Int => (Int => Int) =
    y => (z => x + y + z)

  def operation(g: Int => Int, f: (Int, Int) => Int): (Int, Int) => Int = {
    def foo(a: Int, n: Int) = g(a) * f(a, n)
    foo
  }

  def contieniN(num: Int, n: Int): Int = if (num.toString().contains(n.toString())) 1 else 0

  def quadrato = operation(x => x * x, contieniN)

  val result = quadrato(15, 1)

  // Oppure

  operation(x => x * x, contieniN)(15, 1)

  def mainXXX(args: Array[String]) {
    println(addB1(10)(20))
    println(addB2(10)(20)(30))
  }
}