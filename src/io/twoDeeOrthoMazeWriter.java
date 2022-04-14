package io;

import maze.TwoDeeOrthoMaze;

/**
 * Takes a twoDeeOrthMaze object and creates a String representation of it.
 * Represents walls as #'s, nodes as O's and paths as whitespace.
 * 
 * @author Jesse Woods
 *
 */
public class twoDeeOrthoMazeWriter {
	
	/**
	 * Holds the maze to be written out.
	 */
	private TwoDeeOrthoMaze maze;
	
	/**
	 * Constructor takes an appropriate object so that it can be written.
	 * 
	 * @param input
	 */
	public twoDeeOrthoMazeWriter(TwoDeeOrthoMaze input) {
		this.maze = input;
	}
	
	/**
	 * Called to get a string representation of the maze. 
	 * 
	 * Each node will be in the center of a 3x3 grid. If there is a path up, down, left, or right from the
	 * node, then that space will be empty. If there is no path, then there will be a hash mark to represent
	 * the wall there.
	 * 
	 * @return
	 */
	public String writeMaze() {
		StringBuilder mazeSB = new StringBuilder();
		//Iterate the rows of the maze, three times each
		for(int i = 0; i < maze.height(); i++) {//Iterates rows
			for(int j = 0; j < maze.width(); j++) {//Iterates columns in rows
				for(int k = 0; i < 3; k++) {//Iterates the 3 lines of output for each row
					
				}
			}
		}
		
		return mazeSB.toString();
	}
}
