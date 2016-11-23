package GravityGolfGame;

public class BoardCell {
	
	char boardCellInitial;
	private boolean triangle;
	private boolean ball;
	private boolean win;
	private int x;
	private int y;
	
	public BoardCell(){
		
	}
	
	public BoardCell(int x, int y, boolean hasTriangle, boolean hasBall){
		
	}

	public char getInitial() {
		return boardCellInitial;
	}
	
	public void setInitial() {
		
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
		return this.x;
	}
	
	public int getYUp(){
		return this.y;
	}
	
}
