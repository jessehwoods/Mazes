package maze;

/**
 * Implements the binary tree maze generation algorithm, which generates the maze by randomly
 * assigning one of two paths (left and up in this case) to all nodes except the row and column
 * furthest to the direction of movement (leftmost column and topmost row here). 
 * 
 * The only state to be maintained will be width and height, but I want the setup of the maze
 * to be static, so it will not change if it has to be accessed again, so I'm going to use a 
 * pseudorandom number generator.
 * 
 * @author Jesse Woods
 *
 */

public class binaryTreeMaze implements twoDeeOrthoMaze {

	
	
	@Override
	public int width() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean upPath(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean downPath(int row, int column) {
		// TODO Auto-generated method stub
		return false;
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

}
