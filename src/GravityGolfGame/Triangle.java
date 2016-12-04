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
	private int[] xPoints;
	private int[] yPoints;
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		xPoints = scaleTranslateX(getXVert(), GameEngine.CELL_SIZE * 2, 0);
		yPoints = scaleTranslateY(getYVert(), GameEngine.CELL_SIZE * 2, 0);

		g.setColor(color);
		// May be problems here with null pointers on loading?
		g.fillPolygon(xPoints, yPoints, xPoints.length);

	}
	
	public void draw(Graphics g){
		// Points array calculations
		xPoints = scaleTranslateX(getXVert(), GameEngine.CELL_SIZE, GameEngine.CELL_SIZE);
		yPoints = scaleTranslateY(getYVert(), GameEngine.CELL_SIZE, GameEngine.CELL_SIZE);
		
		updateBoundingBox(xPoints, yPoints);
		
		g.setColor(color);
		g.fillPolygon(xPoints, yPoints, xPoints.length);
		
		// Bounding Box Visualization
		
		g.setColor(Color.RED);
		g.drawRect((int)boundingBox.getX(), (int)boundingBox.getY(),(int) boundingBox.width, (int)boundingBox.getHeight());
		
		
		return;
	}
	
	private double[] getXVert(){

		// Original Points
		double[] xPointsExact = { 0, 0, 1 };
		
		if (type == Type._60) {
			xPointsExact[2] = 0.7;
		}

		// Flip based on orientation
		if (orientation == Orientation.UP) {
			xPointsExact[0] = xPointsExact[2];
			if (type == Type._60) {
				for (int i = 0; i < xPointsExact.length; i++) {
					xPointsExact[i] += 0.3;
				}
			}
		} else if (orientation == Orientation.LEFT) {
			xPointsExact[1] = xPointsExact[2];
			if (type == Type._60) {
				for (int i = 0; i < xPointsExact.length; i++) {
					xPointsExact[i] += 0.3;
				}
			}
		}

		return xPointsExact;
	}
	
	private double[] getYVert(){

		// Original Points
		double[] yPointsExact = { 0, 1, 1 };
		
		if (type == Type._30) {
			yPointsExact[0] = 0.3;
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

			values[i] += pos.getY() * translateFactor - translateFactor;
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
	
	public boolean intersects(Vector a, Vector b){
		/*
		double det = ((yPoints[1] - yPoints[2]) * (xPoints[0] - xPoints[2])
				+ (xPoints[2] - xPoints[1]) * (yPoints[0] - yPoints[2]));
		
		if (det == 0){
			return true;
		}
		
		double alpha = ((yPoints[1] - yPoints[2]) * (a.getX() - xPoints[2])
				+ (xPoints[2] - xPoints[1]) * (a.getY() - yPoints[2]))
				/ det;
		
		double beta = ((yPoints[2] - yPoints[0]) * (a.getX() - xPoints[2])
				+ (xPoints[0] - xPoints[2]) * (a.getY() - yPoints[2]))
				/ det;
		
		double gamma = 1.0 - alpha - beta;
		
		if (alpha > 0 && beta > 0 && gamma > 0){
			System.out.println(a);
			System.out.println("a: " + alpha + " b: " + beta + " g: " + gamma + "\n\n\n\n");
			return true;
		}
		*/
		// Compute vectors
		Vector v0 = Vector.sub(new Vector(xPoints[2], yPoints[2]), new Vector(xPoints[0], yPoints[0]));
		Vector v1 = Vector.sub(new Vector(xPoints[1], yPoints[1]), new Vector(xPoints[0], yPoints[0]));
		Vector v2 = Vector.sub(a, new Vector(xPoints[0], yPoints[0]));
		
		if (orientation == Orientation.UP){
			v0 = Vector.sub(new Vector(xPoints[2], yPoints[2]), new Vector(xPoints[1], yPoints[1]));
			v1 = Vector.sub(new Vector(xPoints[0], yPoints[0]), new Vector(xPoints[1], yPoints[1]));
			v2 = Vector.sub(a, new Vector(xPoints[1], yPoints[1]));
		}

		// Compute dot products
		double dot00 = Vector.dot(v0, v0);
		double dot01 = Vector.dot(v0, v1);
		double dot02 = Vector.dot(v0, v2);
		double dot11 = Vector.dot(v1, v1);
		double dot12 = Vector.dot(v1, v2);

		// Compute barycentric coordinates
		double invDenom = 1 / (dot00 * dot11 - dot01 * dot01);
		double u = (dot11 * dot02 - dot01 * dot12) * invDenom;
		double v = (dot00 * dot12 - dot01 * dot02) * invDenom;

		// Check if point is in triangle
		if ((u >= 0) && (v >= 0) && (u + v < 1)) {
			System.out.println(a);
			System.out.println("a: " + u + " b: " + v + " g: " + invDenom + "\n\n\n");
			return true;
		}

		
		
		
		
//		// Line in Question. of the form lineX x + lineY y = LineC
//		double b1 = b.getX() - a.getX();
//		double a1 = b.getY() - a.getY();
//		double c1 = a1 * a.getX() + b1 * a.getY();
//		
//		// Lines of Triangle
//		/*
//		double triX = xPoints[1] - xPoints[0];
//		double triY = yPoints[1] - yPoints[0];
//		double triC = triX * xPoints[0] + triY * yPoints[0];
//		*/
//		
//		for(int i = 0; i < xPoints.length; i++){
//			for (int j = 0; j < xPoints.length; j++){
//				if (i == j){
//					continue;
//				}
//				
//				double b2 = xPoints[i] - xPoints[j];
//				double a2 = yPoints[i] - yPoints[j];
//				double c2 = a2 * xPoints[i] + b2 * yPoints[j];
//				
//				double det = a1 * b2 - a2 * b1;
//				if (det == 0) {
//					continue;
//				} else {
//					
//					double x = (b2 * c1 - b1 * c2) / det;
//					double y = (a1 * c2 - a2 * c2) / det;
//					
//					if (Math.min(a.getY(), b.getY()) < y && y < Math.max(a.getY(), b.getY())){
//						System.out.println("Intersect: (" + x + ", " + y + ")");
//						if (Math.min(a.getX(), b.getX()) < x && x < Math.max(a.getX(), b.getX())){
//							return true;
//						}
//						else {
//							continue;
//						}
//					}
//					else {
//						continue;
//					}
//					
//				}
//			}
//		}
		
		return false;
	}
	
	public Rectangle getBounds() { return boundingBox; }
	
	private void updateBoundingBox(int[] x, int[]y){
		if (orientation == Orientation.RIGHT || orientation == Orientation.LEFT){
			boundingBox = new Rectangle(x[0], y[0], x[2] - x[0], y[2] - y[0]);
		} else if (orientation == Orientation.DOWN){
			boundingBox = new Rectangle(x[0] , y[0], x[2] - x[0], y[1] - y[0]);
		} else {
			boundingBox = new Rectangle(x[1] , y[0], x[2] - x[1], y[2] - y[0]);
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
