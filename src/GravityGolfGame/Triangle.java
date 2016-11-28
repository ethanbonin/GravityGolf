package GravityGolfGame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Triangle extends JComponent {
	
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
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g){
		// Original Points
		double[] xPointsExact = {0, 0, 1};
		double[] yPointsExact = {0, 1, 1};
		if (type == Type._60){ xPointsExact[2] = 0.6; }
		if (type == Type._30){ yPointsExact[0] = 0.4; }
		
		// Flip based on orientation
		if(orientation == Orientation.UP){
			xPointsExact[0] = xPointsExact[2];
			if (type == Type._60) {
				for (int i = 0; i < xPointsExact.length; i++) {
					xPointsExact[i] += 0.4;
				}
			}
		} 
		else if(orientation == Orientation.LEFT){
			xPointsExact[1] = xPointsExact[2];
			yPointsExact[1] = yPointsExact[0];
			if (type == Type._60) {
				for (int i = 0; i < xPointsExact.length; i++) {
					xPointsExact[i] += 0.4;
				}
			}
		}
		else if(orientation == Orientation.DOWN){
			yPointsExact[2] = yPointsExact[0];
		}
		
		// Scale and Translate
		// Probably will need to change this based on board drawing
		for (int i = 0; i < xPointsExact.length; i++){
			xPointsExact[i] *= GameEngine.CELL_SIZE;
			yPointsExact[i] *= GameEngine.CELL_SIZE;
			
			xPointsExact[i] += pos.getX();
			yPointsExact[i] += pos.getYUp();
		}
		
		// Round to integer
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		for (int i = 0; i < xPointsExact.length; i++){
			xPoints[i] = (int) xPointsExact[i];
			yPoints[i] = (int) yPointsExact[i];
		}
		
		g.setColor(color);
		g.fillPolygon(xPoints, yPoints, xPoints.length);
		
		return;
	}
	
	public void setPosition(BoardCell p) { pos = p; }
	public BoardCell getPosition() { return pos; }
	
	public void setOrientaion(Orientation o) { orientation = o; }
	public Orientation getOrientation() { return orientation; }
	
	public Type getType(){ return type; }
	
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
