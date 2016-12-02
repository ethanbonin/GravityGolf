package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import GravityGolfGame.Ball;
import GravityGolfGame.Board;
import GravityGolfGame.BoardCell;

public class GameConditionTest {
	
	private static Ball testBall = new Ball();
	private static Board board;
	private static BoardCell testCell = new BoardCell(1, 1, false, true);
	
	
		@BeforeClass
		public static void setup(){
			board = Board.getInstance();
			board.load();
			testBall.setStartLocation(10, 24);
		}
		
		@Test
		public void testPause(){
			Board.pauseGame();
			assertEquals(false, testBall.isBallMoving());
		}
		
		@Test
		public void testWin(){
			assertEquals(true, Board.isGameOver(testBall));
		}
		
}
