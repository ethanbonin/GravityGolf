package GravityGolfGame;

public class Vector {

	public Vector() {
		x = 0;
		y = 0;
		update();
	}
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
		update();
	}
	
	private double x;
	private double y;
	private double mag;
	
	// Setters / Getters
	public double getX(){ return x; }
	public double getY(){ return y; }
	public double getMag() { return mag; }
	public void setX(double val){ x = val; update(); }
	public void setY(double val){ y = val; update(); }
	public void negate(){x = -x; y = -y; update(); }
	
	// Math Ops
	public static Vector sub(Vector v1, Vector v2){ return new Vector(v1.x - v2.x, v1.y - v2.y); }
	public static Vector mult(Vector v1, Vector v2){ return new Vector(v1.x * v2.x, v1.y * v2.y); }
	public static Vector mult(Vector v1, double d){ return new Vector(v1.x * d, v1.y * d); }
	public static double dot(Vector v1, Vector v2){ return v1.x * v2.x + v1.y * v2.y; }
	
	
	// Private Helpers
	private void update(){
		mag = Math.sqrt(x * x + y * y);
	}


	@Override
	public String toString() {
		return "Vector [x=" + x + ", y=" + y + ", mag=" + mag + "]";
	}
	
	// Override equals check
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	

}
