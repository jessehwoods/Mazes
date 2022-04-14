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
	 * Character to be used in representing walls.
	 */
	private static char wall = '#';
	
	/**
	 * Character to be used in representing paths.
	 */
	private static char path = ' ';
	
	/**
	 * Character to be used in representing nodes.
	 */
	private static char node = 'O';
	
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
			for(int j = 0; j < maze.width(); j++) {//Iterates the up paths
				mazeSB.append(wall);
				addWall(maze.upPath(i, j), mazeSB);
				mazeSB.append(wall);
			}
			for(int j = 0; j < maze.width(); j++) {//Iterates the left/right paths and nodes
				addWall(maze.upPath(i, j), mazeSB);
				mazeSB.append(node);
				addWall(maze.upPath(i, j), mazeSB);
			}
			for(int j = 0; j < maze.width(); j++) {//Iterates the down paths
				mazeSB.append(wall);
				addWall(maze.downPath(i, j), mazeSB);
				mazeSB.append(wall);
			}
		}
		
		return mazeSB.toString();
	}
	
	/**
	 * Puts a wall or a path depending on the value given.
	 * @param isWall whether this is meant to be a wall or not.
	 * @param mazeSB the StringBuilder to add the character to.
	 */
	private void addWall(boolean isWall, StringBuilder mazeSB) {
		if(isWall) {
			mazeSB.append(wall);
		}
		else {
			mazeSB.append(path);
		}
	}
}
