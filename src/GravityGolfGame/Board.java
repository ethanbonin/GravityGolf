package GravityGolfGame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import GravityGolfGame.Triangle.Type;

public class Board extends JPanel {
	
	private static final int MAX_BOARD_SIZE = 100;
	private static Board theInstance = new Board();
	private static BoardCell[][] grid;
	private ArrayList<Triangle> triangles;
	private Ball ball;
	String csvFile;
	
	int numCols;
	int numRows;
	
	private Board() {
		grid = new BoardCell[MAX_BOARD_SIZE][MAX_BOARD_SIZE];
		triangles = new ArrayList<Triangle>();
		ball = new Ball();
	}
	
	public static Board getInstance() {
		return theInstance;
	}

	public static boolean isGameOver() {
		return false;
	}
	

	public void setConfigFiles(String file) {
		csvFile = file;
	}
	
	public void load(){
		
		try {
			loadBoardConfig();
		} catch (IOException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
		}
		
		
		
		// TEST Triangles (Visual testing)
		triangles.add(new Triangle(getCellAt(13, 11), Type._45, Orientation.RIGHT));
		
		//triangles.add(new Triangle(getCellAt(13, 1), Type._30, Orientation.LEFT));
		//triangles.add(new Triangle(getCellAt(4, 6), Type._60, Orientation.DOWN));
		
		//triangles.add(new Triangle(getCellAt(17, 10), Type._45, Orientation.UP));
		//triangles.add(new Triangle(getCellAt(17, 4), Type._45, Orientation.DOWN));
		//triangles.add(new Triangle(getCellAt(22, 4), Type._45, Orientation.RIGHT));
		/*
		triangles.add(new Triangle(getCellAt(5,5), Type._30, Orientation.RIGHT));
		triangles.add(new Triangle(getCellAt(7,5), Type._30, Orientation.UP));
		triangles.add(new Triangle(getCellAt(9,5), Type._30, Orientation.LEFT));
		triangles.add(new Triangle(getCellAt(11,5), Type._30, Orientation.DOWN));
		
		triangles.add(new Triangle(getCellAt(5,7), Type._45, Orientation.RIGHT));
		triangles.add(new Triangle(getCellAt(7,7), Type._45, Orientation.UP));
		triangles.add(new Triangle(getCellAt(9,7), Type._45, Orientation.LEFT));
		triangles.add(new Triangle(getCellAt(11,7), Type._45, Orientation.DOWN));
		
		triangles.add(new Triangle(getCellAt(5,9), Type._60, Orientation.RIGHT));
		triangles.add(new Triangle(getCellAt(7,9), Type._60, Orientation.UP));
		triangles.add(new Triangle(getCellAt(9,9), Type._60, Orientation.LEFT));
		triangles.add(new Triangle(getCellAt(11,9), Type._60, Orientation.DOWN));
		*/

	}
	
	public void update(){
		
		// Calc new ball pos
		// See if there will be a collision
		// Yes, handle collision then move ball
		// No, move ball
		// Also check if the ball is in the goal and handle it
		
		// Calculate new Position
		Vector newPos = new Vector(ball.getX() + ball.getVelocity().getX() + ball.getRadius(), ball.getY() + ball.getVelocity().getY() + ball.getRadius());
		Vector velocity = ball.getVelocity();
		Vector newVelocity = velocity;
		
		// Check for triangle collision detection
		for (Triangle t : triangles){
			if (t.intersects(newPos)){
				newVelocity = calcTriangleCollision(velocity, t);
			}
		}
		
		// Check for wall collision detection
//		for (BoardCell C: BoardCell.wallCells) {
//			
//		}
		
		
		
		ball.setVelocity(newVelocity);
		ball.move();
		
		repaint();
		return;
	}
	
	private Vector calcTriangleCollision(Vector v, Triangle t) {
		// Determine which side the ball is hitting
		v.negate();

		double min = Math.toDegrees(Math.acos(Vector.dot(v, Orientation.RIGHT.getVector())));
		Orientation side = Orientation.RIGHT;

		for (Orientation o : Orientation.values()) {

			double dot = Math.toDegrees(Math.acos(Vector.dot(v, o.getVector())));
			if (dot < min) {
				side = o;
				min = dot;
			}
		}

		// Calculate new Velocity Vector
		Vector norm = t.getNormal(side);
		v.negate();

		Vector newVelocity = calcReflection(v, norm, side);
		
		// Transfer to window coordinates
		if (side == Orientation.LEFT || side == Orientation.RIGHT) {
			newVelocity.setY(newVelocity.getY() * -1);
		} else {
			if(t.getOrientation() == Orientation.DOWN || t.getOrientation() == Orientation.UP){
				if(t.getOrientation() != side){
					newVelocity.setX(newVelocity.getX() * -1);
				}
			}
			newVelocity.setX(newVelocity.getX() * -1);
		}

		return newVelocity;
	}
	
	private Vector calcReflection(Vector v, Vector normal, Orientation side){
		
		Vector newVelocity = Vector.sub(v, Vector.mult(Vector.mult(normal, Vector.dot(v, normal)), 2));
		newVelocity = Vector.mult(newVelocity, v.getMag());
		
		return newVelocity;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int x = 0;
		int y = 0;
		
		// Draw Grid
		for(BoardCell[] b : grid){
			for(BoardCell c : b){
				if (c != null) {
					c.draw(g, x, y);
					x += GameEngine.CELL_SIZE;
				}
			}
			x = 0;
			y += GameEngine.CELL_SIZE;
		}
		
		// Draw Triangles
		for (Triangle t : triangles){
			t.draw(g);
		}
		
		
		// Draw Player Last
		ball.draw(g);
		
	}
	
	public void reset(){
		ball.reset();
		ball.setVelocity(new Vector(0,1));
		repaint();
	}
	
	private void loadBoardConfig() throws IOException {
		
		FileReader file = new FileReader(csvFile);
		BufferedReader in = new BufferedReader(file);

		String line;
		int i = 0;
		while ((line = in.readLine()) != null) {

			String[] cells = line.split(",");
			
			numCols = cells.length;
			
			for (int j = 0; j < cells.length; j++) {
				
				grid[i][j] = new BoardCell(i, j, cells[j].charAt(0));
				
				if (cells[j].charAt(0) == 's'){
					ball.setPosition(i * GameEngine.CELL_SIZE, j * GameEngine.CELL_SIZE);
					ball.setStartLocation(i * GameEngine.CELL_SIZE, j * GameEngine.CELL_SIZE);
				} 
				
			}
			i++;
		}
		numRows = i;
	}

	
	public BoardCell getCellAt(int i, int j) {
		return grid[i][j];
	}
}
