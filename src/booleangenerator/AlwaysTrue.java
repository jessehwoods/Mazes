package booleangenerator;

/**
 * BooleanGenerator that always generates a value of true.
 * 
 * @author Jesse Woods
 *
 */
public class AlwaysTrue implements BooleanGenerator {

	@Override
	public boolean getBoolean() {
		return true;
	}

}
