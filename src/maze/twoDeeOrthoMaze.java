package maze;

/**
 * Interface defining the behavior of a maze that can be accessed as a group of
 * nodes arranged on a 2d plane, with cartesian coordinates (row, column), 
 * orthogonal (up, down, left, right) connections, and all paths can be assumed 
 * to be two-way (so if (0,0) connects to (0,1), then the reverse is also true).
 * 
 * The nodes are assumed to be on a 2d plane with the coordinate (0,0) at the topmost,
 * leftmost position. So an adding to row moves downward and add to column moves right.
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
	 * @throws IllegalArgumentException if row or column is outside the maze limits.
	 */
	public boolean upPath(int row, int column);

	/**
	 * Tells you if the node at the given row and column has a path going down.
	 * @param row is the row of the node to check.
	 * @param column is the columns of the node to check.
	 * @return whether there is a down path from this node.
	 * @throws IllegalArgumentException if row or column is outside the maze limits.
	 */
	public boolean downPath(int row, int column);
	
	/**
	 * Tells you if the node at the given row and column has a path going left.
	 * @param row is the row of the node to check.
	 * @param column is the columns of the node to check.
	 * @return whether there is a left path from this node.
	 * @throws IllegalArgumentException if row or column is outside the maze limits.
	 */
	public boolean leftPath(int row, int column);
	
	/**
	 * Tells you if the node at the given row and column has a path going right.
	 * @param row is the row of the node to check.
	 * @param column is the columns of the node to check.
	 * @return whether there is a right path from this node.
	 * @throws IllegalArgumentException if row or column is outside the maze limits.
	 */
	public boolean rightPath(int row, int column);
	
}
