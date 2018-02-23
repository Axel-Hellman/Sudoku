package sudoku;

public class SudokuSolver {

	public int[][] matris;

	// Konstruktor
	public SudokuSolver() {
		matris = new int[9][9];
	}

	// Testar om det funkar att sätta in ett värde
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

	// Stoppa in ett värde på en specifik plats
	public void put(int posX, int posY, int Nbr) {
		matris[posX][posY] = Nbr;
	}

	// får värdet på en specifik plats. (Används till att kolla numrena runt
	// omkring)
	public int getNbr(int posX, int posY) {
		return matris[posX][posY];
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

	// kollar listan, ser om det finns en nästkommande ruta.
	public boolean hasNext() {
		return false;
	}
}
