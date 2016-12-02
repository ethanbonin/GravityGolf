package GravityGolfGame;

public class BallBounce extends Ball {

	private Vector normal;
	private int slopeAngle;
	private double newVectorX;
	private double newVectorY;

	public BallBounce(Vector normal, int slopeAngle) {
		super();
		this.normal = normal;
		this.slopeAngle = slopeAngle;
	}

	public void getNewTrajectory() {
		// get current velocity and trajectory of the ball
		Vector tangent = new Vector();

		// if the first encounter of an object make the x component nonzero
		if (this.getTrajectory().getX() == 0) {
			this.setTrajectory(new Vector(1, 1));
		}

		tangent = Vector.sub(this.getTrajectory(), normal);

		// get new X component of vector
		newVectorX = tangent.getX() * Math.cos(Math.toRadians(slopeAngle))
				+ normal.getX() * Math.cos(Math.toRadians(90 - slopeAngle));

		// get new Y component of vector
		newVectorY = tangent.getY() * Math.sin(Math.toRadians(slopeAngle))
				+ normal.getY() * Math.sin(Math.toRadians(90 - slopeAngle));

		this.setTrajectory(new Vector(newVectorX, newVectorY));
	}

	public Vector getNewVelocity() {
		Vector terminalVelocity = this.getVelocity();
		double newVelocityX = terminalVelocity.getMag() * newVectorX;
		double newVelocityY = terminalVelocity.getMag() * newVectorY;

		return new Vector(newVelocityX, newVelocityY);
	}

}
