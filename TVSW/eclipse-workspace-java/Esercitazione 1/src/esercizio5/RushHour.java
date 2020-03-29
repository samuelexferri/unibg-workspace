package esercizio5;

public class RushHour {

	int griglia[][];

	public RushHour() {
		griglia = new int[6][6];

		// Questo sarebbe inutile perchè è inizilizzato a zero di default
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				griglia[i][j] = 0;
			}
		}

		griglia[2][2] = 1; // Macchina rossa
		griglia[1][5] = 2;
		griglia[2][5] = 3;
		griglia[3][5] = 4;
		griglia[4][1] = 5;
		griglia[0][3] = 6;
	}

	/**
	 * Move car
	 *
	 * @param row la riga della macchina da spostare: può essere un numero qualsiasi
	 *            ma viene fatto il controllo che sia tra 0 e 5 compresi.
	 * @param col la colonna della macchina da spostare: può essere un numero
	 *            qualsiasi ma viene fatto il controllo che sia tra 0 e 5 compresi.
	 * @param dir la direzione: 1. verso l'alto; 2. verso destra; 3. verso il basso;
	 *            4. verso sinistra.
	 * @return true se la macchina è spostata.
	 */
	public boolean moveCar(int row, int col, int dir) {
		if (row < 0 || row > 5 || col < 0 || col > 5 || dir < 1 || dir > 4) {
			// In tal caso ho sbagliato gli indici oppure ho indicato una direzione
			// inesistente
			return false;
		}

		if (griglia[row][col] == 0) {
			// In tal caso ho selezionato una casella vuota, non devo spostare altre
			// macchine
			return false;
		} else {

			int nRow, nCol; // Nuove coordinate della macchina

			if (dir == 1) {
				// Verso l'alto
				if (row == 0)
					// Voglio andare verso l'alto, ma sono al bordo
					return false;
				nRow = row - 1;
				nCol = col;
			} else if (dir == 2) {
				// Verso destra
				if (col == 5)
					// Voglio andare verso destra, ma sono al bordo
					return false;
				nCol = col + 1;
				nRow = row;
			} else if (dir == 3) {
				// Verso il basso
				if (row == 5)
					// Voglio andare verso il basso, ma sono al bordo
					return false;
				nRow = row + 1;
				nCol = col;
			} else {
				assert (dir == 4);
				// Verso sinistra
				if (col == 0)
					// Voglio andare verso sinistra, ma sono al bordo
					return false;
				nCol = col - 1;
				nRow = row;
			}

			if (griglia[nRow][nCol] != 0) {
				// La cella di destinazione è già occupata, non posso spostare la macchinina
				return false;
			} else {
				// La cella di destinazione è libera, sposto la macchina
				griglia[nRow][nCol] = griglia[row][col];
				griglia[row][col] = 0;
				return true;
			}
		}
	}

	/**
	 * Red car at exit
	 *
	 * @return true se la macchina rossa è in uscita
	 */
	public boolean redCarAtExit() {
		if (griglia[2][5] == 1) {
			return true;
		}

		return false;
	}
}