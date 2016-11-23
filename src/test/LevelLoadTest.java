package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import GravityGolfGame.Ball;
import GravityGolfGame.Board;

public class LevelLoadTest {
	
	@BeforeClass
	public static void setup(){
		Board board = Board.getInstance();
		board.setConfigFiles("GravityGolfBoard.csv");
	}
	
	@Test
	public void testBoardLoad() {
		assertEquals(true, Board.getCellAt(24, 25).getInitial() == 'W');
		assertEquals(true, Board.getCellAt(24, 0).getInitial() == 'E');
		assertEquals(true, Board.getCellAt(0, 4).getInitial() == 'N');
		assertEquals(true, Board.getCellAt(24, 1).getInitial() == 'S');
	}
}
