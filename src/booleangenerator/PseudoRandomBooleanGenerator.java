package booleangenerator;

/**
 * Generates a pseudorandom boolean based on the height, width, and random seed of the maze,
 * the requested row, and the requested column. Because this is not random, the results for the same 
 * coordinate of the same maze will always be the same. 
 * 
 * However, it will only have a single output for any given coordinate.
 *
 * This uses a linear congruential sequence. I'll be using the closed form equation:
 * X_n+k = (akX_n + (a^k - 1)c/b) mod m, k >= 0, n >= 0
 *
 *@author Jesse Woods
 *
 */
public class PseudoRandomBooleanGenerator implements BooleanGenerator{


	public PseudoRandomBooleanGenerator(int seed) {
		//TODO
	}

	@Override
	public boolean getBoolean(int kValue) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
