package GravityGolfGame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Triangle {
	
	public Triangle(BoardCell pos, Type type, Orientation ori) {
		this.pos = pos;
		this.type = type;
		orientation = ori;
		
		switch(type){
		case _30:
			theta = 30.0;
			color = Color.blue;
			break;
		case _45:
			theta = 45.0;
			color = Color.green;
			break;
		case _60:
			theta = 60.0;
			color = Color.orange;
			break;
		}
	}
	
	public enum Type{
		_30 ("30"),
		_45 ("45"),
		_60 ("60");
		
		private String name;
		
		Type(String name){ this.name = name; }
		public String toString(){ return name; }
	}
	
	private BoardCell pos;
	private Type type;
	private Orientation orientation;
	private double theta;
	private Color color;
	
	public void draw(Graphics g, BoardCell cell){
		// Original Points
		int[] xPoints = {0, 0, 1};
		int[] yPoints = {0, 1, 1};
		
		// Scale and Translate
		// Probably will need to change this based on board drawing
		for (int i = 0; i < xPoints.length; i++){
			xPoints[i] *= GameEngine.CELL_SIZE;
			yPoints[i] *= GameEngine.CELL_SIZE;
			
			xPoints[i] += cell.getX();
			yPoints[i] += cell.getYUp();
		}
		
		g.setColor(color);
		g.fillPolygon(xPoints, yPoints, xPoints.length);
		
		return;
	}
	
	public void setPosition(BoardCell p) { pos = p; }
	public BoardCell getPosition() { return pos; }
	
	public Orientation getOrientation() { return orientation; }
	
	public Vector getNormal(Orientation side) {

		// Determine Side Vector
		Vector sideNorm = calcSideVector(side);
		
		// Calculate Default Normal
		double x = Math.cos(Math.toRadians(90 - theta));
		double y = Math.sin(Math.toRadians(90 - theta));

		// Determine triangle orientation and set normal
		switch (orientation) {
		case RIGHT:
			break;
		case UP:
			x = -x;
			break;
		case LEFT:
			x = -x;
			y = -y;
			break;
		case DOWN:
			y = -y;
			break;
		default:
			System.out.println("Incorrect Orientation. Triangle.getNormal()");
			break;
		}
		
		Vector norm = new Vector(x, y);
		
		// Determine which normal to return
		double angle = Math.toDegrees(Math.acos(Math.toRadians(Vector.dot(sideNorm, norm))));
		if (angle < 90 && angle > 0){
			return norm;
		}
		else {
			return sideNorm;
		}
	}
	
	private Vector calcSideVector(Orientation side){
		
		if (side == Orientation.RIGHT){
			return new Vector(1, 0);
		} else if (side == Orientation.UP){
			return new Vector(0, 1);
		} else if (side == Orientation.LEFT){
			return new Vector(-1, 0);
		} else if (side == Orientation.DOWN){
			return new Vector(0, -1);
		}
		else {
			System.out.println("Incorrect Orientation. Triangle.getNormal() calcSideVector");
		}
		
		return null;
	}

}
