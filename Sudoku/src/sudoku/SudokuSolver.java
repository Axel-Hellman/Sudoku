package sudoku;

public class SudokuSolver {

	public int[][] matris;
	
	// Konstruktor
	public SudokuSolver () {
		matris = new int[9][9];
	}
	
	// Stoppa in ett värde på en specifik plats
	public void put(int Nbr, int posX, int posY) {
		matris[posX][posY] = Nbr;
	}
	
	// får värdet på en specifik plats.
	public int getNbr(int posX, int posY) {
		return matris[posX][posY];
	}
	
	// löser sudokut.
	public boolean solver(){
		return false;
	}
	
	// kollar listan, ser om det finns en nästkommande ruta.
	public boolean hasNext(){
		return false;
	}
}
