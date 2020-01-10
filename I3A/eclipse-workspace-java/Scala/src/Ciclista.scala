// Classe Ciclista
class Ciclista(n: String, c: String, age: Int, naz: String) extends Persona(n, c, age) {

  // Campi
  val nazione: String = naz
  var sponsor: String = ""

  // Metodi
  def getName() = this.n
  def getCognome() = this.c
  def getAge() = this.age
  def getNazione() = this.naz

  override def toString(): String = { nome + " " + cognome + " (" + age + ", " + nazione + ")" }
}

// Sottoclasse Amatore estende Ciclista
class Amatore(n: String, c: String, age: Int, naz: String) extends Ciclista(n: String, c: String, age: Int, naz: String) {
}

// Sottoclasse Amatore estende Ciclista con trait Sponsor
class Professionista(n: String, c: String, age: Int, naz: String, s: String = "Nessuno") extends Ciclista(n: String, c: String, age: Int, naz: String) with Sponsor {
  sponsor = s
}