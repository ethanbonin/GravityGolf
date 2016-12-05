package GravityGolfGame;

import java.awt.Color;
import java.awt.Graphics;

public class BoardCell {
	
	char boardCellInitial;
	private boolean isEnd;
	private boolean isWall;
	private int x;
	private int y;
	
	// NOTE, either we don't need the initial stored, or we don't need the start/end/ball/tri/etc. stored
	public BoardCell(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public BoardCell(int x, int y, char initial){
		this(x, y);
		boardCellInitial = initial;
		if (initial == 'e'){
			isEnd = true;
		}
		if (initial == 'w') {
			isWall = true;
		}
	}
	
	
	public void draw(Graphics g, int x, int y){
		
		g.setColor(Color.GRAY);
		if (isEnd){
			g.setColor(Color.GREEN);
		}
		if (isWall) {
			g.setColor(Color.YELLOW);
		}
		
		g.fillRect(x, y, GameEngine.CELL_SIZE, GameEngine.CELL_SIZE);
		
		// Draws outlines as opposed to solid cell
		
		g.setColor(Color.BLACK);
		g.drawRect(x, y, GameEngine.CELL_SIZE, GameEngine.CELL_SIZE);
		
		return;
	}

	public char getInitial() {
		return boardCellInitial;
	}
	
	//This returns the BoardCell to have the winning Condition. 
	public boolean containsWin() {
		return this.isEnd;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
