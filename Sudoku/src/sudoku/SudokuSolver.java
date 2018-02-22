package sudoku;

public class SudokuSolver {

	public int[][] matris;
	
	// Konstruktor
	public SudokuSolver () {
		matris = new int[9][9];
	}
	
	//Testar om det funkar att sätta in ett värde innan man använder actual put
	public boolean tryPut() {
		return false;
	}
	
	// Stoppa in ett värde på en specifik plats
	public void put(int Nbr, int posX, int posY) {
		matris[posX][posY] = Nbr;
	}
	
	// får värdet på en specifik plats. (Används till att kolla numrena runt omkring)
	public int getNbr(int posX, int posY) {
		return matris[posX][posY];
	}
	
	// löser sudokut.
	public boolean solver(){
	
		// Nästlad loop för att gå igenom hela matrisen
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 9; i++){
				if(i == 9){
					return true;
					//Då är den färdig, förstår inte varför inte detta funkar
				}
				/*else if( matris[j][i] != null ){ //Varför kan man inte ha null där?
					//Metod för att hitta värde att sätta in
					return false;
				} */ else if ( matris[j][i] > 0 && matris[j][i]< 10){
					//Metod för att kolla så att allt är okej, annars returna false och gå tillbaka
				}
				else {
					return false; //Något kul exception :)
				}
			}
		}
		return false;
	}
	
	// kollar listan, ser om det finns en nästkommande ruta.
	public boolean hasNext(){
		return false;
	}
}
