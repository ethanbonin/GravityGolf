package GravityGolfGame;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	public static double VELOCITY_CONSTANT = 1.0;
	public static double ACCELERATION_CONSTANT = 1.0;
	protected double x;
	protected double y;
	protected int originalX;
	protected int originalY;
	protected Vector velocity;
	protected Vector trajectory;
	private double radius;
	boolean isMoving;
	private Color color;
	
	public Ball() {
		//setStartLocation(2,20); //needs to be set elsewhere
		this.isMoving = false;
		velocity = new Vector(0,1);
		radius = (double)(GameEngine.CELL_SIZE) / 2.0;
		this.trajectory = new Vector(0,1);
	}
	
	public void setStartLocation(int startLocationX, int startLocationY) {
		this.y = startLocationX;
		this.x = startLocationY;
		this.originalY = startLocationX;
		this.originalX = startLocationY;
	}
	
	//We need to initialize velocity when the start button is pressed(1,0) or something
	
	public void move(){
		x += velocity.getX();
		y += velocity.getY();
	}

	public void setPosition(int xPos, int yPos){
		// flip rows and cols
		y = xPos;
		x = yPos;
	}
	public void setVelocity(Vector v){ velocity = v; }
	public Vector getVelocity(){ return velocity; }
	public double getX(){ return x; }
	public double getY(){ return y; }
	public double getRadius(){ return radius; }
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillOval((int)x, (int)y, (int)radius * 2, (int)radius * 2);
		return;
	}

	public void reset() {
		this.x = this.originalX;
		this.y = this.originalY;
	}
	
	public boolean isBallMoving() {
		return isMoving;
	}

}
