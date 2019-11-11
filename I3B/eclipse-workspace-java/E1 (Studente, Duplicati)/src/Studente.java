public class Studente implements Comparable<Studente> {
	private String nome;
	private String cognome;
	private int matricola;

	public Studente(String nome, String cognome, int matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public int getMatricola() {
		return this.matricola;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Studente))
			return false;

		Studente s = (Studente) obj; // Cast

		return nome.equals(s.getNome()) && cognome.equals(s.getCognome()) && matricola == s.getMatricola();
	}

	public int compareTo(Studente another) {
		if (this.matricola == another.matricola)
			return 0;
		else if (this.matricola > another.matricola)
			return -1;
		else
			return 1;
	}
}
