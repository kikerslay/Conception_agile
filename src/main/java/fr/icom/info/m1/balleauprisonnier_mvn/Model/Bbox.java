package fr.icom.info.m1.balleauprisonnier_mvn.Model;

/*
 *  Classe Bounding Box gestion des collisions 
 */
public class Bbox {
	public double minX, maxX, minY, maxY;
	
	public Bbox(double minX, double maxX, double minY, double maxY) {
		
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
		
	}
	
	/*
	 * Check si y'a collision
	 */
	public boolean isColliding(Bbox other) {
		return maxX >= other.minX-25 && minX <= other.maxX+10 && maxY >= other.minY-20 && minY <= other.maxY-10;
	}
}
