package GravityGolfGame;

public class BallBounce extends Ball {

	private Vector normal;
	private Vector incomingTrajectory;
	private int slopeAngle;
	private double newVectorX;
	private double newVectorY;
	
	

	public BallBounce(Vector normal, Vector incomingTrajectory, int slopeAngle) {
		super();
		this.normal = normal;
		this.incomingTrajectory = incomingTrajectory;
		this.slopeAngle = slopeAngle;
	}



	public Vector getNewTrajectory() {
		// get current velocity and trajectory of the ball
		Vector tangent = new Vector();
		tangent.sub(incomingTrajectory, normal);
		
		// get new X component of vector
		newVectorX = tangent.getX() * Math.cos(Math.toRadians(slopeAngle))
				+ normal.getX() * Math.cos(Math.toRadians(90 - slopeAngle));

		// get new Y component of vector
		newVectorY = tangent.getY() * Math.cos(Math.toRadians(slopeAngle))
				+ normal.getY() * Math.cos(Math.toRadians(90 - slopeAngle));

		return new Vector(newVectorX,newVectorY);
	}
	
	public Vector getNewVelocity() {
		Vector terminalVelocity = this.getVelocity();
		double newVelocityX = terminalVelocity.getMag() * newVectorX;
		double newVelocityY = terminalVelocity.getMag() * newVectorY;
		
		return new Vector(newVelocityX, newVelocityY);
	}

}
