package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import GravityGolfGame.BoardCell;
import GravityGolfGame.Orientation;
import GravityGolfGame.Triangle;
import GravityGolfGame.Triangle.Type;
import GravityGolfGame.Vector;

public class TriangleInteractTest {

	// Right facing angle test
	Triangle triRight45 = new Triangle(new BoardCell(5, 5), Type._45, Orientation.RIGHT);
	Triangle triRight30 = new Triangle(new BoardCell(5, 5), Type._30, Orientation.RIGHT);
	Triangle triRight60 = new Triangle(new BoardCell(5, 5), Type._60, Orientation.RIGHT);
	
	// Other Facing and Oriented Triangles
	Triangle triUp45 = new Triangle(new BoardCell(5, 5), Type._45, Orientation.UP);
	Triangle triLeft45 = new Triangle(new BoardCell(5, 5), Type._45, Orientation.LEFT);
	Triangle triDown45 = new Triangle(new BoardCell(5, 5), Type._45, Orientation.DOWN);
	
	// Testing the normal for the triangle at different orientations and angles
	@Test
	public void testNormal(){
		
		final double DELTA = 0.000001;
		
		// Test Non-hypotenuse Sides
		assertEquals(new Vector(-1, 0), triRight45.getNormal(Orientation.LEFT));
		assertEquals(new Vector(0, -1), triRight45.getNormal(Orientation.DOWN));
		
		// Test Angles
		// Test 30
		assertEquals(0.5, triRight30.getNormal(Orientation.UP).getX(), DELTA);
		assertEquals(0.866025, triRight30.getNormal(Orientation.UP).getY(), DELTA);
		
		// Test 45
		assertEquals(0.707107, triRight45.getNormal(Orientation.UP).getX(), DELTA);
		assertEquals(0.707107, triRight45.getNormal(Orientation.UP).getY(), DELTA);
		
		// Test 60
		assertEquals(0.5, triRight60.getNormal(Orientation.UP).getY(), DELTA);
		assertEquals(0.866025, triRight60.getNormal(Orientation.UP).getX(), DELTA);
		
		// Test Orientations
		// Up
		assertEquals(-0.707107, triUp45.getNormal(Orientation.LEFT).getX(), DELTA);
		assertEquals(0.707107, triUp45.getNormal(Orientation.LEFT).getY(), DELTA);
		
		// Left
		assertEquals(-0.707107, triLeft45.getNormal(Orientation.LEFT).getX(), DELTA);
		assertEquals(-0.707107, triLeft45.getNormal(Orientation.LEFT).getY(), DELTA);
		
		// Down
		assertEquals(0.707107, triDown45.getNormal(Orientation.DOWN).getX(), DELTA);
		assertEquals(-0.707107, triDown45.getNormal(Orientation.DOWN).getY(), DELTA);
		
	}
	
}
