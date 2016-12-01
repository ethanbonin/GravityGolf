package GravityGolfGame;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	public Ball() {
		x = 0;
		y = 0;
		velocity = new Vector();
	}
	
	int x;
	int y;
	Vector velocity;
	double radius;
	
	boolean isMoving;
	
	private Color color;
	
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
	public int getX(){ return x; }
	public int getY(){ return y; }
	
	public void draw(Graphics g){
		
		g.setColor(Color.RED);
		g.fillOval(x * GameEngine.CELL_SIZE, y * GameEngine.CELL_SIZE, GameEngine.CELL_SIZE, GameEngine.CELL_SIZE);
		
		return;
	}

	public boolean isBallMoving() {
		
		return isMoving;
	}

}
