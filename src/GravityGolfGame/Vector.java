package GravityGolfGame;

public class Vector {

	public Vector() {
		x = 0;
		y = 0;
	}
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
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
	
	// Private Helpers
	private void update(){
		mag = Math.sqrt(x * x + y * y);
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
		if (Double.doubleToLongBits(mag) != Double.doubleToLongBits(other.mag))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	

}
