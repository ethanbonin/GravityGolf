package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import GravityGolfGame.Ball;
import GravityGolfGame.BallBounce;
import GravityGolfGame.Board;
import GravityGolfGame.BoardCell;
import GravityGolfGame.GameEngine;
import GravityGolfGame.Vector;


public class BallMovementTest {
	
	private static GameEngine gameEngine;
	@BeforeClass
	public static void setUp() {
		// Board is singleton, get the only instance and initialize it		
		gameEngine = GameEngine.theInstance();
	}
	
	@Test
	public void BallMovesFromInitialPosition() {

		Ball ball = new Ball();
		ball.setStartLocation(2, 20);
		
		//Testing before the ball moves to make it is in its starting location
		assertEquals(2, ball.getX());
		assertEquals(20, ball.getY());
		
		ball.move();
		//only test y movement because initial trajectory is always straight down
		assertFalse(ball.getY() == 20);	
	}

}
