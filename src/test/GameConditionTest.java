package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import GravityGolfGame.Ball;
import GravityGolfGame.Board;

public class GameConditionTest {
	
	private static Ball testBall;
	private static Board board;
	
		@BeforeClass
		public static void setup(){
			board = Board.getInstance();
			testBall = new Ball();
		}
		
		@Test
		public void testPause(){
			Board.pauseGame();
			assertEquals(false, testBall.isBallMoving());
		}
		
		@Test
		public void testWin(){
			assertEquals(true, Board.isGameOver());
		}
		
}
