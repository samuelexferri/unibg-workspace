class Persona {
}

class Studente extends Persona {
}

class Concorso {
	Persona vincitore() {
		return null;
	}
}

class ConcorsoBorsadiStudio extends Concorso {
	// @Override
	// Persona vincitore(){ return null; } // Alternativa
	Studente vincitore() {
		return null;
	}
}

public class Covarianza {

	public static void main(String[] args) {
		Persona p = new Studente();

		Persona[] gente = new Studente[10];
		System.out.println(gente.getClass());

		Studente[] imieimiglioristudenti = { new Studente(), new Studente() };
		gente = imieimiglioristudenti; // Entrambi puntano agli elementi del vettore
		System.out.println(gente[0].getClass());

		System.out.println(gente[0]);
		gente[0] = new Studente(); // Cambio lo studente
		System.out.println(gente[0]);
		System.out.println(imieimiglioristudenti[0]);

		// gente[0] = new Persona(); // Eccezione a runtime (ArrayStoreException)
		gente = new Persona[10]; // Ridefinisco l'array
		gente[0] = new Persona(); // Eccezione (ArrayStoreException)

		Concorso premi = new ConcorsoBorsadiStudio();
		Persona vinc = premi.vincitore();
	}
}
