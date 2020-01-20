package Esercizio7;

import java.util.ArrayList;

class MainVisitorGenerico {
	public static void main(String[] args) {
		// Creo dei componenti
		ComponenteAtomico ca1 = new ComponenteAtomico("CA1", 5);
		ComponenteAtomico ca2 = new ComponenteAtomico("CA2", 10);
		ComponenteAtomico ca3 = new ComponenteAtomico("CA3", 15);
		ComponenteAtomico ca4 = new ComponenteAtomico("CA4", 20);

		ArrayList<Componente> lista1 = new ArrayList<>();
		lista1.add(ca1);
		lista1.add(ca2);
		ComponenteComposto cc1 = new ComponenteComposto(lista1);

		ArrayList<Componente> lista2 = new ArrayList<>();
		lista2.add(ca1);
		lista2.add(ca2);
		lista2.add(ca3);
		lista2.add(ca4);
		ComponenteComposto cc2 = new ComponenteComposto(lista2);

		Prezzo prezzo = new Prezzo();
		Nome nome = new Nome();

		System.out.println(ca1.accept(prezzo));
		System.out.println(cc1.accept(prezzo));
		System.out.println(cc2.accept(prezzo));

		System.out.println(ca1.accept(nome));
		System.out.println(cc1.accept(nome));
		System.out.println(cc2.accept(nome));
	}
}