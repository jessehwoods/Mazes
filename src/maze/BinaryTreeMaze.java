package maze;

import booleangenerator.BooleanGenerator;

/**
 * Implements the binary tree maze generation algorithm, which generates the maze by randomly
 * assigning one of two paths (left or up in this case) to all nodes except the row and column
 * furthest to the direction of movement (leftmost column and topmost row here). 
 * 
 * The only state to be maintained will be width, height, but I want the setup of the maze
 * to be static, so it will not change if it has to be accessed again, so I'm going to use a 
 * pseudorandom number generator with a seed. 
 * 
 * @author Jesse Woods
 *
 */

public class BinaryTreeMaze implements TwoDeeOrthoMaze {
	
	/**
	 * Stores the width of the maze.
	 */
	private int width;
	
	/**
	 * Stores the height of the maze.
	 */
	private int height;
	
	/**
	 * Object that generates a boolean value for use in generating the maze.
	 */
	private BooleanGenerator generator;

	/**
	 * Paramaterized constructor including seed to be used in pseudorandom number generator.
	 * @param height height of the maze to be generated.
	 * @param width width of the maze to be generated.
	 * @param seed seed to be used in pseudorandom number generation.
	 */
	public BinaryTreeMaze(int height, int width, BooleanGenerator generator) {
		this.height = height;
		this.width = width;
		this.generator = generator;
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
		//Throw an exception if node is invalid
		validateCoordinates(row, column);
		//Check if this is the root (0,0), because that coordinate has neither a left nor up path.
		if(row == 0 && column == 0) {
			return false;
		}
		//Otherwise, every location has to be either left or up, so just return the opposite of left
		return !leftPath(row, column);
	}

	@Override
	public boolean downPath(int row, int column) {
		//Throw an exception if node is invalid
		validateCoordinates(row, column);
		//If this is the lowest row, then there cannot be a path down
		if(row == height - 1) {
			return false;
		}
		//Otherwise, we just check if the next cell down has an up path
		return upPath(row + 1, column);
	}

	@Override
	public boolean leftPath(int row, int column) {
		//Throw an exception if node is invalid
		validateCoordinates(row, column);
		//If it's the top row, then if has to be left, unless it's root
		if(row == 0 && column != 0) {
			return true;
		}
		//If it's the leftmost column, then it cannot be going left
		if(column == 0) {
			return false;
		}
		//Otherwise, use the pseudorandom generator, which should only be used here so that
		//the other path methods can derive their values from leftPath()
		return generator.getBoolean(row + column);
	}

	@Override
	public boolean rightPath(int row, int column) {
		//Throw an exception if node is invalid
		validateCoordinates(row, column);
		// If this is the rightmost columns, then there can't be a right path
		if(column == width - 1) {
			return false;
		}
		//Otherwise, check if the right neighbor has a leftward path
		return leftPath(row, column + 1);
	}
	
	/**
	 * Method to throw an exception if the given row and column are not in the maze limits.
	 * 
	 * Should be called any time a set of coordinates is entered.
	 */
	private void validateCoordinates(int row, int column) {
		if(row >= height || row < 0) {
			throw new IllegalArgumentException("The provided row is outside the maze.");
		} 
		else if(column >= width || column < 0) {
			throw new IllegalArgumentException("The provided column is outside the maze.");
		}
	}

}
