// Abstract Class Persona
abstract class Persona(val nome: String, val cognome: String, private var _age: Int) {
  if (this._age < 0) throw new IllegalArgumentException

  def age = _age
  def age_=(v: Int): Unit = {
    if (v >= 0) _age = v else throw new IllegalArgumentException
  }

  override def toString: String = { nome + cognome + "(" + age + ")" }
}