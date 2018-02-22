package sudoku;

public class SudokuSolver {

	public int[][] matris;
	
	// Konstruktor
	public SudokuSolver () {
		matris = new int[9][9];
	}
	
	//Testar om det funkar att sätta in ett värde 
	public boolean tryPut(int posX, int posY, int a) {
		for(int i = 0; i < 9; i++){
			//Ska testa horisontell, vertikal ral, samt grupp (se metod nedan)
			//if(matris[posX][i] == a || matris[i][posY] == a || group(int posX, int posY, int a)){
				return false;
			//}
		}
		return true;
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
					//Metod för att hitta värde att sätta in, tryPut
					 * tryPut(j, i, matris[i][j])
		        
				} */ else if ( matris[i][j] > 0 && matris[i][j]< 10){
					//Metod för att kolla så att allt är okej, annars returna false och gå tillbaka
				}
				else {
					return false; //Något kul exception :)
				}
			}
		}
		return false;
	}
	
	//Delmetod som kollar ifall siffran finns i samma "grupp" i sudoku
	public boolean group (int posX, int posY, int a) {
		int newPosX = (posX/3)*3;
		int newPosY = (posY/3)*3;
		for(int i = newPosX; i < newPosX + 3; i++){
			for(int j = newPosY; j < newPosY + 3; j++){
				if(matris[i][j] == a){
					return true;
				}
			}
		} return false;
	}
	
	// kollar listan, ser om det finns en nästkommande ruta.
	public boolean hasNext(){
		return false;
	}
}
