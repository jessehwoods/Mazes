package maze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import booleangenerator.AlwaysFalseGenerator;
import booleangenerator.AlwaysTrueGenerator;
import booleangenerator.DefinedValuesGenerator;

/**
 * Tests for BinaryTreeMaze. BinaryTreeMaze requirs a generator at this time when being constructed, so
 * tests will be based on a generator.
 * 
 * @author Jesse Woods
 *
 */
public class BinaryTreeMazeTest {

	/**
	 * A maze in which all paths are up/down, except the topmost row.
	 * Should be shaped like this:
	 * OLLLLLL
	 * UUUUUUU
	 * UUUUUUU
	 * UUUUUUU
	 * UUUUUUU
	 */
	private TwoDeeOrthoMaze alwaysUpMaze;
	private static int alwaysUpMazeHeight = 7;
	private static int alwaysUpMazeWidth = 5;
	
	/**
	 * A maze in which all paths are left/right, except the leftmost column.
	 * Should be shaped like this (O's are walls):
	 * Should be shaped like this:
	 * OLLLL
	 * ULLLL
	 * ULLLL
	 * ULLLL
	 * ULLLL
	 * ULLLL
	 * ULLLL
	 */
	private TwoDeeOrthoMaze alwaysLeftMaze;
	private static int alwaysLeftMazeHeight = 5;
	private static int alwaysLeftMazeWidth = 7;
	
	/**
	 * A maze in which paths alternate left/right and up/down except the topmost row (always left/right) and
	 * the leftmost column (always up/down).
	 * Should be shaped like this:
	 * OLLLLL
	 * ULULUL
	 * ULULUL
	 * ULULUL
	 * ULULUL
	 */
	private TwoDeeOrthoMaze alternatingLeftUpMaze;
	private static int alternatingLeftUpMazeHeight = 6;
	private static int alternatingLeftUpMazeWidth = 5;
	private static boolean[] booleanArray = {false, true, false, true, false, true};
	
    /**
     * Create a new instance of the generator before each test.
     */ 
    @Before
    public void setUp() {
        alwaysUpMaze = new BinaryTreeMaze(alwaysUpMazeHeight, alwaysUpMazeWidth, new AlwaysFalseGenerator());
        alwaysLeftMaze = new BinaryTreeMaze(alwaysLeftMazeHeight, alwaysLeftMazeWidth, new AlwaysTrueGenerator());
        alternatingLeftUpMaze = new BinaryTreeMaze(alternatingLeftUpMazeHeight, alternatingLeftUpMazeWidth, new DefinedValuesGenerator(booleanArray));
    }
    
	@Test
	public void testHeight() {
		assertEquals(alwaysUpMazeHeight, alwaysUpMaze.height());
		assertEquals(alwaysLeftMazeHeight, alwaysLeftMaze.height());
		assertEquals(alternatingLeftUpMazeHeight, alternatingLeftUpMaze.height());
	}
	
	@Test
	public void testWidth() {
		assertEquals(alwaysUpMazeWidth, alwaysUpMaze.width());
		assertEquals(alwaysLeftMazeWidth, alwaysLeftMaze.width());
		assertEquals(alternatingLeftUpMazeWidth, alternatingLeftUpMaze.width());
	}
	
	@Test
	public void testLeftPath() {
		//Test the alwaysLeftMaze, should be true everywhere except the leftmost column
		//i will iterate the rows
		for(int i = 0; i < alwaysLeftMazeHeight; i++) {
			//This one will be the leftmost cell of each row
			assertFalse(alwaysLeftMaze.leftPath(i, 0)); 
			//j will be initialized to 1 to skip the first cell in each row
			for(int j = 1; j < alwaysLeftMazeWidth; j++) {
				assertTrue(alwaysLeftMaze.leftPath(i, j));
			}
		}
		
		//Test the alwaysUpMaze, should be false everywhere except the topmost row
		//Start with the top row, it should be true for all
		for(int i = 0; i < alwaysUpMazeWidth; i++) {
			assertTrue(alwaysLeftMaze.rightPath(0, i)); 
		}
		//Starting on i = 1 to omit the top row
		for(int i = 1; i < alwaysUpMazeHeight; i++) {
			for(int j = 0; j < alwaysUpMazeWidth; j++) {
				assertFalse(alwaysUpMaze.rightPath(i, j));
			}
		}
		
		//Test the alternatingLeftUpMaze
		//TODO
		
	}
	
	@Test
	public void testRightPath() {
		//Test the alwaysLeftMaze, it should always have a right path other than the rightmost column
		for(int i = 0; i < alwaysLeftMazeHeight; i++) {
			for(int j = 0; j < alwaysLeftMazeWidth - 1; j++) {
				//This will cover all the cells in the row except the rightmost
				assertTrue(alwaysLeftMaze.rightPath(i, j));
			}
			//This last one will be the rightmost cell of each row
			assertFalse(alwaysLeftMaze.rightPath(i, alwaysLeftMazeWidth - 1)); 
		}
		
		//Test the alwaysUpMaze, it should always return false except on the top row
		//Start with the top row, it should be true for all
		for(int i = 0; i < alwaysUpMazeWidth; i++) {
			assertTrue(alwaysLeftMaze.rightPath(0, i)); 
		}
		//Starting on i = 1 to omit the top row
		for(int i = 1; i < alwaysUpMazeHeight; i++) {
			for(int j = 0; j < alwaysUpMazeWidth; j++) {
				assertFalse(alwaysUpMaze.rightPath(i, j));
			}
		}
		
		//Test the alternatingLeftUpMaze
		//TODO
		
	}
	
	@Test
	public void testUpPath() {
		//Test the alwaysLeftMaze
		
		//Test the alwaysUpMaze
		
		//Test the alternatingLeftUpMaze
		//TODO
		
	}
	
	@Test
	public void testDownPath() {
		//Test the alwaysLeftMaze
		
		//Test the alwaysUpMaze
		
		//Test the alternatingLeftUpMaze
		//TODO
		
	}

}
