package maze;

/**
 * Implements the binary tree maze generation algorithm, which generates the maze by randomly
 * assigning one of two paths (left and up in this case) to all nodes except the row and column
 * furthest to the direction of movement (leftmost column and topmost row here). 
 * 
 * The only state to be maintained will be width, height, but I want the setup of the maze
 * to be static, so it will not change if it has to be accessed again, so I'm going to use a 
 * pseudorandom number generator with a seed. 
 * 
 * @author Jesse Woods
 *
 */

public class binaryTreeMaze implements twoDeeOrthoMaze {
	
	/**
	 * Stores the width of the maze.
	 */
	private int width;
	
	/**
	 * Stores the height of the maze.
	 */
	private int height;
	
	/**
	 * Stores the seed to be used in generating random values for the maze.
	 */
	private int seed;

	/**
	 * Paramaterized constructor including seed to be used in pseudorandom number generator.
	 * @param height height of the maze to be generated.
	 * @param width width of the maze to be generated.
	 * @param seed seed to be used in pseudorandom number generation.
	 */
	public binaryTreeMaze(int height, int width, int seed) {
		this.height = height;
		this.width = width;
		this.seed = seed;
	}
	
	@Override
	public int width() {
		return this.width;
	}

	@Override
	public int height() {
		return this.height;
	}

	@Override
	public boolean upPath(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean downPath(int row, int column) {
		//If this is the bottom edge of the maze, there is no path down
		if(row == row - 1) {
			return false;
		}
		//Whether there is a downward path is determined by whether the lower cell has an up path
		return upPath(row + 1, column);
	}

	@Override
	public boolean leftPath(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rightPath(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 
	 * @return a pseudorandom number based on the stored seed.
	 */
	private int pseudoRandomNumber() {
		//TODO
	}

}
