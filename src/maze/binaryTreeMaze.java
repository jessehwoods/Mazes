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
		//TODO
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
	 * An abstract class that will be instantiated in versions for up, down, left, and right, to ensure taht
	 * they all use comparable logic and validation procedures.
	 * 
	 * @author Jesse Woods
	 *
	 */
	private abstract static class PathFinder {
		
		/**
		 * External method that is the access point for determining if a node has a desire path by the
		 * methods of binaryTreeMaze.
		 * @param row is the row of the node to examine.
		 * @param column is the column of the node to examine.
		 * @param height is the height of the maze.
		 * @param width is the width of the maze.
		 * @param seed is the seed to be used by the pseudorandom number generator.
		 * @return true if the requested path type exists, false if it does not.
		 */
		protected boolean isPath(int row, int column, int height, int width, int seed) {
			//Make sure the node coordinates are valid for the size of the map
			if(row >= height || column >= width) {
				throw new IllegalArgumentException("That node is outside the maze.");
			}
			//Pass it to the method used for this inquiry
			return calculatePath(row, column, height, width, seed);
		}

		/**
		 * This is the method that will need to be overriden and filled in with content by the sub-classes, 
		 * where the logic for figuring out what to do will reside.
		 * @param row is the row of the node to examine.
		 * @param column is the column of the node to examine.
		 * @param height is the height of the maze.
		 * @param width is the width of the maze.
		 * @param seed is the seed to be used by the pseudorandom number generator.
		 * @return true if the requested path type exists, false if it does not.
		 */
		private static boolean calculatePath(int row, int column, int height, int width, int seed) {
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

}
