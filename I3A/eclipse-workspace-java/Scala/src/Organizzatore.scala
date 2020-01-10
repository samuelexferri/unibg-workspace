// Classe Organizzatore
class Organizzatore(lg: List[Gara]) {

  // Campi
  var lista: List[Gara] = lg

  // Inserisci gara
  def insert(g: Gara) = {
    lista :::= List(g) // Inserisce in testa alla lista
  }

  // Stampa gare
  def print() = {
    // Funzione ausiliaria
    def stampa(g: Gara) = {
      println("[" + g.ID + " '" + g.titolo + "' " + g.tipo + "]")
      println("Partecipanti:")
      g.printPartecipanti
    }

    lista.foreach(stampa)
  }

  // Cerca gara tramite identificativo
  def find(chiave: String): Boolean = {
    var trovato: Boolean = false

    // Funzione ausiliaria
    def trova(g: Gara): Boolean = {
      if (g.ID == chiave) {
        trovato = true; println("Evento trovato: " + g.ID + " '" + g.titolo + "' " + g.tipo)
      }
      trovato
    }

    lista.foreach(trova)

    trovato
  }

  // Stampa vincitori
  def vincitoregare() = {
    // Funzione ausiliaria
    def v(g: Gara) = {
      println("Vincitore gara '" + g.titolo + "': ")
      g.winner
    }

    lista.foreach(v)
  }
}