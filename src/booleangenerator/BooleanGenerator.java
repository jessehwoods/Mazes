package booleangenerator;

/**
 * Interface for object used to generate boolean values for the mazes. 
 * 
 * @author Jesse Woods
 *
 */
public interface BooleanGenerator {

	/**
	 * returns a boolean value according to a defined method.
	 * @param value is a positive integer that can be used in generating the boolean, so that it can be accessed again later and will, hopefully, be the same.
	 * @return a boolean value based on the kValue.
	 * @throws IllegalArgumentException if value is negative.
	 */
	public boolean getBoolean(int value);
	
	
}
