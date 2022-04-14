package booleangenerator;

/**
 * BooleanGenerator that always generates a value of false.
 * 
 * @author Jesse Woods
 *
 */
public class AlwaysFalseGenerator implements BooleanGenerator{

	@Override
	public boolean getBoolean(int kValue) {
		return false;
	}
	
}
