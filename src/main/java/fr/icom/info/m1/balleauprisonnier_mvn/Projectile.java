package fr.icom.info.m1.balleauprisonnier_mvn;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Projectile {
	
	public static final double ballrayon = 15; // rayon fix de la balle 
	public double ballposX = 5; // position X de la balle
	public double ballposY = 5; // position Y de la balle
	public int ballspeedX = 10; // vitesse sur l'axe des X de la balle
	public int ballspeedY = 10; // vitesse sur l'axe des X de la balle
	
	GraphicsContext graphicsContext;
	Image directionArrow;
	Sprite sprite;
	
	
	public Projectile(GraphicsContext gc, double posX, double posY)
	{
		graphicsContext = gc;
		ballposX = posX;
		ballposY = posY;
		Image tilesheetImage = new Image("assets/ball.png");
	    sprite = new Sprite(tilesheetImage, 0,0, Duration.seconds(.2), "top");
	    sprite.setX(ballposX);
	    sprite.setY(ballposY);
	}
	
	// getter de la positionX
	public double getPositionX() {
		return ballposX;
	}
	
	// getter de la positionY
	public double getPositionY() {
		return ballposY;
	}
	
	public void SetPositionX(double x) {
		this.ballposX = x;
	}
	
	// getter de la positionY
	public void SetPositionY(double y) {
		this.ballposY = y;
	}
	
	// On affiche la balle 
	public void draw(/**double x, double y, bool pos**/) {
		//graphicsContext.fillOval(ballspeedX, ballspeedY, ballrayon, ballrayon);
		double posY = getPositionY();
		graphicsContext.drawImage(new Image("assets/ball.png"), ballposX, posY);
		System.out.println(ballposY);
		double cpt = posY;
		cpt = cpt -0.5;
		this.SetPositionY(cpt);
	}
	
}
