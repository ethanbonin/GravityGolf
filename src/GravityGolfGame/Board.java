package GravityGolfGame;

public class Board {
	
	private static Board theInstance = new Board();
	
	private Board() {
		
	}
	
	public static Board getInstance() {
		return theInstance;
	}

	public static boolean isGameOver() {
		//I will create this method when more pars are implemented (Nick)
		//Player will win when the ball reaches a certain spot, simple condition statement
		//TO DO: Need to imlplement the ball
		
		return false;
	}
}
