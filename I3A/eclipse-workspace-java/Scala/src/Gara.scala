import scala.collection._

// Classe Gara
class Gara(d: String, a: List[(Ciclista, Double)]) {

  // Campi
  val titolo: String = d
  var partecipanti: List[(Ciclista, Double)] = a
  var tipo: String = ""
  var ID: String = ""

  // Stampa lista di ciclisti partecipanti a una gara
  def printPartecipanti() {
    // Funzione ausiliaria
    def stampaPartecipanti(a: (Ciclista, Double)) = {

      println(a._1.toString() + " con " + a._2)
    }

    partecipanti.foreach(stampaPartecipanti) // Per ogni elemento di partecipanti esegue la funzione stampaA
  }

  // Stampa il vincitore di una gara
  def winner() {
    var ttt: Double = 9999
    var nome: String = ""
    var cognome: String = ""

    // Funzione ausiliaria
    def mintempo(a: (Ciclista, Double)) = {
      if (a._2 < ttt) // Aggiorno dati di chi ha impiegato meno tempo
        ttt = a._2
      nome = a._1.nome
      cognome = a._1.cognome
    }

    partecipanti.foreach(mintempo)
    println(nome + " " + cognome + " con un tempo di " + ttt)
  }

  // Stampa tutti i partecipanti professionisti di una gara
  def partecipantiProfessionisti() {
    var ciclistiList: List[Ciclista] = List()

    // Funzione ausiliaria
    def doList(a: (Ciclista, Double)) {
      ciclistiList :::= List(a._1)
    }

    partecipanti.foreach(doList)

    ciclistiList
      .filter(_.isInstanceOf[Professionista])
      .map(_.asInstanceOf[Professionista])
      .map(_.sponsorizzato)
  }
}

// Sottoclasse Sprint estende Gara, eredita costruttore e metodi
class Sprint(d: String, a: List[(Ciclista, Double)], id: Int) extends Gara(d: String, a: List[(Ciclista, Double)]) {
  if (id < 1000 || id > 9999) println("Errore ID")
  else
    this.ID = "S" + id

  this.tipo = "Sprint"
}

// Sottoclasse Resistenza estende Gara, eredita costruttore e metodi
class Resistenza(d: String, a: List[(Ciclista, Double)], id: Int) extends Gara(d: String, a: List[(Ciclista, Double)]) {
  if (id < 1000 || id > 9999) println("Errore ID")
  else
    this.ID = "R" + id

  this.tipo = "Resistenza"
}

// Sottoclasse Mista estende Gara, eredita costruttore e metodi
class Mista(d: String, a: List[(Ciclista, Double)], id: Int) extends Gara(d: String, a: List[(Ciclista, Double)]) {
  if (id < 1000 || id > 9999) println("Errore ID")
  else
    this.ID = "M" + id

  this.tipo = "Mista"
}