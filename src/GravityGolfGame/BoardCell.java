package GravityGolfGame;

public class BoardCell {
	
	char boardCellInitial;
	private boolean triangle;
	private boolean ball;
	
	public BoardCell(){
		
	}
	
	public BoardCell(int x, int y){
		
	}

	public char getInitial() {
		return boardCellInitial;
	}
	
	public void setInitial() {
		
	}
	
	//This actually returns back if it contains a triangle or not. 
	public boolean containsTriangle() {
		return triangle;
	}
	
	//To set the boardcell to set the triangle
	public void setTriangle(boolean set){
		this.triangle = set;
	}
	
	//This actually returns back if it contains a ball or not. 
	public boolean containsBall(){
		return ball;
	}
	
	//To set the BoardCell to set the hold the Ball
	public void setBall(boolean set) {
		this.ball = set;
	}
	
	
}
