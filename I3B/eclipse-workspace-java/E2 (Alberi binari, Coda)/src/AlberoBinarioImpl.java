import java.util.List; //Per l'output delle visite
import java.util.Iterator;
import java.util.LinkedList; //Per l'output delle visite

import coda.*; //Per la visita BFS (come esempio di struttura dati propria)
import java.util.Stack; //Per la visita DFS (come esempio di struttura dati predefinita di JFC)

public class AlberoBinarioImpl implements AlberoBinario {
	protected NodoBinario radice;

	// Metodo costruttore di default
	public AlberoBinarioImpl() {
		radice = null;
	}

	// Metodi costruttori: due varianti (uno con l'info ed uno direttamente con il
	// nodo)
	public AlberoBinarioImpl(Object e) {
		radice = new NodoBinario(e);
	}

	public AlberoBinarioImpl(NodoBinario rad) {
		radice = rad;
	}

	// Metodi accessori:
	public NodoBinario radice() {
		return radice;
	}

	public int numNodi() {
		return numNodi(radice);
	}

	/**
	 * Restituisce il numero di nodi dell'albero radicato in un nodo <code>r</code>.
	 * Tale informazione viene determinata conteggiando ricorsivamente il numero di
	 * nodi dei sottoalberi radicati nei figli di <code>r</code>.
	 * 
	 * @return il numero di nodi presenti nell'albero radicato in <code>r</code>.
	 */
	private int numNodi(NodoBinario r) {
		return r == null ? 0 : numNodi(r.sinistro) + numNodi(r.destro) + 1;
	}

	public int grado(NodoBinario v) {
		int grado = 0;
		if (v == null)
			return -1;
		if (((NodoBinario) v).sinistro != null)
			grado++;
		if (((NodoBinario) v).destro != null)
			grado++;
		return grado;
	}

	public Object info(NodoBinario v) {
		return v.elem;
	}

	// Restituisce true se v e' un figlio sinistro
	public boolean figlioSinistro(NodoBinario v) {
		if (v.equals(v.padre.sinistro))
			return true;
		else
			return false;
	}

	// Restituisce true se v e' un figlio sinistro
	public boolean figlioDestro(NodoBinario v) {
		if (v.equals(v.padre.destro))
			return true;
		else
			return false;
	}

	public NodoBinario padre(NodoBinario v) {
		return v.padre;
	}

	public NodoBinario sin(NodoBinario v) {
		return v.sinistro;
	}

	public NodoBinario des(NodoBinario v) {
		return v.destro;
	}

	public void cambiaInfo(NodoBinario v, Object info) {
		v.elem = info;
	}

	public void scambiaInfo(NodoBinario v1, NodoBinario v2) {
		Object app = v1.elem;
		v1.elem = v2.elem;
		v2.elem = app;
	}

	// aggiunge "albero" come sottoalbero sinistro di "padre"
	public void innestaSin(NodoBinario padre, AlberoBinario albero) {
		NodoBinario figlio = albero.radice();
		if (figlio != null)
			figlio.padre = padre;
		padre.sinistro = figlio;
	}

	// aggiunge "albero" come sottoalbero destro di "padre"
	public void innestaDes(NodoBinario padre, AlberoBinario albero) {
		NodoBinario figlio = albero.radice();
		if (figlio != null)
			figlio.padre = padre;
		padre.destro = figlio;
	}

	// elimina il sottoalbero sinistro di "padre" e lo restituisce
	public AlberoBinario potaSinistro(NodoBinario padre) {
		NodoBinario figlio = padre.sinistro;
		figlio.padre = null;
		AlberoBinario newalbero = new AlberoBinarioImpl(figlio);
		padre.sinistro = null;
		return newalbero;
	}

	// elimina il sottoalbero destro di "padre" e lo restituisce
	public AlberoBinarioImpl potaDestro(NodoBinario padre) {
		NodoBinario figlio = padre.destro;
		figlio.padre = null;
		AlberoBinarioImpl newalbero = new AlberoBinarioImpl(figlio);
		padre.destro = null;
		return newalbero;
	}

	// Stacca e restituisce il sottoalbero radicato in un certo
	// NodoBinario "rimosso" dell'albero
	public AlberoBinario pota(NodoBinario rimosso) {
		if (rimosso == null)
			return new AlberoBinarioImpl(); // l'albero vuoto
		if (rimosso.padre == null) { // "rimosso" � la radice dell'albero
			radice = null;
			return new AlberoBinarioImpl(rimosso); // restituiamo l'intero albero
		}
		NodoBinario pad = rimosso.padre;
		if (figlioSinistro(rimosso)) { // se "rimosso" � figlio sinistro
			AlberoBinario newalbero = potaSinistro(pad);
			return newalbero;
		} else { //// "rimosso" � figlio destro
			AlberoBinario newalbero = potaDestro(pad);
			return newalbero;
		}
	}

	// Restituisce la lista degli elementi in una visita DFS (iterativa)
	public List visitaDFS() {
		List output = new LinkedList();// lista di elementi in output
		Stack<NodoBinario> pila = new Stack<NodoBinario>(); // Classe generica Stack<T>
		if (radice != null)
			pila.push(radice);
		while (!pila.isEmpty()) {
			NodoBinario u = pila.pop();// Richiederebbe il casting se usassimo la classe Stack non generica
			output.add(u.elem);// mettiamo in output corrente
			// inseriamo in pila il figlio destro e poi quello sinistro
			if (u.destro != null)
				pila.push(u.destro);
			if (u.sinistro != null)
				pila.push(u.sinistro);
		}
		return output;
	}

	// Restituisce la lista degli elementi in una visita BFS
	public List visitaBFS() {
		List output = new LinkedList();
		Coda coda = new CodaCollegata();
		if (radice != null)
			coda.enqueue(radice);
		while (!coda.isEmpty()) {
			NodoBinario u = (NodoBinario) coda.dequeue();
			output.add(u.elem); // Il metodo add di LinkedList aggiunge il nuovo elemnto alla fine
			// Inseriamo in coda il figlio sinistro e poi quello destro
			if (u.sinistro != null)
				coda.enqueue(u.sinistro);
			if (u.destro != null)
				coda.enqueue(u.destro);
		}
		return output;
	}

	// ESERCITAZIONE

	@Override
	public int level(NodoBinario u) {
		if (u.padre == null)
			return 0;
		else
			return 1 + level(u.padre);
	}

	@Override
	public int altezza() {
		if (this == null)
			return 0;

		int altezzasx = 0;
		int altezzadx = 0;

		if (this.radice.sinistro != null) {
			AlberoBinario clonesx = new AlberoBinarioImpl(this.radice.sinistro);
			altezzasx = clonesx.altezza() + 1;
		}
		if (this.radice.destro != null) {
			AlberoBinario clonedx = new AlberoBinarioImpl(this.radice.destro);
			altezzadx = clonedx.altezza() + 1;
		}

		return max(altezzasx, altezzadx);
	}

	// Private: Massimo
	private int max(int altezza1, int altezza2) {
		if (altezza1 > altezza2)
			return altezza1;
		else
			return altezza2;
	}

	@Override
	public int numFoglie() {
		if (this.radice == null)
			return 0;

		if (this.radice.sinistro == null && this.radice.destro == null)
			return 1;

		if (this.radice.sinistro != null && this.radice.destro != null) {
			AlberoBinario clonesx = new AlberoBinarioImpl(this.radice.sinistro);
			AlberoBinario clonedx = new AlberoBinarioImpl(this.radice.destro);
			return clonesx.numFoglie() + clonedx.numFoglie();
		} else if (this.radice.sinistro != null) {
			AlberoBinario clonesx = new AlberoBinarioImpl(this.radice.sinistro);
			return clonesx.numFoglie();
		} else if (this.radice.destro != null) {
			AlberoBinario clonedx = new AlberoBinarioImpl(this.radice.destro);
			return clonedx.numFoglie();
		}

		return 0;
	}

	@Override
	public int numNodiInterni() {
		return this.numNodi() - this.numFoglie();
	}

	@Override
	public boolean equals(AlberoBinarioImpl another) {
		if (this.radice.elem == another.radice.elem && this.radice.sinistro == null && another.radice.sinistro == null
				&& this.radice.destro == null && another.radice.destro == null) {
			return true;
		}

		if (this.radice.elem == another.radice.elem && this.radice.sinistro == another.radice.sinistro
				&& this.radice.destro == another.radice.destro) {
			if (this.radice.sinistro != null && this.radice.destro != null) {
				AlberoBinario clonesx = new AlberoBinarioImpl(this.radice.sinistro);
				AlberoBinario clonedx = new AlberoBinarioImpl(this.radice.destro);
				return clonesx.equals(new AlberoBinarioImpl(another.radice.sinistro))
						&& clonedx.equals(new AlberoBinarioImpl(another.radice.destro));
			} else if (this.radice.sinistro != null) {
				AlberoBinario clonesx = new AlberoBinarioImpl(this.radice.sinistro);
				return clonesx.equals(new AlberoBinarioImpl(another.radice.sinistro));
			} else if (this.radice.destro != null) {
				AlberoBinario clonedx = new AlberoBinarioImpl(this.radice.destro);
				return clonedx.equals(new AlberoBinarioImpl(another.radice.destro));
			}
		}

		// Nessun caso precedente
		return false;
	}

	@Override
	public void eliminaFoglieUguali() {
		eliminaFoglieUgualiNodo(this.radice);
	}

	// Private: Elimina foglie uguali dal nodo
	private void eliminaFoglieUgualiNodo(NodoBinario p) {

		if (p.sinistro == null && p.destro == null && p.padre != null) {

			if (p == p.padre.sinistro && p.elem == p.padre.destro.elem && p.padre.destro.sinistro == null
					&& p.padre.destro.destro == null) {
				p.padre.destro = null;
				p.padre.sinistro = null;
				p.padre = null;
			} else if (p == p.padre.destro && p.elem == p.padre.sinistro.elem && p.padre.sinistro.sinistro == null
					&& p.padre.sinistro.destro == null) {
				p.padre.destro = null;
				p.padre.sinistro = null;
				p.padre = null;
			}
		} else {
			if (p.sinistro != null) {
				eliminaFoglieUgualiNodo(p.sinistro);
			}

			if (p.destro != null) {
				eliminaFoglieUgualiNodo(p.destro);
			}
		}

		return;
	}

	@Override
	public boolean search(Object elem) {
		if (this.radice == null)
			return false;

		if (this.radice == elem) {
			return true;
		}

		if (this.radice.sinistro != null && this.radice.destro != null) {
			AlberoBinario clonesx = new AlberoBinarioImpl(this.radice.sinistro);
			AlberoBinario clonedx = new AlberoBinarioImpl(this.radice.destro);
			return (clonesx.search(elem) || clonedx.search(elem));
		} else if (this.radice.sinistro != null) {
			AlberoBinario clonesx = new AlberoBinarioImpl(this.radice.sinistro);
			return clonesx.search(elem);
		} else if (this.radice.destro != null) {
			AlberoBinario clonedx = new AlberoBinarioImpl(this.radice.destro);
			return clonedx.search(elem);
		}

		return false;
	}

	@Override
	public List<NodoBinario> nodiCardine() {
		List list = new LinkedList();
		NodoBinario u;

		if (this.radice == null)
			return list;

		if (nodiCardineIf(this.radice))
			list.add(this.radice);

		if (this.radice.sinistro != null && this.radice.destro != null) {
			u = this.radice.sinistro;
			if (nodiCardineIf(u))
				list.add(u);
			u = this.radice.destro;
			if (nodiCardineIf(u))
				list.add(u);
		} else if (this.radice.sinistro != null) {
			u = this.radice.sinistro;
			if (nodiCardineIf(u))
				list.add(u);
		} else if (this.radice.destro != null) {
			u = this.radice.destro;
			if (nodiCardineIf(u))
				list.add(u);
		}

		return list;
	}

	private boolean nodiCardineIf(NodoBinario u) {
		int altezzaradicatoinu = (new AlberoBinarioImpl(u)).altezza();
		int profonditàu = level(u);

		if (altezzaradicatoinu == profonditàu)
			return true;
		else
			return false;
	}

	@Override
	public NodoBinario lca(NodoBinario u, NodoBinario v) {
		List<NodoBinario> lu = new LinkedList<>();
		List<NodoBinario> lv = new LinkedList<>();

		if (this.search(u))
			lu.add(u);
		else
			return null;

		if (this.search(v))
			lv.add(v);
		else
			return null;

		while (true) {
			Iterator<NodoBinario> lu_iter = lu.iterator();

			while (lu_iter.hasNext()) {
				NodoBinario lu_temp = lu_iter.next();
				System.out.print(" U" + lu_temp.elem);

				if (lv.contains(lu_temp))
					return lu_temp;
			}

			if (u.padre == null && v.padre == null)
				return null;

			if (u.padre != null) {
				lu.add(u.padre);
				u = u.padre;
			}

			if (v.padre != null) {
				lv.add(v.padre);
				v = v.padre;
			}

		}
	}
}
