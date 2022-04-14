package maze;

/**
 * Interface defining the behavior of a maze that can be accessed as a group of
 * nodes arranged on a 2d plane, with cartesian coordinates (row, column), with
 * orthogonal (up, down, left, right) connections.
 * 
 * The nodes are assumed to be on a 2d plane with the coordinate (0,0) at the topmost,
 * leftmost position. So adding to row moves downward and adding to column moves right.
 * 
 * @author Jesse Woods
 *
 */
public interface TwoDeeOrthoMaze {

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
	 * @param row is the row of the node to check. Moving downward as it increases from zero.
	 * @param column is the columns of the node to check. Moving rightward as it increases from zero.
	 * @return whether there is an up path from this node.
	 * @throws IllegalArgumentException if row or column is outside the maze limits.
	 */
	public boolean upPath(int row, int column);

	/**
	 * Tells you if the node at the given row and column has a path going down.
	 * @param row is the row of the node to check. Moving downward as it increases from zero.
	 * @param column is the columns of the node to check. Moving rightward as it increases from zero.
	 * @return whether there is a down path from this node.
	 * @throws IllegalArgumentException if row or column is outside the maze limits.
	 */
	public boolean downPath(int row, int column);
	
	/**
	 * Tells you if the node at the given row and column has a path going left.
	 * @param row is the row of the node to check. Moving downward as it increases from zero.
	 * @param column is the columns of the node to check. Moving rightward as it increases from zero.
	 * @return whether there is a left path from this node.
	 * @throws IllegalArgumentException if row or column is outside the maze limits.
	 */
	public boolean leftPath(int row, int column);
	
	/**
	 * Tells you if the node at the given row and column has a path going right.
	 * @param row is the row of the node to check. Moving downward as it increases from zero.
	 * @param column is the columns of the node to check. Moving rightward as it increases from zero.
	 * @return whether there is a right path from this node.
	 * @throws IllegalArgumentException if row or column is outside the maze limits.
	 */
	public boolean rightPath(int row, int column);
	
}
