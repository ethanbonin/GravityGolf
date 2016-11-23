package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import GravityGolfGame.Ball;
import GravityGolfGame.Board;

public class GameConditionTest {

	
	
		@BeforeClass
		public void setup(){
			Board board = Board.getInstance();
			Ball testBall = new Ball();
		}
		
		@Test
		public void testPause(){
			Board.pauseGame();
			assertEquals(false, Ball.isBallMoving());
		}
		
		@Test
		public void testWin(){
			assertEquals(true, Board.isGameOver());
		}
		
}
