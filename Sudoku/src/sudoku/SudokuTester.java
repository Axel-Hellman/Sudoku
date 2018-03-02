package sudoku;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sudoku.SudokuSolver;

public class SudokuTester {
	SudokuSolver game;

	@Before
	public void setUp() throws Exception {
		game = new SudokuSolver();
	}

	@After
	public void tearDown() throws Exception {
		game = null;
	}

	@Test
	public void testEmptyBoard() {
		assertTrue("Successfully solved", game.solver());
	}
	
	@Test
	public void testFilledBoard() {
		game.put(2, 0, 8);
		game.put(5, 0, 9);
		game.put(7, 0, 6);
		game.put(8, 0, 2);
		
		game.put(8, 1, 5);
		
		game.put(0, 2, 1);
		game.put(2, 2, 2);
		game.put(3, 2, 5);
		
		game.put(3, 3, 2);
		game.put(4, 3, 1);
		game.put(7, 3, 9);
		
		game.put(1, 4, 5);
		game.put(6, 4, 6);
		
		game.put(0, 5, 6);
		game.put(7, 5, 2);
		game.put(8, 5, 8);
		
		game.put(0, 6, 4);
		game.put(1, 6, 1);
		game.put(3, 6, 6);
		game.put(5, 6, 8);
		
		game.put(0, 7, 8);
		game.put(1, 7, 6);
		game.put(4, 7, 3);
		game.put(6, 7, 1);
		
		game.put(6, 8, 4);
		
		assertTrue("Successfully solved", game.solver());
	}
	
	@Test
	public void testBoardFail() {
		game.put(0, 0, 1);
		game.put(1, 0, 1);
		game.put(2, 2, 1);
		assertFalse("Unsuccessfully solved", game.solver());
		
	}

}
