package test;

import static org.junit.Assert.*;

import org.junit.Test;

import GravityGolfGame.Ball;
import GravityGolfGame.BoardCell;
import GravityGolfGame.GameEngine;

public class BallMovementTest {
	
	
	
	
	@Test
	public void BoardCellContains() {
		
		//This tests to see if a boardcell can contain a Triangle
		
		Ball ball = new Ball();
		ball.setStartLocation(0, 20);

		
		//Testing before the ball moves to make it is in its starting location
		assertEquals(0, ball.getX());
		assertEquals(20, ball.getY());
		
		ball.move();
		assertEquals(20, ball.getY());
		
		
		//Still needs to set up more, but tests to see if It changes it x location
		
		
		
		
		//Still needs to set up more, but tests to see if It changes it y location
		
		
	}
	

}
