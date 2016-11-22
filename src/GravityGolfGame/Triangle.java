package GravityGolfGame;

public class Triangle {

	public Triangle() {
		
	}
	
	public Triangle(BoardCell pos, Type type, Orientation ori) {
		this.pos = pos;
		this.type = type;
		orientation = ori;
	}
	
	public enum Type{
		_30,
		_45,
		_60
	}
	
	private BoardCell pos;
	private Type type;
	private Orientation orientation;
	
	public void setPosition(BoardCell p) { pos = p; }
	public BoardCell getPosition() { return pos; }
	
	public Orientation getOrientation() { return orientation; }
	
	public Vector getNormal(Orientation side){
		
		return new Vector();
	}

}
