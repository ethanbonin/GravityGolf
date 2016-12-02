package GravityGolfGame;

// Specifies orientation of object
public enum Orientation {
	LEFT (new Vector(-1, 0)),
	RIGHT (new Vector(1,0)),
	UP (new Vector(0, 1)),
	DOWN (new Vector(0, -1));
	
	private Vector vec;
	Orientation (Vector v) { vec = v; }
	public Vector getVector() { return vec; }
}
