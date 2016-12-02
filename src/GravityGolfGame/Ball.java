package GravityGolfGame;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	public static double VELOCITY_CONSTANT = 1.0;
	public static double ACCELERATION_CONSTANT = 1.0;
	protected int x;
	protected int y;
	protected int originalX;
	protected int originalY;
	protected Vector velocity;
	protected Vector trajectory;
	private double radius;
	boolean isMoving;
	private Color color;
	
	public Ball() {
		setStartLocation(2,20);
		this.isMoving = false;
		velocity = new Vector(0,1);
		radius = (double)(GameEngine.CELL_SIZE) / 2.0;
		this.trajectory = new Vector(0,1);
	}
	
	public void setStartLocation(int startLocationX, int startLocationY) {
		this.x = startLocationX;
		this.y = startLocationY;
		this.originalX = startLocationX;
		this.originalY = startLocationY;
	}
	
	//We need to initialize velocity when the start button is pressed(1,0) or something
	
	public void move(){
		//x += velocity.getX();
		//y += velocity.getY();
		Vector moveVector = new Vector();
		moveVector = Vector.mult(velocity, trajectory);
		this.x += moveVector.getX();
		this.y += moveVector.getY();
	}
	
	
	public Vector getTrajectory() {
		return trajectory;
	}

	public void setTrajectory(Vector trajectory) {
		this.trajectory = trajectory;
	}

	public void setPosition(int xPos, int yPos){
		// flip rows and cols
		y = xPos;
		x = yPos;
	}
	public void setVelocity(Vector v){ velocity = v; }
	public Vector getVelocity(){ return velocity; }
	public int getX(){ return x; }
	public int getY(){ return y; }
	public double getRadius(){ return radius; }
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(x, y, (int)radius * 2, (int)radius * 2);
		return;
	}

	public boolean isBallMoving() {
		return isMoving;
	}

	public void reset() {
		this.x = this.originalX;
		this.y = this.originalY;
	}

}
