package Esercizio7;

import java.util.ArrayList;

interface Visitable {
	<T> T accept(Visitor<T> v); // Tipo restituito generico (Super/Sottoclassi?)
}

abstract class Componente implements Visitable {
	static int sommaCosto(ArrayList<Componente> l) {
		int somma = 0;
		Prezzo vprezzo = new Prezzo();
		for (Componente i : l) {
			somma += i.accept(vprezzo);
		}
		return somma;
	}
}

class ComponenteAtomico extends Componente {
	String nome;
	int prezzo;

	ComponenteAtomico(String n, int p) {
		nome = n;
		prezzo = p;
	}

	@Override
	public <T> T accept(Visitor<T> v) {
		return v.visit(this);
	}
}

class ComponenteComposto extends Componente {
	ArrayList<Componente> lista = new ArrayList<>();

	ComponenteComposto(ArrayList<Componente> l) {
		lista = l;
	}

	@Override
	public <T> T accept(Visitor<T> v) {
		return v.visit(this);
	}
}