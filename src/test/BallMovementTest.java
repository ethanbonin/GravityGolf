package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import GravityGolfGame.Ball;
import GravityGolfGame.Board;
import GravityGolfGame.BoardCell;
import GravityGolfGame.GameEngine;


public class BallMovementTest {
	
	private static GameEngine gameEngine;
	@BeforeClass
	public static void setUp() {
		// Board is singleton, get the only instance and initialize it		
		gameEngine = GameEngine.theInstance();
	}
	@Test
	public void BoardCellContains() {

		Ball ball = new Ball();
		//ball.setStartLocation(0, 20);
		
		//Testing before the ball moves to make it is in its starting location
		assertEquals(2, ball.getX());
		assertEquals(20, ball.getY());
		
		ball.move();
		assertFalse(ball.getY() == 20);
		assertFalse(ball.getX() == 2);
		
		
		
		//Still needs to set up more, but tests to see if It changes it x location
		
		
		
		
		//Still needs to set up more, but tests to see if It changes it y location
		
		
	}
	

}
