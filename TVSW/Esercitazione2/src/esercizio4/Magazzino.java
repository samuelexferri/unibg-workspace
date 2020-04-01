package esercizio4;

public class Magazzino {

	private /*@ spec_public */ int[] product = new int[5];

	// Invariante, per ogni prodotto ho sempre un numero di pezzi tra 0 e 100
	// Eseguito ogni metodo
	//@ public invariant (\forall int i; i >= 0 && i < 5; product[i]>=0 && product[i]<=100);

	// Costruttore
	// Precondizione: devo assicurare che ogni prodotto sia inizializzato a 0
	//@ ensures (\forall int i; i >= 0 && i < 5; product[i]==0);
	public Magazzino() {
		for (int i = 0; i < 1; i++) {
			product[i] = 0;
		}
	}

	//@ requires 0 <= productIndex && productIndex < product.length;
	// Precondizione: esiste un prodotto con meno di 100 unit�
	//@ requires (\exists int i; i >= 0 && i < 5; product[i]<100);
	//@ requires (product[productIndex]+addQuantity)<=100 && addQuantity<=10;
	// Postcondizione: le quantit� diverse da product_index sono invariate
	//@ ensures(\forall int i; i >= 0 && i <productIndex; product[i] == \old(product[i]) );
	//@ ensures(\forall int i; i >productIndex && i <5; product[i] == \old(product[i]) );
	public boolean insert(int productIndex, int addQuantity) {
		if ((productIndex < 0 || productIndex > 4) || (addQuantity < 0 || addQuantity > 10)
				|| (product[productIndex] + addQuantity) > 100) {
			return false;
		} else {
			product[productIndex] += addQuantity;
			return true;
		}
	}

	// Precondizione: indice compreso tra 0 e 4 compresi
	//@ requires productIndex<5 && productIndex>=0;
	// Postcondizione:se il prodotto ha 100 elementi assicurati che � pieno
	//@ ensures product[productIndex]>=100 ==> \result==true;
	public boolean isFull(int productIndex) {
		if (productIndex < 0 || productIndex > 4)
			return false;
		else
			return product[productIndex] == 100 ? true : false;
	}

	// Postcondizione: se esiste un oggetto con quantit� minore di 100 allora il metodo ritorna false
	//@ ensures (\exists int i; i >= 0 && i < 5; product[i]<100 ==> \result==false);
	public boolean isFull() {
		int total = 0;
		for (int i = 0; i < 5; i++)
			total += product[i];
		return total == 500 ? true : false;
	}
}