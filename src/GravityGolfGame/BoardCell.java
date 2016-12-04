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
	
	//This returns the BoardCell to have the winning Condition. 
	public boolean containsWin() {
		return this.win;
	}
	
	//This sets the BoardCell to have the winning Condition. 
	public void setWin(boolean set) {
		this.win = set;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	
}
