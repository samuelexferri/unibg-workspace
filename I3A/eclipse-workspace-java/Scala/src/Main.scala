// Main
object Main {

  def main(args: Array[String]): Unit = {
    println("TRY CATCH:")
    try {
      val cerror = new Professionista("Luca", "Lucchetti", -22, "Italia", "Conad")
    } catch {
      case e: IllegalArgumentException => println("Età non valida")
    }

    val c1 = new Amatore("Gino", "Ginetti", 21, "Italia")
    val c2 = new Professionista("Marco", "Marchetti", 32, "Italia", "MercatoneUno")
    var c3 = new Professionista("Francois", "Fran", 25, "Francia", "Carrefour")
    var list1: List[(Ciclista, Double)] = List((c1, 21.35), (c2, 23.42), (c3, 57.32))

    println("\nPROFESSIONISTA SPONSORIZZATO:")
    c2.sponsorizzato

    var gara1 = new Sprint("Salerno Sprint", list1, 1000)

    println("\nPROFESSIONISTI DI GARA 1:")
    gara1.partecipantiProfessionisti()

    var c4 = new Amatore("Luis", "Luisso", 28, "Portogallo")
    var c5 = new Amatore("Frigor", "Friger", 33, "Austria")
    var c6 = new Amatore("Danka", "Danker", 21, "Germania")
    var list2: List[(Ciclista, Double)] = List((c4, 56.32), (c5, 57.12), (c6, 56.24))

    var gara2 = new Resistenza("Genova Resiste", list2, 1001)

    var listgare: List[Gara] = List(gara1, gara2)
    var organizzatore = new Organizzatore(listgare)

    println("\nGARE ORGANIZZATE:")
    organizzatore.print

    var c7 = new Amatore("Federico", "Federichini", 17, "Italia")
    var c8 = new Amatore("Jack", "Jock", 26, "USA")
    var c9 = new Amatore("Kan", "Kane", 33, "Australia")
    var c10 = new Amatore("Ros", "Rosso", 32, "Spagna")
    var c11 = new Amatore("Cic", "Nic", 23, "Croazia")
    var list3: List[(Ciclista, Double)] = List((c7, 47.12), (c8, 48.32), (c9, 46.82), (c10, 47.60), (c11, 47.48))

    var gara3 = new Mista("Milano Mix", list3, 1002)

    println("\nAggiungo una gara")
    organizzatore.insert(gara3)

    println("\nGARE ORGANIZZATE:")
    organizzatore.print()

    println("\nCERCO LA GARA M1002:")
    organizzatore.find("M1002")

    println("\nVINCITORI:")
    organizzatore.vincitoregare
  }
}