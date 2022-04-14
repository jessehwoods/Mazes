package booleangenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlwaysFalseGeneratorTest {

	/**
	 * Generator to use in the tests.
	 */
	private BooleanGenerator generator;
	
    /**
     * Create a new instance of the generator before each test.
     */ 
    @Before
    public void setUp() {
        generator = new AlwaysFalseGenerator();
    }
	
	/**
	 * Just making sure that it always returns false. Nothing much else to examine.
	 */
	@Test
	public void testGetBoolean() {
		for(int i = 0; i < 100; i++) {
			assertFalse(generator.getBoolean(i));
		}
	}
	
	/**
	 * Check that an exception is thrown by a negative input.
	 */
	@Test
	public void testNegativeInput() {
		try {
			generator.getBoolean(-1);
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

}
