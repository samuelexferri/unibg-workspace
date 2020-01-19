object ContaPari {

  def pari(n: Int): Int = {
    if (n % 2 == 0)
      return 1
    else
      return 0
  }

  def pariB(n: Int): Boolean = {
    if (n % 2 == 0)
      return true
    else
      return false
  }

  def contaPariFor(list: List[Int]): Int = {
    var somma = 0

    for (i <- list)
      somma += pari(i)

    return somma
  }

  def contaPariForeach(list: List[Int]): Int = {
    var somma = 0

    list.foreach(somma += pari(_))

    return somma
  }

  def contaPariRic(list: List[Int]): Int = {
    if (list.isEmpty)
      return 0

    return pari(list.head) + contaPariRic(list.tail) // Tail si riferisce a tutto il resto
  }

  def contaPariFold(list: List[Int]): Int = list.foldLeft(0)((x, y) => x + pari(y))

  def contaPariFilter(list: List[Int]): Int = list.filter(pari(_) == 1).size

  def contaP(p: (Int => Boolean)): List[Int] => Int = {
    def inner(list: List[Int]): Int = {
      list.filter(p).map(_ => 1).sum
    }
    inner // Chiamo la funzione interna
  }

  def contaPari2(lista: List[Int]): Int = {
    contaP((a: Int) => a % 2 == 0)(lista)
  }

  def main(args: Array[String]) {
    var lista = List(2, 3, 4, 5, 6)

    println(contaPariFor(lista))
    println(contaPariForeach(lista))
    println(contaPariRic(lista))
    println(contaPariFold(lista))
    println(contaPariFilter(lista))

    println
    
    println(contaP(pariB)(lista))
    println(contaPari2(lista))
  }
}