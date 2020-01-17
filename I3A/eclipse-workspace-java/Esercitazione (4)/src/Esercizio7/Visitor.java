package Esercizio7;

interface Visitor<T> {
	abstract T visit(ComponenteAtomico componente);

	abstract T visit(ComponenteComposto componente);
}

class Prezzo implements Visitor<Integer> {

	@Override
	public Integer visit(ComponenteAtomico ca) {
		return ca.prezzo;
	}

	@Override
	public Integer visit(ComponenteComposto cc) {
		return Componente.sommaCosto(cc.lista);
	}
}

class Nome implements Visitor<String> {

	@Override
	public String visit(ComponenteAtomico ca) {
		return ca.nome;
	}

	@Override
	public String visit(ComponenteComposto cc) {
		String buffer = "[ ";
		Nome vnome = new Nome();
		for (Componente i : cc.lista) {
			buffer += i.accept(vnome) + " ";
		}
		return buffer + "]";
	}
}