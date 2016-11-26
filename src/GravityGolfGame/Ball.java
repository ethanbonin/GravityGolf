package GravityGolfGame;

public class Ball {

	public Ball() {
		x = 0;
		y = 0;
	}
	
	int x;
	int y;
	Vector velocity;
	
	boolean isMoving;
	
	public void move(){
		x += velocity.getX();
		y += velocity.getY();
	}
	
	public void setVelocity(Vector v){ velocity = v; }
	public Vector getVelocity(){ return velocity; }
	public int getX(){ return x; }
	public int getY(){ return y; }

	public boolean isBallMoving() {
		
		return isMoving;
	}

}
