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

	public static void main(String[] args) {
		SudokuSolver tester = new SudokuSolver();
		tester.solver();
	}

	public int[][] matris;

	/**
	 * Konstruktor, skapar en ny (tom) 9x9 matris
	 */
	public SudokuSolver() {
		matris = new int[9][9];
	}

	/**
	 * Går rekrusivt igenom hela brädet och försöker lösa sudokut en "ruta" i
	 * taget. Går fram då det fungerar och backtrackar då det ej fungerar
	 * (enligt reglerna av sudoku). Avslutar när det inte går att sätta in ett
	 * nytt tal.
	 * 
	 * @return , om brädet har blivigt löst eller ej.
	 */
	public boolean solver() {

		boolean checker = true;

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (matris[row][col] > 0) {
					if (!tryRules(row, col, matris[row][col])) {
						checker = false;
					}
				}
			}
		}

		if (checker) {
			return solver(0, 0);
		} else {
			return false;
		}
	}

	private boolean solver(int posX, int posY) {
		// printmatrix
		if (posY > 8) {
			return true;
		} else if (posX == 9) {
			posX = 0;
			return solver(posX, posY + 1);
		} else if (matris[posX][posY] == 0) {
			for (int i = 1; i <= 10; i++) {
				if (i == 10) {
					remove(posX, posY);
					return false;
				} else if (tryRules(posX, posY, i)) {
					put(posX, posY, i);
					if (solver(posX + 1, posY)) {
						return true;
					}
				}
			}
		} else {
			return solver(posX + 1, posY);
		}
		return false; // tillfällig return statement
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
	public boolean tryRules(int posX, int posY, int nbr) {
		for (int i = 0; i < 9; i++) {
			if (matris[posX][i] == nbr || matris[i][posY] == nbr || group(posX, posY, nbr)) {
				return false;
			}
		}
		return true;
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
	 * Tar bort värdet (sätter värde 0) på en specifik plats
	 * 
	 * @param posX
	 *            , plats i x-led
	 * @param posY
	 *            , plats i y-led
	 */
	public void remove(int posX, int posY) {
		matris[posX][posY] = 0;
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
