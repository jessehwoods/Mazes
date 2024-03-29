package booleangenerator;

/**
 * BooleanGenerator that always generates a value of true.
 * 
 * @author Jesse Woods
 *
 */
public class AlwaysTrueGenerator implements BooleanGenerator {

	@Override
	public boolean getBoolean(int value) {
		if(value < 0) {
			throw new IllegalArgumentException("Value cannot be negative.");
		}
		return true;
	}

}
