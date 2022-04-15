package io;

import static org.junit.Assert.*;

import org.junit.Test;

import booleangenerator.AlwaysFalseGenerator;
import booleangenerator.AlwaysTrueGenerator;
import maze.BinaryTreeMaze;
import maze.TwoDeeOrthoMaze;

public class twoDeeOrthoMazeWriterTest {

	@Test
	public void test() {
		TwoDeeOrthoMaze toWrite = new BinaryTreeMaze(5, 5, new AlwaysFalseGenerator());
		TwoDeeOrthoMazeWriter writer = new TwoDeeOrthoMazeWriter(toWrite);
		assertEquals("", writer.writeMaze());
	}

}
