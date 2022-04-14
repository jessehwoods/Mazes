package booleangenerator;

/**
 * BooleanGenerator object that takes an array of boolean values and then loops through them
 * using the provided kValue.
 * 
 * @author Jesse Woods
 *
 */
public class DefinedValuesGenerator implements BooleanGenerator {

	/** 
	 * Array of boolean values to return.
	 */
	boolean[] array;
	
	public DefinedValuesGenerator(boolean[] array) {
		if(array == null || array.length <= 0) {
			throw new IllegalArgumentException("Array of boolean values must contain at least 1 value.");
		}
		this.array = array;
	}
	
	@Override
	public boolean getBoolean(int value) {
		if(value < 0) {
			throw new IllegalArgumentException("Value cannot be negative.");
		}
		return array[value % array.length];
	}

}
