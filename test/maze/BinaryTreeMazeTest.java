package maze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import booleangenerator.AlwaysFalseGenerator;
import booleangenerator.AlwaysTrueGenerator;
import booleangenerator.BooleanGenerator;
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
	 * OLLLL
	 * UUUUU
	 * UUUUU
	 * UUUUU
	 * UUUUU
	 */
	private TwoDeeOrthoMaze alwaysUpMaze;
	private static int alwaysUpMazeHeight = 5;
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
	 */
	private TwoDeeOrthoMaze alwaysLeftMaze;
	private static int alwaysLeftMazeHeight = 6;
	private static int alwaysLeftMazeWidth = 6;
	
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
		fail("Not yet implemented");
	}
	
	@Test
	public void testRightPath() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpPath() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDownPath() {
		fail("Not yet implemented");
	}

}
