package maze;

/**
 * Interface defining the behavior of a maze that can be accessed as a group of
 * nodes arranged on a 2d plane, with cartesian coordinates (row, column), only 
 * orthogonal (up, down, left, right) connections, and all paths can be assumed 
 * to be two-way.
 * 
 * @author Jesse Woods
 *
 */
public interface twoDeeOrthoMaze {

	/**
	 * Tells you how many columns are in the maze.
	 * @return number of columns.
	 */
	public int width();
	
	/**
	 * Tells you how many rows are in the maze.
	 * @return number of rows.
	 */
	public int height();
	
	/**
	 * Tells you if the node at the given row and column has a path going up.
	 * @param row is the row of the node to check.
	 * @param column is the columns of the node to check.
	 * @return whether there is an up path from this node.
	 */
	public boolean upPath(int row, int column);

	/**
	 * Tells you if the node at the given row and column has a path going down.
	 * @param row is the row of the node to check.
	 * @param column is the columns of the node to check.
	 * @return whether there is a down path from this node.
	 */
	public boolean downPath(int row, int column);
	
	/**
	 * Tells you if the node at the given row and column has a path going left.
	 * @param row is the row of the node to check.
	 * @param column is the columns of the node to check.
	 * @return whether there is a left path from this node.
	 */
	public boolean leftPath(int row, int column);
	
	/**
	 * Tells you if the node at the given row and column has a path going right.
	 * @param row is the row of the node to check.
	 * @param column is the columns of the node to check.
	 * @return whether there is a right path from this node.
	 */
	public boolean rightPath(int row, int column);
	
}
