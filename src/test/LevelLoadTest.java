package test;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Test;

import GravityGolfGame.Ball;
import GravityGolfGame.Board;
import GravityGolfGame.GameEngine;

public class LevelLoadTest {
	
	private static Board board;
	
	@BeforeClass
	public static void setup(){
		board = Board.getInstance();
		InputStream rdr = GameEngine.theInstance().getClass().getResourceAsStream("/Data/GravityGolfBoard.csv");
		board.setConfigFiles(rdr);
		board.load();
	}
	
	@Test
	public void testBoardLoad() {
		assertEquals(true, board.getCellAt(24, 25).getInitial() == 'W');
		assertEquals(true, board.getCellAt(24, 0).getInitial() == 'E');
		assertEquals(true, board.getCellAt(0, 4).getInitial() == 'N');
		assertEquals(true, board.getCellAt(24, 1).getInitial() == 'S');
	}
}
