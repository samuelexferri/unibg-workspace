object Neutro {

  def neutroPro(a: Int, n: Int): Boolean = {
    if (a * n == a)
      return true
    else
      return false
  }

  def neutro(f: (Int, Int) => Boolean): (Int, Int) => Boolean = {
    def inner(a: Int, n: Int): Boolean = f(a, n) // Funzione
    inner
  }

  def neutroPro2(a: Int, n: Int): Boolean = neutro(neutroPro)(a, n)

  def neutroSomma(a: Int, b: Int): Boolean = neutro((a, b) => if (a + b == a) true else false)(a, b)

  def main(args: Array[String]) {
    println(neutroPro(10, 1))
    println(neutroPro(10, 2))
    println(neutroPro(0, 10))

    println

    println(neutroPro2(10, 1))
    println(neutroPro2(10, 2))
    println(neutroPro2(0, 10))

    println

    println(neutroSomma(10, 1))
    println(neutroSomma(10, 2))
    println(neutroSomma(10, 0))
  }
}