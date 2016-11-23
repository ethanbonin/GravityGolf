package GravityGolfGame;

public class BoardCell {
	
	private boolean triangle;
	private boolean ball;
	private boolean win;
	
	public BoardCell(){
		
	}
	
	public BoardCell(int x, int y, boolean hasTriangle, boolean hasBall){
		
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
	
	public void changeX(int dx){
		
	}
	
	
	public void changeY(int dx){
		
	}
	
	public int getX(){
		return x;
	}
	
}
