package GravityGolfGame;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	protected int x;
	protected int y;
	protected Vector velocity;
	protected Vector trajectory;
	private double radius;
	boolean isMoving;
	private Color color;
	
	public Ball() {
		x = 0;
		y = 0;
		this.isMoving = false;
		velocity = new Vector();
		radius = (double)(GameEngine.CELL_SIZE) / 2.0;
		this.trajectory = new Vector(0,1);
	}
	
	public void move(){
		x += velocity.getX();
		y += velocity.getY();
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
		g.fillOval(x * GameEngine.CELL_SIZE, y * GameEngine.CELL_SIZE, (int)radius * 2, (int)radius * 2);
		
		return;
	}

	public boolean isBallMoving() {
		
		return isMoving;
	}

}
