package GravityGolfGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Triangle extends JComponent {
	
	public Triangle(BoardCell pos, Type type, Orientation ori) {
		this.pos = pos;
		this.type = type;
		orientation = ori;
		boundingBox = null;
		
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
	private Rectangle boundingBox;
	
	// TODO: Create Scale, Translate functions scaleTranslateX, Y (double[] x, int scaleFactor, int translateFactor)
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		int[] xPoints = scaleTranslateX(getXVert(), GameEngine.CELL_SIZE * 2, 0);
		int[] yPoints = scaleTranslateY(getYVert(), GameEngine.CELL_SIZE * 2, 0);

		g.setColor(color);
		g.fillPolygon(xPoints, yPoints, xPoints.length);

	}
	
	public void draw(Graphics g){
		// Points array calculations
		int[] xPoints = scaleTranslateX(getXVert(), GameEngine.CELL_SIZE, GameEngine.CELL_SIZE);
		int[] yPoints = scaleTranslateY(getYVert(), GameEngine.CELL_SIZE, GameEngine.CELL_SIZE);
		
		updateBoundingBox(xPoints, yPoints);
		
		g.setColor(color);
		g.fillPolygon(xPoints, yPoints, xPoints.length);
		
		return;
	}
	
	private double[] getXVert(){

		// Original Points
		double[] xPointsExact = { 0, 0, 1 };
		
		if (type == Type._60) {
			xPointsExact[2] = 0.6;
		}

		// Flip based on orientation
		if (orientation == Orientation.UP) {
			xPointsExact[0] = xPointsExact[2];
			if (type == Type._60) {
				for (int i = 0; i < xPointsExact.length; i++) {
					xPointsExact[i] += 0.4;
				}
			}
		} else if (orientation == Orientation.LEFT) {
			xPointsExact[1] = xPointsExact[2];
			if (type == Type._60) {
				for (int i = 0; i < xPointsExact.length; i++) {
					xPointsExact[i] += 0.4;
				}
			}
		}

		return xPointsExact;
	}
	
	private double[] getYVert(){

		// Original Points
		double[] yPointsExact = { 0, 1, 1 };
		
		if (type == Type._30) {
			yPointsExact[0] = 0.4;
		}

		// Flip based on orientation
		double offBy = yPointsExact[0];
		if (orientation == Orientation.LEFT) {
			yPointsExact[1] = yPointsExact[0];
			for (int i = 0; i < yPointsExact.length; i++) {
				yPointsExact[i] -= offBy;
			}
		} else if (orientation == Orientation.DOWN) {
			yPointsExact[2] = yPointsExact[0];
			for (int i = 0; i < yPointsExact.length; i++) {
				yPointsExact[i] -= offBy;
			}
		}

		return yPointsExact;
	}
	
	private int[] scaleTranslateX(double[] values, int scaleFactor, int translateFactor){
		
		// Scale and Translate
		for (int i = 0; i < values.length; i++) {
			values[i] *= scaleFactor;

			values[i] += pos.getX() * translateFactor - translateFactor;
		}

		// Round to integer
		int[] points = new int[3];
		for (int i = 0; i < points.length; i++) {
			points[i] = (int) values[i];
		}

		return points;
	}
	
	private int[] scaleTranslateY(double[] values, int scaleFactor, int translateFactor){
		
		// Scale and Translate
		for (int i = 0; i < values.length; i++) {
			values[i] *= scaleFactor;

			values[i] += pos.getYUp() * translateFactor - translateFactor;
		}

		// Round to integer
		int[] points = new int[3];
		for (int i = 0; i < points.length; i++) {
			points[i] = (int) values[i];
		}

		return points;
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
	
	public Rectangle getBounds() { return boundingBox; }
	private void updateBoundingBox(int[] x, int[]y){
		boundingBox = new Rectangle(x[0], y[0], x[2] - x[0], y[2] - y[0]);
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
