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

	
	private TwoDeeOrthoMaze alwaysUpMaze;
	
	private TwoDeeOrthoMaze alwaysLeftMaze;
	
	private TwoDeeOrthoMaze alternatingLeftUpMaze;
	
	/**
	 * A boolean array that will return true on odd and false on even in the DefinedValuesGenerator.
	 */
	private static boolean[] booleanArray = {false, true, false, true};
	
    /**
     * Create a new instance of the generator before each test.
     */ 
    @Before
    public void setUp() {
        alwaysUpMaze = new BinaryTreeMaze(5, 5, new AlwaysFalseGenerator());
        alwaysLeftMaze = new BinaryTreeMaze(6, 6, new AlwaysTrueGenerator());
        alternatingLeftUpMaze = new BinaryTreeMaze(10, 10, new DefinedValuesGenerator(booleanArray));
    }
	
	@Test
	public void testDownPath() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDownPath() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDownPath() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDownPath() {
		fail("Not yet implemented");
	}

}
