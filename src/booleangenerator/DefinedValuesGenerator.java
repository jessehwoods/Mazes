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
		this.array = array;
	}
	
	@Override
	public boolean getBoolean(int value) {
		return array[kValue % array.length];
	}

}
