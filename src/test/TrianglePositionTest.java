package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import GravityGolfGame.BoardCell;
import GravityGolfGame.Orientation;
import GravityGolfGame.Triangle;
import GravityGolfGame.Triangle.Type;
import GravityGolfGame.Vector;

public class TrianglePositionTest {

	// Right facing angle test
	Triangle triRight45;
	Triangle triRight30;
	Triangle triRight60;
	
	// Other Facing and Oriented Triangles
	Triangle triUp45;
	Triangle triLeft45;
	Triangle triDown45;
	
	// Setup
	@BeforeClass
	public void setup(){
		triRight45 = new Triangle(new BoardCell(5, 5), Type._45, Orientation.RIGHT);
		triRight30 = new Triangle(new BoardCell(5, 5), Type._30, Orientation.RIGHT);
		triRight60 = new Triangle(new BoardCell(5, 5), Type._60, Orientation.RIGHT);
		
		triUp45 = new Triangle(new BoardCell(5, 5), Type._45, Orientation.UP);
		triLeft45 = new Triangle(new BoardCell(5, 5), Type._45, Orientation.LEFT);
		triDown45 = new Triangle(new BoardCell(5, 5), Type._45, Orientation.DOWN);
		
	}
	
	/* Probably don't need these
	@Test
	public void testPos(){
		
		
	}
	
	@Test
	public void testOrientation(){
		
	}
	*/
	
	// Testing the normal for the triangle at different orientations and angles
	@Test
	public void testNormal(){
		
		// Test Non-Hypotenuse Sides
		assertEquals(triRight45.getNormal(Orientation.LEFT), new Vector(0, -1));
		assertEquals(triRight45.getNormal(Orientation.DOWN), new Vector(-1, 0));
		
	}
	
}
