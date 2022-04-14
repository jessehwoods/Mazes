package booleangenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DefinedValuesGeneratorTest {

	/**
	 * Generator to use in the tests that will return true on odd and false on even.
	 */
	private BooleanGenerator generator1;
	
	/**
	 * Generator to use in the tests that will return false on odd and true on even.
	 */
	private BooleanGenerator generator2;
	
	/**
	 * A boolean array that will return true on odd and false on even.
	 */
	private static boolean[] booleanArray1 = {false, true, false, true};
	
	/**
	 * A boolean array that will return false on every number divisible by 5.
	 */
	private static boolean[] booleanArray2 = {false, true, true, true, true};
	
    /**
     * Create a new instance of the generator before each test.
     */ 
    @Before
    public void setUp() {
        generator1 = new DefinedValuesGenerator(booleanArray1);
        generator2 = new DefinedValuesGenerator(booleanArray2);
    }
	
	/**
	 * Make sure that the generators return the expected values.
	 */
	@Test
	public void testGetBoolean() {
		assertFalse(generator1.getBoolean(0));
		assertFalse(generator2.getBoolean(0));
		
		assertTrue(generator1.getBoolean(1));
		assertTrue(generator2.getBoolean(1));
		
		assertFalse(generator1.getBoolean(2));
		assertTrue(generator2.getBoolean(2));
		
		assertTrue(generator1.getBoolean(3));
		assertTrue(generator2.getBoolean(3));
		
		assertFalse(generator1.getBoolean(4));
		assertTrue(generator2.getBoolean(4));
		
		assertTrue(generator1.getBoolean(5));
		assertFalse(generator2.getBoolean(5));

		assertFalse(generator1.getBoolean(6));
		assertTrue(generator2.getBoolean(6));
		
		assertTrue(generator1.getBoolean(7));
		assertTrue(generator2.getBoolean(7));
	}
	
	/**
	 * Check that an exception is thrown by a negative input.
	 */
	@Test
	public void testNegativeInput() {
		try {
			generator1.getBoolean(-1);
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			generator2.getBoolean(-1);
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	/**
	 * Check that an exception is thrown when creating a generator with an empty array.
	 */
	@Test
	public void testInvalidConstruction() {
		try {
			generator1 = new DefinedValuesGenerator(null);
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			boolean[] invalidArray = {};
			generator1 = new DefinedValuesGenerator(invalidArray);
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

}
