
public class Counter {

	// L'invariante serve a far verificare count > 0 nel metodo inc(), se no lo vedeva localmente
	// e dava errore anche se in realtà count non è mai negativo grazie al costruttore
	//@ invariant count >= 0;
	public int count;
	
	public Counter(){count = 0;}
	
	//@ ensures count == \old(count) +1;
	//@ ensures count > 0;
	public int inc() {
		return ++ count;
	}
	//@ ensures count == 0;
	public void reset() {
		count = 0;
	} 
}
