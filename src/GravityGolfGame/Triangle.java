package GravityGolfGame;

public class Triangle {

	public Triangle() {
		
	}
	
	public enum Type{
		_30,
		_45,
		_60,
		_90
	}
	
	private BoardCell pos;
	private Orientation orientation;
	
	public void setPosition(BoardCell p) { pos = p; }
	public BoardCell getPosition() { return pos; }
	
	public Orientation getOrientation() { return orientation; }

}
