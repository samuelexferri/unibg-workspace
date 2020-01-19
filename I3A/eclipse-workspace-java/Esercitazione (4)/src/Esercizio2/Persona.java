package Esercizio2;

import java.util.Arrays;

public class Persona {

	String nome;
	String cognome;
	char[] CF = new char[16];

	public Persona(String nome, String cognome, char[] CF) {
		this.nome = nome;
		this.cognome = cognome;
		this.CF = CF;
	}

	public boolean equals(Persona p) {
		System.out.println("Sto usando: public boolean equals(Persona p)");
		return Arrays.equals(p.CF, CF);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Persona)
			return equals((Persona) obj);

		return super.equals(obj);
	}
}