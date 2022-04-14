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
		
		//Test the alwaysUpMaze, should be false everywhere except the topmost row, except the root
		//Check the root, should be false
		assertFalse(alwaysUpMaze.leftPath(0, 0));
		//Now the top row, it should be true for all
		for(int i = 0; i < alwaysUpMazeWidth; i++) {
			if(i != 0) {
				assertTrue(alwaysUpMaze.leftPath(0, i));
			}
		}
		//Starting on i = 1 to omit the top row
		for(int i = 1; i < alwaysUpMazeHeight; i++) {
			for(int j = 0; j < alwaysUpMazeWidth; j++) {
				assertFalse(alwaysUpMaze.leftPath(i, j));
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
		
		//Test the alwaysUpMaze, it should always return false except on the top row until the last cell
		//Start with the top row, it should be true for all
		for(int i = 0; i < alwaysUpMazeWidth - 1; i++) {
			assertTrue(alwaysUpMaze.rightPath(0, i)); 
		}
		//Get the last cell of the top row
		assertFalse(alwaysUpMaze.rightPath(0, alwaysUpMazeWidth - 1));
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
		//Test the alwaysLeftMaze, should be false for all except leftmost column except root
		//Start with root
		assertFalse(alwaysLeftMaze.upPath(0, 0));
		for(int i = 0; i < alwaysLeftMazeHeight; i++) {
			//cover the leftmost column for anything but root
			if(i != 0) {
				assertTrue(alwaysLeftMaze.upPath(i, 0));
			}
			//j will be initialized to 1 to avoid the leftmost column
			for(int j = 1; j < alwaysLeftMazeWidth; j++) {
				assertFalse(alwaysLeftMaze.upPath(i, j));
			}
		}
		
		//Test the alwaysUpMaze, should be true for all except topmost row
		//Start with the top row, it should be false for all
		for(int i = 0; i < alwaysUpMazeWidth; i++) {
			assertFalse(alwaysUpMaze.upPath(0, i)); 
		}
		//Starting on i = 1 to omit the top row
		for(int i = 1; i < alwaysUpMazeHeight; i++) {
			for(int j = 0; j < alwaysUpMazeWidth; j++) {
				assertTrue(alwaysUpMaze.upPath(i, j));
			}
		}
		
		//Test the alternatingLeftUpMaze
		//TODO
		
	}
	
	@Test
	public void testDownPath() {
		//Test the alwaysLeftMaze, should be false for all except leftmost column except bottommost leftmost cell
		//Check leftmost column except bottommost cell
		for(int i = 0; i < alwaysLeftMazeHeight - 1; i++) {
			assertTrue(alwaysLeftMaze.downPath(i, 0));
		}
		//Check bottom cell of leftmost column
		assertFalse(alwaysLeftMaze.downPath(alwaysLeftMazeHeight - 1, 0));
		//Check all rows, leaving out the leftmost column
		for(int i = 0; i < alwaysLeftMazeHeight; i++ ) {
			//j is initialize to 1 to omit leftmost column
			for(int j = 1; j < alwaysLeftMazeWidth ; j++) {
				assertFalse(alwaysLeftMaze.downPath(i, j));
			}
		}
		
		//Test the alwaysUpMaze, should be true for all except the bottom row
		//Test all rows, minus the bottommost
		for(int i = 0; i < alwaysUpMazeHeight - 1; i++) { //Stopping before the bottom row
			for (int j = 0; j < alwaysUpMazeWidth; j++) {
				assertTrue(alwaysUpMaze.downPath(i, j));
			}
		}
		//Now test the bottom row
		for(int i = 0; i < alwaysUpMazeWidth; i++) {
			assertFalse(alwaysUpMaze.downPath(alwaysUpMazeHeight - 1, i));
		}		
		
		//Test the alternatingLeftUpMaze
		//TODO
		
	}
	
	@Test
	public void testInvalidLeftPath() {
		//Always left maze
		try {
			alwaysLeftMaze.leftPath(-1, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysLeftMaze.leftPath(0, -1);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysLeftMaze.leftPath(alwaysLeftMazeHeight, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysLeftMaze.leftPath(0, alwaysLeftMazeWidth);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		//Always up maze
		try {
			alwaysUpMaze.leftPath(-1, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysUpMaze.leftPath(0, -1);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysUpMaze.leftPath(alwaysUpMazeHeight, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysUpMaze.leftPath(0, alwaysUpMazeWidth);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		//Alternating maze
		try {
			alternatingLeftUpMaze.leftPath(-1, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alternatingLeftUpMaze.leftPath(0, -1);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alternatingLeftUpMaze.leftPath(alternatingLeftUpMazeHeight, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alternatingLeftUpMaze.leftPath(0, alternatingLeftUpMazeWidth);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
	}
	
	@Test
	public void testInvalidRightPath() {
		//Always left maze
		try {
			alwaysLeftMaze.rightPath(-1, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysLeftMaze.rightPath(0, -1);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysLeftMaze.rightPath(alwaysLeftMazeHeight, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysLeftMaze.rightPath(0, alwaysLeftMazeWidth);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		//Always up maze
		try {
			alwaysUpMaze.rightPath(-1, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysUpMaze.rightPath(0, -1);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysUpMaze.rightPath(alwaysUpMazeHeight, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysUpMaze.rightPath(0, alwaysUpMazeWidth);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		//Alternating maze
		try {
			alternatingLeftUpMaze.rightPath(-1, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alternatingLeftUpMaze.rightPath(0, -1);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alternatingLeftUpMaze.rightPath(alternatingLeftUpMazeHeight, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alternatingLeftUpMaze.rightPath(0, alternatingLeftUpMazeWidth);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
	}
	
	@Test
	public void testInvalidUpPath() {
		//Always left maze
		try {
			alwaysLeftMaze.upPath(-1, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysLeftMaze.upPath(0, -1);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysLeftMaze.upPath(alwaysLeftMazeHeight, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysLeftMaze.upPath(0, alwaysLeftMazeWidth);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		//Always up maze
		try {
			alwaysUpMaze.upPath(-1, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysUpMaze.upPath(0, -1);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysUpMaze.upPath(alwaysUpMazeHeight, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysUpMaze.upPath(0, alwaysUpMazeWidth);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		//Alternating maze
		try {
			alternatingLeftUpMaze.upPath(-1, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alternatingLeftUpMaze.upPath(0, -1);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alternatingLeftUpMaze.upPath(alternatingLeftUpMazeHeight, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alternatingLeftUpMaze.upPath(0, alternatingLeftUpMazeWidth);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
	}
	
	@Test
	public void testInvalidDownPath() {
		//Always left maze
		try {
			alwaysLeftMaze.downPath(-1, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysLeftMaze.downPath(0, -1);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysLeftMaze.downPath(alwaysLeftMazeHeight, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysLeftMaze.downPath(0, alwaysLeftMazeWidth);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		//Always up maze
		try {
			alwaysUpMaze.downPath(-1, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysUpMaze.downPath(0, -1);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysUpMaze.downPath(alwaysUpMazeHeight, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alwaysUpMaze.downPath(0, alwaysUpMazeWidth);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		//Alternating maze
		try {
			alternatingLeftUpMaze.downPath(-1, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alternatingLeftUpMaze.downPath(0, -1);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alternatingLeftUpMaze.downPath(alternatingLeftUpMazeHeight, 0);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			alternatingLeftUpMaze.downPath(0, alternatingLeftUpMazeWidth);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
	}

}
