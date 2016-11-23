package test;

import static org.junit.Assert.*;

import org.junit.Test;

import GravityGolfGame.BoardCell;

public class BallMovementTest {
	
	
	
	
	@Test
	public void BoardCellContains() {
		BoardCell cell = new BoardCell(20,30, false, false);
		
		
		//This tests to see if a boardcell can contain a Circle
		assertEquals(true, cell.containsBall());
		
		//This tests to see if a boardcell can contain a Triangle
		assertEquals(true, cell.containsTriangle());
		
		
		//Still needs to set up more, but tests to see if It changes it x location
		assertEquals(15, cell.getX());
		
		//Still needs to set up more, but tests to see if It changes it y location
		assertEquals(15, cell.getX());
		
	}
	

}
