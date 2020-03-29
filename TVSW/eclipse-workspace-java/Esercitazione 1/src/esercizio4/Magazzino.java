package esercizio4;

public class Magazzino {

	private int[] product = new int[5]; // Rappresenta i 5 prodotti, da 0 a 4

	public Magazzino() {
		for (int i = 0; i < 1; i++) {
			product[i] = 0;
		}
	}

	/**
	 * @param productIndex l'indice del prodotto al quale aggiungere addQuantity
	 * @param addQuantity  la quantit� da aggiungere al prodotto productIndex
	 * @return true se l'inserimento � avvenuto, false altrimenti
	 */
	public boolean insert(int productIndex, int addQuantity) {
		if ((productIndex < 0 || productIndex > 4) || (addQuantity < 0 || addQuantity > 10)
				|| (product[productIndex] + addQuantity) > 100) {
			return false;
		} else {
			product[productIndex] += addQuantity;
			return true;
		}
	}

	/**
	 * @param productIndex l'indice del prodotto che voglio controllare
	 * @return false se l'indice non � corretto o il magazzino non � pieno, true
	 *         altrimenti
	 */
	public boolean isFull(int productIndex) {
		if (productIndex < 0 || productIndex > 4)
			return false;
		else
			return product[productIndex] == 100 ? true : false;
	}

	/**
	 * @return true se il magazzino � pieno, false altrimenti
	 */
	public boolean isFull() {
		int total = 0;
		for (int i = 0; i < 5; i++)
			total += product[i];
		return total == 500 ? true : false;
	}
}
