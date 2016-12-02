package GravityGolfGame;

import java.awt.Color;
import java.awt.Graphics;

public class BoardCell {
	
	char boardCellInitial;
	private boolean triangle;
	private boolean ball;
	private boolean win;
	private boolean isStart;
	private boolean isEnd;
	private int x;
	private int y;
	
	public BoardCell(){
		
	}
	
	
	// NOTE, either we don't need the initial stored, or we don't need the start/end/ball/tri/etc. stored
	public BoardCell(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public BoardCell(int x, int y, boolean isStart, boolean isEnd){
		this.x = x;
		this.y = y;
		this.isStart = isStart;
		this.isEnd = isEnd;
	}
	
	public BoardCell(int x, int y, boolean isStart, boolean isEnd, char initial){
		this(x, y, isStart, isEnd);
		boardCellInitial = initial;
	}
	
	
	public void draw(Graphics g, int x, int y){
		
		g.setColor(Color.GRAY);
		if (isEnd){
			g.setColor(Color.MAGENTA);
		}
		
		g.fillRect(x, y, GameEngine.CELL_SIZE, GameEngine.CELL_SIZE);
		
		if (boardCellInitial == 'S'){
			g.setColor(Color.GREEN);
			g.fillRect(x, y, GameEngine.CELL_SIZE, GameEngine.CELL_SIZE);
		}
		
		
		// Draws outlines as opposed to solid cell
		/**/
		g.setColor(Color.BLACK);
		g.drawRect(x, y, GameEngine.CELL_SIZE, GameEngine.CELL_SIZE);
		/**/
		return;
	}

	public char getInitial() {
		return boardCellInitial;
	}
	
	public void setInitial(char c) {
		
	}
	
	//This actually returns back if it contains a triangle or not. 
	public boolean containsTriangle() {
		return this.triangle;
	}
	
	//To set the Boardcell to set the triangle
	public void setTriangle(boolean set){
		this.triangle = set;
	}
	
	//This actually returns back if it contains a ball or not. 
	public boolean containsBall(){
		return this.ball;
	}
	
	//To set the BoardCell to set the hold the Ball
	public void setBall(boolean set) {
		this.ball = set;
	}
	
	//This returns the BoardCell to have the winning Condition. 
	public boolean containsWin() {
		return this.win;
	}
	
	//This sets the BoardCell to have the winning Condition. 
	public void setWin(boolean set) {
		this.win = set;
	}
	
	
	//This is the simple set to when it the ball is traveling right.
	public void changeXRight(int dx){
		this.x += dx;
	}
	
	//This is the simple set to when it the ball is traveling left.
	public void changeXLeft(int dx){
		this.x -= dx;
	}
	
	//This is the simple set to when it the ball is traveling Up.
	public void changeYUp(int dy){
		this.y += dy;
	}
	
	//This is the simple set to when it the ball is traveling down.
	public void changeYDown(int dy){
		this.y -= dy;
	}
	
	public int getX(){
		return x;
	}
	
	public int getYUp(){
		return y;
	}
	
}
