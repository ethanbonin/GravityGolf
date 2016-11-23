package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import GravityGolfGame.Board;

public class GameConditionTest {

	
	
		@BeforeClass
		public void setup(){
			Board board = Board.getInstance();
		}
		
		@Test
		public void testPause(){
			
		}
		
		@Test
		public void testWin(){
			assertEquals(true, Board.isGameOver());
		}
		
}
