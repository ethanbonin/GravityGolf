package GravityGolfGame;

public class BallBounce {
	
	Vector inputVector;
	//BoardCell boardCell;
	Triangle triangle;
	
	
	public BallBounce(Vector inputVector, Triangle triangle) {
		super();
		//called from boardCell.containsBall() && boardCell.containsTriangle() 
		//from somewhere probably the timer function
		this.inputVector = inputVector;
		this.triangle = triangle;
	}
	
	public Vector getNewTrajectory() {
		//get current velocity and trajectory of the ball
		//return -angleOfIncidence 
		return inputVector;
	}
	

}
