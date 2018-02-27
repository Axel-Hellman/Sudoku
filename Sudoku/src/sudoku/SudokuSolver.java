package sudoku;

/**
 * SudokuSolver implementerar en mängd funktioner för att rekrusivt försöka lösa
 * ett sudokuproblem.
 *
 * @author Axel Hellman, Isabella Steen
 * @version 1.0
 * @since 2018-02-20
 */
public class SudokuSolver {

	public int[][] matris;

	// Konstruktor
	public SudokuSolver() {
		matris = new int[9][9];
	}

	// löser sudokut.
	public boolean solver() {

		// Nästlad loop för att gå igenom hela matrisen
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; i++) {
				if (i == 9) {
					return true;
				} else if (matris[i][j] == 0) { // OBS!! Vet ej om det skall
												// vara == 0 eller == null
					// Metod för att hitta värde att sätta in, tryPut
					tryPut(i, j);

				} else if (matris[i][j] > 0 && matris[i][j] < 10) {
					// Metod för att kolla så att allt är okej, annars returna
					// false och gå tillbaka
				} else {
					return false; // Något kul exception :)
				}
			}
		}
		return false;
	}

	private boolean solver(int posX, int posY) {
		if (posY > 8) {
			return true;
		} else if (posX == 9) {
			posX = 0;
			return solver(posX, posY + 1);
		} else if (tryPut(posX, posY)) {
			return solver(posX + 1, posY);
		}
		return true; // tillfällig return statement
	}

	/**
	 * Testar om det fungerar att sätta in ett värde (1-9) och lägger isåfall in
	 * detta i en matris.
	 * 
	 * @param posX
	 *            , positionen i x-led
	 * @param posY
	 *            , positionen i y-led
	 * @return , Ifall det går att lägga in ett värde
	 */
	public boolean tryPut(int posX, int posY) {
		for (int i = 0; i < 9; i++) {
			for (int j = 1; i < 10; i++) {
				// Ska testa horisontell, vertikal ral, samt grupp (se metod
				// nedan)
				if (matris[posX][i] == j || matris[i][posY] == j || group(posX, posY, j)) {
					return false;
				} else {
					put(posX, posY, j);
					return true;
				}

			}
		}
		return false;
	}

	/**
	 * Stoppar in ett värde (nbr) på en specifik plats i matrisen.
	 * 
	 * @param posX
	 *            , plats i x-led
	 * @param posY
	 *            , plats i y-led
	 * @param nbr
	 *            , värdet
	 */

	public void put(int posX, int posY, int nbr) {
		matris[posX][posY] = nbr;
	}

	/**
	 * Returnerar värdet vid en pecifik position i matrisen.
	 * 
	 * @param posX
	 *            , plats i x-led
	 * @param posY
	 *            , plats i y-led
	 * @return , värdet
	 */

	public int getNbr(int posX, int posY) {
		return matris[posX][posY];
	}

	/**
	 * Delmetod som kollar ifall en siffra "a" finns i samma 3x3 grupp i
	 * sudokut.
	 * 
	 * @param posX
	 *            , plats i x-led
	 * @param posY
	 *            , plats i y-led
	 * @param a
	 *            , värde att jämföra med
	 * @return , om vrdet finns i gruppen eller inte
	 */
	// Delmetod som kollar ifall siffran finns i samma "grupp" i sudoku
	public boolean group(int posX, int posY, int a) {
		int newPosX = (posX / 3) * 3;
		int newPosY = (posY / 3) * 3;
		for (int i = newPosX; i < newPosX + 3; i++) {
			for (int j = newPosY; j < newPosY + 3; j++) {
				if (matris[i][j] == a) {
					return true;
				}
			}
		}
		return false;
	}

}
