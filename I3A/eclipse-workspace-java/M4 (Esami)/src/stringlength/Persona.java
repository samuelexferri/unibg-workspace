package stringlength;

public class Persona implements Comparable<Persona> {
	String nome;

	Persona(String n) {
		nome = n;
	}

	public int compareTo(Persona p) {
		return this.nome.compareTo(p.nome);
	}

	public String toString() {
		return nome;
	}
}