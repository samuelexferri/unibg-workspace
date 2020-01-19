package mylist;

public class Main {
	
	public static void mainXXX(String[] args) {
		MyList<Persona> mylist = new MyList<Persona>();
		mylist.insert(new Persona(10, "Lorenzo"));
		mylist.insert(new Persona(15, "Fabio"));
		mylist.insert(new Persona(5, "Matteo"));

		Persona younger = mylist.younger();
		System.out.println(younger.nome);

		MyList<Studente> students = new MyList<Studente>();
		students.add(new Studente(20, "Sabrina"));
		students.add(new Studente(22, "Martina"));
		students.add(new Studente(19, "Nadine"));

		Studente studente = students.younger();
		System.out.println(studente.nome);
	}
}